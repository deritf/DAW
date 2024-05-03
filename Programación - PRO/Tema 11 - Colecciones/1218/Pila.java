/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad.pkg12.pkg18;

/**
 *
 * @author Usuario
 */
import java.util.ArrayList;

public class Pila<E> {

    private ArrayList<E> elementos;

    public Pila() {
        elementos = new ArrayList<>();
    }

    public void apilar(E elemento) {
        elementos.add(0, elemento);
    }

    public E desapilar() {
        if (elementos.isEmpty()) {
            return null;
        }
        return elementos.remove(0);
    }

    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    public int tamano() {
        return elementos.size();
    }

    @Override
    public String toString() {
        return "Pila{"
                + "elementos=" + elementos
                + '}';
    }
}
//Autor: Derimán Tejera Fumero.
/*
Implementa la dase Pila genérica utilizando un objeto ArrayList para guardar tos elementos.
 */
