/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg12.pkg16;

/**
 *
 * @author Usuario
 */
import java.io.*;
import java.util.*;

public class Actividad1216 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Set<Socio> socios = new TreeSet<>();

        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("socios.dat"))) {
            socios = (TreeSet<Socio>) in.readObject();
        } catch (IOException ex) {
            System.out.println("Lista de socios vacÃ­a");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        int opcion;
        do {
            System.out.println("1.Alta");
            System.out.println("2.Baja");
            System.out.println("3.ModificaciÃ³n");
            System.out.println("4.Listado por dni");
            System.out.println("5.Listado por antigÃ¼edad");
            System.out.println("6.Listado por orden alfabético");
            System.out.println("7.Salir");
            System.out.print("\nIntroducir opciÃ³n: ");
            opcion = new Scanner(System.in).nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.print("dni: ");
                    String dni = new Scanner(System.in).next();
                    alta(socios, dni);
                }
                case 2 -> {
                    System.out.print("dni socio: ");
                    String dni = new Scanner(System.in).next();
                    socios.remove(new Socio(dni));
                }
                case 3 -> {
                    System.out.print("dni: ");
                    String dni = new Scanner(System.in).next();
                    socios.remove(new Socio(dni));
                    alta(socios, dni);
                }
                case 4 -> {
                    System.out.println(socios);
                }
                case 5 -> {
                    Comparator<Socio> c = new Comparator<>() {
                        @Override
                        public int compare(Socio o1, Socio o2) {
                            return o2.antiguedad() - o1.antiguedad();
                        }
                    };
                    Set<Socio> s = new TreeSet<>(c);
                    s.addAll(socios);
                    System.out.println(s);
                }
                case 6 -> {
                    System.out.println("");
                    Comparator<Socio> c = new Comparator<>() {
                        @Override
                        public int compare(Socio o1, Socio o2) {
                            return o1.nombre.compareTo(o2.nombre);
                        }
                    };
                    Set<Socio> s = new TreeSet<>(c);
                    s.addAll(socios);
                    for (Socio socio : s) {
                        System.out.print(socio);
                    }
                    System.out.println("");
                }
            }
        } while (opcion != 7);
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("socios.dat"))) {
            out.writeObject(socios);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    static boolean alta(Set<Socio> socios, String dni) {
        System.out.print("nombre: ");
        String nombre = new Scanner(System.in).next();
        System.out.print("fecha de alta (dd/MM/yyyy): ");
        String fechaAlta = new Scanner(System.in).next();
        Socio nuevo = new Socio(dni, nombre, fechaAlta);
        return socios.add(nuevo);
    }
}

//Autor: Derimán Tejera Fumero
/*
Implementa una aplicación que gestione los socios de un club usando la clase Socio implementada en la Actividad resuelta 12.11.
En particular, se deberán ofrecer las opciones de alta, baja y modificación de los datos de un socio. Además, se listarán los
socios por nombre o por antigüedad en el club.
 */
