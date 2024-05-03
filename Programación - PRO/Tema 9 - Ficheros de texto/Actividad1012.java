/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad10.pkg12;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Actividad1012 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Este programa guarda un nombre y una edad introducidas por el usuario en un fichero datos.txt.");
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre: ");
        String nombre;
        nombre = sc.nextLine();
        System.out.print("Edad: ");
        String edad;
        edad = sc.nextLine();
        System.out.println("=====================================");

        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter("datos.txt", true));

            out.write(nombre, 0, nombre.length());
            out.write(" ");
            out.write(edad, 0, edad.length());
            out.newLine();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Ha ocurrido un error.");

        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }
    }
}
//Autor: Derimán Tejera Fumero
/*
Diseria una aplicación que pida al usuario su nombre y edad. Estos datos deben guardarse en el fichero datos.txt
Si este fichero existe, deben añadirse al final en una nueva linea, y en caso de no existir, debe crearse.
 */
