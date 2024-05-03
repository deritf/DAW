/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg5.pkg15;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Derexe
 */
public class Actividad515 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int notas[][] = {
            {7, 2, 8},
            {6, 2, 8},
            {4, 2, 8},
            {7, 7, 8},
            {5, 5, 8}
        };

        double mediaTrimestre[] = new double[3];

        mostrarDatos(notas);
        mostrarMediaPorTrimestre(notas, mediaTrimestre);
        mostrarMediaPorAlumno(notas, mediaTrimestre);
    }

    static void mostrarDatos(int notas[][]) {

        System.out.println("Tamaño actual del array es: " + (notas.length));
        System.out.println(Arrays.deepToString(notas));

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("----------------------------");
        System.out.println("|  NOTAS ALUMNOS GRUPO 1:  |");
        System.out.println("----------------------------");
        System.out.println("               T1 T2 T3");

        for (int i = 0; i < 5; i++) {
            System.out.print("Alumno: " + (i + 1) + " -> ");
            for (int j = 0; j < 3; j++) {
                System.out.print("  ");
                System.out.print(notas[i][j]);

            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    static void mostrarMediaPorTrimestre(int notas[][], double mediaTrimestre[]) {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 5; j++) {

                int x = 0;
                mediaTrimestre[i] = mediaTrimestre[i] + (notas[j][i]);
                x++;

            }
            System.out.println("Media del grupo 1 en el T" + (i + 1) + ": " + (mediaTrimestre[i]) / 5);
        }
        System.out.println(" ");
    }

    static void mostrarMediaPorAlumno(int notas[][], double mediaTrimestre[]) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        int numAlu = 0;
        double mediaAlumnoSeleccionado = 0;

        while (numAlu != -1) {

            System.out.println("Introduce el número del alumno que desea consultar: ");
            System.out.println("RECUERDA: Para salir, introduce: -1.");
            numAlu = sc.nextInt();

            if ((numAlu > 5) || (numAlu < 1)) {
                System.out.println("El número no es válido, recuerda que en el grupo 1 solo hay 5 alumnos. ");
            } else {
                for (int j = 0; j < 3; j++) {
                    mediaAlumnoSeleccionado = (notas[numAlu - 1][0] + notas[numAlu - 1][1] + notas[numAlu - 1][2]);
                }

                mediaAlumnoSeleccionado = mediaAlumnoSeleccionado / 3;

                System.out.println(" ");
                System.out.print("La media del alumno [" + numAlu + "] es: ");
                formato(mediaAlumnoSeleccionado);
                System.out.println(" ");
            }
        }
    }

    static void formato(double mediaAlumnoSeleccionado) {

        String pattern = "#.##";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String formattedDouble = decimalFormat.format(mediaAlumnoSeleccionado);
        System.out.println(formattedDouble);
    }

}
//Autor: Derimán Tejera Fumero.

/*
Debes desarrollar una aplicación que ayude a gestionar las notas de un centro educativo. Los alumnos se organizan en grupos compuestos por 5 personas. Leer las notas (números enteros)
del primer, segundo y tercer trimestre de un grupo. Debes mostrar al final la nota media del grupo en cada trimestre y la media del alumno que se encuentra en una posición dada
(que el usuario introduce por teclado).
 */
