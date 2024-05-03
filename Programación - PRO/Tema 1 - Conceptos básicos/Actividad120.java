/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg1.pkg20;

import java.util.Locale;
import java.util.Scanner;
import java.lang.Math;
/**
 *
 * @author Antimonius
 */
public class Actividad120 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    double num;
    double raiz;
   
    Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.US);
    
    System.out.print("Este programa calcula la raíz cuadrada del número real introducido por el usuario.\n");
    System.out.print("Introduzca un númro real: ");
    num = sc.nextDouble();
    
    raiz = Math.sqrt(num);
    
    System.out.println("El resultado de la raíz cuadrada de " + num + " es: " + raiz);
    
    }
    
}
//Autor: Derimán Tejera Fumero.
