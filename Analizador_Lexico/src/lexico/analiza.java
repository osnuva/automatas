package lexico;

/**
 * @author Nuñez Vazquez Brandon Osmar
 * @author Torres Gonzalez Jaime Aldair
 */
import lexico.autofin.autoFinNo;
import lexico.autofin.Nodos;
import lexico.info.datos;

public class analiza {

    protected files archivo;
    protected datos errores, identificadores, general, reservadas, especiales,
            digitos;
    protected String[] lineas;
    protected String lexema;
    protected autoFinNo afn;
    protected String estado;
    protected int contReservada = 600;

    /*
    Constructor donde llamamos al metodo archivo, ademas de establecer los datos
    y ademas llamamos a la clase autoFinNo con el fin de checar cada estado
     */
    public analiza() throws Exception {
        this.archivo = new files();
        this.archivo.abrirArchivo();
        this.errores = new datos("Errores");
        this.identificadores = new datos("Identificador");
        this.general = new datos("General");
        this.reservadas = new datos("Reservadas");
        this.especiales = new datos("Especiales");
        this.digitos = new datos("Digitos");
        this.lineas = this.archivo.leerArchivo();
        this.lexema = "";
        this.estado = "q0";
        this.afn = new autoFinNo();
    }

    /*
    En este metodo se analiza cada lexema, como tal su estructura es la siguiente
    tiene dos metodos for, uno para recorrer cada linea, donde en cada vuelta, se
    reinicia el lexema y el estado, ademas de utilizar un nodo temporal (tmp),
    para cambiar cada estado, cuando ya se le la linea entra al segundo for, donde
    dentro de este for hay un ciclo switch donde dependiendo el caso (el estado)
    y las normas ya establecidas va cambiando de estado, al final de cada caso se
    agrega a su dato/lista correspondiente
    
     */
    public void analizar() {
        for (String linea : this.lineas) {
            this.lexema = "";
            this.estado = "q0";
            Nodos tmp = null;
            for (int fin = 0; fin < linea.length(); fin++) {
                switch (this.estado) {
                    case "q0":
                        tmp = this.afn.obtenerNodo("q0");
                        if (expreg.esMayuscula(linea.charAt(fin))) {

                            this.estado = tmp.getTransicionDeSimbolo(expreg.mayuscula);
                            this.lexema += String.valueOf(linea.charAt(fin));

                        } else if (expreg.esMinuscula(linea.charAt(fin))) {

                            this.estado = tmp.getTransicionDeSimbolo(expreg.minuscula);
                            this.lexema += String.valueOf(linea.charAt(fin));

                        } else if (expreg.esEspecial(linea.charAt(fin))) {

                            this.estado = tmp.getTransicionDeSimbolo(String.valueOf(linea.charAt(fin)));
                            this.lexema += String.valueOf(linea.charAt(fin));
                            this.agregarEspecial(linea.charAt(fin));

                        } else if (expreg.esDigito(linea.charAt(fin))) {

                            this.estado = tmp.getTransicionDeSimbolo(expreg.valor);
                            this.lexema += String.valueOf(linea.charAt(fin));

                        } else if (expreg.espacioBlanco(linea.charAt(fin))) {
                            this.estado = "q0";
                        } else {
                            this.lexema += String.valueOf(linea.charAt(fin));
                            this.agregarLista(errores, lexema, 500, "Error");
                            this.lexema = "";
                            this.estado = "q0";
                        }
                        break;

                    case "q1":
                        tmp = this.afn.obtenerNodo("q1");
                        if (expreg.esMayuscula(linea.charAt(fin))) {
                            this.agregarError();
                            fin--;

                        } else if (expreg.esMinuscula(linea.charAt(fin))) {

                            this.estado = tmp.getTransicionDeSimbolo(expreg.minuscula);
                            this.lexema += String.valueOf(linea.charAt(fin));

                        } else if (expreg.esEspecial(linea.charAt(fin))) {

                            this.agregarError();
                            fin--;

                        } else if (expreg.esDigito(linea.charAt(fin))) {

                            this.estado = tmp.getTransicionDeSimbolo(expreg.valor);
                            this.lexema += String.valueOf(linea.charAt(fin));

                        } else if (expreg.esGuionBajo(linea.charAt(fin))) {

                            this.estado = tmp.getTransicionDeSimbolo(String.valueOf(expreg.guion_bajo));
                            this.lexema += String.valueOf(linea.charAt(fin));

                        } else if (expreg.espacioBlanco(linea.charAt(fin))) {

                            this.agregarError();

                        } else {
                            this.agregarError();
                            fin--;
                        }
                        break;

                    case "q2":
                        tmp = this.afn.obtenerNodo("q2");
                        if (expreg.esMinuscula(linea.charAt(fin))) {

                            this.estado = tmp.getTransicionDeSimbolo(expreg.minuscula);
                            this.lexema += String.valueOf(linea.charAt(fin));

                            if (fin == linea.length() - 1) {
                                this.agregarIdentificador();
                            }

                        } else if (expreg.esDigito(linea.charAt(fin))) {

                            this.estado = tmp.getTransicionDeSimbolo(expreg.valor);
                            this.lexema += String.valueOf(linea.charAt(fin));
                            if (fin == linea.length() - 1) {
                                this.agregarIdentificador();
                            }

                        } else if (expreg.esGuionBajo(linea.charAt(fin))) {

                            this.estado = tmp.getTransicionDeSimbolo(String.valueOf(expreg.guion_bajo));
                            this.lexema += String.valueOf(linea.charAt(fin));
                            if (fin == linea.length() - 1) {
                                this.agregarIdentificador();
                            }

                        } else {

                            this.agregarIdentificador();
                            fin--;
                        }
                        break;

                    case "q3":
                        tmp = this.afn.obtenerNodo("q3");
                        if (expreg.esMayuscula(linea.charAt(fin))) {
                            this.agregarError();
                            fin--;

                        } else if (expreg.esMinuscula(linea.charAt(fin))) {

                            this.estado = tmp.getTransicionDeSimbolo(expreg.minuscula);
                            this.lexema += String.valueOf(linea.charAt(fin));
                            if (fin == linea.length() - 1) {
                                this.agregarIdentificador();
                            }

                        } else if (expreg.esEspecial(linea.charAt(fin))) {

                            this.agregarError();
                            fin--;

                        } else if (expreg.esDigito(linea.charAt(fin))) {

                            this.estado = tmp.getTransicionDeSimbolo(expreg.valor);
                            this.lexema += String.valueOf(linea.charAt(fin));
                            if (fin == linea.length() - 1) {
                                this.agregarIdentificador();
                            }

                        } else if (expreg.esGuionBajo(linea.charAt(fin))) {

                            this.estado = tmp.getTransicionDeSimbolo(String.valueOf(expreg.guion_bajo));
                            this.lexema += String.valueOf(linea.charAt(fin));
                            if (fin == linea.length() - 1) {
                                this.agregarError();
                            }

                        } else if (expreg.espacioBlanco(linea.charAt(fin))) {

                            this.agregarError();

                        } else {
                            this.agregarError();
                            fin--;
                        }
                        break;

                    case "q4":
                        tmp = this.afn.obtenerNodo("q4");
                        if (expreg.esMinuscula(linea.charAt(fin))) {

                            this.estado = tmp.getTransicionDeSimbolo(expreg.minuscula);
                            this.lexema += String.valueOf(linea.charAt(fin));
                            if (fin == linea.length() - 1) {
                                this.agregarPalabra();
                            }

                        } else {
                            this.agregarPalabra();
                            fin--;

                        }
                        break;

                    case "q5":
                        tmp = this.afn.obtenerNodo("q5");
                        if (expreg.esDigito(linea.charAt(fin))) {

                            this.estado = tmp.getTransicionDeSimbolo(expreg.valor);
                            this.lexema += String.valueOf(linea.charAt(fin));
                            if (fin == linea.length() - 1) {
                                this.agregarDigito("Entero", 257);
                            }

                        } else if (expreg.esPunto(linea.charAt(fin))) {

                            this.estado = tmp.getTransicionDeSimbolo(String.valueOf(expreg.punto));
                            this.lexema += String.valueOf(linea.charAt(fin));

                        } else {
                            this.agregarDigito("Entero", 257);
                            fin--;
                        }
                        break;

                    case "q6":
                        tmp = this.afn.obtenerNodo("q6");
                        if (expreg.esDigito(linea.charAt(fin))) {

                            this.estado = tmp.getTransicionDeSimbolo(expreg.valor);
                            this.lexema += String.valueOf(linea.charAt(fin));
                            if (fin == linea.length() - 1) {
                                this.agregarDigito("Flotante", 258);
                            }

                        } else {
                            this.agregarError();
                            fin--;
                        }
                        break;

                    case "q7":
                        tmp = this.afn.obtenerNodo("q7");
                        if (expreg.esDigito(linea.charAt(fin))) {

                            this.estado = tmp.getTransicionDeSimbolo(expreg.valor);
                            this.lexema += String.valueOf(linea.charAt(fin));
                            if (fin == linea.length() - 1) {
                                this.agregarDigito("Flotante", 258);
                            }

                        } else {
                            this.agregarDigito("Flotante", 258);
                            fin--;
                        }
                        break;
                }
            }
        }
    }

