"El nombre de los artistas para los que no hay año de fallecimiento es: ",
" ",
for $art in doc("artistas.xml")/artistas/artista
where empty($art/fallecimiento)
return data($art/nombreCompleto)


