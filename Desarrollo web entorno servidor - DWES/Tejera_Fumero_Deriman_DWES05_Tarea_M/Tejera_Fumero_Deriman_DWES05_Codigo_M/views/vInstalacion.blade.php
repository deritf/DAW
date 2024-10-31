@extends('plantillas.plantilla1')

@section('titulo', 'Instalación de Datos')

@section('contenido')
<div class="container mt-5">
    <h1 class="text-center">Instalación de Datos</h1>
    <p class="text-center">Presiona el botón para generar datos de ejemplo.</p>
    <div class="text-center">
        <a href="crearDatos.php" class="btn btn-success install-btn">
            <i class="bi bi-database"></i> Instalar Datos de Ejemplo
        </a>
    </div>
</div>
@endsection