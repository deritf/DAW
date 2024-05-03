/*
Realizar la validación del formulario facilitado en el enunciado, usando el Modelo de registro avanzado de eventos según W3C, cumpliendo los siguientes requisitos:

    Programar el código de JavaScript en un fichero independiente. Las modificaciones que se permiten realizar en el fichero .html son la de escribir la referencia al fichero de JavaScript para enlazarlo solamente. No se permite cambiar los type de los inputs.

    Almacenar en una cookie el número de intentos de envío del formulario que se van produciendo y mostrar un mensaje en el id="intentos" similar a: "Intento de Envíos del formulario: X". Es decir cada vez que le demos al botón de enviar tendrá que incrementar el valor de la cookie en 1 y mostrar su contenido en el id="intentos" del HTML.

    Todos los campos del formulario son obligatorios rellenarlos para enviar el formulario. Una vez que los campos NOMBRE y APELLIDOS pierdan el foco, el contenido que se haya escrito en esos campos se convertirá en, la primera letra en mayúsculas y el resto en mínusculas.

    Validar los campos de texto NOMBRE y APELLIDOS, NOMBRE pueden ser hasta 20 letras incluído espacio en blanco por si tiene un nombre compuesto. Y APELLIDO hasta 35 letras incluido en varias ocasiones espacio en blanco por si tiene un apellido compuesto. Si se produce algún error, mostrar el mensaje personalizado en el id="errores" del HTML, y poner el foco en el campo correspondiente. También se deberá poner el borde del campo en rojo para señalar dónde está el error. Para ello tienes en el archivo CSS una clase error ya implementada para tal finalidad.

    Validar la EDAD que contenga solamente valores numéricos y que esté en el rango de 18 a 105. Si se produce algún error, mostrar el mensaje personalizado en el id="errores" del HTML, y poner el foco en el campo correspondiente. También se deberá poner el borde del campo en rojo para señalar dónde está el error. Para ello tienes en el archivo CSS una clase error ya implementada para tal finalidad.

    Validar el NIF. Utilizar una expresión regular que permita solamente 8 números un guión y una letra. Si se produce algún error, mostrar el mensaje personalizado en el id="errores" del HTML, y poner el foco en el campo correspondiente. También se deberá poner el borde del campo en rojo para señalar dónde está el error. Para ello tienes en el archivo CSS una clase error ya implementada para tal finalidad. No es necesario validar que la letra sea correcta. Explicar las partes de la expresión regular mediante comentarios.

    Validar el E-MAIL. Si se produce algún error, mostrar el mensaje personalizado en el id="errores" del HTML, y poner el foco en el campo correspondiente. También se deberá poner el borde del campo en rojo para señalar dónde está el error. Para ello tienes en el archivo CSS una clase error ya implementada para tal finalidad.

    Validar que se haya seleccionado alguna de las PROVINCIAS. Una vez se haya elegido una opción se habilitará la selección para Isla(por defecto la selección isla debe estar desactivada), dejando solo la elección de las islas de dicha provincia a elegir. Si se produce algún error, mostrar el mensaje personalizado en el id="errores" del HTML, y poner el foco en el campo correspondiente. También se deberá poner el borde del campo en rojo para señalar dónde está el error. Para ello tienes en el archivo CSS una clase error ya implementada para tal finalidad.

    Validar el campo FECHA DE NACIMIENTO debe coincidir la fecha con la edad que dijo previamente que tenía.Si se produce algún error, mostrar el mensaje personalizado en el id="errores" del HTML, y poner el foco en el campo correspondiente. También se deberá poner el borde del campo en rojo para señalar dónde está el error. Para ello tienes en el archivo CSS una clase error ya implementada para tal finalidad.

    Validar el campo TELEFONO, debe permitir 9 dígitos obligatorios y el primer dígito debe ser 6 o 9. Si se produce algún error, mostrar el mensaje personalizado en el id="errores" del HTML, y poner el foco en el campo correspondiente. También se deberá poner el borde del campo en rojo para señalar dónde está el error. Para ello tienes en el archivo CSS una clase error ya implementada para tal finalidad.

    Pedir confirmación de envío del formulario. Si se confirma el envío realizará el envío de los datos y modificará el valor de la cookie a 0; en otro caso cancelará el envío.
*/

//erroresNaveg

