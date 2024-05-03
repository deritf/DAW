/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg7.pkg18;

/**
 *
 * @author Usuario
 */
public class Actividad718 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      Cola c = new Cola(10);
      for (int i = 1; i <= 10; i++) {
         c.encola(i);
      }
      
      System.out.println("Primero: " + c.primero());
      System.out.println("Vacía: " + c.vacia());
      while(!c.vacia()) {
         System.out.println(c.desencola());
      }
    }
}
