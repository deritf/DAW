<?php

require '../vendor/autoload.php';

use Futbolapp\Gestorjugadores\Jugador;

session_start();

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $nombre = trim($_POST['nombre']);
    $apellidos = trim($_POST['apellidos']);
    $dorsal = trim($_POST['dorsal']);
    $posicion = $_POST['posicion'];
    $barcode = trim($_POST['codigo_barras']);

    $jugador = new Jugador();

    if (!$jugador->esDorsalUnico($dorsal)) {
        $_SESSION['error'] = "El dorsal ya está en uso. Por favor, elige otro.";
        header('Location: fcrear.php');
        exit;
    }

    if (empty($barcode)) {
        $_SESSION['error'] = "El código de barras no puede estar vacío.";
        header('Location: fcrear.php');
        exit;
    }
    if (!$jugador->esCodigoBarrasUnico($barcode)) {
        $_SESSION['error'] = "El código de barras ya está en uso. Por favor, genera uno nuevo.";
        header('Location: fcrear.php');
        exit;
    }

    $jugador->crearJugador($nombre, $apellidos, $dorsal, $posicion, $barcode);

    $_SESSION['mensaje_exito'] = "Jugador creado con éxito.";

    header('Location: jugadores.php');
    exit;
}