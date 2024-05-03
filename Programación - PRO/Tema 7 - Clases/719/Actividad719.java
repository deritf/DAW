/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg7.pkg19;

/**
 *
 * @author Usuario
 */
public class Actividad719 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Pila p = new Pila();
      for (int i = 1; i <= 10; i++) {
         p.apila(i);
      }
      
      System.out.println("Cima: " + p.cima());
      while(!p.vacia()) {
         System.out.println(p.desapila());
      }
   }
}
    

