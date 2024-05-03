/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad11.pkg12;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class Actividad1112 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DataInputStream dato = new DataInputStream(new FileInputStream("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Actividad11.11\\archivo.bin"));
            double valor = dato.readDouble();
            dato.close();
            System.out.println("El valor leído desde archivo.bin es: " + valor);
        } catch (IOException e) {
            System.err.println("Error al leer el valor desde archivo.bin: " + e.getMessage());
        }
    }
}
//Autor: Derimán Tejera Fumero.
/*
Abre el fichero de la Actividad de aplicación 11.11. lee el valor double contenido en él y muéstralo por pantalla.
 */
