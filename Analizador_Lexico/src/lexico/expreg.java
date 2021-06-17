package lexico;

/**
 * @author Nuñez Vazquez Brandon Osmar
 * @author Torres Gonzalez Jaime Aldair
 */
public class expreg implements normas {

    /*
    En cada metodo es donde se aplican las normas o reglas de las expresiones
    regulares, dependiendo de si son mayusculas, minusculas, numeros naturales,
    reservadas, etc. (de acuerdo a la clase anterior)
     */
    public static boolean esMayuscula(char c) {
        String s = String.valueOf(c);

        return s.matches(mayuscula);
    }

    public static boolean esMinuscula(char c) {
        String s = String.valueOf(c);

        return s.matches(minuscula);
    }

    public static boolean esDigito(char c) {
        String s = String.valueOf(c);

        return s.matches(valor);
    }

    public static boolean esPunto(char c) {
        return c == punto;
    }

    public static boolean esGuionBajo(char c) {
        return c == guion_bajo;
    }

    public static boolean espacioBlanco(char c) {
        String s = String.valueOf(c);

        return s.equals("") || s.equals(" ") || s.equals("\n") || s.equals("\t");
    }

    public static boolean esReservada(String cadena) {

        boolean es = false;

        for (String tmp : reservadas) {
            if (tmp.equals(cadena)) {
                es = true;
            }
        }

        return es;
    }

    public static boolean esEspecial(char c) {
        boolean es = false;

        for (char tmp : cespeciales) {

            if (tmp == c) {
                es = true;
            }
        }

        return es;
    }

}
