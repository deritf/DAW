/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg1.pkg16;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Antimonius
 */
public class Actividad116 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    double seg;
    double minTotal;
    double horaTotal;
    double segTotal;
   
    Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.US);
    
    System.out.print("Este programa calcula cuántas horas, minutos y segundos hay en la cifra de segundos que introduzca el usuario.\n");
    System.out.print("Introduce el número de segundos: ");
    seg = sc.nextDouble();
    
    horaTotal = seg/3600;
    
    double i_horaTotal = (int) horaTotal;
    double f_horaTotal = horaTotal - i_horaTotal;
    
    minTotal = f_horaTotal*60;
    
    double i_minTotal = (int) minTotal;
    double f_minTotal = minTotal - i_minTotal;
       
    segTotal = seg - ((i_horaTotal*3600)+(i_minTotal*60));
                         
    System.out.println("Son " + i_horaTotal + " hora(s)" + i_minTotal + " minuto(s) y " + segTotal + " segundo(s).");      
    }   
}
//Autor: Derimán Tejera Fumero.
