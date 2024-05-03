/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg7.pkg16;

/**
 *
 * @author Usuario
 */
public class Actividad716 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      Punto p1 = new Punto(1, 4);
      p1.desplazaX(1);
      p1.desplazaY(-2);
      p1.muestra();
      Punto p2 = new Punto(3, 3);

      System.out.println("Distancia: " + p1.distanciaEuclidea(p2));
    }
}
//Autor: Derimán Tejera Fumero.
