/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad11.pkg15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Usuario
 */
public class Actividad1115 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (BufferedReader leerNumeros = new BufferedReader(new FileReader("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Actividad11.15SUP\\numeros.dat")); PrintWriter pares = new PrintWriter(new FileWriter("pares.dat")); PrintWriter impares = new PrintWriter(new FileWriter("impares.dat"))) {

            String linea;
            while ((linea = leerNumeros.readLine()) != null) {
                int num = Integer.parseInt(linea.trim());
                if (num % 2 == 0) {
                    pares.println(num);
                } else {
                    impares.println(num);
                }
            }
            System.out.println("Números escritos en los archivos pares.dat e impares.dat.");
        } catch (IOException e) {
            System.err.println("Error al leer o escribir archivo: " + e.getMessage());
        }
    }

}
//Autor: Derimán Tejera Fumero.
/*
Implemento un programa que lea números enteros desde el fichero numeros.dat y los vaya guardando en los ficheros par.dat e impar.dat, según su paridad.
 */
