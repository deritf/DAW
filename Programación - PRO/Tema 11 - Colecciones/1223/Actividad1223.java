/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg12.pkg23;

import java.util.Scanner;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 *
 * @author Usuario
 */
public class Actividad1223 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> nombres = new LinkedHashSet<>();

        System.out.println("Este programa permite insertar una serie de nombres, los que el usuario quiera, luego mostrará por pantalla una lista de todos los nombres introducidos sin repeticiones y por orden alfabético. ");
        System.out.println("Recuerda: Introduce 'fin' para finalizar la entrada de nombres.");
        System.out.println("Introduce los nombres:");
        String nombre = sc.nextLine();
        while (!nombre.equals("fin")) {
            nombres.add(nombre);
            nombre = sc.nextLine();
        }

        List<String> nombresOrdenados = new ArrayList<>(nombres);
        Collections.sort(nombresOrdenados);

        System.out.println("");
        System.out.println("-----------------------------");
        System.out.println("Los nombres introducidos son: ");
        System.out.println("");
        for (String n : nombresOrdenados) {
            System.out.println(n);
        }
    }

}
//Autor: Derimán Tejera Fumero.
/*
Repite la Actividad de aplicación 12.22 de forma que se inserten los nombres manteniendo el orden alfabético.
 */
