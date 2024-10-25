<?php

require '../vendor/autoload.php';

use Faker\Factory as Faker;
use Futbolapp\Gestorjugadores\Jugador;

$faker = Faker::create();

$jugador = new Jugador();

for ($i = 0; $i < 10; $i++) {
    $nombre = $faker->firstName;
    $apellidos = $faker->lastName;
    $posicion = $faker->randomElement(['Portero', 'Defensa', 'Lateral Izquierdo', 'Lateral Derecho', 'Central', 'Delantero']);
    $barcode = $faker->unique()->ean13;

    do {
        $dorsal = $faker->numberBetween(1, 99);
    } while (!$jugador->esDorsalUnico($dorsal));

    $jugador->crearJugador($nombre, $apellidos, $dorsal, $posicion, $barcode);
}

header('Location: jugadores.php');
exit;