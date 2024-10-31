
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><?php echo $__env->yieldContent('titulo'); ?></title>
    <link href="../styles/styles.css" rel="stylesheet"> <!-- Ruta absoluta -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Libre+Barcode+128&display=swap" rel="stylesheet">
</head>
<body id="<?php echo $__env->yieldContent('body_id'); ?>">
    <div class="container mt-5">
        <h1 class="text-center"><?php echo $__env->yieldContent('encabezado'); ?></h1>
        <?php echo $__env->yieldContent('contenido'); ?>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
<?php /**PATH C:\xampp\htdocs\Tejera_Fumero_Deriman_DWES05_Codigo\views/plantillas/plantilla1.blade.php ENDPATH**/ ?>