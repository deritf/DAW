/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg5.pkg11;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Derexe
 */
public class Actividad511 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        System.out.println("Este programa permite buscar un número al usuario un número en una tabla y devuelve una nueva tabla con las posiciones en las que se encuentran.");

        System.out.println("¿Qué número desea buscar en la tabla?");
        int clave;
        clave = sc.nextInt();
        System.out.println("=====================================");

        int tamano = 100;
        int maximo = 10;
        int minimo = 0;

        int t[] = new int[tamano];

        generarTablaAleatoria(t, tamano, maximo, minimo);
        buscarTodos(t, clave);

    }

    static void generarTablaAleatoria(int t[], int tamano, int maximo, int minimo) {

        for (int i = 0; i < tamano; i++) {

            t[i] = (int) (Math.random() * maximo + minimo);
        }

        System.out.println("El contenido del array (t) generado aleatoriamente, de tamaño [" + t.length + "] es: ");
        System.out.println(Arrays.toString(t));

    }

    static void buscarTodos(int t[], int clave) {

        int u[] = new int[0];

        int x = 0;

        for (int i = 0; i < t.length; i++) {

            if (t[i] == clave) {
                u = Arrays.copyOf(u, u.length + 1);
                u[x] = i;

                x++;

            }

        }

        if (x == 0) {
            System.out.println("No se ha encontrado ninguna coincidencia. ");
        } else {
            System.out.println("Se han encontrado [" + u.length + "] coincidencias con el valor proporcionado, están localizadas en las posiciones: ");

        }
        System.out.println(Arrays.toString(u));

    }

}
//Autor: Derimán Tejera Fumero.

/*
Realiza la función: int [ ] buscarTodos {int t [], int clave), que crea y devuelve una tabla con todos los indices de los elementos
donde se encuentra la dave de búsqueda. En el caso de que clave no se encuentre en la tabla t, la función devolverá una tabla vacia.
 */
