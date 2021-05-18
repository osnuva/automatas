package afdequivalent;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class Nodo {

    public String nombre;
    public boolean inicial, finall;
    public Nodo apu;
    public Map<String, String> transi;

    public Nodo(String name, boolean i, boolean f) {
        this.nombre = name;
        this.inicial = i;
        this.finall = f;
        this.transi = new HashMap();
    }

    public void llenarTransiciones(String alfabeto) {
        for (String simbolo : alfabeto.split(",")) {
            transi.put(simbolo, JOptionPane.showInputDialog(
                    "La transicion de " + this.nombre + " cuando es (" + simbolo + ") va hacia:"));
        }
    }

    public String getTransicion(String sim) {
        return this.transi.get(sim);
    }
}
