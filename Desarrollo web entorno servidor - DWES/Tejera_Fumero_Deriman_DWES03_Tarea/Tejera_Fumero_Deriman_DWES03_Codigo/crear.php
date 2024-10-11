<?php
require_once 'conexion.php';

try {
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
            $sql_last_id = "SELECT MAX(id) AS ultimo_id FROM productos";
            $stmt_last_id = $conexion->prepare($sql_last_id);
            $stmt_last_id->execute();
            $ultimo_id = $stmt_last_id->fetch(PDO::FETCH_ASSOC)['ultimo_id'];
            $nuevo_id = $ultimo_id + 1;

            $sql_insert = "INSERT INTO productos (id, nombre, codigo, descripcion, precio, familia)
                           VALUES (:id, :nombre, :codigo, :descripcion, :precio, :familia)";
            $stmt_insert = $conexion->prepare($sql_insert);
            $stmt_insert->bindParam(':id', $nuevo_id);
            $stmt_insert->bindParam(':nombre', $nombre);
            $stmt_insert->bindParam(':codigo', $codigo);
            $stmt_insert->bindParam(':descripcion', $descripcion);
            $stmt_insert->bindParam(':precio', $precio);
            $stmt_insert->bindParam(':familia', $familia);

            if ($stmt_insert->execute()) {
                echo "Producto creado con éxito.";
            } else {
                echo "Error al crear el producto.";
            }
        } else {
            echo "Por favor, complete todos los campos.";
        }
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
    <title>Crear Producto</title>
    <link rel="stylesheet" href="styles.css" />
  </head>
  <body>
    <h1>Crear Producto</h1>
    <form action="crear.php" method="post">
      <section class="form-group">
        <article class="form-column">
          <label for="nombre">Nombre</label>
          <input
            type="text"
            id="nombre"
            name="nombre"
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
            placeholder="Precio (€)"
            required
            min="0"
            step="any"
            title="Debe introducir solo números"
          />
        </article>

        <article class="form-column">
          <label for="nombre_corto">Nombre corto</label>
          <input
            type="text"
            id="nombre_corto"
            name="nombre_corto"
            placeholder="Nombre corto"
            required
            pattern="[a-zA-Z0-9\s]+"
            title="Debe tener al menos 8 caracteres alfanuméricos"
          />

          <label for="familia">Familia</label>
          <select id="familia" name="familia" required>
            <option value="">Seleccione una opción</option>
            <?php foreach ($familias as $familia): ?>
              <option value="<?php echo htmlspecialchars($familia['cod']); ?>">
                <?php echo htmlspecialchars($familia['nombre']); ?>
              </option>
            <?php endforeach; ?>
          </select>
        </article>
      </section>

      <label for="descripcion">Descripción</label>
      <textarea
        id="descripcion"
        name="descripcion"
        placeholder="Escriba aquí la descripción del producto..."
        required
        minlength="5"
        title="Debe tener al menos 8 caracteres alfanuméricos"
      ></textarea>

      <section class="buttons">
        <button type="submit" class="btn-crear">Crear</button>
        <button type="reset" class="btn-limpiar">Limpiar</button>
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