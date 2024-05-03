/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg2.pkg17;

import java.util.Locale;
import java.util.Scanner;
import java.lang.Math;

/**
 *
 * @author Antimonius
 */
public class Actividad217 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    
    
    int aleatorio1;
    int aleatorio2;
    int sumaPC;
    int sumaUsu;
    
   
    Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.US);
    
    System.out.print("¡Bienvenido al juego de la suma!\n");
    System.out.print("Este programa genera dos números aleatorios (entre 1 y 99) que el usuario debe sumar.\n");
    
    aleatorio1 = (int)(Math.random()*99+1);
    aleatorio2 = (int)(Math.random()*99+1);
    
    System.out.print("Suma los valores: " + aleatorio1 + " y " + aleatorio2 + "\n");
    
    sumaPC = aleatorio1 + aleatorio2;
    
    System.out.print("Introduce el valor de la suma: ");
    sumaUsu = sc.nextInt();
    
    if(sumaUsu == sumaPC){
    System.out.print("¡Correcto!\n");    
    }
    else{
    System.out.print("¡Incorrecto!\n");    
    }
    
   
        
    }
    
}

//Autor: Derimán Tejera Fumero.
