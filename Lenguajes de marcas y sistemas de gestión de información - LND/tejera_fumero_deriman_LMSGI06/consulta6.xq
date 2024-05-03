"Estos son los modelos de impresora de tipo láser:",
" ",
for $imp in doc("impresoras.xml")/impresoras/impresora
where $imp/@tipo="láser"
return data($imp/modelo)
