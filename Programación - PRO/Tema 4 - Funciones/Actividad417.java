/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg4.pkg17;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Antimonius
 */
public class Actividad417 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    int a, b;
         
    Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.US);
        
    System.out.println("Este programa indica si los dos números introducidos por el usuario son amigos.");   
                       
        do{
            System.out.print("Introduce el número 1: ");
            a = sc.nextInt();
                if (a<=0){
                System.out.print("El número no es válido, recuerda tiene que ser mayor que 0.\n");
                }
        }while(a<=0);
        
        do{
            System.out.print("Introduce el número 2: ");
            b = sc.nextInt();
                if (b<=0){
                System.out.print("El número no es válido, recuerda tiene que ser mayor que 0.\n");
                }
        }while(b<=0);
        
        numerosAmigos(a,b);

    }
    
    static void numerosAmigos(int a, int b){
        int resultadoA = 0;
        int resultadoB = 0;
        
        for(int i = 1; i < a ; i++){
            
            if(a%i==0){            
            resultadoA = resultadoA + i;                       
            }   
        }
        
        for(int i = 1; i < b ; i++){
            
            if(b%i==0){            
            resultadoB = resultadoB + i;            
            }   
        }
        
        if(resultadoA == b){
        System.out.println("¡Genial! " + a + " y " + b + " son números amigos.");
        }
        else{
        System.out.println("¡Oh no! " + a + " y " + b + " no son números amigos.");    
        }
    }
}
//Autor: Derimán Tejera Fumero.
