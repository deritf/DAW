<?php
namespace Clases;

class Familia {
    public static function getFamilias() {
        try {
            $conexion = Conexion::conectar();
            $stmt = $conexion->query("SELECT cod FROM familias");
            $familias = $stmt->fetchAll(PDO::FETCH_COLUMN);
            if ($familias === false) {
                throw new \Exception("Error en la consulta de familias.");
            }
            return $familias;
        } catch (\Exception $e) {
            die("Error en getFamilias: " . $e->getMessage());
        }
    }
}