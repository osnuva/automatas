package afdsimplificacion;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class Node {

    String nombre;
    boolean inicial, fina;
    Map<String, String> transiciones;

    public Node(Node n) {
        this(n.getNombre(), n.isInicial(), n.isFina(), n.getTransiciones());
    }

    public Node(String nombre, boolean inicial, boolean fina, Map<String, String> transiciones) {
        this.nombre = nombre;
        this.inicial = inicial;
        this.fina = fina;
        this.transiciones = transiciones;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isInicial() {
        return inicial;
    }

    public boolean isFina() {
        return fina;
    }

    public Map<String, String> getTransiciones() {
        return transiciones;
    }

    public Node(String name, boolean i, boolean f) {
        this.nombre = name;
        this.inicial = i;
        this.fina = f;
        this.transiciones = new HashMap();
    }

    public void llenarTransiciones(String alfabeto) {
        for (String simbolo : alfabeto.split(",")) {
            transiciones.put(simbolo, JOptionPane.showInputDialog(
                    "La transicion de " + this.nombre + " cuando es (" + simbolo + ") va hacia:"));
        }
    }

    public String getTransicionDeSimbolo(String simbolo) {
        return this.transiciones.get(simbolo);
    }
}
