
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author gabriel.max && raphaela.wagner
 */
public class leituraDeArquivo {

    public static void main(String[] args)
            throws FileNotFoundException /*Exceção do FileReader (File not found)*/,
            IOException /*Exceção do readLine (In out exception)*/
    {
        // -- Importar o arquivo .txt --
        // Abre o arquivo
        FileReader arq = new FileReader("matriz5x5.txt");

        // -- Tratar os dados do arquivo --
        // Faz a leitura bufferizada (aperfeiçoada) dos caracteres do arquivo
        BufferedReader arqTratado = new BufferedReader(arq);

        // -- Ler as linhas do arquivo --
        // Lê as linhas do arquivo e armazena em uma lista Float
        ArrayList<String> linhas = new ArrayList<>();
        String linhaArq;
        while ((linhaArq = arqTratado.readLine()) != null) {
            linhas.add(linhaArq);
        }

        // Mostra a leitura até o momento
        for (int i = 0; i < linhas.size(); i++) {
            System.out.println(linhas.get(i));
        }

//        // -- Converter a String linhas em um vetor float --
//        // Divide a string em strings somente com numeros e armazena em um vetor de string
//        String vetStr[]=linha.split(" ");
//        
//        // Cria um vetor de float do mesmo tamanho que o vetor de string vetStr[]
//        float A[] = new float[vetStr.length];
//        
//        // Converte cada posicao do vetor de String vetStr[] para float e atribui no vetor A[]
//        for( int i=0; i < vetStr.length;i++)
//            A[i]=Float.parseFloat(vetStr[i]);
    }
}
