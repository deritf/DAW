/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg1.pkg21;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Antimonius
 */
public class Actividad121 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    double a;
    double b;
    boolean resultado;
   
    Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.US);
    
    System.out.print("Este programa comparar números para verificar si son iguales o no.\n");
    System.out.print("Introduzca un número (a): ");
    a = sc.nextDouble();
    System.out.print("Introduzca un número (b): ");
    b = sc.nextDouble();
    
    resultado = a == b;
    
    System.out.println("Es " + resultado + " que los números (a) y (b) son iguales.");
        
    }
    
}
//Autor: Derimán Tejera Fumero.
