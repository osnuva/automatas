package lexico;

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

public class files {

    String[] lin;
    File files;
    String path = "src/textos/codigo.txt";

    /*
    Metodo que abre el archivo
     */
    public void abrirArchivo() throws FileNotFoundException, IOException {
        files = new File(path);

        if (!files.exists()) {
            System.out.println("Seleccione un archivo...");
            JFileChooser promptFile = new JFileChooser();
            promptFile.setFileFilter(new FileNameExtensionFilter("Documentos", "txt"));
            int option = promptFile.showDialog(null, "Seleccionar");
            //System.out.println(option);
            System.out.println("Nueva ruta: " + promptFile.getSelectedFile().toString());
            System.out.println("");
            files = new File(promptFile.getSelectedFile().toString());
        }
    }

    /*
    Metodo que al igual que el de la clase lecAutoFinNo cuenta las lineas para
    guardarlas con ayuda del siguiente metodo
     */
    private void contarLineas() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(files));
        int i = 0;

        while (br.readLine() != null) {
            i++;
        }
        lin = new String[i];
    }

    /*
    Este metodo guarda esas lineas en un arreglo
     */
    public String[] leerArchivo() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(files));
            String cadena;
            int i = 0;
            contarLineas();

            while ((cadena = br.readLine()) != null) {
                lin[i] = cadena;
                i++;
                //System.out.println(cadena);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return lin;
    }
}
