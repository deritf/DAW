/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg4.pkg13;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Antimonius
 */
public class Actividad413 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.US);    
        
    int n;    
        
        System.out.println("Este programa muestra los números pares hasta el número indicado por el usuario.");   
                             
        System.out.print("Hasta que número deseas calcular: ");
        n = sc.nextInt();
      
        System.out.println("Los número pares hasta el " + n + " son: ");    
            
        muestraPares(n);             
    }
    
    static void muestraPares (int n){  
        for (int i = 1 ; i <= n ; i++){
           
            if (i%2==0){
            System.out.println(i);    
            } 
        }      
    }
}
//Autor: Derimán Tejera Fumero.

