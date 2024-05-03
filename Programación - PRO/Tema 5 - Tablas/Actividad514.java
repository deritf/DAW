/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg5.pkg14;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Derexe
 */
public class Actividad514 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        double salario = 0;
        double salarioCiudadano[] = new double[1];
        double salarioMinimo = 1050.00;

        System.out.println("Este programa realiza una encuesta estadística para conocer el nivel adquisitivo de los habitantes de una comunidad.");

        while (salario != -1) {

            System.out.println("Introduce valor del sueldo del ciudadano [" + salarioCiudadano.length + "]: ");
            salario = sc.nextDouble();
            if (salario < salarioMinimo) {
                System.out.println("El número no es válido, recuerda que el salario mínimo es de " + salarioMinimo + " (euros) el salario del ciudadano [" + salarioCiudadano.length + "] debe ser igual o superior.");
            } else {
                salarioCiudadano[salarioCiudadano.length - 1] = salario;
                salarioCiudadano = Arrays.copyOf(salarioCiudadano, salarioCiudadano.length + 1);
            }
        }

        ordenarArrayDecrecientemente(salarioCiudadano);

        System.out.println("\n\n\n\n\n\n");

        System.out.println("::::::::::::::::::: DATOS :::::::::::::::::::");
        System.out.println("Tamaño actual de la base de datos: " + (salarioCiudadano.length - 1) + " ciudadano(s).");
        System.out.println("Datos introducidos hasta ahora son: ");
        System.out.println(Arrays.toString(salarioCiudadano));
        System.out.println("El sueldo máximo es: " + salarioCiudadano[0]);
        System.out.println("El sueldo mínimo es: " + salarioCiudadano[salarioCiudadano.length - 2]);
        mediaSueldos(salarioCiudadano);
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::");
    }

    static void ordenarArrayDecrecientemente(double salario[]) {
        for (int i = 0; i < salario.length - 1; i++) {
            int max = i;

            for (int j = i + 1; j < salario.length; j++) {
                if (salario[j] > salario[max]) {
                    max = j;
                }
            }

            if (i != max) {
                double aux = salario[i];
                salario[i] = salario[max];
                salario[max] = aux;
            }
        }
    }

    static void mediaSueldos(double salarioCiudadano[]) {

        double total = 0;
        double media = 0;

        for (int i = 0; i <= salarioCiudadano.length - 2; i++) {
            total = total + salarioCiudadano[i];
        }

        media = total / (salarioCiudadano.length - 1);
        System.out.println("La media de los sueldos es: " + media);
    }
}

//Autor: Derimán Tejera Fumero.

/*
El ayuntamiento de tu localidad te ha encargado una aplicación que ayude a realizar encuestas estadísticas para conocer el nivel adquisitivo de los habitantes del mtxiicipto. Para ello, tendrás que preguntar el sueldo a cada persona encuestada. A priori. no conoces el número de encuestados. Para finalizar la entrada de datos, introduce un sueldo con valor -1.
Una vez terminada la entrada de datos, muestra la siguiente información:
■ Todos los sueldos introducidos ordenados de forma decreciente.
■ El sueldo máximo y mínimo.
■ La media de los sueldos.
 */
