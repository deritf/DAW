@extends('plantillas.plantilla1')

@section('titulo', 'Jugadores')
@section('body_id', 'listaJugadores')

@section('contenido')
<div class="container mt-5">
    <h1 class="text-center">Listado de Jugadores</h1>

    @if ($mensaje_exito)
        <div class="alert alert-success">
            {{ $mensaje_exito }}
        </div>
    @endif

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
            @forelse ($jugadores as $jugador)
                <tr>
                    <td>{{ $jugador->nombre }} {{ $jugador->apellidos }}</td>
                    <td>{{ $jugador->posicion }}</td>
                    <td>{{ $jugador->dorsal ?? 'Sin Asignar' }}</td>
                    <td class="barcode">{{ $jugador->barcode }}</td>
                </tr>
            @empty
                <tr>
                    <td colspan="4" class="text-center">No hay jugadores registrados</td>
                </tr>
            @endforelse
        </tbody>
    </table>
</div>
@endsection
