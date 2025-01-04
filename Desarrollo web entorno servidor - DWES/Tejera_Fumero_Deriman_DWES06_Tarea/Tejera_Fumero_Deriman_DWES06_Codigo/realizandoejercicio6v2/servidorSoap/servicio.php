<?php
require '../vendor/autoload.php';
use Clases\Operaciones;

$uri = 'http://localhost/unidad6/servidorSoap';
$parametros = ['uri' => $uri];

try {
    $server = new SoapServer(null, $parametros);
    $server->setClass(Operaciones::class);
    $server->handle();
} catch (SoapFault $f) {
    die("Error en el servidor: " . $f->getMessage());
}