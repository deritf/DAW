/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg2.pkg18;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Antimonius
 */
public class Actividad218 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    
    int respuestaUsuario;
    int operandoAleatorio1;
    int operandoAleatorio2;
    int operacionAleatoria;
    int respuestaCorrecta = 0;
    String operacion = "";
    
    Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.US);
    
    System.out.print("¡Bienvenido al juego de la suma, resta y multiplicación!\n");
       
    System.out.print("Este programa genera dos números aleatorios (entre 1 y 99) y el usuario debe hacer la operación indicada correctamente.\n");
    
    operandoAleatorio1 = (int)(Math.random()*99+1);
    operandoAleatorio2 = (int)(Math.random()*99+1);
        
    operacionAleatoria = (int)(Math.random()*3+1); 
    
    if(operacionAleatoria==1){
        System.out.print("Suma");
        operacion = "Suma";
    }    
    if(operacionAleatoria==2){
        System.out.print("Resta");
        operacion = "Resta";
    }    
    if(operacionAleatoria==3){
        System.out.print("Multiplica");
        operacion = "Multiplicación";
    }
    

    System.out.print(" los valores: " + operandoAleatorio1 + " y " + operandoAleatorio2 + "\n");
       
    System.out.print("Introduce el resultado: ");
    respuestaUsuario = sc.nextInt();
       
    if(operacion=="Suma"){
        respuestaCorrecta = operandoAleatorio1 + operandoAleatorio2;
    }
    else if(operacion=="Resta"){
        respuestaCorrecta = operandoAleatorio1 - operandoAleatorio2;
    }
    else if(operacion=="Multiplicación"){
        respuestaCorrecta = operandoAleatorio1 * operandoAleatorio2;
    }
        
    if(respuestaUsuario== respuestaCorrecta){
    System.out.print("¡Correcto!\n");    
    }
    else{
    System.out.print("¡Incorrecto!\n");    
    }
  
    }
    
}

//Autor: Derimán Tejera Fumero.