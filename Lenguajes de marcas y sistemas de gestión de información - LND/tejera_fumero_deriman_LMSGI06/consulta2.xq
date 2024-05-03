"Estos son los artistas que nacieron antes de 1500:",
" ",
for $artista in doc("artistas.xml")//artistas/artista
where $artista/number(nacimiento)<1500
return data($artista/nombreCompleto)




