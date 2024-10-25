<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Jugadores</title>
    <link href="../styles/styles.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Libre+Barcode+128&display=swap" rel="stylesheet">
</head>
<body id="listaJugadores">
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

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>