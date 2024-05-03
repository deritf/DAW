<html>
<head>
<title>Ejercicio 1. Apartado 5</title>
<h1>ARTISTAS NACIDOS EN ESPAÑA </h1>
</head>

<body>
<table>
<br/>
<tr><td>Nombre</td><td>Año de nacimiento</td><td>Año de fallecimiento</td><td>País</td></tr>
{
for $artista in doc("artistas.xml")/artistas/artista
where $artista/pais="España"
return <tr><td>{data($artista/nombreCompleto)}</td><td>{data($artista/nacimiento)}</td><td>{data($artista/fallecimiento)}</td><td>{data($artista/pais)}</td></tr>    
} 
</table>
</body>
</html>