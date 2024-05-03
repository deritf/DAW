/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad10.pkg20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class Actividad1020 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String fichero1 = "texto1.txt";
        String fichero2 = "texto2.txt";

        try {

            System.out.println("Este programa muertra por pantalla la línea y número de carácter donde difieren 2 textos dados en los ficheros texto1.txt y texto2.txt.");

            String contenidoArchivo1[] = leerFichero(fichero1);
            String contenidoArchivo2[] = leerFichero(fichero2);

            for (int i = 0; i < contenidoArchivo1.length && i < contenidoArchivo2.length; i++) {
                if (!contenidoArchivo1[i].equals(contenidoArchivo2[i])) {
                    int posicionDiferencia = buscarPrimeraDiferencia(contenidoArchivo1[i], contenidoArchivo2[i]);
                    System.out.println("La primera diferencia está en la línea [" + (i + 1) + "], carácter [" + (posicionDiferencia + 1) + "].");
                    return;
                }
            }

            if (contenidoArchivo1.length != contenidoArchivo2.length) {
                System.out.println("Los ficheros tienen diferente cantidad de líneas.");
            } else {
                System.out.println("Los ficheros son idénticos.");
            }

        } catch (IOException e) {
            System.out.println("Error al leer los ficheros.");
            e.printStackTrace();
        }
    }

    private static String leerFichero      (String nombreFichero)  [] throws IOException {
        BufferedReader lector = new BufferedReader(new FileReader(nombreFichero));
        String linea;
        String contenido[] = new String[0];

        while ((linea = lector.readLine()) != null) {
            String nuevoContenido[] = new String[contenido.length + 1];
            System.arraycopy(contenido, 0, nuevoContenido, 0, contenido.length);
            nuevoContenido[contenido.length] = linea;
            contenido = nuevoContenido;
        }

        lector.close();
        return contenido;
    }

    private static int buscarPrimeraDiferencia(String linea1, String linea2) {
        int longitud = Math.min(linea1.length(), linea2.length());

        for (int i = 0; i < longitud; i++) {
            if (linea1.charAt(i) != linea2.charAt(i)) {
                return i;
            }
        }

        return longitud;
    }
}
//Autor: Derimán Tejera Fumero.
/*
Algunos sistemas operativos disponen de la orden comp. que compara dos archivos y nos dice si son iguales
o distintos. Diseña esta orden de forma que. además, nos diga en qué linea y carácter se encuentra la
primera diferencia. Utiliza los ficheros texto1.txt y texto2.txt
 */
