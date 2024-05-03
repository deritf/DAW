/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg3.pkg12;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Antimonius
 */
public class Actividad312 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    
    long numUsuario;
    long numTratado;
    int cifra = 0;
    long unidad;
    long suma = 0;
    
    Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.US);
    
    System.out.print("Este programa convierte un número binario dado por el usuario a decimal.\n");
    System.out.print("Nota: El mayor número representable es el límite de cifra soportado por el tipo de dato LONG.\n");
    System.out.print("Introduce el número binario para convertirlo: ");
    numUsuario = sc.nextLong();
    
    
    numTratado = numUsuario;
    
    //Este bucle calcula el número de cifras.
    while(numTratado > 0){
               
        numTratado = numTratado/10;         
        cifra++;            
    }
    
    System.out.print("El número introducido por el usuario tiene: " + cifra + " cifras (el límite son 19).\n");
    
    
    unidad = numUsuario;    
    long divisor = 10;
    long divisor2 = 1;
    int potencia = 1;
    
    int repeticion = 0;
    
    for(;cifra > 0; cifra--){
                                             
        unidad = (numUsuario % divisor)/divisor2;
                                        
        suma = suma + (unidad * potencia);
        potencia = potencia * 2;
        
        divisor = divisor * 10;
        divisor2 = divisor2 * 10;
        
        repeticion++;
                    
    }
    
    System.out.print("=====================================\n"); 
    System.out.print("El número en decimal es: " + suma + "\n");
    System.out.print("=====================================\n"); 
    
    }
    
}
//Autor: Derimán Tejera Fumero.

