/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg3.pkg11;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Antimonius
 */
public class Actividad311 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    int num;  
    int bin;   
    
    Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.US);
    
    System.out.print("Este programa convierte un número decimal dado por el usuario a binario.\n");
    System.out.print("Introduce el número decimal para convertirlo: ");
    num = sc.nextInt();
        
    while(num>0){
                
    bin = num%2;
    System.out.print(bin + "\n");
    num = num/2;
    
    }    
    
    System.out.print("Conversion concluida.\n");
    System.out.print("NOTA: Recuerda que el resultado se lee de abajo para arriba.\n");
        
    }
    
}
//Autor: Derimán Tejera Fumero.

