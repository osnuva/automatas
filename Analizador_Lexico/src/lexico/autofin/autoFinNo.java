package lexico.autofin;

/**
 * @author Nuñez Vazquez Brandon Osmar
 * @author Torres Gonzalez Jaime Aldair
 */
import java.io.IOException;

public class autoFinNo implements Cloneable {

    protected String alfa, eIni, eFin;
    protected int nmoEstados;
    protected Nodos[] estados;
    protected lecAutoFinNo leer;
    protected String[] lin;
    protected int index = 0;

    /*
    Metodo para abrir el archivo de texto
     */
    public autoFinNo() {
        this.leer = new lecAutoFinNo();
        try {
            this.leer.abrirArchivo();
        } catch (IOException e) {
            e.getMessage();
        }

        this.lin = this.leer.leerArchivo();
        this.asignarValores();
    }

    /*
    Constructor de la clase
     */
    public autoFinNo(String alfabeto, int noEstados) {
        this.alfa = alfabeto;
        this.nmoEstados = noEstados;
        this.eIni = "";
        this.eFin = "";
        estados = new Nodos[noEstados];
    }

    /*En este metodo
    Se asignan los valores en respecto a como estan en el archivo de texto,
    donde tenemos el primer if que checa el numero de estados, el estado inicial
    el estado final y coloca en el estado las transiciones
     */
    private void asignarValores() {
        for (int i = 0; i < lin.length; i++) {
            if (i == 0) {
                this.alfa = lin[i];
            }

            if (i == 1) {
                this.nmoEstados = Integer.parseInt(lin[i]);
                this.estados = new Nodos[this.nmoEstados];
            }

            if (i == 2) {
                this.eIni = lin[i];
            }

            if (i == 3) {
                this.eFin = lin[i];
            }

            if (i > 3) {
                this.llenarEstado(lin[i], index++);
            }

        }
    }

    /*
    En este metodo se llenan todas las transiciones de acuerdo al ultimo if del
    del metodo pasado  
     */
    private void llenarEstado(String linea, int index) {
        estados[index] = new Nodos();
        String[] tmpData = linea.split("@");
        String[] infoEstado = tmpData[1].split(",");
        estados[index].setNombre(tmpData[0]);
        for (int j = 0; j < infoEstado.length; j++) {
            if (j == 0) {
                estados[index].setInicial(infoEstado[j].equals("1"));
            }
            if (j == 1) {
                estados[index].setFina(infoEstado[j].equals("1"));
            }
            if (j > 1) {
                estados[index].setNuevaTransicion(infoEstado[j]);
            }
        }
    }

    /*
    En este metodo simplemente se obtienen los nodos utilizando un ciclo for
     */
    public Nodos obtenerNodo(String nombreNodo) {
        Nodos estado = null;
        for (Nodos tmp : this.estados) {
            if (tmp.getNombre().equals(nombreNodo)) {
                estado = tmp;
            }
        }
        return estado;
    }

    /*
    En este metodo se obtiene el nodo inicial utilizando un ciclo for
     */
    public Nodos obtenerNodoInicial() {
        Nodos estado = null;
        for (Nodos tempo : this.estados) {
            if (tempo.ini) {
                estado = tempo;
            }
        }
        return estado;
    }

    /*
    Metodo que utilizando un ciclo for se denomina si un nodo es final
     */
    public boolean nodoEsFinal(Nodos n) {
        boolean f = false;
        for (Nodos tempo : this.estados) {
            if (n.finall == true) {
                f = true;
            }
        }
        return f;
    }

    /*
    Metodo que elimina los nodos
     */
    public boolean eliminarNodo(Nodos n) {
        boolean eliminado = false;
        try {
            Nodos[] nn = new Nodos[nmoEstados - 1];
            int k = 0;
            for (int i = 0; i < nmoEstados; i++) {
                if (!estados[i].nom.equals(n.nom)) {
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

    /*
    Metodo que establece el estado inicial por ello recibe el parametro String
    ei(Estado inicial)
     */
    public void setEstadoInicial(String ei) {
        this.eIni = ei;
    }

    /*
    Metodo que retorna el alfabeto
     */
    public String getAlfabeto() {
        return alfa;
    }

    /*
    Metodo que retorna la cantidad de estados
     */
    public int getNoEstados() {
        return nmoEstados;
    }

    /*
    Metodo que retorna el estado inicial
     */
    public String getEstadoInicial() {
        return eIni;
    }

    /*
    Metodo que retorna los estados finales
     */
    public String getEstadosFinales() {
        return eFin;
    }

    /*
    Metodo que retorna los estados en un arreglo
     */
    public Nodos[] getEstados() {
        return estados;
    }

    /*
    Metodo que imprime el automata
     */
    public void imprimirAutomata() {
        for (int i = 0; i < nmoEstados; i++) {
            String edoTransiciones = "";
            edoTransiciones = ("El estado " + estados[i].getNombre() + " va hacia --> \n");
            for (String s : this.alfa.split(",")) {
                String es = estados[i].getTransicionDeSimbolo(s);
                if (es != null) {
                    edoTransiciones += (es + " en " + s + "\n");
                }
            }
            System.out.println(" " + edoTransiciones);
        }
    }
}
