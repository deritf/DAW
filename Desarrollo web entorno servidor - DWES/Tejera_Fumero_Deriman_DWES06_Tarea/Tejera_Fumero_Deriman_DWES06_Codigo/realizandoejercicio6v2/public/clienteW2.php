<?php
require_once __DIR__ . '/../src/Clases1/ClasesOperacionesService.php';

use Clases1\ClasesOperacionesService;

try {
    $cliente = new ClasesOperacionesService();

    $pvp = $cliente->getPVP(1);
    echo "PVP del producto 1: $pvp\n";

    $stock = $cliente->getStock(1, 2);
    echo "Stock del producto 1 en la tienda 2: $stock\n";

    $familias = $cliente->getFamilias();
    echo "Familias: " . implode(", ", $familias) . "\n";

    $productosFamilia = $cliente->getProductosFamilia("CAMARA");
    echo "Productos de la familia 'CAMARA': " . implode(", ", $productosFamilia) . "\n";

} catch (Exception $e) {
    echo "Error: " . $e->getMessage();
}