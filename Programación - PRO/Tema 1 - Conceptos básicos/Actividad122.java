/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg1.pkg22;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Antimonius
 */
public class Actividad122 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    double metros;
     
    Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.US);
    
    System.out.print("Este programa calcula la distancia permitida en el ranking de FILA.\n");
    System.out.print("Introduzca la distancia de su lanzamiento en metros: ");
    metros = sc.nextDouble();
    
    metros = metros*100;
    
    double i_metros = (int) metros;
    double f_metros = metros - i_metros;
    
    System.out.println("Su resultado en el ranking es de: " + i_metros + " centímetros.");
    
    }
    
}
//Autor: Derimán Tejera Fumero.
