/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad.pkg7.pkg15;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Calendario {
    
    Scanner sc = new Scanner(System.in);
    int anio;
    int mes;
    int dia;

    public Calendario(int dia, int mes, int anio) {
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;

        if (anio<=0){
            System.out.println("La fecha no es válida. El año es incorrecto. El resultado mostrado no será correcto.");
            }
        
        if (mes<0 && mes>=12){
            System.out.println("La fecha no es válida. El mes es incorrecto. El resultado mostrado no será correcto.");
            }
        
        if (mes<=28 && mes>=31){
            System.out.println("La fecha no es válida. El mes es incorrecto. El resultado mostrado no será correcto.");
            }
        
        if (dia>31 && (mes==1 || mes==3  || mes==5  || mes==7  || mes==8  || mes==10 || mes==12)) {
            System.out.println("La fecha no es válida. El número de días para ese mes no existe. El resultado mostrado no será correcto."); 
        }
        
        if (dia>30 && (mes==4 || mes==6  || mes==9  || mes==11)) {
            System.out.println("La fecha no es válida. El número de días para ese mes no existe. El resultado mostrado no será correcto."); 
        }
        
        if (dia>28 && (mes==2)) {
            System.out.println("La fecha no es válida. El número de días para ese mes no existe. El resultado mostrado no será correcto."); 
        }
    }
    
    void incrementarDia() {
        
        if (dia==31 && (mes==1 || mes==3  || mes==5  || mes==7  || mes==8  || mes==10)) {
            mes++;
            dia=1;
        }
        
        if (dia==30 && (mes==4 || mes==6  || mes==9  || mes==11)) {
            mes++;
            dia=1;
        }
        
        if (dia==28 && (mes==2)) {
            mes++;
            dia=1;
        }
        
        if (dia==31 && (mes==12)) {
            mes=1;
            dia=1;
            anio++;
        }
    }
    
    public void incrementaMes(){
               
        if (mes==12) {
            mes=1;
            dia=1;
            anio++;
        }
        else{
            mes++;
        }       
    }
    
    public void incrementarAnio(int cantidad){

        System.out.println("Introduce el valor para año: ");   
                       
        do{
            System.out.print("Introduce el anio: ");
            anio = sc.nextInt();
                if (anio <= 0){
                System.out.println("El año no es válido, recuerda que tiene que ser mayor que 0.");
                }
        } while (anio <= 0);   
    }
    
    public void mostrar(){
        System.out.println();
        System.out.println("Mostrando fecha...");
        System.out.println(dia + "/" + mes + "/" + anio);
        System.out.println();
    }
    
    public boolean iguales(Calendario otraFecha){   
    return (otraFecha.getDia() == dia && otraFecha.getMes() == mes &&otraFecha.getAnio() == anio);
    }
    
    public int getDia(){       
        return dia;
    }
    
    public int getMes(){       
        return mes;
    }
    
    public int getAnio(){       
        return anio;
    }
}
//Autor: Derimán Tejera Fumero.
