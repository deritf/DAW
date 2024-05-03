/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad.pkg7.pkg17;

/**
 *
 * @author Usuario
 */
public class Cifrado {
        
    private static final char[] Alfabeto = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    

     
    public static String cesar(String texto, int n) {
        char cifradoTexto[] = new char[texto.length()];

        for (int i = 0; i < texto.length(); i++) {
            char charActual = texto.charAt(i);

            if (Character.isLetter(charActual)) {
                int indiceAlfabeto;
                if (Character.isLowerCase(charActual)) {
                    indiceAlfabeto = charActual - 'a';
                } else {
                    indiceAlfabeto = charActual - 'A';
                }
                int indiceAlfabetoNuevo = (indiceAlfabeto + n) % Alfabeto.length;
                char charNuevo = Alfabeto[indiceAlfabetoNuevo];
                if (Character.isUpperCase(charActual)) {
                    charNuevo = Character.toUpperCase(charNuevo);
                }
                cifradoTexto[i] = charNuevo;
            } else {
                cifradoTexto[i] = charActual;
            }
        }

        return new String(cifradoTexto);
    }  
}
//Autor: Derimán Tejera Fumero.

