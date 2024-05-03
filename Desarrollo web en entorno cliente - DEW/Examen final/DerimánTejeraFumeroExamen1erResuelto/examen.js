//Agregamos un oyente para el evento "load" en la ventana y llamamos a la función "iniciar".
window.addEventListener("load", iniciar);

//Declaramos la variable etiqPrestaciones fuera de las funciones para evitar problemas por no inizialización.
let etiqPrestaciones;

function iniciar() {
    //Obtenemos referencias a elementos del DOM para manipular marcas y modelos de coches.
    const marcaSlc = document.getElementById("marcas");
    const modeloSlc = document.getElementById("modelo");
    const etiqMarca = document.getElementById("etiq_marcas");
    const etiqModelo = document.getElementById("etiq_modelo");
    const prestacionesSlc = document.getElementById("prestaciones");
    const etiqPrestaciones = document.getElementById("etiq_prestaciones");

    //Inicialmente al cargar el HTML por primera vez, ocultamos los elementos de modelo.
    etiqModelo.style.visibility = "hidden";
    modeloSlc.style.visibility = "hidden";

    //Cargamos las marcas de coches disponibles en el selector llamando a la función mostrarMarcas()
    mostrarMarcas();

    //Función que logra mostrar todas las marcas de coche en el selector de Marcas.
    function mostrarMarcas() {
        //Limpiamos el selector de marcas y establecemos una opción por defecto.
        marcaSlc.innerHTML = '<option value="" selected="selected"></option>';

        //Inicializamos una solicitud con AJAX para obtener las marcas de coches desde el servidor.
        let xhttp = new XMLHttpRequest();
        let objeto = { "tabla": "marcas" };

        //Gestionamos la respuesta del servidor para llenar el selector de marcas.
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                let array = JSON.parse(this.responseText);
                array.forEach(marca => {
                    let opcion = document.createElement("option");
                    opcion.textContent = marca.nombre;
                    opcion.value = marca.id_marca;
                    marcaSlc.appendChild(opcion);
                });
            }
        };

        //Enviamos la solicitud al servidor para obtener las marcas.
        let parametros = JSON.stringify(objeto);
        xhttp.open("POST", "acceso_bd.php", true);
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send("objeto=" + parametros);
    }

    //Añadimos un evento "change" al selector de marcas para cargar los modelos de la marca seleccionada por el usuario.
    marcaSlc.addEventListener("change", function () {

        //Actualizamos id_marca cuando el usuario seleccione una marca en el desplegable.
        id_marca = marcaSlc.value;

        //Verificamos si id_marca no está vacía y mostramos etiqueta y selector de modelo en consecuencia.
        if (id_marca !== "") {
            etiqModelo.style.visibility = "visible";
            modeloSlc.style.visibility = "visible";
            //Borramos el campo de prestaciones si el usuario decide cambiar de marca de vehículo.
            borrarCampoPrestaciones()
            mostrarModelos();
        } else {
            etiqModelo.style.visibility = "hidden";
            modeloSlc.style.visibility = "hidden";
            //Reinicializamos el valor del selector a la opción en blanco.
            modeloSlc.value = "";
            borrarCampoPrestaciones()
        }
    });

    function mostrarModelos() {
        //Mostramos los elementos de modelo y limpiamos el selector de modelos.
        etiqModelo.style.visibility = "visible";
        modeloSlc.style.visibility = "visible";
        modeloSlc.innerHTML = '<option value="" selected="selected"></option>';

        //Inicializamos una solicitud con AJAX para obtener modelos de coches según la marca seleccionada por el usuario.
        let xhttp = new XMLHttpRequest();
        let objeto = { "tabla": "modelo" };

        //Gestionamos la respuesta del servidor para llenar el campo selector de modelos.
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                let array = JSON.parse(this.responseText);
                let valorMarcaSeleccionada = marcaSlc.value;
                array.forEach(modelo => {
                    if (valorMarcaSeleccionada === modelo.id_marca) {
                        let opcion = document.createElement("option");
                        opcion.textContent = modelo.modelo;
                        opcion.value = modelo.id_modelo;
                        modeloSlc.appendChild(opcion);
                    }
                });
            }
        };

        //Enviamos la solicitud al servidor para obtener los modelos según la marca que haya seleccionado el usuario.
        let parametros = JSON.stringify(objeto);
        xhttp.open("POST", "acceso_bd.php", true);
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send("objeto=" + parametros);
    }

    //Añadimos un evento "change" al selector de modelos para realizar todas las acciones necesarias.
    modeloSlc.addEventListener("change", function () {
        id_modelo = modeloSlc.value;

        //Verificamos si id_modelo no está vacía y mostramos etiqueta y selector de modelo en consecuencia.
        if (id_modelo !== "") {
            //Mostramos el contenido de id_modelo en la consola para ir comparando los valores que toman, sólo para verificar el correcto funcionamiento del código.
            console.log("Contenido de id_marca:", id_marca, " id_modelo:", id_modelo);

            //Llamamos a agregarCampoPrestaciones cada vez que el usuario cambia el modelo en el seleccionable.
            agregarCampoPrestaciones();
            //Cargamos las prestaciones en el selector.
            mostrarPrestaciones();

        } else {
            //Si el usuario deselecciona el modelo, ocultamos tanto la etiqueta como el selector de Prestaciones.
            borrarCampoPrestaciones();
        }
    });

    function agregarCampoPrestaciones() {
        //Referencia al elemento body en el que se incrustarán los elmentos creados.
        const body = document.body;

        //Comprobamos si no existe ya un elemento con el id "etiq_prestaciones" y "prestaciones".
        if (!document.getElementById("etiq_prestaciones") && !document.getElementById("prestaciones")) {
            //Creamos etiqueta para prestaciones en el body del HTML.
            const etiqPrestaciones = document.createElement("label");
            etiqPrestaciones.setAttribute("id", "etiq_prestaciones");
            etiqPrestaciones.setAttribute("for", "prestaciones");
            etiqPrestaciones.textContent = "Prestaciones:";
            body.appendChild(etiqPrestaciones);

            //Creamos un selector de opciones.
            const prestacionesSlc = document.createElement("select");
            prestacionesSlc.setAttribute("name", "prestaciones");
            prestacionesSlc.setAttribute("id", "prestaciones");
            body.appendChild(prestacionesSlc);
        }
    }

    //Función para borrar el campo de Prestaciones del formulario.
    function borrarCampoPrestaciones() {
        const etiqPrestaciones = document.getElementById("etiq_prestaciones");
        const prestacionesSlc = document.getElementById("prestaciones");

        //Verificamos si los elementos existen antes de intentar eliminarlos.
        if (etiqPrestaciones) {
            etiqPrestaciones.parentNode.removeChild(etiqPrestaciones);
        }

        if (prestacionesSlc) {
            prestacionesSlc.parentNode.removeChild(prestacionesSlc);
        }
    }

    //Función para mostrar las prestaciones disponibles en el selector.
    function mostrarPrestaciones() {
        const prestacionesSlc = document.getElementById("prestaciones");

        prestacionesSlc.innerHTML = '<option value="" selected="selected"></option>';

        let xhttp = new XMLHttpRequest();
        let objeto = {
            "tabla": "opciones",
        };
        xhttp.onreadystatechange = function () {
            if ((this.readyState == 4) && (this.status == 200)) {
                let array = JSON.parse(this.responseText);


                for (let i = 0; i < array.length; i++) {
                    if ((id_marca === array[i].id_marca) && (id_modelo === array[i].id_modelo)) {
                        let opcion = document.createElement("option");
                        opcion.textContent = array[i].nombre;
                        opcion.value = array[i].id_opcion;
                        prestacionesSlc.appendChild(opcion);
                    }
                }
            }
        };

        //Convertimos el objeto a una cadena JSON
        let parametros = JSON.stringify(objeto);

        //Configuramos la solicitud AJAX para enviar el objeto al servidor mediante POST
        xhttp.open("POST", "acceso_bd.php", true);
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send("objeto=" + parametros);
    }
}
//Derimán Tejera Fumero 2DAW semi B.