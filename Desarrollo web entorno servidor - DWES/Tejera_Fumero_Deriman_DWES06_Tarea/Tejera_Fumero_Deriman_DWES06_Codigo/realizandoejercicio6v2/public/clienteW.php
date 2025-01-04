<?php
$wsdl = 'http://localhost/realizandoejercicio6v2/servidorSoap/servicio.wsdl';

try {
    $client = new SoapClient($wsdl);

    $pvp = $client->getPVP("1");
    echo "PVP: " . $pvp . PHP_EOL;

    $stock = $client->getStock("1", "1");
    echo "Stock: " . $stock . PHP_EOL;

    $familias = $client->getFamilias();
    echo "Familias: " . implode(", ", $familias) . PHP_EOL;

    $productosFamilia = $client->getProductosFamilia("CONSOL");
    echo "Productos de la familia: " . implode(", ", $productosFamilia) . PHP_EOL;

} catch (SoapFault $fault) {
    echo "Error: {$fault->getMessage()}";
}