<?php
session_start();

session_unset();
session_destroy();

header("Location: index.php");
exit();
?>

<!--
    Autor: Derimán Tejera Fumero.
    Asignatura: DWES CFGS DAW
    Fecha: 02-12-2024
-->