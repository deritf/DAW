function mostrarHora() {
    //Creamos un objeto Date para obtener la hora al ejecutar el programa.
    const ahora = new Date();
    //Extraemos la hora actual del objeto ahora que almacena la hora completa del sistema.
    let hora = ahora.getHours();
    //Extraemos los minutos actuales.
    let minutos = ahora.getMinutes();
    //Extraemos los segundos actuales.
    let segundos = ahora.getSeconds();
    //Inicializamos la variable amPM con AM en un primer momento. Esto podría cambiar luego en el if.
    let AM_PM = "AM";

    //Cambiamos a formato de 12 horas (AM/PM) si la hora es mayor o igual a 12.
    if (hora >= 12) {
        AM_PM = "PM";
    }

    //Cambiamos la hora a 00:00 si es mayor que 0 restando 12 a el valor de hora.
    if (hora > 12) {
        hora = hora - 12;
    }

    //Agregamos ceros a los minutos y segundos para mantener el formato 00:00.
    const minutosFormateados = minutos < 10 ? `0${minutos}` : minutos;
    const segundosFormateados = segundos < 10 ? `0${segundos}` : segundos;

    //Almacenamos las horas en los dos formatos pedidos para luego enviar a pantalla.
    const horaDetallada = `${hora}:${minutosFormateados}:${segundosFormateados}`;
    const horaAmPm = `${hora}:${minutosFormateados} ${AM_PM}`;

    //Mandamos a la pantalla principal las horas solicitadas con un texto especifinado que se muestra.
    document.getElementById("hora-completa").textContent = `${horaDetallada}`;
    document.getElementById("hora-ampm").textContent = `${horaAmPm}`;
}

//Llamamos a la función para mostrar la hora en la página principal.
mostrarHora();
//Derimán Tejera Fumero 2DAW Semi B