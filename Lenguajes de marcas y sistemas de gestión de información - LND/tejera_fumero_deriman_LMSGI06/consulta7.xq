"Estos son los modelos de impresora con mas de un tamaño:",
" ",
for $imp in doc("impresoras.xml")/impresoras/impresora
where ($imp/tamaño="A3" and $imp/tamaño="A4") or ($imp/tamaño="A3" and $imp/tamaño="A5") or ($imp/tamaño="A4" and $imp/tamaño="A5")
return concat (data($imp/marca), " - ", data($imp/modelo))