    /*
    Este metodo imprime cada lista o dato
     */
    public void imprimir() {
        this.identificadores.imprimir();
        System.out.println("");
        this.reservadas.imprimir();
        System.out.println("");
        this.digitos.imprimir();
        System.out.println("");
        this.especiales.imprimir();
        System.out.println("");
        this.general.imprimir();
        this.errores.imprimir();
        System.out.println("");
    }

    /*
    Este metodo va agregando a la lista los lexemas especiales/simples, ademas
    se va agregando a la lista general dependiendo como los va leyendo
     */
    private void agregarEspecial(char c) {
        this.agregarLista(especiales, lexema, (int) c, "Caracter especial");
        this.agregarLista(general, lexema, (int) c, "Caracter especial");
        this.lexema = "";
        this.estado = "q0";
    }

    /*
    Este metodo va agregando a la lista los lexemas de numeros naturales, ademas
    se va agregando a la lista general dependiendo como los va leyendo
     */
    private void agregarDigito(String clasificacion, int atributo) {
        this.agregarLista(digitos, lexema, atributo, clasificacion);
        this.agregarLista(general, lexema, atributo, clasificacion);
        this.lexema = "";
        this.estado = "q0";
    }

    /*
    Este metodo va agregando a la lista los lexemas de palabras reservadas,
    ademas se va agregando a la lista general dependiendo como los va leyendo
     */
    private void agregarPalabra() {
        if (expreg.esReservada(lexema)) {
            this.agregarLista(reservadas, lexema, contReservada, "Palabra reservada");
            this.agregarLista(general, lexema, contReservada++, "Palabra reservada");
            this.lexema = "";
            this.estado = "q0";
        } else {
            this.agregarError();
        }
    }

    /*
    Metodo que añade el identificador si es reservada, simple, etc.
     */
    private void agregarIdentificador() {
        this.agregarLista(identificadores, lexema, 295, "Identificador");
        this.agregarLista(general, lexema, 295, "Identificador");
        this.lexema = "";
        this.estado = "q0";
    }

    /*
    Lista que se imprime en caso de que el analizador lexico detecte errores
     */
    private void agregarError() {
        this.agregarLista(errores, lexema, 500, "Error");
        this.lexema = "";
        this.estado = "q0";
    }

    /*
    Metodo que establece cada token, recibe como parametro la lista, cadena,
    el atributo y su clasificacion. 
     */
    private void agregarLista(datos lista, String cadena,
            int atributo, String clasificacion) {
        tokens token = new tokens(cadena, atributo, clasificacion);
        lista.capturar(token);
    }

}
