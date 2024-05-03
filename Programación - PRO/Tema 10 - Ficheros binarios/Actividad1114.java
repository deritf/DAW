/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad11.pkg14;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Actividad1114 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce una frase: ");
        String frase = scanner.nextLine();

        try (DataOutputStream dato = new DataOutputStream(new FileOutputStream("frase.bin"))) {
            dato.writeUTF(frase);
            System.out.println("Frase guardada en frase.bin");
        } catch (IOException e) {
            System.err.println("Error al escribir la frase en frase.bin: " + e.getMessage());
        }

        try (DataInputStream dato = new DataInputStream(new FileInputStream("frase.bin"))) {
            String fraseRecuperada = dato.readUTF();
            System.out.println("Frase recuperada: " + fraseRecuperada);
        } catch (IOException e) {
            System.err.println("Error al leer la frase de frase.bin: " + e.getMessage());
        }
    }
}
//Autor: Derimán Tejera Fumero.
/*
Introduce por teclado una frase y guárdala en un archivo binario. A continuación, recupérala y muéstrala por pantalla.
 */
