<?php
$url = "http://localhost/unidad6/servidorSoap/servicio.php";

$cliente = new SoapClient(null, [
    'location' => $url,
    'uri' => "urn:localhost/unidad6/servidorSoap",
    'trace' => true,
]);

// getPVP
echo "PVP de un producto:\n";
try {
    $pvp = $cliente->getPVP("PROD001");
    echo "PVP: " . $pvp . "\n";
} catch (Exception $e) {
    echo "Error en getPVP: " . $e->getMessage() . "\n";
}

// getStock
echo "Stock de un producto en una tienda:\n";
try {
    $stock = $cliente->getStock("PROD001", "TIENDA1");
    echo "Stock: " . $stock . "\n";
} catch (Exception $e) {
    echo "Error en getStock: " . $e->getMessage() . "\n";
}

// getFamilias
echo "Lista de familias:\n";
try {
    $familias = $cliente->getFamilias();
    print_r($familias);
} catch (Exception $e) {
    echo "Error en getFamilias: " . $e->getMessage() . "\n";
}

// getProductosFamilia
echo "Productos de una familia:\n";
try {
    $productos = $cliente->getProductosFamilia("FAM001");
    print_r($productos);
} catch (Exception $e) {
    echo "Error en getProductosFamilia: " . $e->getMessage() . "\n";
}