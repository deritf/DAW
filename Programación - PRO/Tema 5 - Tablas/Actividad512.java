/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg5.pkg12;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Derexe
 */
public class Actividad512 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int t[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Array con contenido ordenado: ");
        System.out.println(Arrays.toString(t));
        System.out.println("------------------------------");

        desordenar(t);

    }

    static void desordenar(int t[]) {

        Random aleatorio = new Random();

        for (int i = 0; i < t.length; i++) {
            int posAleatoria = aleatorio.nextInt(t.length);
            int temp = t[i];
            t[i] = t[posAleatoria];
            t[posAleatoria] = temp;
        }

        System.out.println("Array con contenido (DES)ordenado: ");
        System.out.println(Arrays.toString(t));
    }

}
//Autor: Derimán Tejera Fumero.

/*
Escribe la función void desordenar (int t[]), que cambia de forma aleatoria los elementos
contenidos en la tabla t. Si la tabla estuviera ordenada, dejaría de estarlo.
 */
