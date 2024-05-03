/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg2.pkg19;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Antimonius
 */
public class Actividad219 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        double angulo;
        double radianes = 0;
        final double pi = 3.141592;
        double x;

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        System.out.print("Este programa pide el valor de un ángulo y devuelve su equivalente en radianes.\n");
        System.out.print("Introduce el valor del ángulo(º): ");
        angulo = sc.nextDouble();

        if(angulo>=0 && angulo<=360){       
            radianes = (angulo*pi)/180;          
        }
        else if(angulo>360){
            angulo = (angulo%360);
            radianes = (angulo*pi)/180;                  
        }
        else if(angulo<0){
            angulo = 360 + angulo;
            radianes = (angulo*pi)/180; 
        }

        System.out.print("El resultado son: " + radianes + " radianes.\n");
    
    
    }
    
}

//Autor: Derimán Tejera Fumero.