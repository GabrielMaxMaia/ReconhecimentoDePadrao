
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Gabriel Max & Raphaela Wagner
 */
public class leituraDeArquivo {

    public static void main(String[] args)
            throws FileNotFoundException /*Exceção do FileReader (File not found)*/,
            IOException /*Exceção do readLine (In out exception)*/ {
        
        // Vai importar o arquivo .txt
        FileReader arquivo = new FileReader("matriz5x5.txt");

        // vai tratar as infos do arquivo
        BufferedReader arquivoTratado = new BufferedReader(arquivo);

        // ler as linhas do arquivo
        String linhas = arquivoTratado.readLine();
        System.out.println(linhas);
        System.out.println();
        
        
        // converter a primeira linha em int
        
        
        
    }

}
