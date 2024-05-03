/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad.pkg12.pkg17;

/**
 *
 * @author Usuario
 */
import java.util.ArrayList;

public class Cola<T> {

    private ArrayList<T> elementos;

    public Cola() {
        this.elementos = new ArrayList<>();
    }

    public void encolar(T elemento) {
        elementos.add(elemento);
    }

    public T desencolar() {
        if (elementos.isEmpty()) {
            return null;
        }
        return elementos.remove(0);
    }
}
//Autor: Derimán Tejera Fumero.
/*
Implementa la dase Cola genérica utilizando un objeto ArrayList pora guardar tos elementos.
 */
