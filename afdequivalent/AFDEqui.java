/*
  LENGUAJES Y AUTOMATAS I - EQUIVALENCIA ENTRE DOS AFD's (17-05-21)
 ALUMNOS:
   NUÑEZ VAZQUEZ BRANDON OSMAR
   TORRES GONZALEZ JAIME ALDAIR
 */
package afdequivalent;

import javax.swing.JOptionPane;

public class AFDEqui {

    public AFD m1;
    public AFD m2;
    public String alfabeto;

    public static void main(String[] args) {
        AFDEqui e = new AFDEqui();
        e.inicio();
        e.cEquivalencia();
    }

    public void inicio() {
        alfabeto = JOptionPane.showInputDialog("Alfabeto (∑={0,1}):");
        int noEstM1 = Integer.parseInt(JOptionPane.showInputDialog("No. de estados M1:"));
        m1 = new AFD(alfabeto, noEstM1);
        m1.llenarEstados();

        int noEstM2 = Integer.parseInt(JOptionPane.showInputDialog("No. de estados M2 :"));
        m2 = new AFD(alfabeto, noEstM2);
        m2.llenarEstados();
    }

    public void cEquivalencia() {
        Equi eq = new Equi(m1, m2, alfabeto);
        eq.compararAutomatas(m1.obtenerNodoInicial(), m2.obtenerNodoInicial());
    }
}
