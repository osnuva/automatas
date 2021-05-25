package afdsimplificacion;

import javax.swing.JOptionPane;

public class AFD implements Cloneable {

    String alfabeto;
    int noEstados;
    String estadoInicial;
    String estadosFinales;
    Node[] estados;

    public AFD(AFD a) {
        this(a.getAlfabeto(), a.getEstados().length, a.getEstadoInicial(), a.getEstadosFinales(), a.getEstados());
    }

    public AFD(String alfabeto, int noEstados, String ei, String ef, Node[] estados) {
        this.alfabeto = alfabeto;
        this.noEstados = noEstados;
        this.estadoInicial = ei;
        this.estadosFinales = ef;
        this.estados = new Node[this.noEstados];

        for (int i = 0; i < this.noEstados; i++) {
            this.estados[i] = new Node(estados[i]);
        }
    }

    public void setEstadoInicial(String ei) {
        this.estadoInicial = ei;
    }

    public String getAlfabeto() {
        return alfabeto;
    }

    public int getNoEstados() {
        return noEstados;
    }

    public String getEstadoInicial() {
        return estadoInicial;
    }

    public String getEstadosFinales() {
        return estadosFinales;
    }

    public Node[] getEstados() {
        return estados;
    }

    public AFD(String alfabeto, int noEstados) {
        this.alfabeto = alfabeto;
        this.noEstados = noEstados;
        this.estadoInicial = "";
        this.estadosFinales = "";
        estados = new Node[noEstados];
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

            estados[i] = new Node(name, ini, fina);

            estados[i].llenarTransiciones(this.alfabeto);
        }
    }

    public Node obtenerNodo(String nombreNodo) {
        Node estado = null;
        for (Node tmp : this.estados) {
            if (tmp.nombre.equals(nombreNodo)) {
                estado = tmp;
            }
        }
        return estado;
    }

    public Node obtenerNodoInicial() {
        Node estado = null;
        for (Node tmp : this.estados) {
            if (tmp.inicial) {
                estado = tmp;
            }
        }
        return estado;
    }

    public boolean nodoEsFinal(Node n) {
        boolean f = false;
        for (Node tmp : this.estados) {
            if (n.fina == true) {
                f = true;
            }
        }
        return f;
    }

    public boolean eliminarNodo(Node n) {
        boolean eliminado = false;
        try {

            Node[] nn = new Node[noEstados - 1];
            int k = 0;
            for (int i = 0; i < noEstados; i++) {
                if (!estados[i].nombre.equals(n.nombre)) {
                    nn[k] = estados[i];
                    k++;
                } else {
                    eliminado = true;
                }
            }
            estados = nn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eliminado;
    }

    public void imprimirAutomata() {
        for (int i = 0; i < noEstados; i++) {
            String edoTransiciones = "";
            edoTransiciones = ("El estado " + estados[i].nombre + " va hacia --> \n");
            for (String s : this.alfabeto.split(",")) {
                edoTransiciones += (estados[i].transiciones.get(s) + " en " + s + "\n");
            }
            System.out.println(" " + edoTransiciones);
        }
    }
}
