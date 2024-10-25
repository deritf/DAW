<?php
require '../vendor/autoload.php';
session_start();

use Futbolapp\Gestorjugadores\Jugador;
use Faker\Factory as Faker;
use Jenssegers\Blade\Blade;

$views = '../views';
$cache = '../cache';

$blade = new Blade($views, $cache);

$faker = Faker::create();
$jugador = new Jugador();

if (!isset($_GET['barcode'])) {
    do {
        $codigo_barras = $faker->ean13;
    } while (!$jugador->esCodigoBarrasUnico($codigo_barras));

    header("Location: fcrear.php?nombre=&apellidos=&dorsal=&posicion=&barcode={$codigo_barras}");
    exit;
}

$nombre = isset($_GET['nombre']) ? $_GET['nombre'] : '';
$apellidos = isset($_GET['apellidos']) ? $_GET['apellidos'] : '';
$dorsal = isset($_GET['dorsal']) ? $_GET['dorsal'] : '';
$posicion = isset($_GET['posicion']) ? $_GET['posicion'] : '';
$codigo_barras = isset($_GET['barcode']) ? $_GET['barcode'] : '';

echo $blade->render('vcrear', [
    'error' => $_SESSION['error'] ?? null,
    'mensaje_exito' => $_SESSION['mensaje_exito'] ?? null,
    'codigo_barras' => $codigo_barras,
    'nombre' => $nombre,
    'apellidos' => $apellidos,
    'dorsal' => $dorsal,
    'posicion' => $posicion
]);

unset($_SESSION['error'], $_SESSION['mensaje_exito']);