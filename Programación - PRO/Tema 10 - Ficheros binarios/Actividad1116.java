/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg1116;

import java.io.*;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Actividad1116 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String nombres[] = leerNombres();
        String nuevosNombres[] = pedirNuevosNombres();
        String listaNombres[] = fusionarNombres(nombres, nuevosNombres);
        guardarNombres(listaNombres);
        System.out.println("");
        System.out.println("");
        System.out.println("La lista actualizada de nombres es la siguiente: ");
        leerNombres();
    }

    public static String[] leerNombres() {

        String[] nombres = null;
        try {
            File archivo = new File("nombres.dat");

            System.out.println("Los nombres contenidos en el archivo " + archivo + " son: ");
            Scanner scanner = new Scanner(archivo);
            int numNombres = 0;
            while (scanner.hasNextLine()) {
                String nombre = scanner.nextLine();
                System.out.println(nombre);
                numNombres++;
            }
            System.out.println("");
            System.out.println("");
            scanner.close();
            nombres = new String[numNombres];
            scanner = new Scanner(archivo);
            int i = 0;
            while (scanner.hasNextLine()) {
                nombres[i] = scanner.nextLine();
                i++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo");
        }
        return nombres;
    }

    public static String[] pedirNuevosNombres() {
        String[] nuevosNombres = new String[0];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Introduce un nombre (introduce 'fin' para terminar): ");
        String nombre;
        try {
            nombre = br.readLine();
            while (!nombre.equals("fin")) {
                nuevosNombres = insertarNombre(nuevosNombres, nombre);
                System.out.print("Introduce otro nombre (introduce 'fin' para terminar): ");
                nombre = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error al leer desde la consola");
        }
        return nuevosNombres;
    }

    public static String[] fusionarNombres(String[] nombres1, String[] nombres2) {
        String[] listaNombres = new String[nombres1.length + nombres2.length];
        int indice1 = 0;
        int indice2 = 0;
        int indiceLista = 0;
        while (indice1 < nombres1.length && indice2 < nombres2.length) {
            if (nombres1[indice1].compareTo(nombres2[indice2]) < 0) {
                listaNombres[indiceLista] = nombres1[indice1];
                indice1++;
            } else {
                listaNombres[indiceLista] = nombres2[indice2];
                indice2++;
            }
            indiceLista++;
        }
        while (indice1 < nombres1.length) {
            listaNombres[indiceLista] = nombres1[indice1];
            indice1++;
            indiceLista++;
        }
        while (indice2 < nombres2.length) {
            listaNombres[indiceLista] = nombres2[indice2];
            indice2++;
            indiceLista++;
        }
        return listaNombres;
    }

    public static void guardarNombres(String[] nombres) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("nombres.dat"));
            for (String nombre : nombres) {
                bw.write(nombre + "\n");
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo");
        }
    }

    public static String[] insertarNombre(String[] nombres, String nombre) {
        String nuevosNombres[] = new String[nombres.length + 1];
        int indice = 0;
        while (indice < nombres.length && nombre.compareTo(nombres[indice]) > 0) {
            nuevosNombres[indice] = nombres[indice];
            indice++;
        }
        nuevosNombres[indice] = nombre;
        while (indice < nombres.length) {
            nuevosNombres[indice + 1] = nombres[indice];
            indice++;
        }
        return nuevosNombres;
    }

}

//Autor: Derimán Tejera Fumero.
/*
Implementa una aplicación que gestione una lista de nombres ordenada por orden alfabético.
Al arrancar se leerá de un fichero los nombres insertados anteriormente y se pedirán nombres
nuevos hasta que se introduzca la cadena <<fin>>. Cada nombre que se introduzca deberá añadirse
a los que ya habrá, de forma que la lista permanezca ordenada. Al terminar, se guardará en
el fichero la lista actualizada.
 */
