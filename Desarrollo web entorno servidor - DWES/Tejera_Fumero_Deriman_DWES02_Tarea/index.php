<?php
session_start();
?>

<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Tarea DWES02 - Agenda de contactos</title>
    <link rel="stylesheet" href="styles.css" />
  </head>
  <body>
    <?php if (isset($_SESSION['mensaje'])): ?>
      <section class="mensaje-esquina-superior-izquierda" id="mensaje"><?php echo $_SESSION['mensaje']; unset($_SESSION['mensaje']); ?></section>
    <?php endif; ?>

      <h2>Agenda</h2>

    <form action="agenda.php" method="get" >
    <?php if (isset($_SESSION['agenda']) && !empty($_SESSION['agenda'])): ?>
      <fieldset id="parte-formulario-1">
        <legend>Datos Agenda</legend>
        <?php include 'mostrar_agenda.php'; ?>
      </fieldset>
      <?php endif; ?>
    </form>

    <form action="agenda.php" method="post">
      <fieldset id="parte-formulario-2">
        <legend>Nuevo Contacto</legend>
        <label for="nombre" id="etiqueta-negrita-y-azul">Nombre:</label>
        <input type="text" id="nombre" name="nombre" />
        <br />
        <label for="telefono" id="etiqueta-negrita-y-azul">Teléfono:</label>
        <input type="text" id="telefono" name="telefono" pattern="[0-9]{9}" maxlength="9" title="El teléfono debe contener 9 números entre 0 y 9." />
        <br /><br />
        <button type="submit" class="btn-anadir-contacto">
          Añadir Contacto
        </button>
        <button type="reset" class="btn-limpiar-campos">Limpiar Campos</button>
      </fieldset>
    </form>

    <form action="agenda.php" method="get">
      <?php if (isset($_SESSION['agenda']) && !empty($_SESSION['agenda'])): ?>
      <fieldset id="parte-formulario-3">
        <legend>Vaciar Agenda</legend>
        <button type="submit" name="vaciar" value="1" class="btn-vaciar">
          Vaciar
        </button>
      </fieldset>
      <?php endif; ?>
    </form>
  </body>
</html>

<!--Autor: Derimán Tejera Fumero.-->
<!--Asignatura: DWES CFGS DAW-->
<!--Fecha: 27-09-2024-->