/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad10.pkg13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class Actividad1013 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int tabla1[] = leerNumerosFichero("numeros1.txt");
        int tabla2[] = leerNumerosFichero("numeros2.txt");

        int tablaFusionada[] = fusionarTablas(tabla1, tabla2);

        System.out.println("Este programa leerá de dos fichero (numeros1.txt y numeros2.txt) los números que contienen y los ordenaran en un tercer fichero (numerosOrdenados.txt).");

        ordenar(tablaFusionada, 0, tablaFusionada.length - 1);

        escribirNumerosArchivo("numerosOrdenados.txt", tablaFusionada);
        System.out.println("Finalizando programa.");
    }

    private static int[] leerNumerosFichero(String nombreFichero) {
        int tabla[] = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreFichero))) {
            String line;
            int contador = 0;
            while ((line = reader.readLine()) != null) {
                if (tabla == null) {
                    tabla = new int[1];
                } else {
                    int[] temp = new int[contador + 1];
                    System.arraycopy(tabla, 0, temp, 0, contador);
                    tabla = temp;
                }
                tabla[contador] = Integer.parseInt(line);
                contador++;
            }
            System.out.println("Leídos los números de ficheros " + nombreFichero + "[COMPLETADO]");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ha ocurrido un error.");
        }
        return tabla;
    }

    private static int[] fusionarTablas(int tabla1[], int tabla2[]) {
        int tablaFusionada[] = new int[tabla1.length + tabla2.length];
        System.arraycopy(tabla1, 0, tablaFusionada, 0, tabla1.length);
        System.arraycopy(tabla2, 0, tablaFusionada, tabla1.length, tabla2.length);
        System.out.println("Fusionando tablas [COMPLETADO]");

        return tablaFusionada;
    }

    private static void ordenar(int tabla[], int izquierda, int derecha) {

        if (izquierda < derecha) {
            int indice = dividir(tabla, izquierda, derecha);
            ordenar(tabla, izquierda, indice - 1);
            ordenar(tabla, indice + 1, derecha);
        }

    }

    private static int dividir(int tabla[], int izquierda, int derecha) {
        int indicePivote = tabla[derecha];
        int y = izquierda - 1;
        for (int x = izquierda; x <= derecha - 1; x++) {

            if (tabla[x] < indicePivote) {
                y++;
                intercambiar(tabla, y, x);
            }

        }
        intercambiar(tabla, y + 1, derecha);

        return y + 1;
    }

    private static void intercambiar(int tabla[], int x, int y) {
        int temp = tabla[x];
        tabla[x] = tabla[y];
        tabla[y] = temp;
    }

    private static void escribirNumerosArchivo(String nombreArchivo, int tabla[]) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (int num : tabla) {
                writer.write(num + "\n");
            }
            System.out.println("Escritos los números en el fichero " + nombreArchivo + "[COMPLETADO]");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ha ocurrido un error.");
        }
    }
}

//Autor: Derimán Tejera Fumero
/*
Implementa un programa que lea dos listas de números enteros no ordenados de sendos archivos con un número por línea,
los reúna en una lista única y los guarde en orden creciente en un tercer archivo, de nuevo uno por linea.
 */
