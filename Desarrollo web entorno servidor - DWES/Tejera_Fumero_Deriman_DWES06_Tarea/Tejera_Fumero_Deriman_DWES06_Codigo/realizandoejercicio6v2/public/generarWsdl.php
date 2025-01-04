<?php
require __DIR__ . '/../vendor/autoload.php';

use PHP2WSDL\PHPClass2WSDL;

$namespace = "http://localhost/realizandoejercicio6v2/servidorSoap";
$class = "Clases\Operaciones";

$wsdlGenerator = new PHPClass2WSDL($class, $namespace);

$wsdlGenerator->generateWSDL();

file_put_contents(__DIR__ . '/../servidorSoap/servicio.wsdl', $wsdlGenerator->dump());