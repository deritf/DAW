/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg6.pkg18;

import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author Usuario
 */
public class Actividad618 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        String fraseString;
        
        String inicioComentario = " ";

        System.out.print("Introduzca una frase separada por espacios para convertir en nomenclatura Camel Case: ");
        fraseString = sc.nextLine();
        
        fraseString = fraseString.toLowerCase();
        
        String[] fraseSeparada = fraseString.split(" ");
        
        System.out.println(Arrays.deepToString(fraseSeparada));
        
        
        

        String fraseFinal = fraseSeparada[0];
        
        char aMayuscula;
        
        for(int i = 1; i < fraseSeparada.length; i++){
             
       
            aMayuscula = Character.toUpperCase(fraseSeparada[i].charAt(0));
            
            fraseFinal = fraseFinal + (aMayuscula + fraseSeparada[i].substring(1));
        }
        
        System.out.println(fraseFinal);
    } 
    
}
//Autor: Derimán Tejera Fumero.
