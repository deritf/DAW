/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad.pkg7.pkg18;

/**
 *
 * @author Usuario
 */
public class Cola {

    int cola[];
    int primero;
    int ultimo;
    int tamano;

    public Cola(int tamano) {
        this.cola = new int[tamano];
        primero = -1;
        ultimo = -1;
        this.tamano = tamano;
    }

    public void encola(int valor) {
        if (ultimo == tamano - 1) {
            System.out.println("La cola está llena");
        } else if (primero == -1 && ultimo == -1) {
            primero++;
            ultimo++;
            cola[ultimo] = valor;
        } else {
            ultimo++;
            cola[ultimo] = valor;
        }
    }

    public int desencola() {
        int valor = -1;
        if (primero == -1 && ultimo == -1) {
            System.out.println("La cola está vacía");
        } else if (primero == ultimo) {
            valor = cola[primero];
            primero = -1;
            ultimo = -1;
        } else {
            valor = cola[primero];
            primero++;
        }
        return valor;
    }

    public int primero() {
        if (primero == -1 && ultimo == -1) {
            System.out.println("La cola está vacía");
            return -1;
        }
        return cola[primero];
    }

    public boolean vacia() {
        return (primero == -1 && ultimo == -1);
    }
}
//Autor: Derimán Tejera Fumero.
