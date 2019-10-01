
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Gabriel.Max
 */
public class ReconhecimentoDePadrao {

    public static void main(String[] args) throws IOException {

        //Escolhe o arquivo a ser carregado
        String arquivo = "matriz5x5.txt";
        
        //Ativa as saídas para consulta no terminal
        boolean ativarSaidas = false;

        //Carrega o arquivo e salva em uma matriz
        float matriz[][] = carregarArquivo(arquivo);

        //Saída para consulta
        if (ativarSaidas) {
            //Imprime a matriz float
            System.out.println("\n-----------Matriz do Arquivo-----------\n");
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println("");
            }
        }

        //Soma as linhas da matriz
        float somaLinha[] = somarSequencia("linha", matriz);

        //Saída para consulta
        if (ativarSaidas) {
            //Imprime o vetor com a soma das linhas
            System.out.println("\n-----------Soma das Linhas-----------\n");
            for (float item : somaLinha) {
                System.out.println(item);
            }
        }

        //Soma as colunas da matriz
        float somaColuna[] = somarSequencia("coluna", matriz);

        //Saída para consulta
        if (ativarSaidas) {
            //Imprime o vetor com a soma das colunas
            System.out.println("\n-----------Soma das Colunas-----------\n");
            for (float item : somaColuna) {
                System.out.println(item);
            }
        }

        //Soma cada índice do vetor de linhas com o anterior
        float vetorLinhaLegado[] = somarLegado(somaLinha);

        //Saída para consulta
        if (ativarSaidas) {
            //Imprime o vetor com a soma das linhas legado
            System.out.println("\n-----------Soma das Linhas Legado-----------\n");
            for (float f : vetorLinhaLegado) {
                System.out.println(f);
            }
        }

        //Soma cada índice do vetor de colunas com o anterior
        float vetorColunaLegado[] = somarLegado(somaColuna);

        //Saída para consulta
        if (ativarSaidas) {
            //Imprime o vetor com a soma das colunas legado
            System.out.println("-----------Soma das Colunas Legado-----------\n");
            for (float f : vetorColunaLegado) {
                System.out.println(f);
            }
        }

        //Exibe o resultado do centro de gravidade
        System.out.println("-----------Centro de Gravidade-----------\n");

        //Descobre o centro do vetor de linhas e colunas
        System.out.println("Linha");
        int centroLinha = descobrirCentro(vetorLinhaLegado);
        System.out.println("Coluna");
        int centroColuna = descobrirCentro(vetorColunaLegado);
        System.out.println("Linha:" + centroLinha + " - Coluna:" + centroColuna);

    }

    private static float[][] carregarArquivo(String arquivo) throws FileNotFoundException, IOException {

        String str;
        String vetStr[];

        //Lê o arquivo
        BufferedReader arquivoBuffer = new BufferedReader(new FileReader(arquivo));

        //Lê a primeira linha e imprime a leitura
        str = arquivoBuffer.readLine();

        //System.out.println("\n-----------Tamanho da Matriz-----------\n");
        //System.out.println(str);
        
        //Separa os valores da leitura em um vetor
        vetStr = str.split(" ");

        //Cria a matriz com os valores da leitura da primeira linha
        float matriz[][] = new float[Integer.parseInt(vetStr[0])][Integer.parseInt(vetStr[1])];

        //Converte e preenche a matriz com os valores
        for (int i = 0; i < matriz.length; i++) {
            str = arquivoBuffer.readLine();
            vetStr = str.split(" ");
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = Float.parseFloat(vetStr[j]);
            }
        }

        return matriz;
    }

    private static float[] somarSequencia(String tipo, float matriz[][]) {

        if (tipo.equals("linha")) {

            //Cria um vetor com a soma das linhas
            float linhaSomada[] = new float[matriz.length];

            for (int i = 0; i < matriz.length; i++) 
                for (int j = 0; j < matriz[0].length; j++) 
                    linhaSomada[i] += matriz[i][j];

            return linhaSomada;

        } else if (tipo.equals("coluna")) {

            //Cria um vetor com a soma das colunas
            float colunaSomada[] = new float[matriz[0].length];

            for (int i = 0; i < matriz[0].length; i++) 
                for (int j = 0; j < matriz.length; j++) 
                    colunaSomada[i] += matriz[j][i];

            return colunaSomada;

        } else {
            return null;
        }
    }

    private static float[] somarLegado(float vetor[]) {

        //Cria um vetor com a soma de cada índice com o anterior
        float vetorLegado[] = new float[vetor.length];

        for (int i = 0; i < vetor.length; i++) {
            vetorLegado[i] += vetor[i];
            if (i > 0) {
                vetorLegado[i] += vetorLegado[i - 1];
            }
        }

        return vetorLegado;
    }

    private static int descobrirCentro(float vetor[]) {

        //Cria dois vetores para guardar os índices e os valores
        float indice[] = new float[vetor.length - 2];
        float result[] = new float[vetor.length - 2];

        //Percorre o vetor recebido calculando a diferença entre os lados
        for (int i = 1; i < vetor.length - 1; i++) {
            float res = Math.abs((vetor[i - 1]) - (vetor[vetor.length - 1] - vetor[i]));
            result[i - 1] = res;
            indice[i - 1] = i;
        }

        //Variáveis para salvar os resultados
        float menorResultado = result[0];
        float ind = indice[0];

        //Separa qual o menor resultado
        for (int i = 0; i < result.length; i++)
            if (result[i] < menorResultado) {
                menorResultado = result[i];
                ind = indice[i] + 1;
            }

        System.out.println("Menor resutado:" + menorResultado + " - Posição:" + ind + "\n");

        //Arredonda o resultado e passa para um inteiro
        int centro = Math.round(ind);

        return centro;
    }
}