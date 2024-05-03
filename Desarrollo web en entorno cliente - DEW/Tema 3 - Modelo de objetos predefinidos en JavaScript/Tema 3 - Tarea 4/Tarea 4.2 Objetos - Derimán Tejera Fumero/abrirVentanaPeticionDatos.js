/*
El siguiente código es una adaptación de la siguiente fuente:
https://developer.mozilla.org/en-US/docs/Web/API/Window/navigator
He usado este código por que Visual Studio Code marca "navigator.appCodeName" como "Deprecated"
y no funciona correctamente.
*/
function obtenerNombreNavegador() {
//Obtiene la cadena "navigator.userAgent" y se la asigna a la variable userAgent.
    var userAgent = navigator.userAgent;

//Ahora en este apartado se buscarán nombres clave en var userAgent y si los encuentra devolverá un nombre de navegador.
    if (userAgent.includes("Firefox")) {
        return "Mozilla Firefox";
      } else if (userAgent.includes("SamsungBrowser")) {
        return "Samsung Internet";
      } else if (userAgent.includes("Opera") || userAgent.includes("OPR")) {
        return "Opera";
      } else if (userAgent.includes("Edge")) {
        return "Microsoft Edge (Legacy)";
      } else if (userAgent.includes("Edg")) {
        return "Microsoft Edge (Chromium)";
      } else if (userAgent.includes("Chrome")) {
        return "Google Chrome or Chromium";
      } else if (userAgent.includes("Safari")) {
        return "Apple Safari";
      } else {
        return "unknown";
      }
}

function abrirVentanaNueva(nombreNavegador) {

//Creamos la variable "var nombreNavegador" y le pasamos el resultado de la llamada a la función "obtenerNombreNavegador".
    var nombreNavegador = obtenerNombreNavegador();

//Abrimos una nueva ventana "window.open"
    var nuevaVentana = window.open(
        "",
        "nueva",
        "resizable=0, width=800, height=600"
//"" le dice al navegador que abra la nueva ventana sin una dirección en particular.
//"nueva" nombre para la ventana que utilizará como identificador. También provoca la cración de la nueva ventana separada de la principal.
//resizable=0 para impedir que el usuario redimensione la ventana. En la última versión firefox (118.0.2) parece no respetar esta instrucción.
//width=800 especifica que la ventana tiene un ancho de 800 píxeles.
//height=600 especifica que la ventana tiene un ancho de 600 píxeles.

    );
        nuevaVentana.document.open();

//Escribimos contenido en la nueva ventana.
        nuevaVentana.document.write("<h3>Ejemplo Ventana Nueva</h3>");
        nuevaVentana.document.writeln("URL completa: " + nuevaVentana.document.URL + "<br>");
        nuevaVentana.document.writeln("Protocolo utilizado: " + nuevaVentana.location.protocol + "<br>");
        nuevaVentana.document.writeln("Nombre en código del navegador: " + nombreNavegador + "<br>");

//Comprobamos que Java está habilitado en la venana y devuelve un mensaje indicando SI o NO según sea el caso.
        if (nuevaVentana.navigator.javaEnabled === true) {
            nuevaVentana.document.writeln("Java SI disponible en esta ventana<br>");
        } else {
            nuevaVentana.document.writeln("Java NO disponible en esta ventana<br>");
        }
//Inserta en la URL de la venana nueva un enlace, para este caso he usado la página del agregador de noticias meneame.net.
//Además se especifica las dimensiones que deberá tener la página.
        nuevaVentana.document.writeln('<iframe src="https://www.meneame.net/" width="800" height="600"></iframe>');
}

