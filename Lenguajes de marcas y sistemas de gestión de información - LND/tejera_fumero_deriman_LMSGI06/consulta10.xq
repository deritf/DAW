"Estos son los modelos de impresoras en red:",
" ",
for $imp in doc("impresoras.xml")/impresoras/impresora
where ($imp/enred)
return concat (data($imp/marca), " - ", data($imp/modelo))
