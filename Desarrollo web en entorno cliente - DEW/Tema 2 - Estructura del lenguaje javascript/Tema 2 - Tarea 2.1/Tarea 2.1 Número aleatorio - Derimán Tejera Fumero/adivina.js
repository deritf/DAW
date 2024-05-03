const MAX_INTENTOS = 5;
let intentos = 0;
const numeroAleatorio = Math.floor(Math.random() * 101);

function adivinarNumero() {
    intentos++;
    const numeroUsuario = parseInt(document.getElementById("numeroUsuario").value);

    if (isNaN(numeroUsuario) || numeroUsuario < 0 || numeroUsuario > 100) {
        alert("Ingresa un número válido entre 0 y 100.");
        return;
    }

    switch (true) {
        case numeroUsuario === numeroAleatorio:
            document.getElementById("resultado").textContent = `¡Felicidades Adivinaste el número ${numeroAleatorio} en ${intentos} intentos!`;
            break;
        case intentos === MAX_INTENTOS:
            document.getElementById("resultado").textContent = `¡Has fallado! El número era ${numeroAleatorio}.`;
            break;
        case numeroUsuario < numeroAleatorio:
            document.getElementById("resultado").textContent = `Intento ${intentos}/${MAX_INTENTOS}: El número es MAYOR. Inténtalo de nuevo.`;
            break;
        case numeroUsuario > numeroAleatorio:
            document.getElementById("resultado").textContent = `Intento ${intentos}/${MAX_INTENTOS}: El número es MENOR. Inténtalo de nuevo.`;
            break;
    }
}
//Derimán Tejera Fumero 2DAW Semi B