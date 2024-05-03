/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad10.pkg16bis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Actividad1016BIS {

    /**
     * @param args the command line arguments
     */
    private static final String FILENAME = "firmas.txt";
    private static final int MAX_FIRMAS = 100; // Máximo número de firmas permitidas
    private static String firmas[] = new String[MAX_FIRMAS]; // Arreglo de firmas

    public static void main(String[] args) {
        leerFirmas();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        while (!salir) {

            System.out.println("MENU DE OPCIONES3");
            System.out.println("1. Mostrar firmas");
            System.out.println("2. Añadir firma");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción:");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    mostrarFirmas();
                    break;
                case 2:
                    System.out.print("Introduzca un nombre:");
                    String nombre = scanner.nextLine();
                    if (buscarFirma(nombre) != -1) {
                        System.out.println("El nombre ya está en la lista.");
                        System.out.println("");
                        System.out.println("");
                    } else {
                        agregarFirma(nombre);
                        guardarFirmas();
                        System.out.println("Nombre añadido a la lista.");
                        System.out.println("");
                        System.out.println("");
                    }
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
                    System.out.println("");
                    System.out.println("");
                    break;
            }
        }
    }

    private static void leerFirmas() {
        File file = new File(FILENAME);
        if (file.exists()) {
            try (BufferedReader in = new BufferedReader(new FileReader(file))) {
                String line;
                int i = 0;

                while ((line = in.readLine()) != null && i < MAX_FIRMAS) {
                    firmas[i] = line;
                    i++;
                }

            } catch (IOException e) {
                System.out.println("Error al leer el fichero de firmas: " + e.getMessage());
            }
        }
    }

    private static void guardarFirmas() {
        try (BufferedWriter in = new BufferedWriter(new FileWriter(FILENAME))) {
            for (int i = 0; i < MAX_FIRMAS; i++) {
                if (firmas[i] != null) {
                    in.write(firmas[i]);
                    in.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el fichero de firmas: " + e.getMessage());
        }
    }

    private static void mostrarFirmas() {
        System.out.println("");
        System.out.println("");
        System.out.println("Las firmas almacenadas son: ");
        for (int i = 0; i < MAX_FIRMAS; i++) {
            if (firmas[i] != null) {
                System.out.println("[" + (i + 1) + "] " + firmas[i]);
            }
        }
        System.out.println("");
        System.out.println("");
    }

    private static void agregarFirma(String nombre) {
        for (int i = 0; i < MAX_FIRMAS; i++) {
            if (firmas[i] == null) {
                firmas[i] = nombre;
                break;
            }
        }
    }

    private static int buscarFirma(String nombre) {
        for (int i = 0; i < MAX_FIRMAS; i++) {
            if (firmas[i] != null && firmas[i].equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }
}
//Autor: Derimán Tejera Fumero.
/*
Un libro de firmas es útil para recoger los nombres de todas las personas que
han pasado por un determinado lugar. Crea una aplicación que permita mostrar
el libro de firmas e insertar un nuevo nombre (comprobando que no se encuentre repetido).
Llamaremos al fichero firmas.txt.
 */
