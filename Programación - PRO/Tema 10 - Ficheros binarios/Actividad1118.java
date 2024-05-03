/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg1118;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Actividad1118 {

    /**
     * @param args the command line arguments
     */
    private static final String FILENAME = "firmas.dat";
    private static final int MAX_FIRMAS = 100;
    private static String firmas[] = new String[MAX_FIRMAS];

    public static void main(String[] args) {
        leerFirmas();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        while (!salir) {

            System.out.println("MENU DE OPCIONES");
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
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                firmas = (String[]) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al leer el fichero de firmas: " + e.getMessage());
            }
        }
    }

    private static void guardarFirmas() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            out.writeObject(firmas);
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
Un libro de firmas es útil para recoger los nombres de todas las personas que han pasado por un determinado lugar.
Crea una aplicación que permita mostrar el libro de firmas o insertar un nuevo nombre (comprobando que no se encuentre
repetido) usando el fichero binario firmas.dat.
 */
