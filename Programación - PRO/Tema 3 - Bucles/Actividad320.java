/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg3.pkg20;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Antimonius
 */
public class Actividad320 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    double Dinero;
    double DineroTotal = 0;
    int i = 1;
    double ValorAnterior;
              
    Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.US);
        
    System.out.print("Este programa calcula el total del dinero que posee el usuario.\n");   
                       
        do{
            System.out.print("Introduce el dinero [" + i + "] que tienes: ");
            Dinero = sc.nextDouble();
            
            if(Dinero >= 0){
                DineroTotal = DineroTotal + Dinero;
            }
            
            i++;
            
            if (Dinero < 0){
                System.out.print("El número no es válido, recuerda tiene que ser mayor que 0.\n");              
                i--;
            }
        } while (Dinero != 0);
        
        System.out.print("La suma total del dinero que tienes es: " + DineroTotal + " euros.\n");
    }
    
}
//Autor: Derimán Tejera Fumero.
