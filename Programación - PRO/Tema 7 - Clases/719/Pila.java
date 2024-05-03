/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad.pkg7.pkg19;

/**
 *
 * @author Usuario
 */
public class Pila {
    
    private int pila[];
    private int cima;
    private int tamano;
    
    public Pila() {
        tamano = 10;
        cima = -1;
        pila = new int[tamano];
    }

    public void apila(int valor) {
        if (cima == tamano - 1) {
            System.out.println("La pila está llena");
        } else {
            cima++;
            pila[cima] = valor;
        }
    }

    public int desapila() {
        if (cima == -1) {
            System.out.println("La pila está vacía");
            return -1;
        } else {
            int valor = pila[cima];
            cima--;
            return valor;
        }
    }
    
    public int cima() {
        if (cima == -1) {
            System.out.println("La pila está vacía");
            return -1;
        } else {
            return pila[cima];
        }
    }
        
    public boolean vacia() {
        return cima == -1;
    }  
}
//Autor: Derimán Tejera Fumero.