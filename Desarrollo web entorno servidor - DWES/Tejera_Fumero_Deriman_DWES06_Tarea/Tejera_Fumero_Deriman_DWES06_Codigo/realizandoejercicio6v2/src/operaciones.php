<?php
namespace Clases;

class Operaciones {
    public function getPVP($id) {
        return Producto::getPVP($id);
    }

    public function getStock($producto, $tienda) {
        return Stock::getStock($producto, $tienda);
    }

    public function getFamilias() {
        try {
            $pdo = new \PDO("mysql:host=localhost;dbname=tarea6", "gestor", "secreto", [
                \PDO::ATTR_ERRMODE => \PDO::ERRMODE_EXCEPTION,
                \PDO::ATTR_DEFAULT_FETCH_MODE => \PDO::FETCH_ASSOC
            ]);

            $stmt = $pdo->query("SELECT cod FROM familias");

            $resultado = $stmt->fetchAll();

            if (!empty($resultado)) {
                return array_column($resultado, 'cod');
            } else {
                return ["No hay datos en familias"];
            }
        } catch (\PDOException $e) {
            return ["Error de conexión o consulta: " . $e->getMessage()];
        }
    }

    public function getProductosFamilia($codFamilia) {
        try {
            $pdo = new \PDO("mysql:host=localhost;dbname=tarea6", "gestor", "secreto", [
                \PDO::ATTR_ERRMODE => \PDO::ERRMODE_EXCEPTION,
                \PDO::ATTR_DEFAULT_FETCH_MODE => \PDO::FETCH_ASSOC
            ]);

            $stmt = $pdo->prepare("SELECT id FROM productos WHERE familia = :codFamilia");
            $stmt->bindParam(':codFamilia', $codFamilia, \PDO::PARAM_STR);
            $stmt->execute();

            $resultado = $stmt->fetchAll();

            if (!empty($resultado)) {
                return array_column($resultado, 'id');
            } else {
                return ["No hay productos para la familia especificada"];
            }
        } catch (\PDOException $e) {
            return ["Error de conexión o consulta: " . $e->getMessage()];
        }
    }
}