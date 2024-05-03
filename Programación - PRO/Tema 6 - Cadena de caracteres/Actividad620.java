/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg6.pkg20;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Actividad620 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fraseString;
        
        String inicioComentario = " ";

        System.out.print("Introduzca una frase para ordenar sus palabas alfabéticamente: ");
        fraseString = sc.nextLine();
        
        String[] palabrasSeparadas = fraseString.split(" ");
        Arrays.sort(palabrasSeparadas);

        System.out.println(Arrays.deepToString(palabrasSeparadas));

    }   
}
//Autor: Derimán Tejera Fumero.
