/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg5.pkg18;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Derexe
 */
public class Actividad518 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int matriz[][] = new int [4][4];

        int resultadoSumaFilas [] = new int [4];
        int resultadoSumaColumnas [] = new int [4];
        
        System.out.println("Este programa verifica si una matriz que introduce por teclado el usuario es mágica o no."); 
        
        introducirMatriz(matriz);        
        mostrarDatos(matriz);        
        sumaFilas(matriz, resultadoSumaFilas);
        sumaColumnas(matriz, resultadoSumaColumnas);
        
        System.out.println("¿La matriz es mágica?"); 
        System.out.println(" ");        
        if(Arrays.equals(resultadoSumaFilas,resultadoSumaColumnas)){
           System.out.println("¡FELICIDADES! La matriz es mágica."); 
        }
        else{
           System.out.println("¡OH NO! La matriz NO es mágica."); 
        }
    }
 
    static void mostrarDatos(int matriz[][]) {
        
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        
        System.out.println("La matriz que introdujiste es esta: "); 
        System.out.println(Arrays.deepToString(matriz));
        System.out.println(" ");
        System.out.println("o vista de otro modo: ");
        System.out.println(" ");
        
        for (int i=0;i<4;i++){
            
            for(int j=0;j<4;j++){
               System.out.print("  ");
               System.out.print(matriz[i][j]);                             
            }  
            System.out.println(" "); 
        }              
    }

    static void sumaFilas(int matriz[][], int resultadoSumaFilas[]) {

        for (int i=0;i<4;i++){            
            for(int j=0;j<4;j++){              
                resultadoSumaFilas[i] = (resultadoSumaFilas[i] + matriz[i][j]);                              
            }             
        }      
    }
        
    static void sumaColumnas(int matriz[][], int resultadoSumaColumnas[]) {

        for (int i=0;i<4;i++){
            for(int j=0;j<4;j++){   
                resultadoSumaColumnas[i] = (resultadoSumaColumnas[i] + matriz[j][i]);                 
            }   
        }       
    }
    
    static void introducirMatriz(int matriz[][]) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        
        System.out.println("Introduce los datos para la matriz... ");
        
        for (int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                
                System.out.println("Posición -> Fila:[" + (i+1) + "] - Columna[" + (j+1) + "]: ");
                matriz[i][j] = sc.nextInt();                               
            }   
        }       
    }    
}

//Autor: Derimán Tejera Fumero.

/*
Escribe un programa que solicite los elementos de una matriz de tamaño 4x4. La aplicación debe decidir si la matriz introducida corresponde 
a una matriz mágica, que es aquella donde la suma de los elementos de cualquier fila o de cualquier columna valen lo mismo.
*/
