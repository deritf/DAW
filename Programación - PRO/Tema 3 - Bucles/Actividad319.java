/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg3.pkg19;

import java.util.Locale;
import java.util.Scanner;
/**
 *
 * @author Antimonius
 */
public class Actividad319 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        double raiz;
        double numero = 1;
        int iext = 1;
        
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        
        System.out.print("Este programa calcula la raíz cuadrada mediante aproximación.\n");   
                       
        do{
            System.out.print("Introduce el valor de la raíz que quires calcular: ");
            raiz = sc.nextDouble();
                if (raiz < 0){
                System.out.print("El número no es válido, recuerda tiene que ser mayor que 0.\n");
                }
        } while (raiz < 0);
        
        
        for(int i = 1; numero < raiz ;i++){
        System.out.println("Iteración número: [" + i + "].");    
        numero = i * i;    
        System.out.println(i + " * " + i + " : " + numero);  
        iext = i;
            
        }
        
        if (numero > raiz){
            iext--;
            numero = iext*iext;
        }
        System.out.println("===================================================="); 
        System.out.println("Se ha escogido por aproximación: " + iext + " * " + iext + " cuyo resultado es: " + numero); 
        System.out.println("El resto es: (" + raiz + "-" + numero + ") = " + (raiz - numero) );   
        
    }
    
}
//Autor: Derimán Tejera Fumero.

