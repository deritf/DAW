public class Caja {
    private final int ancho;
    private final int alto;
    private final int fondo;
    private final Unidad unidad;
    String etiqueta;

    Caja(int ancho, int alto, int fondo, Unidad unidad) {
        this.ancho = ancho;
        this.alto = alto;
        this.fondo = fondo;
        this.unidad = unidad;
    }

    double getVolumen() {
        if (unidad == Unidad.M) {
            return (ancho * alto * fondo);
        } else {
            return (ancho * alto * fondo) / 1_000_000.0;
        }
    }

    void setEtiqueta(String etiqueta) {
        if (etiqueta.length() > 30) {
            this.etiqueta = etiqueta.substring(0, 30);
        } else {
            this.etiqueta = etiqueta;
        }
    }

    @Override
    public String toString() {
        return ("Medidas de la caja: (ancho->)" + ancho + " (alto->)" + alto + " (fondo->) " + fondo + " Unidad: " + unidad);
    }
}
//Autor: Derimán Tejera Fumero
