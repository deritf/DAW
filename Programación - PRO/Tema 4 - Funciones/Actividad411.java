/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg4.pkg11;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Antimonius
 */
public class Actividad411 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           
    Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.US);
    
    double radio;
    final double pi = 3.141592;
    
    System.out.println("Este programa calcula la superficie y el volúmen de una esfera según su radio.");   
                       
        do{
            System.out.print("Introduce el radio: ");
            radio = sc.nextDouble();
                if (radio <= 0){
                System.out.println("El número no es válido, recuerda que tiene que ser mayor que 0.");
                }
        } while (radio <= 0);    
        
        System.out.println("La superficie de la esfera es: " + superficieEsfera(pi, radio));
        System.out.println("El volumen de la esfera es: " + volumenEsfera(pi, radio));
    }

    static double superficieEsfera (double pi, double radio){
        double superficie;
        superficie = 4*pi*radio*radio;
        return superficie;
    }    

    static double volumenEsfera (double pi, double radio){
        double volumen;
        volumen = ((4*pi)/3)*radio*radio*radio;
        return volumen;
    }     
}
//Autor: Derimán Tejera Fumero.




