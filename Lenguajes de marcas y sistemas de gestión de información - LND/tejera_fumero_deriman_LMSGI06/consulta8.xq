"Estos son los modelos de impresora con tamaño A3 u otros además de ese:",
" ",
for $imp in doc("impresoras.xml")/impresoras/impresora
where ($imp/tamaño="A3") or ($imp/tamaño="A3" and $imp/tamaño="A4") or ($imp/tamaño="A3" and $imp/tamaño="A5")
return concat (data($imp/marca), " - ", data($imp/modelo))
