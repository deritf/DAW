/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg7.pkg13;

import java.util.Arrays;
/**
 *
 * @author Usuario
 */
public class Actividad713 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

      Colores colores = new Colores(); 
      colores.addColor("Marrón");
      colores.addColor("Azul");
      colores.addColor("Amarillo");
      colores.addColor("Celeste");
      colores.addColor("Rosa");
      colores.addColor("ColorPrueba1");
      colores.addColor("ColorPrueba2");
      
      System.out.println(Arrays.toString(colores.seleccionColores(20)));        
    }
}

