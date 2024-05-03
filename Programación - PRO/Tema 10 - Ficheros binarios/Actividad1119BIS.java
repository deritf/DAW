/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg1119bis;

import java.io.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Usuario
 */
public class Actividad1119BIS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int opcion;
        do {
            System.out.println("MENU DE OPCIONES");
            System.out.println("1. Añadir número de llamadas");
            System.out.println("2. Mostrar lista completa");
            System.out.println("3. Borrar contenido del archivo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                System.out.println("Error de entrada/salida");
                opcion = -1;
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida");
                opcion = -1;
            }
            switch (opcion) {
                case 1:
                    int numLlamadas = leerNumeroLlamadasDia("Introduce el número de la llamadas: ");
                    if (numLlamadas != -1) {
                        anadirNumero(numLlamadas);
                        System.out.println("Número de llamadas añadido correctamente al archivo.");
                        System.out.println("");
                        System.out.println("");
                    }
                    break;
                case 2:
                    mostrarLista();
                    break;
                case 3:
                    borrarDatosAlmacenados();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 0);
    }

    public static int leerNumeroLlamadasDia(String mensaje) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = -1;
        System.out.print(mensaje);
        try {
            num = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.out.println("Error de E/S.");
        } catch (NumberFormatException e) {
            System.out.println("Número no válido.");
        }
        return num;
    }

    public static void anadirNumero(int numLlamadas) {
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream("telefonos.bin", true));
            LocalDate fechaActual = LocalDate.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String fechaFormateada = fechaActual.format(formato);
            out.writeUTF(fechaFormateada);
            out.writeInt(numLlamadas);
            out.close();
        } catch (IOException e) {
            System.out.println("Error de E/S.");
        }
    }

    public static void mostrarLista() {
        try {
            System.out.println("");
            System.out.println("");
            System.out.println("Los números almacenados son: ");
            DataInputStream in = new DataInputStream(new FileInputStream("telefonos.bin"));
            while (in.available() > 0) {
                String fecha = in.readUTF();
                int numLlamadas = in.readInt();
                System.out.println(fecha + " - " + numLlamadas);
            }
            in.close();
            System.out.println("");
            System.out.println("");

        } catch (IOException e) {
            System.out.println("Error de E/S.");
        }
    }

    public static void borrarDatosAlmacenados() {
        try {
            new FileOutputStream("telefonos.bin").close();
        } catch (IOException e) {
            System.out.println("Error de E/S.");
        }
    }
}
//Autor: Derimán Tejera Fumero.
/*
Por motivos puamente estadísticos se desea llevar constancia del número de llamadas recibidas cada dia en una oficina.
Para ello, al terminar cada jornada laboral se guarda dicho número al final de un archivo binario. Implementa una
aplicación con un menú, que nos permita añadir el número correspondiente cada dia y ver la lista completa en cualquier momento.
 */
