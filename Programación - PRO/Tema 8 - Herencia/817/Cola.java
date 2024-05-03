public class Cola extends Lista {
    public void encolar(Integer nuevo) {
        insertarFinal(nuevo);
    }

    public Integer desencolar() {
        return eliminar(0);
    }
}
//Autor: Derimán Tejera Fumero.

