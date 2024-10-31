

<?php $__env->startSection('titulo', 'Crear Jugador'); ?>

<?php $__env->startSection('contenido'); ?>
<div class="container mt-5">
    <h1 class="text-center">Crear Jugador</h1>

    <?php if($error): ?>
    <div class="alert alert-danger">
        <?php echo e($error); ?>

    </div>
    <?php endif; ?>

    <?php if (isset($_SESSION['mensaje_exito'])): ?>
        <div class="alert alert-success">
            <?= $_SESSION['mensaje_exito'] ?>
        </div>
        <?php unset($_SESSION['mensaje_exito']); ?>
    <?php endif; ?>


    <form action="guardar_jugador.php" method="POST">
        <div class="row">
            <div class="col-md-6">
                <label for="nombre">Nombre</label>
                <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre" value="<?php echo e($nombre); ?>" required>
            </div>
            <div class="col-md-6">
                <label for="apellidos">Apellidos</label>
                <input type="text" class="form-control" id="apellidos" name="apellidos" placeholder="Apellidos" value="<?php echo e($apellidos); ?>" required>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4">
                <label for="dorsal">Dorsal</label>
                <input type="number" class="form-control" id="dorsal" name="dorsal" placeholder="Dorsal" value="<?php echo e($dorsal); ?>" required>
            </div>
            <div class="col-md-4">
                <label for="posicion">Posición</label>
                <select class="form-control" id="posicion" name="posicion" required>
                    <option value="Portero" <?php echo e($posicion == 'Portero' ? 'selected' : ''); ?>>Portero</option>
                    <option value="Defensa" <?php echo e($posicion == 'Defensa' ? 'selected' : ''); ?>>Defensa</option>
                    <option value="Centrocampista" <?php echo e($posicion == 'Centrocampista' ? 'selected' : ''); ?>>Centrocampista</option>
                    <option value="Delantero" <?php echo e($posicion == 'Delantero' ? 'selected' : ''); ?>>Delantero</option>
                </select>
            </div>
            <div class="col-md-4">
                <label for="codigo_barras">Código de Barras</label>
                <input type="text" class="form-control" id="codigo_barras" name="codigo_barras" placeholder="Código de Barras" value="<?php echo e($codigo_barras); ?>" readonly>
            </div>
        </div>

        <div class="row mt-4">
            <div class="col-md-12">
                <div class="button-group">
                    <button type="submit" class="btn btn-primary">Crear</button>
                    <button type="reset" class="btn btn-success">Limpiar</button>
                    <a href="jugadores.php" class="btn btn-info">Volver</a>
                    <a href="generarCode.php?nombre=<?php echo e($nombre); ?>&apellidos=<?php echo e($apellidos); ?>&dorsal=<?php echo e($dorsal); ?>&posicion=<?php echo e($posicion); ?>" class="btn btn-secondary">Generar Barcode</a>
                </div>
            </div>
        </div>
    </form>
</div>
<?php $__env->stopSection(); ?>
<?php echo $__env->make('plantillas.plantilla1', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\xampp\htdocs\Tejera_Fumero_Deriman_DWES05_Codigo\views/vcrear.blade.php ENDPATH**/ ?>