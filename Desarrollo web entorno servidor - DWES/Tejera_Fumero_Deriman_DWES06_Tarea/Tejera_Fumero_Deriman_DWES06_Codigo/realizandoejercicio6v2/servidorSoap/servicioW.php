<?php
require_once '../vendor/autoload.php';
use Clases\Operaciones;

$options = [
    'uri' => 'http://localhost/realizandoejercicio6v2/servidorSoap',
    'location' => 'http://localhost/realizandoejercicio6v2/servidorSoap/servicioW.php'
];

$server = new SoapServer("servicio.wsdl", $options);
$server->setClass(Operaciones::class);
$server->handle();
