/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg7.pkg11;

import java.util.Scanner;
/**
 *
 * @author Usuario
 */
public class Actividad711 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Marcapagina marca;
      marca = new Marcapagina();
      marca.siguientePag();
      marca.siguientePag();
      marca.siguientePag();
      System.out.println("Última página: " + marca.ultimaPaginaLeida());
      marca.comenzar();
      System.out.println("Última página: " + marca.ultimaPaginaLeida());
   }   
}
