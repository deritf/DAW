public class Main {
    public static void main(String[] args) {

        Nota cancion[] = {Nota.DO, Nota.SI, Nota.SOL, Nota.RE, Nota.FA};
        Campana p = new Campana();
        for (Nota nota : cancion) {
            p.add(nota);
        }
        p.interpretar();
    }
}