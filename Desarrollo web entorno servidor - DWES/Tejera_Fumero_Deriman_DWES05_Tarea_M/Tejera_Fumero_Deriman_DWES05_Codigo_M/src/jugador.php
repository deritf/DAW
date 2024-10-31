<?php

namespace Futbolapp\Gestorjugadores;

use PDO;

class Jugador extends Conexion {

    public function obtenerJugadores() {
        $consulta = "SELECT * FROM jugadores ORDER BY dorsal ASC";
        $stmt = $this->conexion->prepare($consulta);
        $stmt->execute();
        return $stmt->fetchAll(PDO::FETCH_OBJ);
    }

    public function crearJugador($nombre, $apellidos, $dorsal, $posicion, $barcode) {
        $consulta = "INSERT INTO jugadores (nombre, apellidos, dorsal, posicion, barcode) VALUES (:nombre, :apellidos, :dorsal, :posicion, :barcode)";
        $stmt = $this->conexion->prepare($consulta);
        $stmt->execute([
            ':nombre' => $nombre,
            ':apellidos' => $apellidos,
            ':dorsal' => $dorsal,
            ':posicion' => $posicion,
            ':barcode' => $barcode
        ]);
    }

    public function esDorsalUnico($dorsal) {
        $consulta = "SELECT COUNT(*) as total FROM jugadores WHERE dorsal = :dorsal";
        $stmt = $this->conexion->prepare($consulta);
        $stmt->execute([':dorsal' => $dorsal]);
        $resultado = $stmt->fetch(PDO::FETCH_OBJ);
        return $resultado->total == 0;
    }

    public function esCodigoBarrasUnico($barcode) {
        $consulta = "SELECT COUNT(*) as total FROM jugadores WHERE barcode = :barcode";
        $stmt = $this->conexion->prepare($consulta);
        $stmt->execute([':barcode' => $barcode]);
        $resultado = $stmt->fetch(PDO::FETCH_OBJ);
        return $resultado->total == 0;
    }
}