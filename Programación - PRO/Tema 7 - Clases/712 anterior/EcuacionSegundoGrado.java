/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad.pkg7.pkg12.anterior;

/**
 *
 * @author Usuario
 */
public class EcuacionSegundoGrado {
        
    double a;
    double b;
    double c;
    double discriminante;
 
    public EcuacionSegundoGrado(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
                      
    }
    
    
    public void discriminante(){

        if (discriminante > 0) {           
            System.out.println("El discriminante es positivo.");
        }
        else{
            System.out.println("El discriminante es NO es positivo.");
        }
        //System.out.println("El discriminante es positivo."); 
    }
    
    public void resolverEcuacion(){
        
            discriminante = b * b - 4 * a * c;
        
            double solucion1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double solucion2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            System.out.println("Las soluciones son: x1 = " + solucion1 + " y x2 = " + solucion2);
        
    }
    
    void mostrarDatosActuales(){
        
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
    }
    
    void setDatos(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;    
    }
}
//Autor: Derimán Tejera Fumero.