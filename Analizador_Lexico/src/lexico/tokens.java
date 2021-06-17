package lexico;

/**
 * @author Nuñez Vazquez Brandon Osmar
 * @author Torres Gonzalez Jaime Aldair
 */
public class tokens {

    protected String lexema;
    protected int atributo;
    protected String clasificacion;

    /*
    Constructor de la clase
     */
    public tokens(String lexema, int atributo, String clasificacion) {
        this.lexema = lexema;
        this.atributo = atributo;
        this.clasificacion = clasificacion;
    }

    /*
    Metodo que retorna el lexema
     */
    public String getLexema() {
        return lexema;
    }

    /*
    Metodo que establece el lexema
     */
    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    /*
    Metodo que obtiene el atributo de cada lexema
     */
    public int getAtributo() {
        return atributo;
    }

    /*
    Metodo que coloca el atributo de cada lexema
     */
    public void setAtributo(int atributo) {
        this.atributo = atributo;
    }

    /*
    Metodo que retorna la clasificacion de cada lexema
     */
    public String getClasficacion() {
        return clasificacion;
    }

    /*
    Metodo que coloca la clasificacion de cada lexema
     */
    public void setClasficacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    /*
    Metodo sobrecargado que imprime la informacion anterior
     */
    @Override
    public String toString() {
        return "|   " + lexema + "\t|  " + clasificacion + "\t|(" + String.valueOf(atributo) + ")";
    }

}
