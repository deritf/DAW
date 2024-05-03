/*
Partiendo del fichero.html que se te proporciona en Información de Interés, se pide realizar los siguientes apartados:

Previamente se debe crear en PhpMyAdmin que nos proporciona Xampp, la BD espana, ejecutar los 3 scripts sql que se proporcionan en Información de interés para crear las 3 tablas en la BD y todas las filas de las tablas con los datos proporcionados.

Creamos un fichero.php para establecer la conexión a la BD mediante el método POST o GET. Y convertimos la salida del fichero, en JSON con json_encode

En el fichero.html solo se puede añadir la línea de referencia al fichero JavaScript (js)

Debemos ocultar el select id="provincias" e id="municipios y cargar con los datos de la BD las comunidades en el select id="comunidades". Todos los select mostrarán el primer campo en blanco.

Al seleccionar en el select id="comunidades" una opción, cuando detecte un cambio, deberá mostrar las provincias. Es decir, mostrar el select id="provincias" y cargar las provincias de dicha comunidad autónoma seleccionada de la BD.

Al seleccionar en el select id="provincias" una opción, cuando detecte un cambio, deberá mostrar los municipios. Es decir, mostrar el select id="municipios" y cargar los municipios de dicha provincia seleccionada de la BD

Si después de estos pasos volvemos a elegir otra provincia, deberemos borrar todo lo que hay en el select id="municipios" y cargarlo con los municipios de la nueva provincia seleccionada.

Si por el contrario lo que queremos es cambiar la CCAA entonces tendremos que deshabilitar el select id="muncipios" para que no se vea, y borrar los elementos que hay en el select id="provincias" y añadir las provincias de la nueva selección de CCAA.
*/



//Utilizamos estas variables para almacenar los ID de la comunidad autónoma y la provincia seleccionados por el usuario en los selectores de la página web.
//Se utilizarán para saber que provincias y municipios deberán ser cargados respectivamente desde la base de datos XAMPP.
let id_comunidad_de_bd_comunidad = "";
let id_provincia_de_bd_provincia = "";

