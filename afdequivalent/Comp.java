package afdequivalent;

public class Comp {

    public String nombreColumna;
    public final Nodo nodos[] = new Nodo[2];

    public Comp(String nombreColumna, Nodo estado1, Nodo estado2) {
        this.nombreColumna = nombreColumna;
        nodos[0] = estado1;
        nodos[1] = estado2;
    }

    public Nodo[] getEstadosColumna(String nombreColumna) {
        return this.nodos;
    }

}
