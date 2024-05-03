/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg6.pkg16;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Actividad616 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        
      Scanner sc = new Scanner(System.in);
      String frase;     
      
      System.out.print("Introduzca una frase: ");
      frase = sc.nextLine();
      
      frase = frase.replace('a', '@');
      frase = frase.replace('e', '€');
      frase = frase.replace('i', '1');
      frase = frase.replace('o', '0');
      frase = frase.replace('u', 'v');
      
      System.out.println(frase);
        
    }
    
}
//Autor: Derimán Tejera Fumero.

