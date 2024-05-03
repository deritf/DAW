/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg3.pkg13;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Antimonius
 */
public class Actividad313 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    int hora = 0;    
    int minutos = 0;
    int segundos = 0;
    int segundosSuma = 0;
    final int hora2 = 0;
    final int minutos2 = 0;
    final int segundos2 = 0;
    
    Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.US);
        
    System.out.print("Este programa pide al usuario la hora, minutos y segudos de una hora y un número determinado de segundo para sumarle.\n");   
                       
        do{
            System.out.print("Introduce las horas: ");
            hora = sc.nextInt();
                if (hora<0){
                System.out.print("Las horas introducidos no son válidos, inténtalo de nuevo.\n");
                }
        }while(hora<0);
        
        do{
            System.out.print("Introduce los minutos: ");
            minutos = sc.nextInt();
                if (minutos<0 || minutos>59){
                System.out.print("Los minutos introducidos no son válidos, inténtalo de nuevo.\n");
                }            
        }while(minutos<0 || minutos>59);
        
        do{
            System.out.print("Introduce los segundos: ");
            segundos = sc.nextInt(); 
                if (segundos<0 || segundos>59){
                System.out.print("Los segundos introducidos no son válidos, inténtalo de nuevo.\n");
                }
        }while(segundos<0 || segundos>59);
        
        do{
            System.out.print("Introduce los segundos que deseas añadir a la hora indicada: ");
            segundosSuma = sc.nextInt(); 
                if (segundosSuma<0){
                System.out.print("Los segundos introducidos no son válidos, inténtalo de nuevo.\n");
                }
        }while(segundosSuma<0);
        
        
        System.out.print("==============================================================\n");
        
        if(hora<10 && minutos<10 && segundos<10){
            System.out.print("La hora inicial: " + hora2 + hora + ":" + minutos2 + minutos + ":" + segundos2 + segundos + " + " + segundosSuma + " segundos.\n");
        }        
        else if(segundos<10 && hora<10){
            System.out.print("La hora inicial: " + hora2 + hora + ":" + minutos + ":" + segundos2 + segundos + " + " + segundosSuma + " segundos.\n");
        }        
        else if(segundos<10 && minutos<10){
            System.out.print("La hora inicial: " + hora + ":" + minutos2 + minutos + ":" + segundos2 + segundos + " + " + segundosSuma + " segundos.\n");
        }        
        else if(hora<10 && minutos<10){
            System.out.print("La hora inicial: " + hora2 + hora + ":" + minutos2 + minutos + ":" + segundos + " + " + segundosSuma + " segundos.\n");
        }        
        else if(hora<10){
            System.out.print("La hora inicial: " + hora2 + hora + ":" + minutos + ":" + segundos + " + " + segundosSuma + " segundos.\n");
        }         
        else if(minutos<10){
            System.out.print("La hora inicial: " + hora + ":" + minutos2 + minutos + ":" + segundos + " + " + segundosSuma + " segundos.\n");
        }         
        else if(segundos<10){
            System.out.print("La hora inicial: " + hora + ":" + minutos + ":" + segundos2 + segundos + " + " + segundosSuma + " segundos.\n");
        }
        else{
            System.out.print("La hora inicial: " + hora + ":" + minutos + ":" + segundos + " + " + segundosSuma + " segundos.\n");
        }
        
                                                           
        segundos = segundosSuma + segundos;
        
              
        while(segundos>=60){
            segundos = segundos - 60;
            minutos++; 
        }
        
        while(minutos>=60){
            minutos = minutos - 60;
            hora++; 
        }
                            
                                                                                                            
        if(hora<10 && minutos<10 && segundos<10){
            System.out.print("El resultado es: " + hora2 + hora + ":" + minutos2 + minutos + ":" + segundos2 + segundos + "\n");
        }        
        else if(segundos<10 && hora<10){
            System.out.print("El resultado es: " + hora2 + hora + ":" + minutos + ":" + segundos2 + segundos + "\n");
        }        
        else if(segundos<10 && minutos<10){
            System.out.print("El resultado es: " + hora + ":" + minutos2 + minutos + ":" + segundos2 + segundos + "\n");
        }        
        else if(hora<10 && minutos<10){
            System.out.print("El resultado es: " + hora2 + hora + ":" + minutos2 + minutos + ":" + segundos + "\n");
        }        
        else if(hora<10){
            System.out.print("El resultado es: " + hora2 + hora + ":" + minutos + ":" + segundos + "\n");
        }         
        else if(minutos<10){
            System.out.print("El resultado es: " + hora + ":" + minutos2 + minutos + ":" + segundos + "\n");
        }         
        else if(segundos<10){
            System.out.print("El resultado es: " + hora + ":" + minutos + ":" + segundos2 + segundos + "\n");
        } 
                
    }   
}
//Autor: Derimán Tejera Fumero.


