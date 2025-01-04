<?php
require_once __DIR__ . '/../vendor/autoload.php';

use Wsdl2PhpGenerator\Generator;
use Wsdl2PhpGenerator\Config;

$generator = new Generator();
$config = new Config([
    'inputFile' => 'C:/xampp/htdocs/realizandoejercicio6v2/servidorSoap/servicio.wsdl',
    'outputDir' => 'C:/xampp/htdocs/realizandoejercicio6v2/src/Clases1',
    'namespaceName' => 'Clases1'
]);

$generator->generate($config);

echo "Clases generadas en la carpeta 'src/Clases1'";