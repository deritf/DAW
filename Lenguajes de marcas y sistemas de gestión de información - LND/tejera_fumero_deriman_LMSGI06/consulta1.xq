"El nombre y país de todos los artistas son: ",
" ",
for $artista in doc("artistas.xml")//artistas/artista
return concat ("Artista: ", data($artista/nombreCompleto), ". Nacido/a en: ", data($artista/pais))

