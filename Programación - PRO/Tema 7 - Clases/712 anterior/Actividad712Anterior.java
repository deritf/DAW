/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg7.pkg12.anterior;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Actividad712Anterior {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        double a = 2;
        double b = 40;
        double c = 9;
        
        EcuacionSegundoGrado ecuacion1;
        ecuacion1 = new EcuacionSegundoGrado(a, b, c);
        
        System.out.println("Este programa resuelve ecuaciones de segundo grado.");
        
        do {
            System.out.println("------------------------------------------------");
            System.out.println("Menú:");
            System.out.println("1. Mostra datos actuales para a, b y c.");
            System.out.println("2. Resultado de la ecuación.");
            System.out.println("3. ¿Es positivo el discriminante?.");
            System.out.println("4. ¿Quieres cambiar los datos?.");
            System.out.println("5. Salir");
            System.out.println("------------------------------------------------");
            System.out.print("Introduce una opción: ");
            opcion = sc.nextInt();
          
            switch (opcion) {
                case 1 -> {
                    System.out.println();
                    ecuacion1.mostrarDatosActuales();
                    System.out.println();
                }
                case 2 -> {
                    System.out.println();
                    ecuacion1.resolverEcuacion();
                    System.out.println();
                }
                case 3 -> {
                    System.out.println();
                    ecuacion1.discriminante();
                    System.out.println();
                }
                case 4 -> {
                    System.out.println();
                    System.out.println("Introduce los valores a, b, y c:");
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    c = sc.nextDouble();
                    ecuacion1.setDatos(a, b, c);
                    System.out.println();
                }
                case 5 -> System.out.println("Saliendo del programa... ");
                default -> System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 5);  
    }
}
//Autor: Derimán Tejera Fumero.    

