

<?php $__env->startSection('titulo', 'Jugadores'); ?>
<?php $__env->startSection('body_id', 'listaJugadores'); ?>

<?php $__env->startSection('contenido'); ?>
<div class="container mt-5">
    <h1 class="text-center">Listado de Jugadores</h1>

    <?php if($mensaje_exito): ?>
        <div class="alert alert-success">
            <?php echo e($mensaje_exito); ?>

        </div>
    <?php endif; ?>

    <a href="fcrear.php" class="btn btn-success mb-3">+ Nuevo Jugador</a>

    <table class="table">
        <thead>
            <tr>
                <th>Nombre Completo</th>
                <th>Posición</th>
                <th>Dorsal</th>
                <th>Código de Barras</th>
            </tr>
        </thead>
        <tbody>
            <?php $__empty_1 = true; $__currentLoopData = $jugadores; $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $jugador): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); $__empty_1 = false; ?>
                <tr>
                    <td><?php echo e($jugador->nombre); ?> <?php echo e($jugador->apellidos); ?></td>
                    <td><?php echo e($jugador->posicion); ?></td>
                    <td><?php echo e($jugador->dorsal ?? 'Sin Asignar'); ?></td>
                    <td class="barcode"><?php echo e($jugador->barcode); ?></td>
                </tr>
            <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); if ($__empty_1): ?>
                <tr>
                    <td colspan="4" class="text-center">No hay jugadores registrados</td>
                </tr>
            <?php endif; ?>
        </tbody>
    </table>
</div>
<?php $__env->stopSection(); ?>

<?php echo $__env->make('plantillas.plantilla1', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\xampp\htdocs\Tejera_Fumero_Deriman_DWES05_Codigo\views/vjugadores.blade.php ENDPATH**/ ?>