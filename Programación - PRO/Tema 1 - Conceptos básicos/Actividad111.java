/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg1.pkg11;

import java.util.Scanner;
import java.util.Locale;

/**
 *
 * @author Antimonius
 */
public class Actividad111 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      double iva;    
      double precio;
      double precioConIva;
      double precioTotal;
      
      Scanner sc = new Scanner(System.in);
      sc.useLocale(Locale.US);
      
      System.out.print("Este programa calcula el IVA aplicable a un precio, por favor, recuerde usar punto (.) si introduce números decimales.\n");
      System.out.print("Introduce el precio (base imponible) aquí: ");
      precio = sc.nextDouble();
      System.out.print("Introduce el IVA(%): ");
      iva = sc.nextDouble();
      
      precioConIva = (iva*precio)/100;
      precioTotal = precioConIva + precio;
      
      System.out.println("El importe del IVA es: " + precioConIva + " euros.");
      System.out.println("El importe total es: " + precioTotal + " euros.");
    }
    
}

//Autor: Derimán Tejera Fumero.
