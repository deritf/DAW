<?php
require_once 'conexion.php';

try {
    $id = isset($_POST['id']) ? intval($_POST['id']) : 0;

    $sql = "SELECT id, nombre, codigo, descripcion, precio, familia FROM productos WHERE id = :id";
    $stmt = $conexion->prepare($sql);
    $stmt->bindParam(':id', $id, PDO::PARAM_INT);
    $stmt->execute();

    $producto = $stmt->fetch(PDO::FETCH_ASSOC);

    if (!$producto) {
        echo "Producto no encontrado";
        die();
    }
} catch (PDOException $e) {
    echo "Error en la conexión: " . $e->getMessage();
    die();
}
?>

<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Detalle Producto</title>
    <link rel="stylesheet" href="styles.css" />
  </head>
  <body>
    <h1>Detalle Producto</h1>

    <section class="detalle-cuadro">
      <div class="detalle-cabecera"><?php echo htmlspecialchars($producto['nombre']); ?></div>
      <div class="detalle-cuerpo">
        <p class="centrar-texto"><strong>Código:</strong> <?php echo htmlspecialchars($producto['id']); ?></p>
        <p><strong>Nombre:</strong> <?php echo htmlspecialchars($producto['nombre']); ?></p>
        <p><strong>Nombre corto:</strong> <?php echo htmlspecialchars($producto['codigo']); ?></p>
        <p><strong>Código Familia:</strong> <?php echo htmlspecialchars($producto['familia']); ?></p>
        <p><strong>PVP (€):</strong> <?php echo htmlspecialchars($producto['precio']); ?></p>
        <p><strong>Descripción:</strong> <?php echo htmlspecialchars($producto['descripcion']); ?></p>
      </div>
    </section>

    <button
      type="button"
      class="btn-volver"
      onclick="window.location.href='listado.php'"
    >
      Volver
    </button>
  </body>
</html>

<!--Autor: Derimán Tejera Fumero.-->
<!--Asignatura: DWES CFGS DAW-->
<!--Fecha: 11-10-2024-->