function obtenerDatosUsuario() {

//Solicitamos al usuario mediante un prompt su nombre completo
    var nombreCompleto = prompt("Introduzca su nombre y apellidos:");

/*Utilizamos un bucle do while para verificar una entrada correcta de datos en 
este caso un día ente 1 y 31, de lo contrario mostrará un mensaje indicando el error y el bucle se reiniciará.
Otra condición utilizada es isNaN "is Not a Number" que devolverá false si lo que ha escrito el usuario no es un número o no se puede convertir en un núemro.
Utilizaremos esto a lo largo de todo el código para verificar la entrada de datos por parte del usuario.
*/
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

/*A la hora de mostrar los resultados en el resumen final, me di cuenta de que indicarlo con número al menos para mi es confuso
pudiendo utilizar directamente el nombre del mesNacimiento. Por esto utilizaré un switch para convertir el número del mes en el nombre
de dicho mes y asignarselo a una variable llamada "nombreMes" a la que llamaré en el resumen final, mostrando un resultado mas "humano".
*/
    console.log("Mes nacimiento " + mesNacimiento);
    var nombreMes;
    switch (mesNacimiento) {
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

//Solicita al usuario un año de nacimiento, no he especificado limitaciones en este dato ya que puede ser mucho mas variable que los otros.
    var anoNacimiento = prompt("Introduzca AÑO de nacimiento:");

/*Creamos un objeto Date con el nombre "fechaNacimiento" que representa la fecha completa de nacimiento del usuario. Para generar esta fecha utilizaremos:
anoNacimiento: Es el año introducido por el usuario.
mesNacimiento: Es el mes introducido por el usuario. Le restamos -1 porque en JS los meses se representan del 0 al 11, pero al usuario le solicitamos un mes del 1 al 12, así quedaría ajsutado.
diaNacimiento: Es el día de nacimiento del usuario.
*/
    var fechaNacimiento = new Date(anoNacimiento, mesNacimiento, diaNacimiento);
//fechaActual es la fecha tomada del sistema en el momento en el que se ejecuta ésta línea de código.
    var fechaActual = new Date();
//Para calcular la edad del usuario restamos las dos fechas, la actual del sistema y la proporcionada por el usuario. El resultado será la diferencia en milisegundos entre ambas.
    var edad = Math.floor((fechaActual - fechaNacimiento) / (365.25 * 24 * 60 * 60 * 1000));
//Calculamos la edad del usuario utilizando "Math.floor" para reondear hacia abajo porque coloquialmente la edad se dice en años enteros, no en fracciones de año.
//Para obtener el resultado en años, el resultado en milisegundos lo dividimos entre: 365.25 días que tiene el año * 24 horas * 60 minutos * 60 segundos * 1000 milisegundos.

    realizarCalculos(nombreCompleto, diaNacimiento, mesNacimiento, nombreMes, anoNacimiento, edad);
}

//Creamos una función llamada "realizarCalculos" que toma datos de otra llamada "datosUsuario":
function realizarCalculos(nombreCompleto, diaNacimiento, mesNacimiento, nombreMes, anoNacimiento, edad) {
//Buscamos la primera aparición de la letra "a" en el nombre completo del usuario.
    var primeraA = nombreCompleto.indexOf("a");
//Buscamos la última aparición de la letra "a" en el nombre completo del usuario.
    var ultimaA = nombreCompleto.lastIndexOf("a");
//Elimina las tres primeras letras del nombre completo del usuario.
    var nombreSinTresPrimeras = nombreCompleto.slice(3);
//Pone en mayúscula en nombre completo del usuario.
    var nombreEnMayusculas = nombreCompleto.toUpperCase();
//Utilizamos la función Math.cos para calcular el coseno de 180 grados.
    var coseno180 = Math.cos(180 * Math.PI / 180);
//Creamos un array con varios números y luego utilizamos Math.max para extraer de ellos el mayor y se lo pasamos a la variable numeroMayor.
    var numeros = [34, 67, 23, 75, 35, 19];
    var numeroMayor = Math.max(...numeros);
//Utilizamos Math.random para elegir un número al azar de 0 a 999.999.999. Luego utilizamos Math.floor para redondear a la baja y mostrar solo número enteros.
    var numeroAzar = Math.floor(Math.random() * 1000000000);

//Muestra todos los resultados en la ventana principal, los datos aparecerán entre dos líneas separadoras que ya indicamos en el HTML -> <hr />.
    document.write("Buenos días " + nombreCompleto + "<br>");
    document.write("Tu nombre tiene " + nombreCompleto.length + " caracteres, incluidos espacios.<br>");
    document.write("La primera letra A de tu nombre está en la posición: " + primeraA + "<br>");
    document.write("La última letra A de tu nombre está en la posición: " + ultimaA + "<br>");
    document.write("Tu nombre menos las 3 primeras letras es: " + nombreSinTresPrimeras + "<br>");
    document.write("Tu nombre todo en mayúsculas es: " + nombreEnMayusculas + "<br>");
    document.write("Tu edad es: " + edad + " años.<br>");
    document.write("Naciste un feliz " + diaNacimiento + " de " + nombreMes + " del año " + anoNacimiento + ".<br>");
    document.write("El coseno de 180 es: " + coseno180 + "<br>");
    document.write("El número mayor de (34,67,23,75,35,19) es: " + numeroMayor + "<br>");
    document.write("Ejemplo de número al azar: " + numeroAzar + "<br>");
}

/* Llamamos a las funciones por orden para que en primer lugar abra la ventana auxiliar y luego en la ventana principal pida al usuario los datos para hacer los 
cálculos con ellos. Para, al final mostrar los cálculos realizados con todos esos datos.*/
abrirVentanaNueva();
obtenerDatosUsuario();
realizarCalculos(nombreCompleto, diaNacimiento, mesNacimiento, nombreMes, anoNacimiento, edad);
//Derimán Tejera Fumero 2DAW Semi B