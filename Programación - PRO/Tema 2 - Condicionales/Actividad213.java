/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg2.pkg13;

import java.util.Scanner;

/**
 *
 * @author Antimonius
 */
public class Actividad213 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    int comidaDiaria;
    int numAnimales;
    int kilosPorAnimal;
    int comidaNecesaria;
    int sobraFalta;
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Este programa calcula la disponibilidad de alimento diaria de una granja.");       
    System.out.print("¿Cuál es la cantidad de comida disponible para hoy?(Kg): ");
    comidaDiaria = sc.nextInt();
    System.out.print("¿Cuál es el número de animales que comerán hoy?(unidades): ");
    numAnimales = sc.nextInt();
    System.out.print("¿Cuánto come de media cada animal?(Kg): ");
    kilosPorAnimal = sc.nextInt();
    
    comidaNecesaria = kilosPorAnimal * numAnimales;
    
    if(comidaDiaria >= 1 && numAnimales >= 1 && kilosPorAnimal >= 1){
    
            if(comidaNecesaria < comidaDiaria){
            System.out.print("Hay comida suficiente para alimentar a la granja.\n");
            sobraFalta = comidaDiaria - comidaNecesaria;
            System.out.print("Sobran " + sobraFalta + " kilos de comida.\n");
            }
            else{
            System.out.print("No hay comida suficiente para alimentar a la granja.\n");
            sobraFalta = comidaNecesaria - comidaDiaria;
            System.out.print("Se recomienda hacer un pedido de " + sobraFalta + " kilos de comida.\n");
            }
        
    }
    else{
    System.out.print("ERROR. Ha introducido un valor imposible.\n");
    System.out.print("Inténtalo de nuevo.\n");     
    }
    
    }
}

//Autor: Derimán Tejera Fumero.