//document.addEventListener garantiza que se ha ejecutado todo el documento HTML antes de ejecutarse para garantizar que ya existen todos los elementos a los que se va a hacer referencia en el script.
document.addEventListener('DOMContentLoaded', function () {
    //Objenemos todas las referncias a todos los IDs indicados entre ' ' en la página HTML.
    const opcionSelect = document.getElementById('opcion');
    const baseInput = document.getElementById('base');
    const exponenteInput = document.getElementById('exponente');
    const botonCalcular = document.getElementById('calcular');
    const resultadoFinal = document.getElementById('resultado');

    //Cuando se hace click en el botón calcular, se ejeecutará la función
    botonCalcular.addEventListener('click', function () {
        //Almacenamos la elección del usuario en const opcion para ejecutar en el switch el case que le corresponda.
        const opcion = opcionSelect.value;

        //Switch con los tres cálculos a afectuar:
        switch (opcion) {
            case '1':
                //Realizamos una conversión forzada a parseFloat para evitar la entreada de caracteres en lugar de números, así evitamos este tipo de errores.
                const base = parseFloat(baseInput.value);
                const exponente = parseFloat(exponenteInput.value);

                //Verificamos que base y exponente son números válidos, ambos deben serlo para ejecuar el cálculo. 
                if (!isNaN(base) && !isNaN(exponente)) {
                    //La función Math.pow toma los dos valores, la base elevado al exponente y almacena el resultado en const resultado.
                    const resultado = Math.pow(base, exponente);
                    //Devolvemos por pantalla una cadena de texto con los detalles de la operación realizada y su resultado.
                    resultadoFinal.textContent = `La potencia de ${base} elevado a ${exponente} es: ${resultado}`;
                } else {
                    resultadoFinal.textContent = 'Por favor, ingresa valores válidos.';
                }
                break;
            case '2':
                const numeroRaiz = parseFloat(baseInput.value);

                if (!isNaN(numeroRaiz) && numeroRaiz >= 0) {
                    const resultado = Math.sqrt(numeroRaiz);
                    resultadoFinal.textContent = `La raíz de ${numeroRaiz} es: ${resultado}`;
                } else {
                    resultadoFinal.textContent = 'Por favor, ingresa un número no negativo válido.';
                }
                break;
            case '3':
                const numeroRedondeo = parseFloat(baseInput.value);

                if (!isNaN(numeroRedondeo)) {
                    const resultado = Math.round(numeroRedondeo);
                    resultadoFinal.textContent = `El redondeo del número ${numeroRedondeo} es: ${resultado}`;
                } else {
                    resultadoFinal.textContent = 'Por favor, ingresa un número válido.';
                }
                break;
            //Aunque en principio no es posible seleccionar otra opción, por buenas prácticas se ha creado una opción default por si la selección de opciones en el menú no es ni 1, ni 2 ni 3.
            default:
                resultadoFinal.textContent = 'Por favor, selecciona una opción válida.';
        }
    });
});
//Derimán Tejera Fumero 2DAW Semi B