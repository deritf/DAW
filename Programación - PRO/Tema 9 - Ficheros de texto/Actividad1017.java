/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad10.pkg17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Actividad1017 {

    /**
     * @param args the command line arguments
     */
    private static final String NOMBRE_ARCHIVO = "texto.txt";
    private static final int LINEAS_POR_PAGINA = 24;

    public static void main(String[] args) {

        int inicio = 0;
        int fin = LINEAS_POR_PAGINA;

        boolean salir = false;
        Scanner scanner = new Scanner(System.in);

        while (!salir) {
            try (BufferedReader in = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
                int lineaActual = 0;
                String linea = in.readLine();
                while (linea != null) {
                    if (lineaActual >= inicio && lineaActual < fin) {
                        System.out.println(linea);
                    }
                    lineaActual++;
                    linea = in.readLine();
                }
                if (lineaActual <= fin) {
                    salir = true;
                } else {
                    System.out.println("");
                    System.out.println("======================");
                    System.out.println("MENU DE OPCIONES");
                    System.out.println("1. Mostrar más líneas");
                    System.out.println("2. Salir");
                    System.out.print("Seleccione una opción:");

                    int opcion = scanner.nextInt();
                    switch (opcion) {
                        case 1:
                            inicio += LINEAS_POR_PAGINA;
                            fin += LINEAS_POR_PAGINA;
                            break;
                        case 2:
                            salir = true;
                            break;
                        default:
                            System.out.println("Opción inválida.");
                            break;
                    }

                    System.out.println("======================");
                    System.out.println("");
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo " + NOMBRE_ARCHIVO + ": " + e.getMessage());
                salir = true;
            }
        }
    }
}
//Autor: Derimán Tejera Fumero.
/*
Un libro de firmas es útil para recoger los nombres de todas las personas que
han pasado por un determinado lugar. Crea una aplicación que permita mostrar
el libro de firmas e insertar un nuevo nombre (comprobando que no se encuentre repetido).
Llamaremos al fichero firmas.txt.
 */
