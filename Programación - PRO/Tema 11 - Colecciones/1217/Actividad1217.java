/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg12.pkg17;

/**
 *
 * @author Usuario
 */
public class Actividad1217 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cola<Integer> c = new Cola<>();
        for (int i = 0; i < 10; i++) {
            c.encolar(i);
        }

        Integer num = c.desencolar();
        while (num != null) {
            System.out.println(num);
            num = c.desencolar();
        }
    }
}

//Autor: Derimán Tejera Fumero
/*
Implementa la clase "Cola" genérica utilizando un objeto ArrayList para guardar los elementos.
 */
