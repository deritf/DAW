<?php

if (!empty($_SESSION['agenda'])) {
    echo '<ul>';
    foreach ($_SESSION['agenda'] as $nombre => $telefono) {

        $telefono_formateado = chunk_split($telefono, 3, ' ');
        $telefono_formateado = rtrim($telefono_formateado, ' ');

        echo '<li class="letras-azules">' . ($nombre) . '&emsp; &emsp; <strong>' . ($telefono_formateado) . '</strong></li>';
    }
    echo '</ul>';
} else {
    echo '<p>No hay contactos en la agenda.</p>';
}
?>