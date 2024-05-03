/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg6.pkg13.expregular;

/**
 *
 * @author Usuario
 */
public class Actividad613ExpRegular {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        String sentenciaC = "if (a==3) /* igual a tres */ a++; /* incrementaos a */";
        
        String sentenciaLimpia = sentenciaC.replaceAll("/\\*[^*]*\\*+(?:[^/*][^*]*\\*+)*/", "");
        
        System.out.println("Sentencia original: " + sentenciaC);
        System.out.println("Sentencia modificada: " + sentenciaLimpia);
    }
}
