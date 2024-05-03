/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad.pkg7.pkg11;

/**
 *
 * @author Usuario
 */
public class Marcapagina {   
    int paginaActual;

    public Marcapagina() {
        this.paginaActual = 0;
    }

    public void siguientePag() {
        paginaActual++;
        System.out.println("Página leída... ");
    }
    
    public int ultimaPaginaLeida() {       
        return paginaActual;
    }
    
    public void comenzar() {
        paginaActual = 0;
    }
}
//Autor: Derimán Tejera Fumero.
