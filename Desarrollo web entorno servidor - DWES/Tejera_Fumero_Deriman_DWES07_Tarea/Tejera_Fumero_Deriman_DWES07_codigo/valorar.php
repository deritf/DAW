<?php
require_once 'conexion.php';
session_start();

if (!isset($_SESSION['usuario'])) {
    echo json_encode(['success' => false, 'message' => 'Debes iniciar sesión para votar.']);
    exit;
}

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $usuario = $_SESSION['usuario'];
    $idProducto = $_POST['id'];
    $valoracion = (int) $_POST['valoracion'];

    $stmt = $conexion->prepare("SELECT COUNT(*) FROM votos WHERE idPr = :idPr AND idUs = :idUs");
    $stmt->execute(['idPr' => $idProducto, 'idUs' => $usuario]);
    $yaVotado = $stmt->fetchColumn();

    if ($yaVotado) {
        $stmt = $conexion->prepare("UPDATE votos SET cantidad = :cantidad WHERE idPr = :idPr AND idUs = :idUs");
        $stmt->execute(['cantidad' => $valoracion, 'idPr' => $idProducto, 'idUs' => $usuario]);
        echo json_encode(['success' => true, 'message' => 'Tu voto ha sido actualizado.']);
    } else {
        $stmt = $conexion->prepare("INSERT INTO votos (cantidad, idPr, idUs) VALUES (:cantidad, :idPr, :idUs)");
        $stmt->execute(['cantidad' => $valoracion, 'idPr' => $idProducto, 'idUs' => $usuario]);
        echo json_encode(['success' => true, 'message' => 'Tu voto ha sido registrado.']);
    }
    exit;
}
?>

<!--
    Autor: Derimán Tejera Fumero.
    Asignatura: DWES CFGS DAW
    Fecha: 02-12-2024
-->