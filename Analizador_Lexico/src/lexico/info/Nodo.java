package lexico.info;

/**
 * @author Nuñez Vazquez Brandon Osmar
 * @author Torres Gonzalez Jaime Aldair
 */

import lexico.tokens;

public class Nodo {

    protected tokens token;
    protected Nodo siguiente;

    /*
   Constructor de la clase
     */
    public Nodo(tokens token) {
        this.token = token;
        siguiente = null;
    }

    /*
   Metodo que retorna el token
     */
    public tokens getToken() {
        return token;
    }

    /*
    Metodo que retorna el siguiente nodo
     */
    public Nodo getSiguiente() {
        return siguiente;
    }

    /*
    Metodo que establece el token
     */
    public void setToken(tokens token) {
        this.token = token;
    }

    /*
    Metodo que establece el siguiente nodo
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    /*
    Metodo sobrecargado para imprimir el token
     */
    @Override
    public String toString() {
        return this.token.toString();
    }
}
