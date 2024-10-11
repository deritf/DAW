<?php
require_once 'conexion.php';

if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['id'])) {
    $id = intval($_POST['id']);

    if ($id >= 0) {
        $sql_delete = "DELETE FROM productos WHERE id = :id";
        $stmt_delete = $conexion->prepare($sql_delete);
        $stmt_delete->bindParam(':id', $id, PDO::PARAM_INT);

        if ($stmt_delete->execute()) {
            $mensaje = "Producto con ID: $id borrado correctamente.";
        } else {
            $mensaje = "Error al borrar el producto.";
        }
    } else {
        $mensaje = "ID de producto inválido.";
    }
} else {
    $mensaje = "No se recibió un ID de producto.";
}
?>

<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Borrar Producto</title>
    <link rel="stylesheet" href="styles.css" />
  </head>
  <body id="fondo-blanco-seccion-borrar-producto" class="texto-a-la-izquierda">
    <p class="mensaje-producto-borrado">
      <?php echo $mensaje; ?>
    </p>

    <button
      type="button"
      class="btn-volver-seccion-borrar-producto"
      onclick="window.location.href='listado.php'"
    >
      Volver
    </button>
  </body>
</html>

<!--Autor: Derimán Tejera Fumero.-->
<!--Asignatura: DWES CFGS DAW-->
<!--Fecha: 11-10-2024-->