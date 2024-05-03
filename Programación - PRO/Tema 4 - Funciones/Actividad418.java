/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg4.pkg18;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Antimonius
 */
public class Actividad418 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    int cantidad, maximo, minimo;
          
    Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.US);
        
    System.out.println("Este programa muestra una serie de números aleatorios entre los valores indicados por el usuario.");   
                       
        do{
            System.out.print("Introduce el número de números a mostrar: ");
            cantidad = sc.nextInt();
                if (cantidad<=0){
                System.out.println("El número no es válido, recuerda tiene que ser mayor que 0.");
                }
        }while(cantidad<=0);
        
        do{
            System.out.print("Introduce el valor mínimo: ");
            minimo = sc.nextInt();
                if (minimo<0){
                System.out.println("El número no es válido, recuerda tiene que ser mayor que 0.");
                }
        }while(minimo<0);
        
        do{
            System.out.print("Introduce el valor máximo: ");
            maximo = sc.nextInt();
                if (maximo<minimo){
                System.out.println("El número no es válido, recuerda tiene que ser mayor que el valor mínimo [" + minimo + "].");
                }
        }while(maximo<minimo);
        
        System.out.println("=================================================");
        numerosAleatorios(cantidad,minimo,maximo);
        System.out.println("=================================================");
        
    }
    
    static void numerosAleatorios(int cantidad, int minimo, int maximo){
        
        for(int i = 0; i <= cantidad ; i++){
            
            int numero = (int)(Math.random()*maximo+minimo);
            System.out.println("Valor [" + i + "]: " + numero);
            
        }              
    }
}
//Autor: Derimán Tejera Fumero.
