/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg1.pkg18;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Antimonius
 */
public class Actividad118 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int horm;
    int aran;
    int coch;
    int Total;
    
   
    Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.US);
    
    System.out.print("Este calcula en número total de patas de diferentes invertebrados\n");
    System.out.print("Introduce el número de hormigas: ");
    horm = sc.nextInt();
    System.out.print("Introduce el número de arañas: ");
    aran = sc.nextInt();
    System.out.print("Introduce el número de cochinillas: ");
    coch = sc.nextInt();
    
    
    Total = horm*6 + aran*8 + coch*14;
         
    System.out.println("El número total de patas es: " + Total);
    }
    
}
//Autor: Derimán Tejera Fumero.
