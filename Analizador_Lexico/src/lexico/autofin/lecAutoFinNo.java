package lexico.autofin;

/**
 * @author Nuñez Vazquez Brandon Osmar
 * @author Torres Gonzalez Jaime Aldair
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class lecAutoFinNo {

    String[] lin;
    File data;
    String path = "src/textos/automata.txt";

    /*
    Este metodo abre el archivo utilizando la direccion de
    donde esta ubicada
     */
    public void abrirArchivo() throws FileNotFoundException, IOException {
        data = new File(path);

        if (!data.exists()) {
            JFileChooser promptFile = new JFileChooser();
            promptFile.setFileFilter(new FileNameExtensionFilter("Documentos", "txt"));
            int option = promptFile.showDialog(null, "Seleccionar");
            System.out.println(option);
            System.out.println(promptFile.getSelectedFile().toString());
            data = new File(promptFile.getSelectedFile().toString());
        }
    }

    /*
    Este metodo sirve para contar cuantas lineas de texto tiene el archivo
     */
    private void contarLineas() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(data));
        int i = 0;

        while (br.readLine() != null) {
            i++;
        }
        lin = new String[i];
    }

    /*
    Este metodo apoyandose del pasado que leia las lineas, guarda esas lineas
    en un arreglo
     */
    public String[] leerArchivo() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(data));
            String cadena;
            int i = 0;
            contarLineas();

            while ((cadena = br.readLine()) != null) {
                lin[i] = cadena;
                i++;
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return lin;
    }
}
