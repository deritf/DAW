/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg7.pkg12;

/**
 *
 * @author Usuario
 */
public class Actividad712 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Ecuacion2Grado ec = new Ecuacion2Grado(1, -3, 2);
      System.out.println(ec.esPositivoDiscriminante());
      double soluciones[] = ec.solucion();
      System.out.println("x1: " + soluciones[0]);
      System.out.println("x2: " + soluciones[1]);
      
      ec.setB(1);
      System.out.println("x1: " + ec.solucion()[0]);
   }
}

