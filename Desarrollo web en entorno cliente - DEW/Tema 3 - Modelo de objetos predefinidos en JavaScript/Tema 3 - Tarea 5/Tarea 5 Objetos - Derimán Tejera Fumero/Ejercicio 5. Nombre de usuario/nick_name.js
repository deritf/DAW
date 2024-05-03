function generarNombresDeUsuario() {
    //Conseguimos los valores introducidos por el usuario en cada campo y los asignamos a constantes para trabajar con ellos. Los localizamos gracias a la ID.
    const nombre = document.getElementById("nombre").value;
    const apellido1 = document.getElementById("apellido1").value;
    const apellido2 = document.getElementById("apellido2").value;

    //Creamos las opcines de nombres para el usuario y se las asignamos a Opcion1 y 2.
    //En Opción1 cogemos la primera letra del nombre, las tres primeras letras de apellido1 y las tres primeras letras de apellid2.
    const Opcion1 = nombre.charAt(0) + apellido1.slice(0, 3) + apellido2.slice(0, 3);
    //En Opción1 cogemos las tres primeras letras del nombre, las tres primeras letras de apellido1 y las tres primeras letras de apellid2.
    const Opcion2 = nombre.slice(0, 3) + apellido1.slice(0, 3) + apellido2.slice(0, 3);

    //Mostramos las opciones que generamos en la página principal en la ID
    const resultados = document.getElementById("resultados");

    //Transformamos las dos opciones a minúsculas como indica el enunciado.
    const opcion1EnMinuscula = Opcion1.toLowerCase();
    const opcion2EnMinuscula = Opcion2.toLowerCase();

    //Mostramos el resultado de las dos opciones.
    resultados.innerHTML = `Opción 1: ${opcion1EnMinuscula}<br>Opción 2: ${opcion2EnMinuscula}`;
}
//Derimán Tejera Fumero 2DAW Semi B