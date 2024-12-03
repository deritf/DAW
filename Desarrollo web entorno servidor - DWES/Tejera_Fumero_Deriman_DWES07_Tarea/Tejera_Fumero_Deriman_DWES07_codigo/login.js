async function enviarFormulario() {
  const form = document.getElementById("miForm");
  const formData = new FormData(form);

  try {
    const response = await fetch("login.php", {
      method: "POST",
      body: formData,
    });

    const result = await response.json();
    if (result.success) {
      window.location.href = result.redirect;
    } else {
      alert(result.message);
    }
  } catch (error) {
    alert("Ocurrió un error en el servidor.");
  }
}

/*
    Autor: Derimán Tejera Fumero.
    Asignatura: DWES CFGS DAW
    Fecha: 02-12-2024
*/
