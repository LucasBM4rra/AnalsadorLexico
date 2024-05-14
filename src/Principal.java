import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Principal {

    public static void main(String[] args) throws FileNotFoundException{

        String CaminhoArquivoAnalisado = "";
        String TextoArquivoAnalisado;
        Lexer objetoAnalisadorLexico = new Lexer();

        JFileChooser fileChooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos texto (*.txt)", "txt");
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION){

            File selectedFile = fileChooser.getSelectedFile();

            System.out.println("\n  =====> Arquivo selecionado: " + selectedFile.getAbsolutePath());

            objetoAnalisadorLexico.AnalisadorLexico(selectedFile);
        }
        else{
            System.out.println("Nenhum arquivo selecionado");
        }
    }
}
