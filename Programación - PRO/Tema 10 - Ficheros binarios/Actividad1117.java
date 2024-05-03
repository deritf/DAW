/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad1117;

import java.io.*;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Actividad1117 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Escribe el texto, línea a línea. (Si deseas terminar, deja una línea en blanco y pulsa Intro)");

        guardarTexto();

        try {
            FileInputStream fis = new FileInputStream("texto.bin");
            DataInputStream dis = new DataInputStream(fis);
            String linea;
            System.out.println("Mostrando contenido del archivo:");
            while (dis.available() > 0) {
                linea = dis.readUTF();
                System.out.println(linea);
            }
            dis.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
    }

    public static void guardarTexto() {
        try {
            FileOutputStream fos = new FileOutputStream("texto.bin");
            DataOutputStream dos = new DataOutputStream(fos);
            Scanner scanner = new Scanner(System.in);
            String linea;

            do {
                linea = scanner.nextLine();
                dos.writeUTF(linea);
            } while (!linea.isEmpty());
            dos.close();
            fos.close();
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error al guardar el texto en el archivo");
        }
    }
}

//Autor: Derimán Tejera Fumero.
/*
Escribe un texto, línea a línea, de forma que cada vez que se pulse Intro. se guarde la línea en un archivo binario.
El proceso se termina cuando introduzcamos una línea vacía. Después el programa lee el texto completo del archivo y
lo muestra por pantalla.
 */
