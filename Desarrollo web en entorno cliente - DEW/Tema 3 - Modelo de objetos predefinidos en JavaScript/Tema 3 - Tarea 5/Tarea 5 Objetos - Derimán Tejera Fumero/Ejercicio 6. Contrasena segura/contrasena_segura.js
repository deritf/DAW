//Esta función se activa cuando se ha cargado todo el contenido de la página HTML para asegurarnos de que efectivamente se a cargado antes de activar esta función.
document.addEventListener("DOMContentLoaded", function () {
    
    //En ambos casos se almacena una referencia vinculada con una ID del archivo HTML.
    const formulario = document.getElementById("formulario");
    const texto = document.getElementById("texto");

    //Creamos un evento de escucha que se ejecuta cuando el usuario hace clic en el botón verificar.
    formulario.addEventListener("submit", function (e) {
        //Con e.preventDefault() evitamos que la página recargue y permite ver el resultado de verificar_seguridad.
        e.preventDefault();
        //Accedemos a la contraseña escrita por el usuario a través de la ID "contrasena" y la asignamos a const contrasena.
        const contrasena = document.getElementById("contrasena").value;

        //Llamamos a la función verificar_seguridad para que actúe sobre el argumento contrasena.
        //Si (verificar_seguridad(contrasena)) cumple correctamente con la verificación que hace la función, entonces devuelve true y muestra que la contraseña es SEGURA, si no lo cumple es false y ejecuta NO SEGURA.
        if (verificar_seguridad(contrasena)) {
            texto.textContent = "Contraseña SEGURA.";
        } else {
            texto.textContent = "Contraseña NO SEGURA.";
        }
    });

    function verificar_seguridad(contrasena) {
        //Calculamos la longitud de la contraseña y la almacenamos para verificar si está entre 8 y 16 caracteres.
        const length = contrasena.length;

        //Aquí realizamos la verificación de todos los criterios necesarios para considerarla segura. Utilizaremos && que es "and" por lo que deben cumplirse todas para retornar true, de lo contrario, si falla 1 sola devolverá false.
        //Utilizaremos expresiones regulares sencillas y test, que devolverá true si se cumple la condición de dicho apartado.
        return length >= 8 && length <= 16 && /[A-Z]/.test(contrasena) && /[a-z]/.test(contrasena) && /\d/.test(contrasena) && /[-_@#$%&]/.test(contrasena);
    }    
});
//Derimán Tejera Fumero 2DAW Semi B