/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad11.pkg13;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class Actividad1113 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DataInputStream dato = new DataInputStream(new FileInputStream("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Actividad11.13SUP\\tabla.bin"));

            int n = dato.readInt();
            double[] tabla = new double[n];

            for (int i = 0; i < n; i++) {
                tabla[i] = dato.readDouble();
            }

            dato.close();

            System.out.println("Tabla leída desde tabla.bin:");
            for (int i = 0; i < n; i++) {
                System.out.println(tabla[i]);
            }

        } catch (IOException e) {
            System.err.println("Error al leer la tabla desde tabla.bin: " + e.getMessage());
        }
    }
}
//Autor: Derimán Tejera Fumero.
/*
Escribe un programa que lea de un fichero binario una tabla de números double y después muestre el contenido de la tabla por consola.
 */
