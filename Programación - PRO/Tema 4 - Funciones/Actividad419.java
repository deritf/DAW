/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg4.pkg19;

import java.util.Locale;
import java.util.Scanner;
import java.text.DecimalFormat;

/**
 *
 * @author Antimonius
 */
public class Actividad419 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    double maximo = 1, minimo = 0;
    int cantidad =0;
    
    Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.US);
        
    System.out.println("Este programa muestra una serie de números reales aleatorios entre " + minimo + " y " + maximo);   
                       
        do{
            System.out.print("Introduce el número de números a mostrar: ");
            cantidad = sc.nextInt();
                if (cantidad<=0){
                System.out.println("El número no es válido, recuerda tiene que ser mayor que 0 y entero.");
                }
        }while(cantidad<=0);

        System.out.println("=================================================");
        numerosAleatorios(cantidad);
        System.out.println("=================================================");    
    }
    
    static void numerosAleatorios(int cantidad){
        
        for(int i = 0; i <= cantidad ; i++){
            
            double numero = (double)(Math.random()*1+0);
            
            String pattern = "#.##";
            DecimalFormat decimalFormat = new DecimalFormat(pattern);
            String formattedDouble = decimalFormat.format(numero);             
            System.out.println("Valor [" + i + "]: " + formattedDouble);            
        } 
    }  
}
//Autor: Derimán Tejera Fumero.