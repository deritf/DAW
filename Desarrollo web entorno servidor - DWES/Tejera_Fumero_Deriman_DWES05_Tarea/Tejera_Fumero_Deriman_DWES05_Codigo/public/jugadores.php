<?php
require '../vendor/autoload.php';

use Futbolapp\Gestorjugadores\Jugador;
use Jenssegers\Blade\Blade;

session_start();

$views = '../views';
$cache = '../cache';

$blade = new Blade($views, $cache);

$jugadorModel = new Jugador();
$jugadores = $jugadorModel->obtenerJugadores();

$mensaje_exito = $_SESSION['mensaje_exito'] ?? null;

echo $blade->render('vjugadores', [
    'jugadores' => $jugadores,
    'mensaje_exito' => $mensaje_exito
]);

unset($_SESSION['mensaje_exito']);