<?php
session_start();
require_once 'conexion.php';

if (!isset($_SESSION['usuario'])) {
    header("Location: login.php");
    exit();
}

$usuarioActual = $_SESSION['usuario'];

$sql = "
    SELECT
        p.id,
        p.nombre,
        IFNULL(ROUND(AVG(v.cantidad), 1), 0) AS valoracion_media,
        COUNT(v.cantidad) AS num_votos
    FROM productos p
    LEFT JOIN votos v ON p.id = v.idPr
    GROUP BY p.id, p.nombre
    ORDER BY p.id ASC";

$stmt = $conexion->prepare($sql);
$stmt->execute();
$productos = $stmt->fetchAll(PDO::FETCH_ASSOC);

$sqlVotosUsuario = "
    SELECT idPr, cantidad
    FROM votos
    WHERE idUs = :usuario";

$stmtVotos = $conexion->prepare($sqlVotosUsuario);
$stmtVotos->execute(['usuario' => $usuarioActual]);
$votosUsuario = $stmtVotos->fetchAll(PDO::FETCH_KEY_PAIR);
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Valoración de Productos</title>
    <link rel="stylesheet" href="styles.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <script src="listado.js" defer></script>
</head>
<body>
<header id="header">
    <div class="usuario">
        <i class="fas fa-user"></i>
        <input type="text" class="nombre-usuario" value="<?php echo htmlspecialchars($usuarioActual); ?>" readonly>
    </div>
    <button class="btn-salir" onclick="window.location.href='logout.php';">Salir</button>
</header>

<h1>Valoración de Productos</h1>

<section id="contenedor-principal-de-tabla">
    <table>
        <thead>
            <tr>
                <th>Código</th>
                <th>Nombre</th>
                <th>Valoración</th>
                <th>Valorar</th>
            </tr>
        </thead>
        <tbody>
            <?php foreach ($productos as $producto): ?>
                <tr>
                    <td><?php echo htmlspecialchars($producto['id']); ?></td>
                    <td><?php echo htmlspecialchars($producto['nombre']); ?></td>
                    <td>
                        <?php if ($producto['valoracion_media'] > 0): ?>
                            <span class="estrellas">
                                <?php
                                for ($i = 1; $i <= 5; $i++) {
                                    if ($i <= $producto['valoracion_media']) {
                                        echo '<i class="fas fa-star"></i>';
                                    } elseif ($i - 0.5 <= $producto['valoracion_media']) {
                                        echo '<i class="fas fa-star-half-alt"></i>';
                                    } else {
                                        echo '<i class="far fa-star"></i>';
                                    }
                                }
                                ?>
                            </span>
                            <br>
                            <?php echo htmlspecialchars($producto['num_votos']) . ' ' . ($producto['num_votos'] == 1 ? 'Valoración' : 'Valoraciones'); ?>
                        <?php else: ?>
                            Sin valorar
                        <?php endif; ?>
                    </td>

                    <td>
                        <form onsubmit="event.preventDefault(); votarProducto(<?php echo $producto['id']; ?>, this.valoracion.value);">
                            <select name="valoracion" required>
                                <option value="" disabled selected>-</option>
                                <?php for ($i = 1; $i <= 5; $i++): ?>
                                    <option value="<?php echo $i; ?>" <?php echo (isset($votosUsuario[$producto['id']]) && $votosUsuario[$producto['id']] == $i) ? 'selected' : ''; ?>>
                                        <?php echo $i; ?>
                                    </option>
                                <?php endfor; ?>
                            </select>
                            <button type="submit" class="votar">Votar</button>
                        </form>
                    </td>
                </tr>
            <?php endforeach; ?>
        </tbody>
    </table>
</section>
</body>
</html>

<!--
    Autor: Derimán Tejera Fumero.
    Asignatura: DWES CFGS DAW
    Fecha: 02-12-2024
-->