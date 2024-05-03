/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg4.pkg16;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Antimonius
 */
public class Actividad416 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    int num;   
        
    Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.US);
        
    System.out.print("Este programa muestra todos los divisores primos del número indicado por el usuario.\n");   
                       
        do{
            System.out.print("Introduce el número: ");
            num = sc.nextInt();
                if (num<=0){
                System.out.print("El número no es válido, recuerda tiene que ser mayor que 0.\n");
                }
        }while(num<=0);
        
        divisoresPrimos(num);
        
        
        
    }

    static void divisoresPrimos(int num){
    
    int totalPrimos = 0;    
        
        for(int i = 1; i<=num ; i++){

               int contador = 0;

               for(int j = 1; j<=i ;j++){

                   if(i%j==0){
                       contador++;                  
                   }
               }

                if(contador<=2){
                System.out.println(i);
                totalPrimos++;
                }                        
        }    
    }
}
//Autor: Derimán Tejera Fumero.
