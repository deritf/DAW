<?php
session_start();

if (isset($_POST['borrar'])) {
    if (isset($_SESSION['idioma']) || isset($_SESSION['perfil']) || isset($_SESSION['zona_horaria'])) {
        unset($_SESSION['idioma'], $_SESSION['perfil'], $_SESSION['zona_horaria']);
        $mensaje = "Preferencias borradas.";
    } else {
        $mensaje = "Debes fijar primero las preferencias.";
    }
}

$idioma = isset($_SESSION['idioma']) ? $_SESSION['idioma'] : 'No definido';
$perfil = isset($_SESSION['perfil']) ? $_SESSION['perfil'] : 'No definido';
$zona_horaria = isset($_SESSION['zona_horaria']) ? $_SESSION['zona_horaria'] : 'No definido';
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mostrar</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body id="pagina-de-mostrar">
    <section class="ventana">
        <header class="cabecera">
            <h1>Preferencias</h1>
        </header>
        <main class="contenido">
            <?php if (isset($mensaje)) echo "<div class='mensaje-azul'>$mensaje</div>"; ?>
            <p><strong>Idioma:</strong> <span><?= $idioma ?></span></p>
            <p><strong>Perfil Público:</strong> <span><?= $perfil ?></span></p>
            <p><strong>Zona Horaria:</strong> <span><?= $zona_horaria ?></span></p>
        </main>
<footer class="botones">
    <form method="POST" action="mostrar.php">
        <button class="boton borrar" name="borrar">Borrar</button>
        <button type="button" class="boton establecer" onclick="window.location.href='preferencias.php';">Establecer</button>
    </form>
</footer>
    </section>
</body>
</html>
