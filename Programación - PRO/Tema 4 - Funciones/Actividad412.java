/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg4.pkg12;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Antimonius
 */
public class Actividad412 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        
        double x1;
        double x2;
        double y1;
        double y2;
        
        System.out.println("Este programa calcula la distancia euclídea que separan los puntos x1, y1 y x2, y2..");   
                             
            System.out.print("Introduce el valor de x1: ");
            x1 = sc.nextDouble();
                               
            System.out.print("Introduce el valor de y1: ");
            y1 = sc.nextDouble();
                             
            System.out.print("Introduce el valor de x2: ");
            x2 = sc.nextDouble();
                                    
            System.out.print("Introduce el valor de y2: ");
            y2 = sc.nextDouble();    
        
        System.out.println("El valor de la distancia es: " + distancia(x1, y1, x2, y2));

    }
    
    static double distancia (double x1, double y1, double x2, double y2){
    
    double distancia1;
    
    distancia1 = ((x2-x1) * (x2-x1)) + ((y2-y1) * (y2-y1));
    distancia1 = Math.sqrt(distancia1);   
    return distancia1;  
    }  
}
//Autor: Derimán Tejera Fumero.

