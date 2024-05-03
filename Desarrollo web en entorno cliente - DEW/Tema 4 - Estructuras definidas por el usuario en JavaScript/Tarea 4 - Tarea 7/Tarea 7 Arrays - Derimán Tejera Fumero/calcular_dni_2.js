//Definimos en un array todos las letras que pueden aparecer en los DNI.
var letras = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'];

//Función que calculará la letra del DNI.
function calcularLetraDNI() {
    //Obtenemos y almacenamos el número DNI que introduce el usuario en el formulario.
    var dniInput = document.getElementById("dniInput");
    var numeroDNI = dniInput.value;

    //Validamos si el usuario ha introducido un número válido para un DNI.
    if (!numeroDNI || isNaN(numeroDNI) || numeroDNI.length !== 8) {
        alert("Por favor, introduzca un número de DNI válido de 8 dígitos exactos.");
        return;
    }

    //Transformamos el número del DNI en un número entero para poder hacer cálculos sobre él.
    var dniNumero = parseInt(numeroDNI, 10);
    //Obtenemos la letra calculando el módulo del número de DNI del usuario (%23) y así obtener el índice en el array que contiene la letra.
    var letraCalculada = letras[dniNumero % 23];

    //Mostramos la letra calculada en la pantalla del navegador.
    var resultadoDNI = document.getElementById("resultadoDNI");
    resultadoDNI.innerHTML = "La letra de tu DNI es: " + letraCalculada;
}

//Con esta función generamos un número aleatorio entre un mínimo (incluido) y máximo (excluido).
function aleatorio(min, max) {
    //Aquí utilizamos Math.floor para redondear hacia abajo y asegurar que el número es un entero.
    return Math.floor(Math.random() * (max - min) + min);
}

//Función para separar números pares e impares en dos vectores diferentes.
function par_impar(vector_par, vector_impar) {
    for (var i = 0; i < vector_par.length; i++) {
        //Para descubrir si es par o impar se hallará el módulo del número entre 2, si no es 0, entonces será impar.
        if (vector_par[i] % 2 !== 0) {
            //Si el número es impar se añadirá al final del vector_impar.
            vector_impar.push(vector_par[i]);
            //Eliminamos el número impar del vector_par.
            vector_par.splice(i, 1);
            //Al eliminarse un número en el paso anterior, deberemos resta 1 a i para asegurarnos de no saltarnos el siguiente iteración del bucle.
            i--;
        }
    }
}

//Prototipo para eliminar los valores duplicados en un array.
Array.prototype.Duplicados = function () {
    for (var i = 0; i < this.length; i++) {
        var elemento = this[i];
        var indice = this.lastIndexOf(elemento);
        if (indice !== i) {
            this.splice(indice, 1);
        }
    }
};

//Función para generar 50 números aleatorios en un rango determinado y luego separarlos en un array par y otro impar. 
function generarNumeros() {
    //Obtenermos los rangos mínimo y máximo introducidos por el usuario en el formulario.
    var minimo = parseInt(document.getElementById("minimoInput").value);
    var maximo = parseInt(document.getElementById("maximoInput").value);
    //Creamos dos arrays, uno para los números pares y otro para los impares.
    var vector_par = [];
    var vector_impar = [];

    //Generamos los números pares e impares y los enviamos a sus respectivos arrays.
    for (var i = 0; i < 50; i++) {
        var numero = aleatorio(minimo, maximo);
        if (numero % 2 === 0) {
            vector_par.push(numero);
        } else {
            vector_impar.push(numero);
        }
    }
    //Ordenamos los dos arrays mediante la función sort de menor a mayor.
    //Tomaremos dos valores, a y b para compararlos. Si a<b devuelve un valor negativo. Si a<b devuelve un valor negativo. Si a==b devuelve 0. Si a>b devuelve un valor positivo.  De esta forma sort ordenará los número de forma ascendete.
    vector_par.sort(function (a, b) { return a - b; });
    vector_impar.sort(function (a, b) { return a - b; });

    //Eliminamos los números duplicados de las funciones par e impar llamando a la función Duplicados() definida mas arriba.
    vector_par.Duplicados();
    vector_impar.Duplicados();

    //Llamamos a la función para mostrar los resultados de ambos arrays.
    mostrarResultados(vector_par, vector_impar);
}

//Función para mostrar los resultados en el navegador.
function mostrarResultados(vector_par, vector_impar) {
    //Almacenamos las referencias de las IDs.
    var resultadoNumeros = document.getElementById("resultadoNumeros");
    var resultadoDNI = document.getElementById("resultadoDNI");

    //Limpiamos posibles resultados anteriores que permanezcan en el navegador.
    resultadoNumeros.innerHTML = "";
    resultadoDNI.innerHTML = "";

    //Mostraremos el intervalo elegido.
    var minimoInput = parseInt(document.getElementById("minimoInput").value);
    var maximoInput = parseInt(document.getElementById("maximoInput").value);
    var intervaloElegido = "<h3>El intervalo elegido es [" + minimoInput + ", " + maximoInput + "]</h3><br>";

    //Mostraremos los intervalo encima de "Vectores inicialmente".
    resultadoNumeros.innerHTML += intervaloElegido;

    //Mostrar vectores concatenandolos pero manteniendolos separados por una , .
    resultadoNumeros.innerHTML += "<h3>Vectores inicialmente</h3><br>";
    resultadoNumeros.innerHTML += "<p>vector_par " + vector_par.join(", ") + "</p>";
    resultadoNumeros.innerHTML += "<p>vector_impar " + vector_impar.join(", ") + "</p><br>";

    //Ordenamos los vectores de forma ascendente.
    vector_par.sort(function (a, b) { return a - b; });
    vector_impar.sort(function (a, b) { return a - b; });

    //Creamos la sección "Vectores ordenados" y mostramos todo el contenido de los dos vectores por separado.
    resultadoNumeros.innerHTML += "<h3>Vectores ordenados</h3><br>";
    resultadoNumeros.innerHTML += "<p>vector_par " + vector_par.join(", ") + "</p>";
    resultadoNumeros.innerHTML += "<p>vector_impar " + vector_impar.join(", ") + "</p><br>";

    //Creamos la sección "Vectores organizados en pares e impares con posibles valores duplicados" y mostramos todo el contenido de los dos vectores por separado.
    resultadoNumeros.innerHTML += "<h3>Vectores organizados en pares e impares con posibles valores duplicados</h3><br>";
    resultadoNumeros.innerHTML += "<p>Vector_par " + vector_par.join(", ") + " su tamaño es " + vector_par.length + "</p>";
    resultadoNumeros.innerHTML += "<p>Vector_impar " + vector_impar.join(", ") + " su tamaño es " + vector_impar.length + "</p><br>";

    //Creamos la sección "Vectores ordenados sin duplicados" y mostramos todo el contenido de los dos vectores pero esta vez sin duplicados.
    resultadoNumeros.innerHTML += "<h3>Vectores ordenados sin duplicados</h3><br>";
    resultadoNumeros.innerHTML += "<p>Vector_par " + [...new Set(vector_par)].join(", ") + " su tamaño es " + [...new Set(vector_par)].length + "</p>";
    resultadoNumeros.innerHTML += "<p>Vector_impar " + [...new Set(vector_impar)].join(", ") + " su tamaño es " + [...new Set(vector_impar)].length + "</p>";
}
//Derimán Tejera Fumero 2DAW Semi B