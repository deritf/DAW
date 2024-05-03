/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg6.pkg17;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Actividad617 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  
        Scanner sc = new Scanner(System.in);
        String palabra;
        int tamano;

        System.out.print("Introduzca una palabra para descomponer: ");
        palabra = sc.nextLine();

        System.out.print("Introduzca tamaño para descomponer: ");
        tamano = sc.nextInt();  

        dividirPalabra(palabra, tamano);  
    }
    
    public static void dividirPalabra(String palabra, int tamano){
        int length = (int) Math.ceil(palabra.length() / tamano);
        String[] secuencia = new String[length+1];
        int x = 0;
        
        for (int i = 0; i < palabra.length(); i += tamano) {
            secuencia[x] = (palabra.substring(i, Math.min(palabra.length(), i + tamano)));
            x++;
        }
        
        for (int u = 0; u < secuencia.length; u++){
            System.out.println(secuencia[u]);
        } 
    }
    
}
//Autor: Derimán Tejera Fumero.

