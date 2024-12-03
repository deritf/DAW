async function enviarFormulario() {
  const form = document.getElementById("miForm");
  const formData = new FormData(form);

  try {
    const response = await fetch("signup.php", {
      method: "POST",
      body: formData,
    });

    const data = await response.json();

    if (data.success) {
      alert(data.message);
      form.reset();
    } else {
      document.getElementById("errUsu").textContent = data.errUsu || "";
      document.getElementById("errPass").textContent = data.errPass || "";
      document.getElementById("errMail").textContent = data.errMail || "";
    }
  } catch (error) {
    alert("Error al procesar el registro: " + error.message);
  }
}

/*
    Autor: Derimán Tejera Fumero.
    Asignatura: DWES CFGS DAW
    Fecha: 02-12-2024
*/
