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
        
        // Chama o método para mostrar uma lista
        // mostraListaStr(carregarArquivo(arquivo));
        
        converterLista(carregarArquivo(arquivo));
    }

    // Método estático para carregar o arquivo
    public static List<String> carregarArquivo(String arquivo) {
        
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
    
    // Método estático para mostrar todo conteúdo de uma lista
    public static void mostraListaStr(List<String> lista){
        
        // For each percorre toda a lista
        for(String item : lista)
            System.out.println(item);
    }
    
    // -- Converter uma lista do tipo String para o tipo Float --
    
    // Método estático para converte uma lista String em Float
    public static void converterLista(List<String> listaStr){
        List<Float> listaFloat = new ArrayList<>();
        
        // For each percorre toda a lista
        for(String linha : listaStr){
            System.out.println(linha);
            
            // !! Problema para variar o tamanho, assim não percorrendo todo os arrays !!
            
            // Essa variável serviria para ajustar o tamanho do For each
            int tamanho= listaStr.size();
            
            // Esse For each está percorrendo dois índices de cada array e os convertendo
            for(int i = 0; i < 2; i++){
                String linhaArray[] = linha.split(" ");
                System.out.println(linhaArray[i]);
            }
        }
    }
}
