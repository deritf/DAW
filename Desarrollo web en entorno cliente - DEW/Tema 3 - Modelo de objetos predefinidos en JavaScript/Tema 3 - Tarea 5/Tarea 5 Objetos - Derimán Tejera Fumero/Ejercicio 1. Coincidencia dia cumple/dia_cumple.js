/* La función: obtenerDiaSemana(fecha), obtiene el día en el que nació el usuario a partir de una fecha. */
function obtenerDiaSemana(fecha) {
  //En el array diasSemana se almacenan los nombres de los días de la semana.
  const diasSemana = ["Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"];
  //Creamos un objeto con la fecha que le pasamos.
  const fechaNacimiento = new Date(fecha);
  //Obtenemos el nombre del día de la semana que le corresponde: 0 -> Domingo, 1 -> Lunes, 2 -> Martes etc...
  const diaSemana = fechaNacimiento.getDay();
  //Se devuelve el nombre del día de la semana que corresponda.
  return diasSemana[diaSemana];
}

/* La función: encontrarAniosMismoDiaSemana(fechaNacimiento, diaSemanaObjetivo), encuentra los años en los que coinciden el día del cumpleaños con el del nacimiento. */
function encontrarAniosMismoDiaSemana(fechaNacimiento, diaSemanaObjetivo) {
  //Creamos un objeto fecha partiendo de la fecha de nacimiento.
  const fechaNacimientoDate = new Date(fechaNacimiento);
  //Obtenemos el año inicial desde el que vamos a buscar la coincidencia de días. 
  const anioInicial = fechaNacimientoDate.getFullYear() + 1;
  let anioActual = anioInicial;
  const anios = [];

  //Creamos un bucle para buscar desde el año marcado como inicial hasta el año 2100.
  while (anioActual <= 2100) {

    fechaNacimientoDate.setFullYear(anioActual);
    //Si el día de la semana de la fecha de nacimiento coincide con el día de la semana de otros años, entonces lo añade. 
    if (obtenerDiaSemana(fechaNacimientoDate) === diaSemanaObjetivo) {
      anios.push(anioActual);
    }
    //Incrementamos el año para buscar en el siguiente.
    anioActual++;
  }

  //Devolvemos la lista de los años.
  return anios;
}

/* La función: obtenerDatosUsuario(), pide al usuario todos los datos necesarios para poder realizar los cálculos. */
function obtenerDatosUsuario() {
  var diaNacimiento;
  do {
    diaNacimiento = parseInt(prompt("Introduzca DIA de nacimiento [1-31]:"));
    if (isNaN(diaNacimiento) || diaNacimiento < 1 || diaNacimiento > 31) {
      alert("Por favor, introduzca un número válido para el día (entre 1 y 31).");
    }
  } while (isNaN(diaNacimiento) || diaNacimiento < 1 || diaNacimiento > 31);

  var mesNacimiento;
  do {
    mesNacimiento = parseInt(prompt("Introduzca MES de nacimiento [1-12]:"));
    if (isNaN(mesNacimiento) || mesNacimiento < 1 || mesNacimiento > 12) {
      alert("Por favor, introduzca un número válido para el mes (entre 1 y 12).");
    }
  } while (isNaN(mesNacimiento) || mesNacimiento < 1 || mesNacimiento > 12);

  var anoNacimiento;
  do {
    anoNacimiento = parseInt(prompt("Introduzca AÑO de nacimiento:"));
    if (isNaN(anoNacimiento) || anoNacimiento < 1000) {
      alert("Por favor, introduzca un número válido para el año (mayor que 1000).");
    }
  } while (isNaN(anoNacimiento) || anoNacimiento < 1000);
  

  //Construirmos la fecha de nacimiento  con todos los datos que ha aportado el usuario en el código anterior. 
  //El formato elegido es el mas idóneo para adaptarse a JavaScript, luego los manipularemos para mostrarlos en otro formato las legible.
  const fechaNacimiento = `${anoNacimiento}-${mesNacimiento}-${diaNacimiento}`;
  //Llamamos a la función calcularCumpleanos(fechaNacimiento); y le pasamos la fecha para que pueda mostrar los años coincidentes.
  calcularCumpleanos(fechaNacimiento);
}

