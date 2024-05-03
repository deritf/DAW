/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg2.pkg16;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Antimonius
 */
public class Actividad216 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    double num;
    double x;
    
   
    Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.US);
    
    System.out.print("Este programa pide un número y devuelve el valor absoluto.\n");
    System.out.print("Introduce el número: ");
    num = sc.nextDouble();
    
    x = (num<0?num*(-1):num); 
    
    System.out.print("El valor absoluto sería " + x + "\n");
    
    }
    
}

//Autor: Derimán Tejera Fumero.
