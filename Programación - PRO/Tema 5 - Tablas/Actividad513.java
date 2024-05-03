/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg5.pkg13;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Derexe
 */
public class Actividad513 {

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

        int u[] = new int[t.length];

        u = Arrays.copyOf(t, t.length);

        Random aleatorio = new Random();

        for (int i = 0; i < u.length; i++) {
            int posAleatoria = aleatorio.nextInt(u.length);
            int temp = u[i];
            u[i] = u[posAleatoria];
            u[posAleatoria] = temp;
        }

        System.out.println("Array original (t): ");
        System.out.println(Arrays.toString(t));

        System.out.println("Array nuevo (u) desordenado: ");
        System.out.println(Arrays.toString(u));
    }

}
//Autor: Derimán Tejera Fumero.

/*
Modifica la Actividad de aplicación 5.12 para que la función no modifique la tabla que se pasa como parámetro y. en su lugar,
cree y devuelva una copia de la tabla donde se han desordenado los valores de los elementos.
 */