/* La función: function calcularCumpleanos(fechaNacimiento), calculará el día de la semana coincidente y mostrará los resultados por la página. */
function calcularCumpleanos(fechaNacimiento) {
  //Obtenemos el día de la semana de la fecha de nacimiento que proporcionó el usuario.
  const diaSemanaNacimiento = obtenerDiaSemana(fechaNacimiento);
  //Obtenemos el elemento en index.html donde mostraremos todos los años coincidentes.
  const resultadoElement = document.getElementById("resultado");

  if (diaSemanaNacimiento) {
    //Creamos un objeto con la fecha de nacimiento.
    const fechaNacimientoDate = new Date(fechaNacimiento);
    //Obtenemos el día, el mes y el año de nacimiento.
    const diaNacimiento = fechaNacimientoDate.getDate();
    const mesNacimiento = obtenerNombreMes(fechaNacimientoDate.getMonth() + 1); // Sumamos 1 para obtener el mes correcto. JS = 0 a 11.
    const anioNacimiento = fechaNacimientoDate.getFullYear();

    //Creamos un mensaje a modo de resumen en el que mostramos al usuario los datos que ha introducido, así podrá verificar si son correctos o no y si los resultados generados le son últiles.
    const mensaje = `Naciste un ${diaSemanaNacimiento}, el ${diaNacimiento} de ${mesNacimiento} de ${anioNacimiento}.`;
    //Mostramos el mensaje anterior en la página principal.
    resultadoElement.innerHTML = `<h2>${mensaje}</h2>`;
    //Encontramos los años en los que el cumpleaños del usuario cae el mismo día.
    const aniosMismoDiaSemana = encontrarAniosMismoDiaSemana(fechaNacimiento, diaSemanaNacimiento);


    if (aniosMismoDiaSemana.length > 0) {
      //Mostramos los años en los que se produce la coincidencia de día de la semana para el cumpleaños.
      resultadoElement.innerHTML += `<p>Tu cumpleaños volverá a caer en un ${diaSemanaNacimiento} en los años:<br>${aniosMismoDiaSemana.join("<br>")}</p>`;
    } else {
      //Mostramos este mensaje si no hay mas años con coincidencia.
      resultadoElement.innerHTML += "<p>No volverás a cumplir años en el mismo día de la semana hasta el 2100.</p>";
    }
  } else {
    //Mostramos mensaje de error si la fecha introducida no es válida. Se produce error cuando el año tiene menos de 4 cifras (1000), y aunque debería quedar resuelto con las condiciones impuestas
    //al introducir año, por seguridad o otros imprevistos no contemplados he decidido conservarla.
    resultadoElement.innerHTML = "<p>Fecha de cumpleaños inválida.</p>";
  }
}

/* La función: obtenerNombreMes(numeroMes), transformará el número entero que representa el mes introducido por el usuario en el propio nombre del mes. */
function obtenerNombreMes(numeroMes) {
  let nombreMes;

  switch (numeroMes) {
    case 1:
      nombreMes = "Enero";
      break;
    case 2:
      nombreMes = "Febrero";
      break;
    case 3:
      nombreMes = "Marzo";
      break;
    case 4:
      nombreMes = "Abril";
      break;
    case 5:
      nombreMes = "Mayo";
      break;
    case 6:
      nombreMes = "Junio";
      break;
    case 7:
      nombreMes = "Julio";
      break;
    case 8:
      nombreMes = "Agosto";
      break;
    case 9:
      nombreMes = "Septiembre";
      break;
    case 10:
      nombreMes = "Octubre";
      break;
    case 11:
      nombreMes = "Noviembre";
      break;
    case 12:
      nombreMes = "Diciembre";
      break;
    default:
      nombreMes = "Mes no válido";
      break;
  }

  return nombreMes;
}

//Llamamos inicial que es obtenerDatosUsuario(); para iniciar toda la secuencia de funciones que la enlazan de alguna manera.
obtenerDatosUsuario();
//Derimán Tejera Fumero 2DAW Semi B