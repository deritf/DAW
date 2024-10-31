

<?php $__env->startSection('titulo', 'Instalación de Datos'); ?>

<?php $__env->startSection('contenido'); ?>
<div class="container mt-5">
    <h1 class="text-center">Instalación de Datos</h1>
    <p class="text-center">Presiona el botón para generar datos de ejemplo.</p>
    <div class="text-center">
        <a href="crearDatos.php" class="btn btn-success install-btn">
            <i class="bi bi-database"></i> Instalar Datos de Ejemplo
        </a>
    </div>
</div>
<?php $__env->stopSection(); ?>

<?php echo $__env->make('plantillas.plantilla1', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\xampp\htdocs\Tejera_Fumero_Deriman_DWES05_Codigo\views/vinstalacion.blade.php ENDPATH**/ ?>