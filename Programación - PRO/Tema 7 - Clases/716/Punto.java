/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad.pkg7.pkg16;

/**
 *
 * @author Usuario
 */
public class Punto {
    
    double x;
    double y;
    
    public Punto(double x, double y) {
        this.x = x;
        this.y = y; 
    }
    
    void desplazaX(double dx){
        x = x+dx;      
    }
    
    void desplazaY(double dy){
        y = y+dy;      
    }
    
    void desplaza(double dx, double dy){
        x = x+dx;
        y = y+dy;
    }
    
    double distanciaEuclidea(Punto otro){
        return Math.sqrt(Math.pow((otro.getX() - x), 2) + Math.pow((otro.getY() - y), 2));      
    }
    
    void muestra(){
        System.out.println();
        System.out.println("Mostrando datos del punto...");
        System.out.println("(" + x + "," + y + ")");
        System.out.println();       
    }
    
    public double getX(){       
        return x;
    }
    
    public double getY(){       
        return y;
    }
}
//Autor: Derimán Tejera Fumero.
