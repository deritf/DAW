/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg3.pkg14;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Antimonius
 */
public class Actividad314 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    int num;
    int totalPrimos = 0;
        
    Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.US);
        
    System.out.print("Este programa calcula los número primos entre el 1 y el número indicado por el usuario.\n");   
                       
        do{
            System.out.print("Introduce hasta que número deseas calcular: ");
            num = sc.nextInt();
                if (num<=0){
                System.out.print("El número no es válido, recuerda tiene que ser mayor que 0.\n");
                }
        }while(num<=0);
              
        for(int i = 1; i<=num ; i++){
           
           int contador = 0;
           
           for(int j = 1; j<=i ;j++){
               
               if(i%j==0){
                   contador++;                  
               }
           }
            
            if(contador<=2){
            System.out.print( i + " -> primo.\n");
            totalPrimos++;
            }
            else{
            System.out.print( i + " -> no primo.\n");  
            }            
        }
        
        System.out.print("========================================================\n");
        System.out.print("Resultan un total de " + totalPrimos + " números primos.\n");
        
    }
    
}
//Autor: Derimán Tejera Fumero.

