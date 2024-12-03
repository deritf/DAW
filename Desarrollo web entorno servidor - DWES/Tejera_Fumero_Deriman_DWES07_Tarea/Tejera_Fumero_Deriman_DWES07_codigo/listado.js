async function votarProducto(idProducto, valoracion) {
  try {
    const response = await fetch("valorar.php", {
      method: "POST",
      headers: { "Content-Type": "application/x-www-form-urlencoded" },
      body: new URLSearchParams({ id: idProducto, valoracion }),
    });

    const result = await response.json();
    if (result.success) {
      alert(result.message);
      location.reload();
    } else {
      alert(result.message);
    }
  } catch (error) {
    alert("Error al realizar la votación: " + error.message);
  }
}

/*
    Autor: Derimán Tejera Fumero.
    Asignatura: DWES CFGS DAW
    Fecha: 02-12-2024
*/