//Esperamos a que el DOM del HTML esté completamente cargado.
document.addEventListener("DOMContentLoaded", function () {

  //Obtenermos las referencias a elemnetos del formulario en el HTML utilizando su ID.
  const form = document.querySelector("form");
  const nombreInput = document.getElementById("nombre");
  const apellidosInput = document.getElementById("apellidos");
  const edadInput = document.getElementById("edad");
  const nifInput = document.getElementById("nif");
  const emailInput = document.getElementById("email");
  const provinciaSelect = document.getElementById("provincia");
  const islaSelect = document.getElementById("isla");
  const fechaInput = document.getElementById("fecha");
  const telefonoInput = document.getElementById("telefono");
  const erroresNaveg = document.getElementById("errores");
  const intentosNaveg = document.getElementById("intentos");

  //Inicializamos un contador de intentos a 0.
  let intentos = 0;

  //Creamos dos arrays, uno para cada provincia con los nombres de todas las islas
  const islasTenerife = ['La Palma', 'La Gomera', 'El Hierro', 'Tenerife'];
  const islasGranCanaria = ['Gran Canaria', 'Fuerteventura', 'Lanzarote'];

  //Desactivamos inicialmente el selector de islas del formulario.
  islaSelect.disabled = true;

  //Este evento es para activar el selector de islas cuando el usuario elige una provincia.
  provinciaSelect.addEventListener('change', function () {
    //Esta condición verifica si provinciaSelect tiene algún valor, si no lo tiene, entonces lo mantiene desactivado. Si sí lo tiene lo activa, permitiendo al usuario elegir isla.
    if (provinciaSelect.value) {
      islaSelect.disabled = false;
    } else {
      islaSelect.disabled = true;
    }

    //Vaciamos las opciones existentes en el selector de islas.
    islaSelect.innerHTML = '';

    //Creamos un array vacío, islas, y luego se le transfieren las islas correspondientes a la provincia seleccionada por el usuario.
    let islas = [];
    if (provinciaSelect.value === 'SC') {
      islas = islasTenerife;
    } else if (provinciaSelect.value === 'LP') {
      islas = islasGranCanaria;
    }

    //Se añade una opción predeterminada al selector de islas que indica al usuario lo que debe hacer.
    islaSelect.appendChild(new Option("Seleccione Isla", ""));

    //Hacemos bucle para recorrer el array islas definido un poco mas arriba y crea las opciones de islas para el selector con el contenido del array.
    for (const isla of islas) {
      islaSelect.appendChild(new Option(isla, isla));
    }
  });

  //Event listener para el envío del formulario
  form.addEventListener("submit", function (event) {
    //Prevenimos el comportamiento por defecto del envento.
    event.preventDefault();
    //Incrementamos el contador de intentos y actualizamos la cookie.
    intentos++;
    document.cookie = "intentos=" + intentos;

    intentosNaveg.textContent = "Intento de Envíos del formulario: " + intentos;

    //Restablecer los campos.
    resetStyles();

    //Validamos los campos del formulario y añadimos los errores en un array.
    const errores = validarFormulario();

    if (errores.length === 0) {
      //Si no hay errores pide la confirmación para enviar el formulario.
      const confirmacion = confirm("¿Desea enviar el formulario?");
      if (confirmacion) {
        //Si el usuario confirma, se procede al envío del formulario.
        form.submit();

        //Reiniciamos a 0 el contador de intentos y la cookie.
        intentos = 0;
        document.cookie = "intentos=0";
        intentosNaveg.textContent = "Intento de Envíos del formulario: " + intentos;
      }
    } else {
      //Si existen errores en los camposd el formulario se mostrarán.
      //Limpiamos cualquier texto previo mostrado.
      erroresNaveg.innerHTML = "";

      //Con esta parte lograremos separar con saltos de línea los diferentes errores que puede generar el formulario.
      //Así logramos que sea visualmente mas agradable para el usuario, sobre todo si son muchos los errores.
      errores.forEach((error) => {
        //Creamos un elemento div en el que mostraremos el mensaje de error.
        const errorDiv = document.createElement("div");
        //Se asigna el error actual del array al elemento div.
        errorDiv.textContent = error;
        //Colocamos errorDiv como hijo del elemento HTML con el nombre erroresNaveg para hacerlo visible en la página del navegador.
        erroresNaveg.appendChild(errorDiv);
      });
    }
  });

  //Event listeners para los campos de nombre y apellidos, cuando el usuario avance desde esos campos actuará la función capitalizarTexto y sobreescribirá el contenido.
  nombreInput.addEventListener("blur", () => {
    nombreInput.value = capitalizarTexto(nombreInput.value);
  });

  apellidosInput.addEventListener("blur", () => {
    apellidosInput.value = capitalizarTexto(apellidosInput.value);
  });

  //Función para validar el formulario.
  function validarFormulario() {

    //Creamos el array errores. Aquí almacenaremos los mensajes de errores, sirviendo de registro de todos los errores producidos en el formulario.
    const errores = [];

    //Validamos nombre. Si no es validado mostrará un mensaje de error.
    if (!validarNombre(nombreInput.value)) {
      //Si el nombre no es válido añadimos un mensaje de error al array de errores.
      errores.push("Nombre no válido.");
      //Añadimos la clase error al campo de entrada para aplicar el estilo error de estiloTarea5.css
      nombreInput.classList.add("error");
    }

    //Validamos apellidos. Si no es validado mostrará un mensaje de error.
    if (!validarApellidos(apellidosInput.value)) {
      errores.push("Apellidos no válidos.");
      apellidosInput.classList.add("error");
    }

    //Validamos edad. Si no es validado mostrará un mensaje de error.
    if (!validarEdad(edadInput.value)) {
      errores.push("Edad no válida. La edad debe ser un número natural.");
      edadInput.classList.add("error");
    }

    //Validamos NIF. Si no es validado mostrará un mensaje de error.
    if (!validarNIF(nifInput.value)) {
      errores.push("NIF no válido. Formato aceptado 00000000-0");
      nifInput.classList.add("error");
    }

    //Validamos email. Si no es validado mostrará un mensaje de error.
    if (!validarEmail(emailInput.value)) {
      errores.push("Email no válido.");
      emailInput.classList.add("error");
    }

    //Validamos provincia. Si no es validado mostrará un mensaje de error.
    if (!validarProvincia(provinciaSelect.value)) {
      errores.push("Seleccione una provincia.");
      provinciaSelect.classList.add("error");
    }

    //Validamos provincia e islas. Si no es validado mostrará un mensaje de error.
    if (!validarIsla(islaSelect.value, provinciaSelect.value)) {
      errores.push("Seleccione una isla válida para la provincia seleccionada.");
      islaSelect.classList.add("error");
    }

    //Validamos fecha de nacimiento. Si no es validado mostrará un mensaje de error.
    if (!validarFechaNacimiento(fechaInput.value, edadInput.value)) {
      errores.push("La fecha de nacimiento no coincide con la edad introducida.");
      fechaInput.classList.add("error");
    }

    //Validamos número de teléfono. Si no es validado mostrará un mensaje de error.
    if (!validarTelefono(telefonoInput.value)) {
      errores.push("Teléfono no válido. Los número de teléfono empiezan por 6 o 9 y tiene en total 9 cifras.");
      telefonoInput.classList.add("error");
    }

    return errores;
  }


  //Creamos la función resetStyles para resetear el estilo de los campos del formulario.
  function resetStyles() {
    const inputs = [
      nombreInput,
      apellidosInput,
      edadInput,
      nifInput,
      emailInput,
      provinciaSelect,
      islaSelect,
      fechaInput,
      telefonoInput,
    ];

    //Utilizaremos forEach para realizar el borrado sobre cada uno de los elementos del array.
    inputs.forEach((input) => {
      //Si está presente, entonces para cada elemento se elimina la clase error.
      input.classList.remove("error");
    });
    //Borramos el contenido a mostrar en el HTML por una cadena vacía, logrando así el "borrado" y eliminación de todo contenido previo.
    erroresNaveg.textContent = "";
  }


  function validarNombre(nombre) {
    /* Explicación de la expresión regular:
      ^ indica el inicio del texto.
      [A-Za-zÁáÉéÍíÓóÚúÑñ\s] define el conjunto de caracteres permitidos, que incluye letras en mayúsculas y minúsculas, tildes en mayúsculas y minúsculas, la "Ñ" en mayúscula y minúscula, y espacios en blanco.
      {1,20} establece que la longitud del nombre debe estar entre 1 y 20 caracteres.
      $ indica el final del texto.
      La función test() verifica si el nombre coincide con esta expresión regular y devuelve true o false.
    */
    return /^[A-Za-zÁáÉéÍíÓóÚúÑñ\s]{1,20}$/.test(nombre);
  }

  function validarApellidos(apellidos) {
    /* Explicación de la expresión regular:
      ^ indica el inicio del texto.
      [A-Za-zÁáÉéÍíÓóÚúÑñ\s] define el conjunto de caracteres permitidos, que incluye letras en mayúsculas y minúsculas, tildes en mayúsculas y minúsculas, la "Ñ" en mayúscula y minúscula, y espacios en blanco.
      {1,35} establece que la longitud de los apellidos debe estar entre 1 y 35 caracteres.
      $ indica el final del texto.
      La función test() verifica si los apellidos coinciden con esta expresión regular y devuelve true o false.
    */
    return /^[A-Za-zÁáÉéÍíÓóÚúÑñ\s]{1,35}$/.test(apellidos);
  }

  function validarEdad(edad) {
    /* Función para validar la edad:
      Conviertimos la entrada edad en un número entero utilizando parseInt.
      Verifica si el número obtenido no es NaN (No es un Número) y está en el rango de 18 a 105 años.
      Adicionalmente, compara el valor numérico obtenido con parseFloat(edad) para asegurarse de que no contenga decimales.
      Devuelve true si la edad es válida y false en caso contrario.
    */
    const edadNum = parseInt(edad);
    return !isNaN(edadNum) && edadNum >= 18 && edadNum <= 105 && edadNum === parseFloat(edad);
  }

  function validarNIF(nif) {
    /*
      ^ indica el inicio del texto.
      [0-9]{8} especifica 8 dígitos numéricos.
      - representa el guion.
      - [A-Za-z] permite una letra mayúscula o minúscula después del guion.
      $ indica el final del texto.
      La función test() verifica si el NIF coincide con esta expresión regular y devuelve true o false.
    */
    return /^[0-9]{8}-[A-Za-z]$/.test(nif);
  }

  function validarEmail(email) {
    /*
      ^ indica el inicio del texto.
      [^\s@]+ verifica que no haya espacios en blanco ni en el principio ni en el final del email.
      @ verifica que haya un símbolo @ en el email.
      [^\s@]+ verifica que después del @ haya al menos un carácter.
      \. verifica que después del dominio haya un punto.
      [^\s@]+ verifica que después del punto haya al menos un carácter.
      $ indica el final del texto.
      La función test() verifica si el email coincide con esta expresión regular y devuelve true o false.
    */
    return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
  }

  //Función para verificar si el usuario ha seleccionado una provincia en el usuario.
  function validarProvincia(provincia) {
    //Si el usuario ha seleccionado una provincia, entonces no puede ser "".
    return provincia !== "";
  }

  //Validamos la isla si se corresponde con la provincia a la que está asociada.
  function validarIsla(isla, provincia) {
    if (provincia === "SC") {
      //Islas asociadas a la provincia de S/C de Tenerife.
      return ["La Palma", "La Gomera", "El Hierro", "Tenerife"].includes(isla);
    } else if (provincia === "LP") {
      //Islas asociadas a la provincia de Las Palmas de Gran Canaria.
      return ["Gran Canaria", "Fuerteventura", "Lanzarote"].includes(isla);
    } else {
      //Devuelve false si la isla no está asociada a la provincia.
      return false;
    }
  }

  function validarFechaNacimiento(fecha, edad) {
    const fechaNacimiento = new Date(fecha);
    const hoy = new Date();
    //Calculamos la diferencia de años entre la fecha actual y la de nacimiento.
    const edadCalculada = hoy.getFullYear() - fechaNacimiento.getFullYear();
    //Valida que la fecha del usuario coincide con la fecha de nacimiento.
    return edadCalculada.toString() === edad;
  }

  function validarTelefono(telefono) {
    /*
    ^ indica el inicio del texto.
    [69] verifica que el número comience con 6 o 9.
    [0-9]{8} verifica que haya exactamente 8 dígitos numéricos adicionales.
    $ indica el final del texto.
    La función test() verifica si el número de teléfono coincide con esta expresión regular y devuelve true o false.
    */
    return /^[69][0-9]{8}$/.test(telefono);
  }

  //Función para capitalizar texto.
  function capitalizarTexto(texto) {
    /*
    Primero converitmos todo el texto en minúsculas.
    Utiliza una expresión regular /(?:^|\s)\S/g para encontrar el primer carácter de cada palabra. Lo de cada palabra lo hace g buscando mas coincidencias que la primera.
    (?:^|\s) busca el inicio de una palabra (después de un espacio o al principio).
    \S encuentra cualquier carácter que no sea un espacio en blanco.
    La función replace() coge cada coincidencia y la convierte a mayúscula utilizando una función de reemplazo.
    La función devuelve el texto con la primera letra de cada palabra en mayúscula y las demás letras en minúscula.
    */
    return texto.toLowerCase().replace(/(?:^|\s)\S/g, function (a) {
      //Conviertimos el carácter encontrado a mayúscula y lo devovemos.
      return a.toUpperCase();
    });
  }
});
//Derimán Tejera Fumero 2DAW Semi B