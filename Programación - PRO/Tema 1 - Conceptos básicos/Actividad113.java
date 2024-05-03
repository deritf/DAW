/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg1.pkg13;

import java.util.Scanner;
/**
 *
 * @author Antimonius
 */
public class Actividad113 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    int n;
    int m;
    int x;
    int sumar;
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Este programa toma como entrada dos número entero e indica qué cantidad hay que sumarle al PRIMERO para que sea múltiplo del SEGUNDO.\n");
    System.out.print("Introduce un número entero: ");
    n = sc.nextInt();
    System.out.print("Introduce un número entero(múltiplo): ");
    m = sc.nextInt();
    
    x = n%m;
    sumar = m-x;
      
    System.out.println("Deber sumar " + sumar + " para que sea múltiplo de " + m);
    }
    
}

//Autor: Derimán Tejera Fumero.
