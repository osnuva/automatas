/*
LENGUAJES Y AUTOMATAS I - EQUIVALENCIA ENTRE DOS AFD's (25-03-20)
Programa No. 02
Alumonos:
NUÑEZ VAZQUEZ BRANDON OSMAR
TORRES GONZALEZ JAIME ALDAIR
 */
package afdsimplificacion;

import javax.swing.JOptionPane;

public class AFDEquivalent {

    AFD m1;
    AFD m2;
    AFD m3;
    String alfabeto;

    public static void main(String[] args) {
        AFDEquivalent e = new AFDEquivalent();

        e.simplificarAFD();
    }

    public void comprobarEquivalencia() {
        Equivalencia eq = new Equivalencia(m1, m2, alfabeto);
        eq.compararAutomatas(m1.obtenerNodoInicial(), m2.obtenerNodoInicial());
    }

    public void simplificarAFD() {
        alfabeto = JOptionPane.showInputDialog("Alfabeto (∑={0,1}):");
        int noEstadosM1 = Integer.parseInt(JOptionPane.showInputDialog("No. de estados del automata:"));
        m3 = new AFD(alfabeto, noEstadosM1);
        m3.llenarEstados();

        Simplificacion sim = new Simplificacion(m3, alfabeto, noEstadosM1);
        sim.simplificarA();

    }
}
