/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg6.pkg13;

/**
 *
 * @author Usuario
 */
public class Actividad613 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // ORIGINAL - >   String sentenciaC = "if (a==3) /* igual a tres */ a++; /* incrementaos a */";
      String sentenciaC = "if (a==3) /* igual a tres */ a++; /* incrementaos a */";
      String inicioComentario = "/*";
      String finalComentario = "*/";

      System.out.println("Sentencia original: " + sentenciaC);
      
      while (sentenciaC.contains(inicioComentario)){
          
        int pos;
        pos = sentenciaC.indexOf(inicioComentario);

        int datos0 = pos;
        pos = sentenciaC.indexOf(finalComentario);

        int datos1 = pos;
        sentenciaC = sentenciaC.replace(sentenciaC.substring(datos0, datos1+2), "");
      }
      
      System.out.println("Sentencia modificada: " + sentenciaC);
        
    }
}
//Autor: Derimán Tejera Fumero.

    

