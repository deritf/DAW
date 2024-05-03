/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg2.pkg12;

import java.util.Scanner;

/**
 *
 * @author Antimonius
 */
public class Actividad212 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    int num;
       
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Este programa calcula la letra correspondiente a un número DNI dado.");       
    System.out.print("Introduzca el DNI: ");
    num = sc.nextInt();
    
    
    
        if (num>=10000000 && num<=99999999){

            num = num % 23;    

            switch (num){

                case 0:
                    System.out.print("La letra es [T]\n");    
                    break;    

                case 1:
                    System.out.print("La letra es [R]\n");    
                    break;

                case 2:
                    System.out.print("La letra es [W]\n");    
                    break;

                case 3:
                    System.out.print("La letra es [A]\n");    
                    break;

                case 4:
                    System.out.print("La letra es [G]\n");    
                    break;

                case 5:
                    System.out.print("La letra es [M]\n");    
                    break;

                case 6:
                    System.out.print("La letra es [Y]\n");    
                    break;

                case 7:
                    System.out.print("La letra es [F]\n");    
                    break;

                case 8:
                    System.out.print("La letra es [P]\n");    
                    break;

                case 9:
                    System.out.print("La letra es [D]\n");    
                    break;

                case 10:
                    System.out.print("La letra es [X]\n");    
                    break;

                case 11:
                    System.out.print("La letra es [B]\n");    
                    break;

                case 12:
                    System.out.print("La letra es [N]\n");    
                    break;

                case 13:
                    System.out.print("La letra es [J]\n");    
                    break;

                case 14:
                    System.out.print("La letra es [Z]\n");    
                    break;

                case 15:
                    System.out.print("La letra es [S]\n");    
                    break;

                case 16:
                    System.out.print("La letra es [Q]\n");    
                    break;

                case 17:
                    System.out.print("La letra es [V]\n");    
                    break;

                case 18:
                    System.out.print("La letra es [H]\n");    
                    break;

                case 19:
                    System.out.print("La letra es [L]\n");    
                    break;

                case 20:
                    System.out.print("La letra es [C]\n");    
                    break;

                case 21:
                    System.out.print("La letra es [K]\n");    
                    break;

                case 22:
                    System.out.print("La letra es [E]\n");    
                    break;

                default:
                    System.out.print("Ha ocurrido un error, vuelta a intentarlo.\n"); 

            }

        }
        else{
        System.out.print("El número elegido no es un DNI, vuelta a intentarlo.\n");    
        }
        
    
    }
    
}

//Autor: Derimán Tejera Fumero.