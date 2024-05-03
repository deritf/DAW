/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad11.pkg11;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Locale;

/**
 *
 * @author Usuario
 */
public class Actividad1111 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Introduce un valor: ");
        double valor = sc.nextDouble();
        sc.close();

        try {
            DataOutputStream dato = new DataOutputStream(new FileOutputStream("archivo.bin"));
            dato.writeDouble(valor);
            dato.close();
            System.out.println("El valor " + valor + " ha sido guardado en archivo.bin");
        } catch (IOException e) {
            System.err.println("Error al guardar el valor en archivo.bin: " + e.getMessage());
        }
    }
}
//Autor: Derimán Tejera Fumero.
/*
Pide un valor double por consola y guárdalo en un archivo binario.
 */
