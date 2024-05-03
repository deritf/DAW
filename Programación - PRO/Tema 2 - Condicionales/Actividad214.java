/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg2.pkg14;

import java.util.Scanner;

/**
 *
 * @author Antimonius
 */
public class Actividad214 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    int num;
    int unidad;
    int decena;

    Scanner sc = new Scanner(System.in);
    
    System.out.println("Este programa solicita un número comprendido entre 1 y 99 y lo devuelve escrito en letras.");       
    System.out.print("Introduzca el número: ");
    num = sc.nextInt(); 
    
    unidad = (num % 10);      
    decena = (num % 100) / 10;
    
    
    if(num<1 || num>99) {        
        System.out.println("El número elegido no está entre 1 y 99, inténtelo de nuevo.");
        System.exit(0);  
    }
      
                          
    if(num>=1 && num<=15) {

        switch (num){
         case 1:
             System.out.print("Uno.\n");    
             break;

         case 2:
             System.out.print("Dos.\n");    
             break;

         case 3:
             System.out.print("Tres.\n");    
             break;

         case 4:
             System.out.print("Cuatro.\n");    
             break;

         case 5:
             System.out.print("Cinco.\n");    
             break;

         case 6:
             System.out.print("Seis.\n");    
             break;

         case 7:
             System.out.print("Siete.\n");    
             break;

         case 8:
             System.out.print("Ocho.\n");    
             break;

         case 9:
             System.out.print("Nueve.\n");    
             break;

         /* No uso esta porque ya hay una condición para los terminados en 0 mas abajo.
         case 11:
         System.out.print("Nueve.");    
         break;
         */

         case 11:
             System.out.print("Once.\n");    
             break; 

         case 12:
             System.out.print("Doce.\n");    
             break;    

         case 13:
             System.out.print("Trece.\n");    
             break;    

         case 14:
             System.out.print("Catorce.\n");    
             break;

         case 15:
             System.out.print("Quince.\n");    
             break;    

         }

    } 


    if (num>=16 && num<=19 ||
        num>=21 && num<=29 || 
        num>=31 && num<=39 ||
        num>=41 && num<=49 ||
        num>=51 && num<=59 ||    
        num>=61 && num<=69 ||
        num>=71 && num<=79 ||
        num>=81 && num<=89 ||
        num>=91 && num<=99){

    switch (decena){
         case 1:
             System.out.print("Dieci");    
             break;

         case 2:
             System.out.print("Veinti");    
             break;

         case 3:
             System.out.print("Treinta y ");    
             break;

         case 4:
             System.out.print("Cuarenta y ");    
             break;

         case 5:
             System.out.print("Cincuenta y ");    
             break;

         case 6:
             System.out.print("Sesenta y ");    
             break;

         case 7:
             System.out.print("Setenta y ");    
             break;

         case 8:
             System.out.print("Ochenta y ");    
             break;

         case 9:
             System.out.print("Noventa y ");    
             break;                                       
         } 



    switch (unidad){
         case 1:
             System.out.print("uno.\n");    
             break;

         case 2:
             System.out.print("dos.\n");    
             break;

         case 3:
             System.out.print("tres.\n");    
             break;

         case 4:
             System.out.print("cuatro.\n");    
             break;

         case 5:
             System.out.print("cinco.\n");    
             break;

         case 6:
             System.out.print("seis.\n");    
             break;

         case 7:
             System.out.print("siete.\n");    
             break;

         case 8:
             System.out.print("ocho.\n");    
             break;

         case 9:
             System.out.print("nueve.\n");    
             break;

         }        
 }



 if (unidad==0){

    switch (decena){
         case 1:
             System.out.print("Diez.\n");    
             break;

         case 2:
             System.out.print("Veinte.\n");    
             break;

         case 3:
             System.out.print("Treinta.\n");    
             break;

         case 4:
             System.out.print("Cuarenta.\n");    
             break;

         case 5:
             System.out.print("Cincuenta.\n");    
             break;

         case 6:
             System.out.print("Sesenta.\n");    
             break;

         case 7:
             System.out.print("Setenta.\n");    
             break;

         case 8:
             System.out.print("Ochenta.\n");    
             break;

         case 9:
             System.out.print("Noventa.\n");    
             break;                                      
         }
 }




}

}

//Autor: Derimán Tejera Fumero.
