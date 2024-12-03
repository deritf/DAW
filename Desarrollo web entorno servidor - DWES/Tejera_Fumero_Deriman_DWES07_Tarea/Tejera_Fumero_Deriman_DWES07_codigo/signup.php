<?php
require_once 'conexion.php';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    header('Content-Type: application/json');

    function validarNombre($nombre) {
        return strlen($nombre) >= 4;
    }

    function validarEmail($email) {
        return preg_match("/^[a-z0-9]+([_\\.-][a-z0-9]+)*@([a-z0-9]+([\.-][a-z0-9]+)*)+\\.[a-z]{2,}$/i", $email);
    }

    function validarPasswords($pass1, $pass2) {
        return ($pass1 === $pass2 && strlen($pass1) > 5);
    }

    $usuario = $_POST['usu'] ?? '';
    $password = $_POST['pass1'] ?? '';
    $password2 = $_POST['pass2'] ?? '';
    $email = $_POST['mail'] ?? '';

    $response = [];
    $error = false;

    if (!validarNombre($usuario)) {
        $response['errUsu'] = "El nombre debe tener mas de 3 caracteres.";
        $error = true;
    }

    if (!validarPasswords($password, $password2)) {
        $response['errPass'] = "La contraseña debe ser mayor de 5 caracteres o no coinciden.";
        $error = true;
    }

    if (!validarEmail($email)) {
        $response['errMail'] = "La dirección de email no es válida.";
        $error = true;
    }

    if (!$error) {
        $stmt = $conexion->prepare("SELECT COUNT(*) FROM usuarios WHERE usuario = :usuario OR email = :email");
        $stmt->execute(['usuario' => $usuario, 'email' => $email]);
        if ($stmt->fetchColumn() > 0) {
            $response['errUsu'] = "El usuario o el email ya están registrados.";
            $response['success'] = false;
        } else {
            $passwordCifrada = sha1($password);

            $stmt = $conexion->prepare("INSERT INTO usuarios (usuario, pass, email) VALUES (:usuario, :pass, :email)");
            $stmt->execute([
                'usuario' => $usuario,
                'pass' => $passwordCifrada,
                'email' => $email
            ]);

            $response['success'] = true;
            $response['message'] = "Registro completado exitosamente.";
        }
    } else {
        $response['success'] = false;
    }

    echo json_encode($response);
    exit;
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario con Validación en PHP</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
    <link rel="stylesheet" href="styles.css" />
</head>
<body>

<div class="container mt-5">
    <div class="d-flex justify-content-center h-100">
        <div class="card" style="width: 24rem;">
            <div class="card-header">
                <h3><i class="fa fa-cog mr-1"></i>Registro</h3>
            </div>
            <div class="card-body">
                <form id="miForm">
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user"></i></span>
                        </div>
                        <input type="text" class="form-control" placeholder="usuario" id="usu" name="usu" required>
                        <span id="errUsu" class="text-danger"></span>
                    </div>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-key"></i></span>
                        </div>
                        <input type="password" class="form-control" placeholder="contraseña" id="pass1" name="pass1" required>
                    </div>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-key"></i></span>
                        </div>
                        <input type="password" class="form-control" placeholder="repita la contraseña" id="pass2" name="pass2" required>
                    </div>
                    <span id="errPass" class="text-danger"></span>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fa fa-envelope"></i></span>
                        </div>
                        <input type="email" class="form-control" placeholder="e-Mail" id="mail" name="mail" required>
                    </div>
                    <span id="errMail" class="text-danger"></span>
                    <div class="botones-login-y-signup">
                        <a href="index.php" class="btn btn-secondary">
                            <i class="fas fa-arrow-left"></i> Volver
                        </a>
                        <button type="button" onclick="enviarFormulario()" class="btn float-right btn-info">Registrar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="signup.js" defer></script>

</body>
</html>

<!--
    Autor: Derimán Tejera Fumero.
    Asignatura: DWES CFGS DAW
    Fecha: 02-12-2024
-->