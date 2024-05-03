/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg10.pkg11;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.io.BufferedReader;

/**
 *
 * @author Usuario
 */
public class Actividad1011 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        String texto = "";
        BufferedReader in = null;
        Scanner sc = new Scanner(System.in);

        System.out.println("Este programa permite acceder al contenido de un fichero de texto con el nombre dado por el usuario.");

        System.out.print("¿Cuál es el nombre del fichero que deseas abrir? (INCLUIR extensión): ");
        String nombreFichero;
        nombreFichero = sc.nextLine();
        System.out.println("=====================================");

        File archivo = new File(nombreFichero);

        if (archivo.exists()) {
            System.out.println("El archivo [" + nombreFichero + "] se ha encontrado con éxito.");
        } else if (nombreFichero == "") {
            nombreFichero = "prueba" + ".txt";
            System.out.println("No se ha proporcionado ningún nombre de archivo, se abrirá el archivo por defecto: " + nombreFichero);
        } else {
            System.out.println("No se ha encontrado ningún archivo con ese nombre.");
            System.out.println("Finalizando programa... ");
            System.exit(0);
        }

        try {
            in = new BufferedReader(new FileReader(nombreFichero));

            int c = in.read();
            while (c != -1) {
                texto = texto + (char) c;
                c = in.read();
            }
        } finally {
            in.close();
        }
        System.out.println(texto);
    }
}
//Autor: Derimán Tejera Fumero
/*
Escribe un programa que solicite al usuario el nombre de un fichero de texto y muestre su contenido en pantalla.
Si no se proporciona ningún nombre de fichero, la aplicación utilizará por defecto prueba, txt
 */
