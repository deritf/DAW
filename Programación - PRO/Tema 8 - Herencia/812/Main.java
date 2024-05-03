public class Main {
    public static void main(String[] args) {
        // TODO code application logic here

        Unidad Unidades = Unidad.M;
        Caja cajaGrande = new Caja(1, 2, 3, Unidades);

        Unidades = Unidad.CM;
        Caja cajaPequena = new Caja(3, 3, 5, Unidades);

        System.out.println((double) cajaGrande.getVolumen());

        System.out.println((double) cajaPequena.getVolumen());


        cajaGrande.setEtiqueta("Monitor");
        cajaPequena.etiqueta = "Raton";//Esta manera de asignar el valor de etiqueta no garantiza <30 carac.

        System.out.println(cajaGrande.etiqueta);
        System.out.println(cajaPequena.etiqueta);

        System.out.println(cajaGrande);
        System.out.println(cajaPequena);
    }
}
