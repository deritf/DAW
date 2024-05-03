public class Campana extends Instrumento {

    public Campana() {
        //super();
    }

    @Override
    void interpretar() {
        System.out.println("Esto es de la clase Campana:");
        for (Nota nota : melodia) {
            System.out.print(nota + " ");
        }
        System.out.println();
    }
}
//Autor: Derimán Tejera Fumero
