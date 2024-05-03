/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg4.pkg14;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Antimonius
 */
public class Actividad414 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.US);    
        
    int dias;
    int horas;
    int minutos;
        
        System.out.println("Este programa calcula en segundos los días, horas y minutos introducidos por el usuario.");   
        
        do{
            System.out.print("Introduce los días: ");
            dias = sc.nextInt();
                if (dias <= 0){
                System.out.println("El número no es válido, recuerda que tiene que ser mayor que 0.");
                }
        } while (dias <= 0);
        
        do{
            System.out.print("Introduce las horas: ");
            horas = sc.nextInt();
                if (horas <= 0){
                System.out.println("El número no es válido, recuerda que tiene que ser mayor que 0.");
                }
        } while (horas <= 0);
        
        do{
            System.out.print("Introduce los minutos: ");
            minutos = sc.nextInt();
                if (minutos <= 0){
                System.out.println("El número no es válido, recuerda que tiene que ser mayor que 0.");
                }
        } while (minutos <= 0); 
        
        System.out.println("El total es: " + totalSegundos(dias, horas, minutos) + " segundos.");
    }
    
    static int totalSegundos (int dias, int horas, int minutos){
        
        int Total;
        int TotalDias;
        int TotalHoras;
        int TotalMinutos;
        
        
        TotalDias = dias*86400;
        TotalHoras = horas*3600;
        TotalMinutos = minutos*60;
       
        Total = TotalDias + TotalHoras + TotalMinutos;
        return Total;
    }
}
//Autor: Derimán Tejera Fumero.

