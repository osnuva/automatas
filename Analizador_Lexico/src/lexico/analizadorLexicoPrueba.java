package lexico;

/**
 * @author Nuñez Vazquez Brandon Osmar
 * @author Torres Gonzalez Jaime Aldair
 */
public class analizadorLexicoPrueba {

    public static void main(String[] args) {
        try {
            analiza anl = new analiza();
            anl.analizar();
            anl.imprimir();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

}