document.addEventListener("DOMContentLoaded", function () {

    //Obtenemos las referencias a los elementos HTML de fichero.html.
    const comunidadesSelect = document.getElementById("comunidades");
    const provinciasSelect = document.getElementById("provincias");
    const municipiosSelect = document.getElementById("municipios");
    const etiquetaProvincias = document.getElementById("etiq_provincias");
    const etiquetaMunicipios = document.getElementById("etiq_municipios");

    //Ocultamos la etiqueta "Provincias:" y el selector de opciones de provincias al cargar la página.
    etiquetaProvincias.style.display = "none";
    provinciasSelect.style.display = "none";

    //Ocultamos la etiqueta "Municipios:" y el selector de opciones de municipios al cargar la página.
    etiquetaMunicipios.style.display = "none";
    municipiosSelect.style.display = "none";

    //Con esta función cargargamos las comunidades autónomas desde la base de datos.
    function cargarComunidades() {
        //Hacemos una solicitud Ajax para obtener las comunidades desde acceso_bd.php.
        fetch("acceso_bd.php?tabla=comunidades")
            .then(response => {
                //Verificamos si la respuesta es exitosa (status 200 ok)
                if (!response.ok) {
                    //Si la respuesta no es exitosa, lanzamos un error con un mensaje.
                    throw new Error("Error al cargar comunidades: " + response.status);
                }
                //Convertimos la respuesta en formato JSON y la devolvemos.
                return response.json();
            })
            .then(data => {
                //Limpiamos y luego llenamos el selector de comunidades con los datos obtenidos.
                comunidadesSelect.innerHTML = "";
                //Agregamos una opción en blanco al inicio del selector de comunidades autónomas.
                comunidadesSelect.appendChild(new Option("", ""));
                //Recorremos los datos obtenidos en la lista de comunidades autónomas y las agregamos al selector como opciones.
                data.forEach(comunidad => {
                    comunidadesSelect.appendChild(new Option(comunidad.nombre, comunidad.id_comunidad));
                });
            })
            .catch(error => {
                //Se muestra un mensaje de error al usuario si ha habido problemas al cargar los datos.
                console.error("Se produjo un error al cargar los datos: " + error.message);
            });
    }

    //Llamamos a la funcón "cargarComunidades()" para cargar las opciones de comunidades autónomas en el desplegable de opciones.
    cargarComunidades();

    //Agregamos un escuchador de evento de cambio al selector de comunidades.
    comunidadesSelect.addEventListener("change", function () {
        //Obtenemos el ID de la CCAA seleccionada por el usuario y la almacenamos en la constante id_comunidad_de_bd_comunidad.
        id_comunidad_de_bd_comunidad = comunidadesSelect.value;
        //Enviamos por consola esta información para poder hacer un seguimiento de su correcto funcionamiento y que el dato almacenado es el correcto.
        console.log("La ID de la elección es: id_comunidad:");
        console.log(id_comunidad_de_bd_comunidad);

        //Verificamos si se ha seleccionado una opción en CCAA.
        if (id_comunidad_de_bd_comunidad !== "") {
            //Mostramos la etiqueta "Provincias:" y cargamos las provincias correspondientes.
            etiquetaProvincias.style.display = "inline-block";
            provinciasSelect.style.display = "inline-block";
            //Llamamos a la función para cargar las provincias.
            cargarProvincias();
        } else {
            //Si el usuario no ha seleccionado ninguna opción en CCAA, ocultar la etiqueta "Provincias:" y el selector de provincias.
            etiquetaProvincias.style.display = "none";
            provinciasSelect.style.display = "none";

            //También ocultaremos la etiqueta "Municipios:" y el selector de municipios si se ocultan las provincias.
            etiquetaMunicipios.style.display = "none";
            municipiosSelect.style.display = "none";
        }
    });

    //Agregar un evento de cambio al selector de provincias.
    provinciasSelect.addEventListener("change", function () {
        //Obtenemos el ID de la provincia seleccionada.
        id_provincia_de_bd_provincia = provinciasSelect.value;
        //Enviamos estos datos a la consola para verificar su funcionamiento internamente.
        console.log("La ID de la elección es: id_provincia:");
        console.log(id_provincia_de_bd_provincia);

        //Verificamos si se ha seleccionado una opción en Provincias.
        if (id_provincia_de_bd_provincia !== "") {
            //Mostramos la etiqueta "Municipios:" y cargamos los municipios correspondientes.
            etiquetaMunicipios.style.display = "inline-block";
            municipiosSelect.style.display = "inline-block";
            //Llamamos a la función para cargar los municipios.
            cargarMunicipios();
        } else {
            //Si el usuario no se ha seleccionado ninguna opción en Provincias, ocultamos la etiqueta "Municipios:" y el selector de municipios.
            etiquetaMunicipios.style.display = "none";
            municipiosSelect.style.display = "none";
        }
    });

    //Con esta función cargargamos las provincias desde la base de datos.
    function cargarProvincias() {
        //Hacemos una solicitud Ajax para obtener las provincias desde acceso_bd.php.
        fetch("acceso_bd.php?tabla=provincias")
            .then(response => {
                //Verificamos si la respuesta es exitosa (status 200 ok)
                if (!response.ok) {
                    //Si la respuesta no es exitosa, lanzamos un error con un mensaje.
                    throw new Error("Error al cargar provincias: " + response.status);
                }
                //Convertimos la respuesta en formato JSON y la devolvemos.
                return response.json();
            })
            .then(data => {
                //Limpiamos y luego llenamos el selector de provincias con los datos obtenidos.
                provinciasSelect.innerHTML = "";
                //Agregamos una opción en blanco al inicio del selector de provincias.
                provinciasSelect.appendChild(new Option("", ""));
                //Recorremos los datos obtenidos en la lista de provincias y las agregamos al selector como opciones.
                data.forEach(provincia => {
                    if (provincia.id_comunidades === id_comunidad_de_bd_comunidad) {
                        provinciasSelect.appendChild(new Option(provincia.provincia, provincia.id_provincia));
                    }
                });
            })
            .catch(error => {
                //Se muestra un mensaje de error al usuario si ha habido problemas al cargar los datos.
                console.error("Se produjo un error al cargar los datos: " + error.message);
            });
    }

    //Función para cargar municipios desde la base de datos
    function cargarMunicipios() {
        //Hacemos una solicitud Ajax para obtener los municipios desde acceso_bd.php.
        fetch("acceso_bd.php?tabla=municipios")
            .then(response => {
                //Verificamos si la respuesta es exitosa (status 200 ok)
                if (!response.ok) {
                    //Si la respuesta no es exitosa, lanzamos un error con un mensaje.
                    throw new Error("Error al cargar municipios: " + response.status);
                }
                //Convertimos la respuesta en formato JSON y la devolvemos.
                return response.json();
            })
            .then(data => {
                //Limpiamos y luego llenamos el selector de municipios con los datos obtenidos.
                municipiosSelect.innerHTML = "";
                //Agregamos una opción en blanco al inicio del selector de municipios.
                municipiosSelect.appendChild(new Option("", ""));
                data.forEach(municipio => {
                    //Recorremos los datos obtenidos en la lista de municipios y las agregamos al selector como opciones.
                    //Si se cumple que número de ID de provincia almacenado en la tabla de datos de municipios es igual al número de la provincia seleccionada por
                    // el usuario en el selector de opciones anteriormente, entonces podrá mostrar dicho municipio porque corresponderá a esa  provincia.
                    if (municipio.id_provincia === id_provincia_de_bd_provincia) {
                        municipiosSelect.appendChild(new Option(municipio.nombre, municipio.id_municipio));
                    }
                });
            })
            .catch(error => {
                //Se muestra un mensaje de error al usuario si ha habido problemas al cargar los datos.
                console.error("Se produjo un error al cargar los datos: " + error.message);
            });
    }

    //Llamamos a las funciones para cargar las provincias y municipios al cargar la página.
    cargarProvincias();
    cargarMunicipios();
});
//Derimán Tejera Fumero 2DAW Semi B