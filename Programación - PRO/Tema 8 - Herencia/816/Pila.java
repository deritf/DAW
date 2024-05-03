public class Pila extends Lista {
    void apilar(Integer nuevo) {
        insertarPrincipio(nuevo);
    }

    Integer desapilar() {
        return eliminar(0);
    }
}

//Autor: Derimán Tejera Fumero.






