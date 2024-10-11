<?php
require_once 'conexion.php';

try {
    $id = isset($_POST['id']) ? intval($_POST['id']) : (isset($_GET['id']) ? intval($_GET['id']) : 0);

    if ($id >= 0) {
        $sql_producto = "SELECT * FROM productos WHERE id = :id";
        $stmt_producto = $conexion->prepare($sql_producto);
        $stmt_producto->bindParam(':id', $id, PDO::PARAM_INT);
        $stmt_producto->execute();
        $producto = $stmt_producto->fetch(PDO::FETCH_ASSOC);

        if (!$producto) {
            echo "Producto no encontrado.";
            die();
        }

        $sql_familias = "SELECT cod, nombre FROM familias";
        $stmt_familias = $conexion->prepare($sql_familias);
        $stmt_familias->execute();
        $familias = $stmt_familias->fetchAll(PDO::FETCH_ASSOC);

        if ($_SERVER['REQUEST_METHOD'] === 'POST') {
            $nombre = $_POST['nombre'] ?? '';
            $precio = $_POST['precio'] ?? '';
            $codigo = $_POST['nombre_corto'] ?? '';
            $familia = $_POST['familia'] ?? '';
            $descripcion = $_POST['descripcion'] ?? '';

            if ($nombre && $precio && $codigo && $familia && $descripcion) {
                $sql_update = "UPDATE productos SET nombre = :nombre, codigo = :codigo, descripcion = :descripcion, precio = :precio, familia = :familia WHERE id = :id";
                $stmt_update = $conexion->prepare($sql_update);
                $stmt_update->bindParam(':nombre', $nombre);
                $stmt_update->bindParam(':codigo', $codigo);
                $stmt_update->bindParam(':descripcion', $descripcion);
                $stmt_update->bindParam(':precio', $precio);
                $stmt_update->bindParam(':familia', $familia);
                $stmt_update->bindParam(':id', $id, PDO::PARAM_INT);

                if ($stmt_update->execute()) {
                    echo "Producto modificado con éxito.";
                } else {
                    echo "Error al modificar el producto.";
                }
            } else {
                echo "Por favor, complete todos los campos.";
            }
        }
    } else {
        echo "ID de producto inválido.";
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
    <title>Modificar Producto</title>
    <link rel="stylesheet" href="styles.css" />
  </head>
  <body>
    <h1>Modificar Producto</h1>
    <form action="update.php?id=<?php echo $id; ?>" method="post">
    <input type="hidden" name="id" value="<?php echo $id; ?>">
      <section class="form-group">
        <section class="form-column">
          <label for="nombre">Nombre</label>
          <input
            type="text"
            id="nombre"
            name="nombre"
            value="<?php echo htmlspecialchars($producto['nombre']); ?>"
            placeholder="Nombre"
            required
            minlength="8"
            pattern="[a-zA-Z0-9\s]+"
            title="Debe tener al menos 8 caracteres alfanuméricos"
          />

          <label for="precio">Precio (€)</label>
          <input
            type="number"
            id="precio"
            name="precio"
            value="<?php echo htmlspecialchars($producto['precio']); ?>"
            placeholder="Precio (€)"
            required
            min="0"
            step="any"
            title="Debe introducir solo números"
          />
        </section>

        <section class="form-column">
          <label for="nombre_corto">Nombre corto</label>
          <input
            type="text"
            id="nombre_corto"
            name="nombre_corto"
            value="<?php echo htmlspecialchars($producto['codigo']); ?>"
            placeholder="Nombre corto"
            required
            pattern="[a-zA-Z0-9\s]+"
            title="Debe tener al menos 8 caracteres alfanuméricos"
          />

          <label for="familia">Familia</label>
          <select id="familia" name="familia" required>
            <option value="">Seleccione una opción</option>
            <?php foreach ($familias as $fam): ?>
              <option value="<?php echo htmlspecialchars($fam['cod']); ?>"
              <?php echo $fam['cod'] === $producto['familia'] ? 'selected' : ''; ?>>
                <?php echo htmlspecialchars($fam['nombre']); ?>
              </option>
            <?php endforeach; ?>
          </select>
        </section>
      </section>

      <label for="descripcion">Descripción</label>
      <textarea
        id="descripcion"
        name="descripcion"
        placeholder="Escriba aquí la descripción del producto..."
        required
        minlength="8"
        title="Debe tener al menos 8 caracteres alfanuméricos"
      ><?php echo htmlspecialchars($producto['descripcion']); ?></textarea>

      <section class="buttons">
        <button type="submit" class="btn-modificar">Modificar</button>
        <button
          type="button"
          class="btn-volver"
          onclick="window.location.href='listado.php'"
        >
          Volver
        </button>
      </section>
    </form>
  </body>
</html>

<!--Autor: Derimán Tejera Fumero.-->
<!--Asignatura: DWES CFGS DAW-->
<!--Fecha: 11-10-2024-->