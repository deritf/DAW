//Creamos este evento que se dispara cuando el DOM ha sido completamente cargado en el navegador.
document.addEventListener('DOMContentLoaded', function () {

    //Elemento select para las provincias.
    const provinciasSelect = document.getElementById('provincias');

    //Elemento select para las islas.
    const islasSelect = document.getElementById('islas');

    //Variable para almacenar la etiqueta del elemento "islas".
    let islasLabel;

    //Buscamos la etiqueta del elemento "islas" para poder utilizarla después.
    const labels = document.getElementsByTagName('label');
    for (const label of labels) {
        if (label.getAttribute('for') === 'islas') {
            islasLabel = label;
            break;
        }
    }

    //Elemento de párrafo donde mas tarde mostraremos información.
    const parrafo = document.getElementById('parrafo');

    //Contenedor de imágenes.
    const contenedorImagen = document.getElementById('contenedor_imag');

    //Definimos un objeto islas que contiene información sobre las 2 provincias y las islas asociadas a cada una de ellas.
    const islas = {
        'SC': ["La Palma", "El Hierro", "La Gomera", "Tenerife"],
        'LPGC': ["Gran Canaria", "Fuerteventura", "Lanzarote"]
    };

    //Definimos un objeto acronimosIsla que contiene los acrónimos de las islas. Esto será usado mas adelante para varias tareas, entre ellas acceder a las imágenes.
    const acronimosIsla = {
        'La Palma': 'LP',
        'El Hierro': 'EH',
        'La Gomera': 'LG',
        'Tenerife': 'TF',
        'Gran Canaria': 'GC',
        'Fuerteventura': 'FV',
        'Lanzarote': 'LZ'
    };

    //Obtenemos todas las listas presentes en el documento.
    const ulElements = document.getElementsByTagName('ul');

    //Convertimos la colección de elementos HTML en un array para facilitar su manipulación.
    const municipios = Array.from(ulElements);

    //Variable para almacenar la lista de municipios de la isla seleccionada.
    let municipiosIsla;

    //Establecemos la visibilidad y posición inicial de algunos elementos en el DOM.

    //Ocultamos el select de islas y lo posicionamos absolutamente.
    islasSelect.style.visibility = 'hidden';
    islasSelect.style.position = 'absolute';

    //Ocultamos la etiqueta de islas.
    islasLabel.style.visibility = 'hidden';

    //Ocultamos el párrafo de información.
    parrafo.style.visibility = 'hidden';

    //Ocultamos el contenedor de imágenes.
    contenedorImagen.style.visibility = 'hidden';

    //Creamos un elemento de imagen para mostrar una imagen de la isla seleccionada.
    const imagenIsla = document.createElement('img');

    //Configuramos la imagen inicialmente como oculta y le asignamos un id.
    imagenIsla.style.visibility = 'hidden';
    imagenIsla.id = 'imagenIsla';
    imagenIsla.style.position = 'absolute';

    //Configuramos el contenedor de imágenes como relativo.
    contenedorImagen.style.position = 'relative';

    //Configuramos la posición inicial de la imagen en el contenedor.
    imagenIsla.style.position = 'absolute';
    imagenIsla.style.top = '600px';
    imagenIsla.style.left = '100px';

    //Agregamos la imagen al contenedor de imágenes.
    contenedorImagen.appendChild(imagenIsla);

    //Configuramos el párrafo de información.
    const textoSeleccionado = document.getElementById('parrafo');
    islasSelect.style.visibility = 'hidden';
    islasSelect.style.position = 'absolute';
    islasLabel.style.visibility = 'hidden';
    parrafo.style.visibility = 'hidden';

    //Función para limpiar y ocultar todos los municipios.
    function limpiarMunicipios() {
        municipios.forEach(function (municipio) {
            const municipioItems = municipio.getElementsByTagName('li');
            for (const item of municipioItems) {
                //Establecemos el color de los municipios a negro.
                item.style.color = 'rgb(0, 0, 0)';
            }
            //Ocultamos la lista de municipios.
            municipio.style.display = 'none';
        });
        //Ocultamos el párrafo de información.
        parrafo.style.visibility = 'hidden';
        //Ocultamos la imagen de la isla.
        imagenIsla.style.visibility = 'hidden';
    }

    //Llamamos a la función para limpiar y ocultar los municipios al principio.
    limpiarMunicipios();

    //Agregamos un evento de clic a cada municipio.
    if (municipios) {
        municipios.forEach(function (municipio) {
            municipio.addEventListener('click', function (event) {

                if (municipiosIsla) {
                    const municipiosLista = Array.from(municipiosIsla.getElementsByTagName('li'));
                    municipiosLista.forEach(function (municipioItem) {
                        //Cambiamos el color de los municipios a azul.
                        municipioItem.style.color = 'rgb(0, 0, 255)';
                    });
                    //Cambiamos el color del municipio seleccionado a rojo.
                    event.target.style.color = 'rgb(255, 0, 0)';
                    const nombreMunicipio = event.target.textContent;
                    const islaSeleccionadaNombre = islasSelect.value;
                    const islaSeleccionadaAcr = acronimosIsla[islaSeleccionadaNombre];
                    const nombreIsla = islas[islaSeleccionadaAcr];

                    //Actualizamos el párrafo con información sobre el municipio seleccionado.
                    textoSeleccionado.style.color = 'rgb(0, 211, 28)';
                    textoSeleccionado.textContent = `Has elegido ${nombreMunicipio} es un municipio de la isla de ${islaSeleccionadaNombre}.`;
                    textoSeleccionado.style.visibility = 'visible';

                    //Creamos y mostramos una imagen de la isla seleccionada.
                    const contenedorImagen = document.getElementById('contenedor_imag');
                    const imagenIsla = document.createElement('img');

                    //Configuramos el tamaño de la imagen.
                    imagenIsla.style.width = '70px';
                    imagenIsla.style.height = '70px';

                    //Configuramos la posición de la imagen.
                    imagenIsla.style.position = 'absolute';
                    imagenIsla.style.top = '0px';
                    imagenIsla.style.left = '30px';

                    //Configuramos la posición del párrafo de información.
                    textoSeleccionado.style.position = 'absolute';
                    textoSeleccionado.style.top = '70px';
                    textoSeleccionado.style.left = '600px';

                    //Configuramos la fuente de la imagen de acuerdo a la isla seleccionada. Para ello utilizaremos la tabla de acrónimos.
                    imagenIsla.src = `islas/${islaSeleccionadaAcr.toLowerCase()}.png`;
                    imagenIsla.alt = `Imagen de la isla ${islaSeleccionadaNombre}`;

                    //Limpiamos el contenedor de imágenes y agregamos la nueva imagen.
                    contenedorImagen.innerHTML = '';
                    contenedorImagen.appendChild(imagenIsla);
                    contenedorImagen.style.visibility = 'visible';

                    //Cambiamos el color de los otros municipios a azul, excepto el seleccionado.
                    municipiosLista.forEach(function (municipioItem) {
                        if (municipioItem !== event.target) {
                            municipioItem.style.color = 'rgb(0, 4, 255)';
                        }
                    });
                }
            });
        });
    }

    //Creamos una opción vacía y la agregamos al select de islas, tal y como se muestra en el vídeo de ejemplo proporcionado para la práctica.
    const opcionVacia = document.createElement('option');
    opcionVacia.value = '';
    opcionVacia.textContent = '';
    islasSelect.appendChild(opcionVacia);

    //Agregamos un evento de cambio al select de provincias.
    provinciasSelect.addEventListener('change', function () {
        //Limpiamos y ocultamos los municipios.
        limpiarMunicipios();
        const provinciaSeleccionada = provinciasSelect.value;
        //Limpiamos las opciones del select de islas.
        islasSelect.innerHTML = '';

        //Si el usuario selecciona Santa Cruz de Tenerife o Las Palmas de Gran Canaria:
        if (provinciaSeleccionada === 'SC' || provinciaSeleccionada === 'LPGC') {
            const opcionProvincia = document.createElement('option');
            opcionProvincia.value = provinciaSeleccionada;
            opcionProvincia.textContent = provinciaSeleccionada;
            //Agregamos la opción vacía.
            islasSelect.appendChild(opcionVacia);
            islasSelect.appendChild(opcionProvincia);
            //Desactivamos la opción de provincia.
            opcionProvincia.disabled = true;
            //Configuramos el estilo de la opción.
            opcionProvincia.style.fontWeight = 'bold';
            for (const isla of islas[provinciaSeleccionada]) {
                const opcion = document.createElement('option');
                opcion.value = isla;
                opcion.textContent = isla;
                //Agregamos las islas correspondientes.
                islasSelect.appendChild(opcion);
            }
            //Mostramos el select de islas y la etiqueta.
            islasSelect.style.visibility = 'visible';
            islasSelect.style.position = 'static';
            islasLabel.style.visibility = 'visible';
        } else {
            //Si no se selecciona una provincia correctamente, ocultaremos los elementos siguientes:
            islasSelect.style.visibility = 'hidden';
            islasSelect.style.position = 'absolute';
            islasLabel.style.visibility = 'hidden';
            parrafo.style.visibility = 'hidden';
            contenedorImagen.style.visibility = 'hidden';
        }
    });

    //Agregamos un evento de cambio al select de islas.
    islasSelect.addEventListener('change', function () {

        //Limpiamos y ocultamos los municipios.
        limpiarMunicipios();

        const islaSeleccionadaNombre = islasSelect.value;
        const islaSeleccionadaAcr = acronimosIsla[islaSeleccionadaNombre];
        municipiosIsla = document.getElementById(islaSeleccionadaAcr);

        //Configuramos la posición de la lista de municipios de la isla seleccionada.
        municipiosIsla.style.position = 'absolute';
        municipiosIsla.style.top = '0px';
        municipiosIsla.style.left = '700px';

        //Ocultamos el párrafo de información.
        parrafo.style.visibility = 'hidden';
        municipios.forEach(function (municipio) {
            //Ocultamos todas las listas de municipios.
            municipio.style.display = 'none';
        });
        //Ocultamos el contenedor de imágenes.
        contenedorImagen.style.visibility = 'hidden';

        if (municipiosIsla) {
            //Mostramos la lista de municipios de la isla seleccionada.
            municipiosIsla.style.display = 'inline-block';
        }
    });

});
//Derimán Tejera Fumero 2DAW Semi B