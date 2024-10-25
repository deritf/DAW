<?php

require '../vendor/autoload.php';

session_start();

use Futbolapp\Gestorjugadores\Jugador;

$jugadorModel = new Jugador();

$jugadores = $jugadorModel->obtenerJugadores();

if (empty($jugadores)) {
    header('Location: instalacion.php');
    exit;
} else {
    header('Location: jugadores.php');
    exit;
}