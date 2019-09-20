import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author gabriel.max && raphaela.wagner
 */
public class lerMatriz {

    public static void main(String[] args)
            throws FileNotFoundException /*Exceção do FileReader (File not found)*/,
            IOException /*Exceção do readLine (In out exception)*/ {

        // -- Definir qual arquivo será usado --
        String arquivo = "matriz5x5.txt";

        // Chama o método para mostrar um array
        mostraArray(carregarArquivo(arquivo));
    }

    // Método estático para carregar o arquivo
    public static float[] carregarArquivo(String arquivo) throws FileNotFoundException, IOException {

        BufferedReader arquivoBuffer = new BufferedReader(new FileReader(arquivo));
        // Lê as linhas do arquivo e armazena na lista String
        String str = arquivoBuffer.readLine();
        String vetStr[];
        for(int i = 0; str != null; i++)
             vetStr[i] = str;

        float A[] = new float[vetStr.length];
        
        for (int j = 0; j < vetStr.length; j++)
            A[j] = Float.parseFloat(vetStr[j]);

        // Fecha o arquivo após a leitura
        arquivoBuffer.close();

        return A;
    }

    // Método estático para mostrar todo conteúdo de um array
    public static void mostraArray(float[] A) {
        // For each percorre toda a lista
        for (float item : A) {
            System.out.println(item);
        }
    }
}