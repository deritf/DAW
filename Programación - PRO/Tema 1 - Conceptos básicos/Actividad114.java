/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg1.pkg14;

import java.util.Locale;
import java.util.Scanner;
/**
 *
 * @author Antimonius
 */
public class Actividad114 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    double base;
    double altura;
    double x;
   
    Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.US);
    
    System.out.print("Este programa pide la BASE y la ALTURA de un triángulo para calcular su área.\n");
    System.out.print("Introduce la BASE del triángulo: ");
    base = sc.nextDouble();
    System.out.print("Introduce la ALTURA del triángulo: ");
    altura = sc.nextDouble();
    
    x = (base*altura)/2;
         
    System.out.println("El área del triángulo es: " + x);
    }
    
}

//Autor: Derimán Tejera Fumero.
