/*
Realizar la validación del formulario facilitado en el enunciado, cumpliendo los siguientes requisitos:

Programar el código de JavaScript en un fichero independiente. Las modificaciones que se permiten realizar en el fichero .html son la de escribir la referencia al fichero de JavaScript para enlazarlo y especificar los atributos que consideres nesarios de las etiquetas de HTML5 para validar el campo o controlar errores y ahorrarnos código JavaScript por ejemplo: min, max, maxlenght, required,....también podemos cambiar el tipo del input para controlar errores con la propia etiqueta HTML5. No se trata de cambiar el formato del formulario sino de controlar la validación de los campos.

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

//Se han eliminado la mayoría de restricciones. También se han eliminado los comentarios del código en esta parte ya que serían los mismos que en el ejercicio anterior salvo para el código redundatne eliminado.

document.addEventListener("DOMContentLoaded", function () {

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

  let intentos = 0;

  const islasTenerife = ['La Palma', 'La Gomera', 'El Hierro', 'Tenerife'];
  const islasGranCanaria = ['Gran Canaria', 'Fuerteventura', 'Lanzarote'];

  islaSelect.disabled = true;

  provinciaSelect.addEventListener('change', function () {
    if (provinciaSelect.value) {
      islaSelect.disabled = false;
    } else {
      islaSelect.disabled = true;
    }
    islaSelect.innerHTML = '';

    let islas = [];

    if (provinciaSelect.value === 'SC') {
      islas = islasTenerife;
    } else if (provinciaSelect.value === 'LP') {
      islas = islasGranCanaria;
    }

    islaSelect.appendChild(new Option("Seleccione Isla", ""));

    for (const isla of islas) {
      islaSelect.appendChild(new Option(isla, isla));
    }
  });

  form.addEventListener("submit", function (event) {
    event.preventDefault();
    intentos++;
    document.cookie = "intentos=" + intentos;
    intentosNaveg.textContent = "Intento de Envíos del formulario: " + intentos;

    resetStyles();

    const errores = validarFormulario();

    if (errores.length === 0) {
      const confirmacion = confirm("¿Desea enviar el formulario?");
      if (confirmacion) {
        form.submit();
        intentos = 0;
        document.cookie = "intentos=0";
        intentosNaveg.textContent = "Intento de Envíos del formulario: " + intentos;
      }
    } else {

      erroresNaveg.innerHTML = "";

      errores.forEach((error) => {
        const errorDiv = document.createElement("div");
        errorDiv.textContent = error;
        erroresNaveg.appendChild(errorDiv);
      });
    }
  });

  nombreInput.addEventListener("blur", () => {
    nombreInput.value = capitalizarTexto(nombreInput.value);
  });

  apellidosInput.addEventListener("blur", () => {
    apellidosInput.value = capitalizarTexto(apellidosInput.value);
  });

  function validarFormulario() {
    const errores = [];
    if (!validarFechaNacimiento(fechaInput.value, edadInput.value)) {
      errores.push("La fecha de nacimiento no coincide con la edad introducida.");
      fechaInput.classList.add("error");
    }

    return errores;
  }

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

    inputs.forEach((input) => {
      input.classList.remove("error");
    });
    erroresNaveg.textContent = "";
  }

  function validarFechaNacimiento(fecha, edad) {
    const fechaNacimiento = new Date(fecha);
    const hoy = new Date();
    const edadCalculada = hoy.getFullYear() - fechaNacimiento.getFullYear();
    return edadCalculada.toString() === edad;
  }

  function capitalizarTexto(texto) {
    return texto.toLowerCase().replace(/(?:^|\s)\S/g, function (a) {
      return a.toUpperCase();
    });
  }
});
//Derimán Tejera Fumero 2DAW Semi B