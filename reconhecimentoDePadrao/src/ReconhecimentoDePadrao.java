
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Gabriel.Max
 */
public class ReconhecimentoDePadrao {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String str;
        String vetStr[];
        String arquivo = "matriz5x5.txt";

        //Lê o arquivo
        BufferedReader arquivoBuffer = new BufferedReader(new FileReader(arquivo));
        
        //Lê a primeira linha e imprime a leitura
        str = arquivoBuffer.readLine();
        System.out.println("\n-----------Tamanho da Matriz-----------\n");
        System.out.println(str);
        
        //Separa os valores da leitura em um vetor
        vetStr = str.split(" ");

        //Cria a matriz com os valores da leitura da primeira linha
        float matriz[][] = new float[Integer.parseInt(vetStr[0])][Integer.parseInt(vetStr[1])];

        //Converte e preenche a matriz com os valores
        for(int i = 0; i < matriz.length; i++){
            str = arquivoBuffer.readLine();
            vetStr = str.split(" ");
            for(int j = 0; j < matriz[0].length; j++){
                matriz[i][j] = Float.parseFloat(vetStr[j]);
            }
        }
        
        System.out.println("\n-----------Matriz do Arquivo-----------\n");
        
        //Imprime a matriz float
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[0].length; j++){
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
        }
        
        System.out.println("\n-----------Soma das Linhas-----------\n");
        
        //Cria um vetor com a soma das linhas
        float somaLinha[] = new float[matriz.length];
        
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[0].length; j++){
                somaLinha[i] += matriz[i][j];
            }
        }
        
        //Imprime o vetor com a soma das linhas
        for(float item : somaLinha){
            System.out.println(item);
        }
        
        System.out.println("\n-----------Soma das Colunas-----------\n");
        
        //Cria um vetor com a soma das colunas
        float somaColuna[] = new float[matriz[0].length];
        
        for(int i = 0; i < matriz[0].length; i++){
            for(int j = 0; j < matriz.length; j++){
                somaColuna[i] += matriz[j][i];
            }
        }
        
        //Imprime o vetor com a soma das colunas
        for(float item : somaColuna){
            System.out.println(item);
        }
        
        System.out.println("\n-----------Soma das Linhas Legado-----------\n");
        
        //Soma e imprime cada uma das posições das linhas com a anterior (menos a primeira)
        float somaLinhaLegado[] = new float[somaLinha.length];
        
        for(int i = 0; i < somaLinha.length; i++){
            somaLinhaLegado[i] += somaLinha[i];
            System.out.println(somaLinhaLegado[i]+" - Posição: "+i);
            if(i > 0){
                somaLinhaLegado[i] += somaLinhaLegado[i-1];
                System.out.println(somaLinhaLegado[i]+" - Soma da posição: "+i+" com a posição: "+(i-1)+"\n");
            }
        }
        
        System.out.println("-----------Soma das Colunas Legado-----------\n");
        
        //Soma e imprime cada uma das posições das colunas com a anterior (menos a primeira)
        float somaColunaLegado[] = new float[somaColuna.length];
        
        for(int i = 0; i < somaColuna.length; i++){
            somaColunaLegado[i] += somaColuna[i];
            System.out.println(somaColunaLegado[i]+" - Posição: "+i);
            if(i > 0){
                somaColunaLegado[i] += somaColunaLegado[i-1];
                System.out.println(somaColunaLegado[i]+" - Soma da posição: "+i+" com a posição: "+(i-1)+"\n");
            }
        }
        
        System.out.println("-----------Centro das Linhas Legado-----------\n");
        
        //
        float ultimaPosicao = somaLinhaLegado.length-1;
        float indice[] = new float[somaLinhaLegado.length-2];
        float result[] = new float[somaLinhaLegado.length-2];
        
        
        for(int i = 1; i < somaLinhaLegado.length-1; i++){
            float res = Math.abs((somaLinhaLegado[i-1]) - (somaLinhaLegado[somaLinhaLegado.length-1] - somaLinhaLegado[i]));
            result[i-1] = res;
            indice[i-1] = i;
        }
        
        float menorResultado = result[0];
        float ind = indice[0];
        
        
        for (int i = 0; i < result.length; i++)
            if(result[i]<menorResultado){
                menorResultado=result[i];
                ind = indice[i];
            }
        
        System.out.println("Menor valor das diferenças:"+menorResultado+" - Posição do vetor:"+ind);
    }
}