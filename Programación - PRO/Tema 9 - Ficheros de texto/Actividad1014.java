/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad10.pkg14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class Actividad1014 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String fichero = "carta.txt";
        int caracteres = 0;
        int lineas = 0;
        int palabras = 0;

        System.out.println("Este programa contabiliza los caracteres, líneas y palabras de un texto contenido en carta.txt.");

        try {
            BufferedReader lector = new BufferedReader(new FileReader(fichero));
            String linea;
            while ((linea = lector.readLine()) != null) {
                caracteres += linea.length();
                lineas++;
                palabras += contarPalabras(linea);
            }
            lector.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + fichero + ": " + e.getMessage());
            return;
        }
        System.out.println("Datos del archivo [" + fichero + "]");
        System.out.println("1. Caracteres: " + caracteres);
        System.out.println("2. Lineas: " + lineas);
        System.out.println("3. Palabras: " + palabras);

    }

    public static int contarPalabras(String linea) {
        String palabras[] = linea.split("[ \n]");
        int contador = 0;
        for (String palabra : palabras) {
            if (!palabra.equals("")) {
                contador++;
            }
        }
        return contador;
    }

}
//Autor: Derimán Tejera Fumero.
/*
Escribe un programa que lea un fichero de texto llamado carta txt.
Tenemos que contar los caracteres, las lineas y las palabras. Para
simplificar supondremos que cada palabra está separada de otra por
un único espacio en blanco o por un cambio de linea.
 */
