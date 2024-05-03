/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad.pkg7.pkg13;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Usuario
 */
public class Colores {
    
    String color[] = new String[0]; //Creo array color.

    void addColor(String c1){

        color = Arrays.copyOf(color, color.length+1);
        color[color.length-1] = c1;
    }
    
    String[] seleccionColores(int cantidad){
        String copiaArray[] = Arrays.copyOf(color , color.length);
        
        desordenar(copiaArray);
        int x = Math.min(cantidad, color.length);

        return Arrays.copyOf(copiaArray, x);
}
    
    private void desordenar(String copiaArray[]) {

        Random aleatorio = new Random();

        for (int i = 0; i < copiaArray.length; i++) {
            int posAleatoria = aleatorio.nextInt(copiaArray.length);
            String temp = copiaArray[i];
            copiaArray[i] = copiaArray[posAleatoria];
            copiaArray[posAleatoria] = temp;
        }       
    } 
}
//Autor: Derimán Tejera Fumero.
