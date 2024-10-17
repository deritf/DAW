<?php
session_start();

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $_SESSION['idioma'] = $_POST['idioma'];
    $_SESSION['perfil'] = $_POST['perfil'];
    $_SESSION['zona_horaria'] = $_POST['zona_horaria'];
    $mensaje = "Preferencias de usuario guardadas.";
}

$idioma = isset($_SESSION['idioma']) ? $_SESSION['idioma'] : 'Español';
$perfil = isset($_SESSION['perfil']) ? $_SESSION['perfil'] : 'si';
$zona_horaria = isset($_SESSION['zona_horaria']) ? $_SESSION['zona_horaria'] : 'GMT-0';
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Preferencias Usuario</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body id="pagina-de-preferencias">
    <section class="ventana">
        <header class="cabecera">
            <h1>Preferencias Usuario</h1>
        </header>
        <main class="contenido">
            <?php if (isset($mensaje)) echo "<div class='mensaje-azul'>$mensaje</div>"; ?>
            <form method="POST" action="preferencias.php">
                <section class="preferencia">
                    <label for="idioma">Idioma</label>
                    <select id="idioma" name="idioma">
                        <option value="Español" <?= $idioma == 'Español' ? 'selected' : '' ?>>Español</option>
                        <option value="Inglés" <?= $idioma == 'Inglés' ? 'selected' : '' ?>>Inglés</option>
                    </select>
                </section>
                <section class="preferencia">
                    <label for="perfil">Perfil Público</label>
                    <select id="perfil" name="perfil">
                        <option value="si" <?= $perfil == 'si' ? 'selected' : '' ?>>Sí</option>
                        <option value="no" <?= $perfil == 'no' ? 'selected' : '' ?>>No</option>
                    </select>
                </section>
                <section class="preferencia">
                    <label for="zona_horaria">Zona Horaria</label>
                    <select id="zona_horaria" name="zona_horaria">
                        <option value="GMT-2" <?= $zona_horaria == 'GMT-2' ? 'selected' : '' ?>>GMT-2</option>
                        <option value="GMT-1" <?= $zona_horaria == 'GMT-1' ? 'selected' : '' ?>>GMT-1</option>
                        <option value="GMT-0" <?= $zona_horaria == 'GMT-0' ? 'selected' : '' ?>>GMT</option>
                        <option value="GMT+1" <?= $zona_horaria == 'GMT+1' ? 'selected' : '' ?>>GMT+1</option>
                        <option value="GMT+2" <?= $zona_horaria == 'GMT+2' ? 'selected' : '' ?>>GMT+2</option>
                    </select>
                </section>
                <footer class="botones">
                    <a href="mostrar.php" class="boton mostrar">Mostrar Preferencias</a>
                    <button type="submit" class="boton establecer">Establecer Preferencias</button>
                </footer>
            </form>
        </main>
    </section>
</body>
</html>
