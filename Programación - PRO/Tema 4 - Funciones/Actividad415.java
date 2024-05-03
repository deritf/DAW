/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg4.pkg15;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Antimonius
 */
public class Actividad415 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.US);    
        
    int hora1, minuto1, hora2, minuto2;    
        
        System.out.println("Este programa muestra los minutos que hay entre dos horas dadas por el usuario.");   
                             
        do{
            System.out.print("Tiempo 1. Hora: ");
            hora1 = sc.nextInt();
                if (hora1 <= 0){
                System.out.println("El número no es válido, recuerda que tiene que ser mayor que 0.");
                }
        } while (hora1 <= 0); 
        
        do{
            System.out.print("Tiempo 1. Minutos: ");
            minuto1 = sc.nextInt();
                if (minuto1 <= 0){
                System.out.println("El número no es válido, recuerda que tiene que ser mayor que 0.");
                }
        } while (minuto1 <= 0);
        
        do{
            System.out.print("Tiempo 2. Hora: ");
            hora2 = sc.nextInt();
                if (hora2 <= 0){
                System.out.println("El número no es válido, recuerda que tiene que ser mayor que 0.");
                }
        } while (hora2 <= 0); 
        
        do{
            System.out.print("Tiempo 2. Minutos: ");
            minuto2 = sc.nextInt();
                if (minuto2 <= 0){
                System.out.println("El número no es válido, recuerda que tiene que ser mayor que 0.");
                }
        } while (minuto2 <= 0);
        
        System.out.println("El total es: " + diferenciaMin(hora1, minuto1, hora2, minuto2) + " minutos.");
    }
    
    static int diferenciaMin(int hora1, int minuto1, int hora2, int minuto2){
    
        int Total, TotalHora = 0, TotalMinuto = 0;

        if (hora2>=hora1 && minuto2>=minuto1){
        TotalHora = (hora2-hora1)*60;
        TotalMinuto = (minuto2-minuto1);
        }
        else if (hora2>=hora1 && minuto2<=minuto1){
        TotalHora = (hora2-hora1)*60;
        TotalMinuto = (minuto1-minuto2);
        }
        else if (hora2<=hora1 && minuto2>=minuto1){
        TotalHora = (hora1-hora2)*60;
        TotalMinuto = (minuto2-minuto1);
        }
        else if (hora2<=hora1 && minuto2<=minuto1){
        TotalHora = (hora1-hora2)*60;
        TotalMinuto = (minuto1-minuto2);
        }
        else if (hora2==hora1 || minuto2==minuto1){
        TotalHora = (hora2-hora1)*60;
        TotalMinuto = (minuto1-minuto2);
        }

        Total = TotalHora + TotalMinuto;
        return Total;
    }
}
//Autor: Derimán Tejera Fumero.
