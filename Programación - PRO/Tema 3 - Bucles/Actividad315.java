/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg3.pkg15;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Antimonius
 */
public class Actividad315 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    int filas;
    
        
    Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.US);
        
    System.out.print("Este programa dibuja un triángulo de Pascal con el número de filas indicadas por el usuario.\n");   
                       
        do{
            System.out.print("Introduce el número de filas que deseas: ");
            filas = sc.nextInt();
                if (filas<=0){
                System.out.print("El número no es válido, recuerda tiene que ser mayor que 0.\n");
                }
        }while(filas<=0);
        
        
        for(int i = 0; i<filas ;i++){
                   
            int numero = 1;
            for(int k = 0; k<=i ; k++){
                
                
                System.out.print(numero + " ");
                numero = numero*(i-k)/(k+1);
                                                               
            }
            System.out.print("\n");                       
        }                     
}
}
//Autor: Derimán Tejera Fumero.

