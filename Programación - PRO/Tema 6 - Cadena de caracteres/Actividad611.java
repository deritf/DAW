/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg6.pkg11;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Actividad611 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        final char conjunto1[] = {'e', 'i', 'k', 'm', 'p', 'q', 'r', 's', 't', 'u', 'v'};
        final char conjunto2[] = {'p', 'v', 'i', 'u', 'm', 't', 'e', 'r', 'k', 'q', 's'};      
        String texto;
        char decodificado[];
        
        System.out.println("Este programa hace entendible un texto encriptado según el programa de las actividades resueltas 6.11.");
              
        System.out.println("Introduzca el texto a desencriptar: ");
        texto = sc.nextLine();
        texto = texto.toLowerCase();
        
        decodificado = new char[texto.length()];
        for (int i = 0; i < texto.length(); i++) { 
             decodificado[i] = decodifica(conjunto1, conjunto2, texto.charAt(i));
        }
        
        texto = String.valueOf(decodificado);            
        texto = PrimeraLetraEnMayuscula(texto);
        
        System.out.println(texto);
    }
       
    static char decodifica(char conjunto1[], char conjunto2[], char c) {
      final String conj1 = String.valueOf(conjunto2); 
      char decodificado; 
      int pos = conj1.indexOf(c); 
      if (pos == -1) { 
         decodificado = c; 
      } else {
         decodificado = conjunto1[pos]; 
      }
      return decodificado;
    }
    
    static String PrimeraLetraEnMayuscula(String texto) {
    if (texto == null || texto.isEmpty()) {
        return texto;
        } else {       
            return  texto.toUpperCase().charAt(0) + texto.substring(1, texto.length()).toLowerCase();
        }
    }
    
}
//Autor: Derimán Tejera Fumero.
