/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg1.pkg12;

import java.util.Scanner;
/**
 *
 * @author Antimonius
 */
public class Actividad112 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    int num;
    int sumar;
    int x;
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Este programa toma como entrada un número entero e indica qué cantidad hay que sumarle para que el resultado sea múltiplo de 7.\n");
    System.out.print("Introduce un número entero: ");
    num = sc.nextInt();
    
    x = num%7;
    sumar = 7-x;
    

    
    System.out.println("Deber sumar " + sumar + " para que sea múltiplo de 7.");
    
    }
    
}

//Autor: Derimán Tejera Fumero.

