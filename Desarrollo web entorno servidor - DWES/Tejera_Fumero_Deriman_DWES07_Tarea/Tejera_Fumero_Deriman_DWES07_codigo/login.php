<?php
session_start();

require_once 'conexion.php';

if (isset($_SESSION['usuario'])) {
    header("Location: listado.php");
    exit();
}

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $usuario = $_POST['usu'] ?? '';
    $password = $_POST['pass1'] ?? '';

    $response = ['success' => false, 'message' => ''];

    if (empty($usuario) || empty($password)) {
        $response['message'] = 'Usuario y contraseña son obligatorios.';
    } else {
        $passwordCifrada = sha1($password);

        $stmt = $conexion->prepare("SELECT * FROM usuarios WHERE usuario = :usuario AND pass = :password");
        $stmt->execute(['usuario' => $usuario, 'password' => $passwordCifrada]);
        $user = $stmt->fetch(PDO::FETCH_ASSOC);

        if ($user) {
            $_SESSION['usuario'] = $usuario;
            $response['success'] = true;
            $response['redirect'] = 'listado.php';
        } else {
            $response['message'] = 'Usuario o contraseña incorrectos.';
        }
    }

    header('Content-Type: application/json');
    echo json_encode($response);
    exit;
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
    <script src="login.js" defer></script>
    <link rel="stylesheet" href="styles.css" />
</head>
<body>
<div class="container mt-5">
    <div class="d-flex justify-content-center h-100">
        <div class="card" style="width: 24rem;">
            <div class="card-header">
                <h3><i class="fa fa-cog mr-1"></i>Iniciar sesión</h3>
            </div>
            <div class="card-body">
                <form id="miForm" method="POST" onsubmit="event.preventDefault(); enviarFormulario();">
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user"></i></span>
                        </div>
                        <input type="text" class="form-control" placeholder="Usuario" id="usu" name="usu" required>
                    </div>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-key"></i></span>
                        </div>
                        <input type="password" class="form-control" placeholder="Contraseña" id="pass1" name="pass1" required>
                    </div>
                    <div class="botones-login-y-signup">
                        <a href="index.php" class="btn btn-secondary">
                            <i class="fas fa-arrow-left"></i> Volver
                        </a>
                        <input type="submit" value="Entrar" class="btn btn-info">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

<!--
    Autor: Derimán Tejera Fumero.
    Asignatura: DWES CFGS DAW
    Fecha: 02-12-2024
-->