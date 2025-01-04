<?php
require 'vendor/autoload.php';

use Clases\Conexion;

$conexion = Conexion::conectar();
if ($conexion) {
    echo "Conexión exitosa";
}