package lexico.info;

/**
 * @author Nuñez Vazquez Brandon Osmar
 * @author Torres Gonzalez Jaime Aldair
 */

import lexico.tokens;

public class datos {

    protected Nodo inicio, fin;
    protected String tipo;

    /*
    Constructor de la clase
     */
    public datos() {
        inicio = fin = null;
        this.tipo = null;
    }

    public datos(String tipo) {
        inicio = fin = null;
        this.tipo = tipo;
    }

    /*
    Metodo que captura un token donde se le asigna un nuevo nodo ya dependiendo
    si es inicial o no.
     */
    public void capturar(tokens token) {
        Nodo nuevo = new Nodo(token);
        if (inicio == null) {
            inicio = fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }

    /*
    Metodo que imprime todos los nodos que se encuentren en la lista
     */
    public void imprimir() {
        Nodo temp;
        temp = inicio;
        System.out.println(this.tipo);
        System.out.println("Palabra\t    |Tipo\t    |Atributo");
        while (temp != null) {
            String s = temp.toString();
            System.out.println(s);
            temp = temp.getSiguiente();
        }
    }

    /*
    Este metodo manda la cantidad de nodos que hay
     */
    public int size() {
        Nodo temp;
        temp = inicio;
        int cont = 0;
        while (temp != null) {
            cont++;
            temp = temp.getSiguiente();
        }
        return cont;
    }
}
