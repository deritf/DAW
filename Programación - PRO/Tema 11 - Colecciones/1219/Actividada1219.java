/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividada.pkg12.pkg19;

/**
 *
 * @author Usuario
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Actividada1219 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Este programa mostrará por pantalla las palabras que estén repetidas en una frase incial dada por el usuario. ");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca una frase: ");
        String frase = scanner.nextLine();

        String[] palabras = frase.split(" ");
        List<String> listaPalabras = new ArrayList<>();
        for (String palabra : palabras) {
            listaPalabras.add(palabra);
        }

        Map<String, Integer> conteoPalabras = new HashMap<>();
        for (String palabra : listaPalabras) {
            if (conteoPalabras.containsKey(palabra)) {
                int contador = conteoPalabras.get(palabra);
                conteoPalabras.put(palabra, contador + 1);
            } else {
                conteoPalabras.put(palabra, 1);
            }
        }

        System.out.println("");
        System.out.println("------------------");
        System.out.println("PALABRAS REPETIDAS");
        for (Map.Entry<String, Integer> entry : conteoPalabras.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey());
            }
        }

        System.out.println("");
        System.out.println("---------------------");
        System.out.println("PALABRAS NO REPETIDAS");
        for (Map.Entry<String, Integer> entry : conteoPalabras.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
            }
        }
    }

}
//Autor: Derimán Tejera Fumero.
/*
Escribe un programa donde se introduzca por consola una frase que conste exclusivamente de
palabras separadas por espacios. Las palabras de la frase se almacenarán en una lista. Finalmente,
se mostrarán por pantalla las palabras que estén repetidas y. a continuación, las que no lo estén.
 */
