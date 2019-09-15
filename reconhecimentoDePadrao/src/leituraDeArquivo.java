import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabriel.max && raphaela.wagner
 */
public class leituraDeArquivo {

    public static void main(String[] args)
            throws FileNotFoundException /*Exceção do FileReader (File not found)*/,
            IOException /*Exceção do readLine (In out exception)*/ {

        // -- Definir qual arquivo será usado --
        String arquivo = "matriz5x5.txt";
        
        //System.out.println(carregarArquivo());
    }

    // Método para carregar o arquivo
    private List<String> carregarArquivo(String arquivo) {
        
        // Cria um objeto da classe Lista onde será armazenado os valores String
        List<String> conteudo = new ArrayList<>();
        
        // -- Ler as linhas do arquivo --
        try (BufferedReader arquivoBuffer = new BufferedReader(new FileReader(arquivo))) {
            String str;
            // Lê as linhas do arquivo e armazena na lista String
            while ((str = arquivoBuffer.readLine()) != null) {
                conteudo.add(str);
            }
            // Fecha o arquivo após a leitura
            arquivoBuffer.close();
            
        } catch (IOException ioe) {
            // Caso falhe o carregamento a mensagem de erro do sistema será exibida
            System.out.println(ioe);
        }
        
        // Retorna a Lista String com o conteúdo do arquivo
        return conteudo;
    }
}
