/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad10.pkg18;

import java.util.Arrays;

/**
 *
 * @author Usuario
 */
public class Actividad1018 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String texto = "Hoy 24 de Marzo de 2082 la temperatura es de unos agradables 22 grados Celcius, o lo que es lo mismo, 71,6 grados Fahrenheit o 295.15 grados Kelvin. En contraste, ayer hizo -5 grados Celcius.";
        int enteros[] = leerEnteros(texto);
        System.out.println("Los números enteros encontrados en la cadena de texto son: " + Arrays.toString(enteros));
    }

    private static int[] leerEnteros(String texto) {
        String palabras[] = texto.split(" ");
        int contador = 0;
        for (int j = 0; j < palabras.length; j++) {
            String palabra = palabras[j];
            if (palabra.length() > 0 && (Character.isDigit(palabra.charAt(0)) || (palabra.charAt(0) == '-' && palabra.length() > 1 && Character.isDigit(palabra.charAt(1))))) {
                boolean esEntero = true;
                for (int i = 1; i < palabra.length(); i++) {
                    char c = palabra.charAt(i);
                    if (!Character.isDigit(c)) {
                        if (c == ',' || c == '.') {
                            esEntero = false;
                            break;
                        }
                        if (c != ' ') {
                            esEntero = false;
                            break;
                        }
                    }
                }
                if (esEntero) {
                    contador++;
                }
            }
        }
        int enteros[] = new int[contador];
        contador = 0;
        for (int j = 0; j < palabras.length; j++) {
            String palabra = palabras[j];
            if (palabra.length() > 0 && (Character.isDigit(palabra.charAt(0)) || (palabra.charAt(0) == '-' && palabra.length() > 1 && Character.isDigit(palabra.charAt(1))))) {
                boolean esEntero = true;
                for (int i = 1; i < palabra.length(); i++) {
                    char c = palabra.charAt(i);
                    if (!Character.isDigit(c)) {
                        if (c == ',' || c == '.') {
                            esEntero = false;
                            break;
                        }
                        if (c != ' ') {
                            esEntero = false;
                            break;
                        }
                    }
                }
                if (esEntero) {
                    enteros[contador] = Integer.parseInt(palabra);
                    contador++;
                }
            }
        }
        return enteros;
    }
}
//Autor: Derimán Tejera Fumero.
/*
Escribe la función Integerf] leerEnterosfString texto), al que se le pasa una cadena y devuelve una tabla con todos los enteros que aparecen en ella.
 */
