/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg2.pkg11;

import java.util.Scanner;

/**
 *
 * @author Antimonius
 */
public class Actividad211 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    int num;
    int unidad;
    int decena;
    int centena;
    int unidadMillar;
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Escribe una aplicación que solicite al usuario un número comprendido entre 0 y 9999. La aplicación tendrá que indicar si el número introducido es capicúa.");       
    System.out.print("Introduzca el número: ");
    num = sc.nextInt(); 
    
    
    if (num>=0 && num<=9999){
    
        if (num>=0 && num<=9){
        System.out.println("El número [" + num + "] no es capicúa.");
        }
    
        if (num>=10 && num<=99){
        
            unidad = (num % 10);      
            decena = (num % 100) / 10;
            
            if (unidad == decena){
            System.out.println("El número [" + num + "] es capicúa.");     
            }
            else{
            System.out.println("El número [" + num + "] no es capicúa.");
            }
        }
        
        
        if (num>=100 && num<=999){
            
            unidad = (num % 10);             
            centena = (num / 100);
            
            if (unidad == centena){
            System.out.println("El número [" + num + "] es capicúa.");     
            }
            else{
            System.out.println("El número [" + num + "] no es capicúa.");
            }
        }
        
        if (num>=1000 && num<=9999){
            
            unidad = (num % 10);    
            decena = (num % 100) / 10;
            centena = (num % 1000) / 100;
            unidadMillar = (num /1000);
                 
            if (unidad == unidadMillar && decena == centena){
            System.out.println("El número [" + num + "] es capicúa.");     
            }
            else{
            System.out.println("El número [" + num + "] no es capicúa.");
            }
        }
        
                   
    }       
    else
    System.out.println("ERROR, el número introducido no es válido.");    
        
    }
    
}

//Autor: Derimán Tejera Fumero.