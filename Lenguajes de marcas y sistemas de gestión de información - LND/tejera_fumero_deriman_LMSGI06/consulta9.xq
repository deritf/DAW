"Estos son los modelos de impresora con tamaño únicamente A3:",
" ",
for $imp in doc("impresoras.xml")/impresoras/impresora
where ($imp/tamaño="A3") and not ($imp/tamaño="A3" and $imp/tamaño="A4") and not ($imp/tamaño="A3" and $imp/tamaño="A5")
return concat (data($imp/marca), " - ", data($imp/modelo))
