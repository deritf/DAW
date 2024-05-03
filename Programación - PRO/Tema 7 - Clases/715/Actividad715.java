/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg7.pkg15;

/**
 *
 * @author Usuario
 */
public class Actividad715 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
      Calendario c = new Calendario(31, 12, 2021);
      c.mostrar();
      c.incrementarDia();
      c.mostrar();
      c.incrementaMes();
      c.mostrar();
      
      Calendario a = new Calendario(1, 2, 2022);
      System.out.println("Iguales: " + c.iguales(a));
    }   
}
