<?php
namespace Clases;

class Producto {
    public static function getPVP($id) {
        $conexion = Conexion::conectar();
        $stmt = $conexion->prepare("SELECT pvp FROM productos WHERE id = ?");
        $stmt->execute([$id]);
        return $stmt->fetchColumn();
    }
}