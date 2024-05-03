/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad.pkg7.pkg12;

/**
 *
 * @author Usuario
 */
public class Ecuacion2Grado {
        
    double a;
    double b;
    double c;
    double discriminante;
 
    public Ecuacion2Grado(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;                     
    }
    
    public boolean esPositivoDiscriminante(){
        discriminante = b * b - 4 * a * c;
        return discriminante > 0;
    }
    
    public double[] solucion(){
        discriminante = b * b - 4 * a * c;
        double solucion1 = (-b + Math.sqrt(discriminante)) / (2 * a);
        double solucion2 = (-b - Math.sqrt(discriminante)) / (2 * a);
        return new double[]{solucion1, solucion2};
    }
    
    public void setB(double b) {
        this.b = b;
    }
}
//Autor: Derimán Tejera Fumero.
