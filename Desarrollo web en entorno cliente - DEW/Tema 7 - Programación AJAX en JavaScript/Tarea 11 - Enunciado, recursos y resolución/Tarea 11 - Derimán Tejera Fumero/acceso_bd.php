<?php
//Usar esta cabecera para trabajar con datos de la BD
header("Content-Type: application/json; charset=UTF-8");
error_reporting(0);

//Obtener el nombre de la tabla desde la URL en lugar de un objeto JSON en el cuerpo de la solicitud
$tabla = $_GET["tabla"];

//Parámetros de conexión a la BD por defecto
$servidor = "localhost";
$usuario = "root";
$password = "";
$bbdd = "espana";

//Crear la conexión a la BD
$conexion = new mysqli($servidor, $usuario, $password, $bbdd);

//Comprobar la conexión
if ($conexion->connect_error) {
    die("Error en la conexión: " . $conexion->connect_error);
} else {
    try {
        //Crear la consulta SQL
        $sql = "SELECT * FROM $tabla";

        //Ejecutar la consulta
        $resultado = $conexion->query($sql);

        //Verificar si la consulta se ejecutó correctamente
        if ($resultado === false) {
            //Manejar el error aquí
            $error = $conexion->error;
            echo json_encode(array('error' => $error));
        } else {
            //Obtener los resultados y enviarlos en la respuesta JSON
            $salida = $resultado->fetch_all(MYSQLI_ASSOC);
            echo json_encode($salida);
        }
    } catch (Exception $e) {
        //Manejar excepciones aquí
        echo json_encode(array('error' => $e->getMessage()));
    }
}

$conexion->close();
?>