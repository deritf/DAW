/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad10.pkg15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class Actividad1015 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String fichero = "numeros.txt";
        int numeroMenor = Integer.MAX_VALUE;
        int numeroMayor = Integer.MIN_VALUE;

        try {
            System.out.println("Este programa muertra el menor y el mayor de los números contenidos en el fichero numeros.txt.");

            BufferedReader lector = new BufferedReader(new FileReader(fichero));
            String linea;
            while ((linea = lector.readLine()) != null) {
                int numero = Integer.parseInt(linea.trim());
                if (numero < numeroMenor) {
                    numeroMenor = numero;
                }
                if (numero > numeroMayor) {
                    numeroMayor = numero;
                }
            }
            lector.close();
            System.out.println("El menor número del fichero es: " + numeroMenor);
            System.out.println("El mayor número del fichero es: " + numeroMayor);
        } catch (IOException e) {
            System.out.println("Error al leer el fichero " + fichero + ": " + e.getMessage());
        }
    }
}
//Autor: Derimán Tejera Fumero.
/*
En el archivo números, txt disponemos de uia serie de números (uno por cada línea).
Diseria un programa que procese el fichero y nos muestre el menor y el mayor.
 */
