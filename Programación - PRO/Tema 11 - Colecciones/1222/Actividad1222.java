/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg12.pkg22;

/**
 *
 * @author Usuario
 */
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Actividad1222 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> nombres = new HashSet<>();
        String nombre;
        System.out.println("Este programa permite insertar una serie de nombres, los que el usuario quiera, luego mostrará por pantalla una lista de todos los nombres introducidos sin repeticiones. ");
        System.out.println("Recuerda: Introduce 'fin' para finalizar la entrada de nombres.");
        System.out.println("Introduce los nombres:");
        do {
            nombre = sc.nextLine();
            if (!nombre.equalsIgnoreCase("fin")) {
                nombres.add(nombre);
            }
        } while (!nombre.equalsIgnoreCase("fin"));
        System.out.println("");
        System.out.println("-----------------------------");
        System.out.println("Los nombres introducidos son: ");
        System.out.println("");
        for (String n : nombres) {
            System.out.println(n);
        }
    }
}

//Autor: Derimán Tejera Fumero.
/*
Introduce por teclado, hasta que se introduzca "fin", una serie de nombres, que se insertarán
en una colección, de forma que se conserve el orden de inserción y que no puedan repetirse.
Al final, la colección se mostrará por pantalla.
 */
