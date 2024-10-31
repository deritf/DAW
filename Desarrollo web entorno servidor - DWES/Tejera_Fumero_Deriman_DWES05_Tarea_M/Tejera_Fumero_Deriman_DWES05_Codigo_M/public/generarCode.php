<?php

require '../vendor/autoload.php';

use Futbolapp\Gestorjugadores\Jugador;
use Faker\Factory as Faker;

$faker = Faker::create();

$jugador = new Jugador();

do {
    $codigo_barras = $faker->ean13;
} while (!$jugador->esCodigoBarrasUnico($codigo_barras));

$nombre = isset($_GET['nombre']) ? $_GET['nombre'] : '';
$apellidos = isset($_GET['apellidos']) ? $_GET['apellidos'] : '';
$dorsal = isset($_GET['dorsal']) ? $_GET['dorsal'] : '';
$posicion = isset($_GET['posicion']) ? $_GET['posicion'] : '';

header("Location: fcrear.php?nombre={$nombre}&apellidos={$apellidos}&dorsal={$dorsal}&posicion={$posicion}&barcode={$codigo_barras}");
exit;