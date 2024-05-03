/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg1.pkg17;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Antimonius
 */
public class Actividad117 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    double mili;
    double centi;
    double metros;
    double Total;
    
    
   
    Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.US);
    
    System.out.print("Este programa calcula la suma total de varias unidades y da el resultado total en centímetros.\n");
    System.out.print("Introduce el número de milímetros: ");
    mili = sc.nextDouble();
    System.out.print("Introduce el número de centímetros: ");
    centi = sc.nextDouble();
    System.out.print("Introduce el número de metros: ");
    metros = sc.nextDouble();
    
    
    double i_centi = (int) centi;
    double f_centi = centi - i_centi;
    
  
    System.out.println("---------------------------------");
    System.out.println(mili + " milímetros son " + mili/10 + " centímetros.");
    System.out.println(centi + " centímetros son " + i_centi + " centímetros y " + f_centi*10 + " centrímetros (los decimales).");
    System.out.println(metros + " Son " + metros*100 + " centímetros.");
    System.out.println("---------------------------------");
    
    Total = (mili/10) + i_centi + (metros*100) + (f_centi*10);
    System.out.println("Son " + Total + " centímetros en total.");
    
    
    }
    
}
//Autor: Derimán Tejera Fumero.


