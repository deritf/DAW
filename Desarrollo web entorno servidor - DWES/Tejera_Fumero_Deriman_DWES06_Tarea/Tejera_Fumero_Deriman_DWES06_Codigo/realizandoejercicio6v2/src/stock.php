<?php
namespace Clases;

class Stock {
    public static function getStock($producto, $tienda) {
        $conexion = Conexion::conectar();
        $stmt = $conexion->prepare("SELECT unidades FROM stocks WHERE producto = ? AND tienda = ?");
        $stmt->execute([$producto, $tienda]);
        return $stmt->fetchColumn();
    }
}