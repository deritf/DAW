/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg1.pkg15;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Antimonius
 */
public class Actividad115 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    double a;
    double b;
    double c;
    double x;
    double y;
   
    Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.US);
    
    System.out.print("Este programa resuelve el polinomio y = ax2 + bx + c.\nPara ello pedirá a continuación los valores de x, a, b, y c.\n");
    System.out.print("Introduce el valor de a: ");
    a = sc.nextDouble();
    System.out.print("Introduce el valor de b: ");
    b = sc.nextDouble();
    System.out.print("Introduce el valor de b: ");
    c = sc.nextDouble();
    System.out.print("Introduce el valor de x: ");
    x = sc.nextDouble();
    
    y = a*x*x+b*x+c;
         
    System.out.println("El valor de y es: " + y);
    }
    
    }
    
//Autor: Derimán Tejera Fumero.
