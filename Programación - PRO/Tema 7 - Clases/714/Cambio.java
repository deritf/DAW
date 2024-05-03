/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad.pkg7.pkg14;

/**
 *
 * @author Usuario
 */
public class Cambio {
    
    final double [] monedas={500, 200, 100, 50, 20, 10, 5, 2, 1, 0.5, 0.20, 0.10, 0.05, 0.02, 0.01}; //Propiedad de la clase.
    double importe;
    
    public Cambio(double importe) {
        this.importe = importe;                
    }
    
    public void setImporte(double importe){
        this.importe = importe;
    }

    public void mostrarCambio(){

        System.out.println();
        System.out.println("== NUEVO IMPORTE =="); 
        System.out.println("Importe: " + importe);
        System.out.println(); 
        
        double [] devolver={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        for(int i=0;i<monedas.length;i++)
        {
            if(importe>=monedas[i])
            {
                devolver[i]=Math.floor(importe/monedas[i]);
                importe=importe-(devolver[i]*monedas[i]);
            }
        }
        
        for(int i = 0; i<monedas.length; i++){
           
           System.out.println("Valor [" + monedas[i] + "] " + " = " + devolver[i] + " unidad/es"); 
        }
        
        System.out.println("=========================================================");  
    }  
}
//Autor: Derimán Tejera Fumero.
