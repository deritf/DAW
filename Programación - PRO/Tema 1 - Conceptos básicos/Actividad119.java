/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg1.pkg19;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Antimonius
 */
public class Actividad119 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int adulto;
    int nino;
    final double adultoPrecio = 20;
    final double ninoPrecio = 15.50;
    double Total;
    int descuento;
    double TotalDescuento;
    
   
    Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.US);
    
    System.out.print("Este programa calcula el coste total de entradas al parque acuático.\n");
    System.out.print("Introduce el número de entradas para adultos que desea comprar(20 euros): ");
    adulto = sc.nextInt();
    System.out.print("Introduce el número de entradas para niños que desea comprar(15.50 euros): ");
    nino = sc.nextInt();
    
    Total = adulto*adultoPrecio + nino*ninoPrecio;  
    System.out.println("El precio a pagar es: " + Total + " euros.");
    
    descuento = Total >= 100?5:0;
    
    TotalDescuento = (descuento*Total)/100;
    System.out.println("Si el importe supera los 100 euros, obtiene un descuento en el precio total de: " + TotalDescuento + " euros.");
    System.out.println("El precio a pagar es: " + (Total-TotalDescuento) + " euros.");
    
    }
    
}
//Autor: Derimán Tejera Fumero.
