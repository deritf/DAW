/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg12.pkg18;

/**
 *
 * @author Usuario
 */
public class Actividad1218 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Pila<Integer> p = new Pila<>();
        for (int i = 0; i < 10; i++) {
            p.apilar(i);
        }

        Integer num = p.desapilar();
        while (num != null) {
            System.out.println(num);
            num = p.desapilar();
        }
    }

}
