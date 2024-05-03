/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad.pkg7.pkg11.anterior;

/**
 *
 * @author Usuario
 */
public class MarcaPagina {   
    int paginaActual;

    void incrementarPaginaLeida(){
        paginaActual++;
        System.out.println("Página leída... ");
    }
    
    int getUltimaPaginaLeida(){       
        return paginaActual;
    }
    
    void reiniciarLecturaLibro(){
        paginaActual = 0;
    }
    
    public MarcaPagina(String titulo, String idioma, String editorial, int edicion, int paginas, int paginaActual, String autor, String isbn) {
        this.paginaActual = paginaActual;           
    }
} 
//Autor: Derimán Tejera Fumero.