<?php
session_start();

if (!isset($_SESSION['agenda'])) {
    $_SESSION['agenda'] = [];
}

if (isset($_POST['nombre']) && isset($_POST['telefono'])) {
    $nombre = trim($_POST['nombre']);
    $telefono = trim($_POST['telefono']);

    $nombre=ucwords(strtolower($nombre));

    if (empty($nombre)) {

        $_SESSION['mensaje'] = "Introducir un nombre...";
    } else {
        if (isset($_SESSION['agenda'][$nombre])) {
            if (!empty($telefono)) {
                $_SESSION['agenda'][$nombre] = $telefono;
                $_SESSION['mensaje'] =  "Contacto actualizado...";
            } else {
                unset($_SESSION['agenda'][$nombre]);
                $_SESSION['mensaje'] =  "Contacto eliminado...";
            }
        } else {
            if (!empty($telefono)) {
                $_SESSION['agenda'][$nombre] = $telefono;
                $_SESSION['mensaje'] =  "Contacto añadido...";
            } else {
                $_SESSION['mensaje'] =  "Introduzca un número de teléfono...";
            }
        }
    }
}

if (isset($_GET['vaciar'])) {
    $_SESSION['agenda'] = [];
    $_SESSION['mensaje'] =  "Agenda vaciada...";
}

header('Location: index.php');
exit();
?>