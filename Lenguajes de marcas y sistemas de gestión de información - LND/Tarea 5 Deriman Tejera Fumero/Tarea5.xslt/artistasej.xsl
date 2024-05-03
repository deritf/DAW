<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
  <html>
  <head>
  <title>Tarea 5 LND</title>
  <h2>ARTISTAS FAMOSOS</h2>
  </head>  
  
  <body>
  <!--  Sección que crea la tabla donde irán los datos del fichero artistasej.xml-->
  <table border="4">
  <tr><th>Código</th><th>Nombre</th><th>Año de nacimiento</th><th>Año de fallecimiento</th><th>País</th><th>Página web</th></tr>
  
  <xsl:for-each select="/artistas/artista">
  <xsl:sort select="nacimiento"/> <!--  Aquí se ordenan la table en base al valor de las fechas de nacimiento, es decir, primero en la tabla la fecha de nacimiento mas antigua. -->
  <xsl:if test="nacimiento>1500"> <!--  Aquí se impide aparecer a un autor cuya fecha de nacimiento sea menor a 1500. -->

  <tr>
  <td><xsl:value-of select="@cod"/></td><!--  Para poder acceder al atributo debí usar @. -->
  <td><xsl:value-of select="nombreCompleto"/></td>
  <td><xsl:value-of select="nacimiento"/></td>

<!--  Sección que en el caso de que no exista datos para el elemento "fallecimiento", lo sustituye por la palabra "Desconocido". -->
  <td>
    <xsl:choose>
        <xsl:when test="fallecimiento"> <xsl:value-of select="fallecimiento"/> </xsl:when> <!--  En el caso de existir el dato de "fallecimiento", lo pondrá en la tabla, de lo contrario ejecutará la línea siguiente en la que se añade el texto "Desconocido".-->
        <xsl:otherwise> Desconocido </xsl:otherwise> <!--  En el caso de no existir el dato de fecha de fallecimiento, aparecerá el texto "Desconocido". -->
      </xsl:choose>
  </td>

  <td><xsl:value-of select="pais"/></td>

<!--  Sección que incluye las URL en la tabla y las sustituye por el texto "Saber mas". -->
  <td>
  <a>
  <xsl:attribute name="href">
  <xsl:value-of select="fichaCompleta"/>
  </xsl:attribute>
  <xsl:text>Saber mas</xsl:text> <!--  Aqui aparece el texto del hypervínculo -->
  </a>
  </td>
  </tr>
  </xsl:if>
  </xsl:for-each>
  </table>
  </body>
  </html>
  </xsl:template>
</xsl:stylesheet>

<!-- Autor: Derimán Tejera Fumero -->

