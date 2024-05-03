/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg7.pkg11.anterior;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Actividad711Anterior {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        MarcaPagina libro1;
        libro1 = new MarcaPagina("El Conde de Montecristo", "Castellano", "Alfaguara", 2022, 717, 55, "Alejandro Dumas", "9788497945400");     
        
        System.out.println("Este programa hace la función de marcador de libros para uno en lectura.");
        
        

        do {
            System.out.println("------------------------------------------------");
            System.out.println("Menú:");
            System.out.println("1. Marcar una página como leída.");
            System.out.println("2. Obtener información sobre la última págian leída.");
            System.out.println("3. Comenzar el libro desde el principio.");
            System.out.println("4. Salir");
            System.out.println("------------------------------------------------");
            System.out.print("Introduce una opción: ");
            opcion = sc.nextInt();
          
            switch (opcion) {
                case 1 -> {
                    System.out.println();
                    libro1.incrementarPaginaLeida();
                    System.out.println();
                }
                case 2 -> {
                    System.out.println();
                    System.out.println("La última página leída es: " + libro1.paginaActual);
                    System.out.println();
                }
                case 3 -> {
                    System.out.println();
                    libro1.reiniciarLecturaLibro();
                    System.out.println();
                }
                case 4 -> System.out.println("Saliendo del programa... ");
                default -> System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 4);
    }  
}
//Autor: Derimán Tejera Fumero.