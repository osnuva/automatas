package lexico;

/**
 * @author Nuñez Vazquez Brandon Osmar
 * @author Torres Gonzalez Jaime Aldair
 */
public interface normas {

    /*
    Los siguientes atributos establecen las reglas de las expresiones 
    regulares para el fin de este analizador lexico, ya sea que son mayusculas,
    minusculas, si tiene algun digito, las que son reservadas, los caracteres
    simples o espececiales, los puntos y el guion bajo
     */
    public static String mayuscula = "[A-Z]";
    public static String minuscula = "[a-z]";
    public static String valor = "[0-9]";
    public static String[] reservadas = {"program", "begin", "end"};
    public static char[] cespeciales = {'(', ')', '-', '+', '=', ';', '*'};
    public static char punto = '.';
    public static char guion_bajo = '_';

}
