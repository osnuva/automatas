package afdequivalent;

import javax.swing.JOptionPane;

public class AFD {

    public String alfabeto;
    public int noEstados;
    public String estadoInicial;
    public String estadosFinales;
    public Nodo[] estados;

    public AFD(String alfabeto, int noEstados) {
        this.alfabeto = alfabeto;
        this.noEstados = noEstados;
        this.estadoInicial = "";
        this.estadosFinales = "";
        estados = new Nodo[noEstados];
    }

    public void llenarEstados() {
        for (int i = 0; i < this.noEstados; i++) {
            String name = JOptionPane.showInputDialog("Nombre del Estado No. " + (i + 1));
            boolean ini, fina;
            if (this.estadoInicial.equals("")) {
                ini = JOptionPane.showConfirmDialog(null, "El Estado '" + name
                        + "' ¿Es Inicial?", "Estado " + (i + 1), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                this.estadoInicial = ini ? name : "";
            } else {
                ini = false;
            }

            fina = JOptionPane.showConfirmDialog(null, "El Estado '" + name
                    + "' ¿Es Final?", "Estado " + i, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

            this.estadosFinales += fina ? name + "," : "";

            estados[i] = new Nodo(name, ini, fina);

            estados[i].llenarTransiciones(this.alfabeto);
        }
    }

    public Nodo obtenerNodo(String nombreNodo) {
        Nodo estado = null;
        for (Nodo tmp : this.estados) {
            if (tmp.nombre.equals(nombreNodo)) {
                estado = tmp;
            }
        }
        return estado;
    }

    public Nodo obtenerNodoInicial() {
        Nodo estado = null;
        for (Nodo tmp : this.estados) {
            if (tmp.inicial) {
                estado = tmp;
            }
        }
        return estado;
    }

    public boolean nodoEsFinal(Nodo n) {
        boolean f = false;
        for (Nodo tmp : this.estados) {
            if (n.finall == true) {
                f = true;
            }
        }
        return f;
    }
}
