/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg3.pkg16;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Antimonius
 */
public class Actividad316 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        
    int filas;
    int numero = 0;
        
    Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.US);
        
    System.out.print("Este programa dibuja un triángulo con * con el número de filas indicadas por el usuario.\n");   
                       
        do{
            System.out.print("Introduce el número de filas que deseas: ");
            filas = sc.nextInt();
                if (filas<=0){
                System.out.print("El número no es válido, recuerda tiene que ser mayor que 0.\n");
                }
        }while(filas<=0);
        
        
        for(int i = 0; i<filas ;i++){
        
            for (int j = filas; j > i; j--){
                System.out.print(" ");
            } 
                                                                          
            for(int k = 0; k<=i ; k++){
                               
                System.out.print("* ");
                                
            }
            System.out.print("\n");
            
            
        }    
        
        
    }
    
}
//Autor: Derimán Tejera Fumero.

