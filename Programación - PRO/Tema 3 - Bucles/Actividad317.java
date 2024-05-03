/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg3.pkg17;

import java.util.Locale;
import java.util.Scanner;
import java.lang.Math;

/**
 *
 * @author Antimonius
 */
public class Actividad317 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    int numeroUno;  
    int numeroDos;
    int primo=0;

    Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.US);
        
    System.out.print("Este programa calcula el máximo común divisor de dos números introducidos por el usuario.\n");   
                       
        do{
            System.out.print("Introduce el primer número: ");
            numeroUno = sc.nextInt();
                if (numeroUno <= 0){
                System.out.print("El número no es válido, recuerda tiene que ser mayor que 0.\n");
                }
        } while (numeroUno <= 0);
        
        do{
            System.out.print("Introduce el segundo número: ");
            numeroDos = sc.nextInt();
                if (numeroDos <= 0){
                System.out.print("El número no es válido, recuerda tiene que ser mayor que 0.\n");
                }
        } while (numeroDos <= 0);

        int valor1;
        int valor2;
        valor1 = numeroUno;
        valor2 = numeroDos;
          
        int n1 = numeroUno;
        int n2 = numeroDos;
        int resultadoUno = 1;
        int resultadoDos = 1;
           
        //OBTENEMOS LOS NUMEROS PRIMOS POR LOS QUE DIVIDIR NUMERO UNO
        for(int i = 2; i<=numeroUno && i<=numeroDos ; i++){
                       
            int p1 = primo;         
            int contador = 0;
           
            primo = i;
            p1 = i;
            
            if(n1%primo==0){
              
              System.out.print(n1 + "|" + p1 + " \n");
              n1 = n1/primo;
              numeroUno = numeroUno/primo;
              resultadoUno = resultadoUno*primo;
              i = 1;    
            }
        }

        System.out.print("==========================\n");

                //OBTENEMOS LOS NUMEROS PRIMOS POR LOS QUE DIVIDIR NUMERO DOS
        for(int i = 2;i<=numeroDos ; i++){
                       
            int p2 = primo;         
            int contador = 0;
           
            primo = i;
            p2 = i;
   
            if(n2%primo==0){
              
              System.out.print(n2 + "|" + p2 + " \n");
              n2 = n2/primo;
              numeroDos = numeroDos/primo;
              resultadoDos = resultadoDos*primo;
              i = 1;   
            }
        
        }
        
        System.out.println("===================================");       
        System.out.println("El máximo común divisor es: [" + calculaElMcdDe(valor1, valor2) + "]");
    }


            public static int calculaElMcdDe(int valor1, int valor2){


                int menor = Math.min(valor1, valor2);    
                int posibleMcd = menor;    


                while(true){
                        if((valor1 % posibleMcd == 0) && (valor2 % posibleMcd == 0)){
                        return posibleMcd;
                        }
                        else{
                            posibleMcd--;
                        }   

                }
                }
            }
//Autor: Derimán Tejera Fumero.
//Co-autora: Estefanía Miranda López.




