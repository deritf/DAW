<?php
namespace Clases;

use PDOException;

class Conexion {
    public static function conectar() {
        try {
            return new \PDO("mysql:host=localhost;dbname=tarea6", "gestor", "secreto", [
                \PDO::ATTR_ERRMODE => \PDO::ERRMODE_EXCEPTION,
                \PDO::ATTR_DEFAULT_FETCH_MODE => \PDO::FETCH_ASSOC
            ]);
        } catch (PDOException $e) {
            die("Error de conexión: " . $e->getMessage());
        }
    }
}