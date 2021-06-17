package lexico.autofin;

/**
 * @author Nuñez Vazquez Brandon Osmar
 * @author Torres Gonzalez Jaime Aldair
 */
import java.util.Map;
import java.util.HashMap;

public class Nodos {

    protected String nom;
    protected boolean ini, finall;
    protected Map<String, String> transiciones;

    /*
    Metodo que inicializa el Hashmap para utilizarlo con las transiciones
     */
    public Nodos() {
        this.transiciones = new HashMap();
    }

    /*
    Constructor de la clase
     */
    public Nodos(String name, boolean i, boolean f) {
        this.nom = name;
        this.ini = i;
        this.finall = f;
        this.transiciones = new HashMap();
    }

    /*
    Este metodo establece la transicion en un arreglo
     */
    public void setNuevaTransicion(String data) {
        String[] tmp = data.split("#");
        this.transiciones.put(tmp[0], tmp[1]);
    }

    /*
    Este metodo devuelve los simbolos de las transiciones que recibe como 
    parametro el String simbolo
     */
    public String getTransicionDeSimbolo(String simbolo) {
        return this.transiciones.get(simbolo);
    }

    /*
    Este metodo establece el nombre de los estados que recibe como parametro 
    el String nombre(Estado)
     */
    public void setNombre(String nombre) {
        this.nom = nombre;
    }

    /*
    Este metodo establece el nodo inicial que recibe como parametro el dato 
    inicial (Estado)
     */
    public void setInicial(boolean inicial) {
        this.ini = inicial;
    }

    /*
    Este metodo establece el nodo final que recibe como parametro el dato fina
    (Estado)
     */
    public void setFina(boolean fina) {
        this.finall = fina;
    }

    /*
    Este metodo establece las trancisicones que recibe como parametro los
    valores del hashmap
     */
    public void setTransiciones(Map<String, String> transiciones) {
        this.transiciones = transiciones;
    }

    /*
    Metodo que retorna el nombre de los estados
     */
    public String getNombre() {
        return nom;
    }

    /*
    Metodo que retorna si el estado es inicial
     */
    public boolean isInicial() {
        return ini;
    }

    /*
    Metodo que retorna si el estado es final
     */
    public boolean isFina() {
        return finall;
    }

    /*
    Metodo que retorna las transiciones
     */
    public Map<String, String> getTransiciones() {
        return transiciones;
    }
}
