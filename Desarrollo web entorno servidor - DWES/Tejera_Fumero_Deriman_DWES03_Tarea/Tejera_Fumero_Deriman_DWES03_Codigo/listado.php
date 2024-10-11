<?php
require_once 'conexion.php';

$sql = "SELECT id, nombre, codigo FROM productos ORDER BY nombre ASC";
$stmt = $conexion->prepare($sql);
$stmt->execute();
$productos = $stmt->fetchAll(PDO::FETCH_ASSOC);
?>

<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Gestión de Productos</title>
    <link rel="stylesheet" href="styles.css" />
  </head>
  <body>
    <h1>Gestión de Productos</h1>

    <section id="contenedor-principal-de-tabla">
      <table>
        <thead>
          <tr>
            <th>Detalle</th>
            <th>ID</th>
            <th>Código</th>
            <th>Nombre</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          <?php foreach ($productos as $producto): ?>
          <tr>
            <td>
              <form action="detalle.php" method="post" style="display:inline;">
              <input type="hidden" name="id" value="<?php echo htmlspecialchars($producto['id']); ?>">
              <button type="submit" class="detalle">Detalle</button>
              </form>
            </td>

            <td><?php echo htmlspecialchars($producto['id']); ?></td>
            <td><?php echo htmlspecialchars($producto['codigo']); ?></td>
            <td><?php echo htmlspecialchars($producto['nombre']); ?></td>
            <td>
              <form action="update.php" method="post" style="display:inline;">
              <input type="hidden" name="id" value="<?php echo htmlspecialchars($producto['id']); ?>">
              <button type="submit" class="actualizar">Actualizar</button>
              </form>

              <form action="borrar.php" method="post" style="display:inline;">
              <input type="hidden" name="id" value="<?php echo htmlspecialchars($producto['id']); ?>">
              <button type="submit" class="borrar">Borrar</button>
              </form>
            </td>
          </tr>
          <?php endforeach; ?>
        </tbody>
      </table>
      <button
      type="button"
      class="crear"
      onclick="window.location.href='crear.php'"
    >
      Crear
    </button>
    </section>
  </body>
</html>

<!--Autor: Derimán Tejera Fumero.-->
<!--Asignatura: DWES CFGS DAW-->
<!--Fecha: 11-10-2024-->