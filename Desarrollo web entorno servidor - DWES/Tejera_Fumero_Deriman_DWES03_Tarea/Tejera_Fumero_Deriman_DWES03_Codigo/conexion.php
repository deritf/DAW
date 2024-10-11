<?php
$host = 'localhost';
$dbname = 'proyecto';
$user = 'root';
$password = '';

try {
    $conexion = new PDO("mysql:host=$host;dbname=$dbname;charset=utf8mb4", $user, $password);
    $conexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $e) {
    echo "Error en la conexión: " . $e->getMessage();
    die();
}

/*
    Autor: Derimán Tejera Fumero.
    Asignatura: DWES CFGS DAW
    Fecha: 11-10-2024
*/