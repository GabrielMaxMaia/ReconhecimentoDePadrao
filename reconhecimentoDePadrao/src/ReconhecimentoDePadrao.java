
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

        // -- Lê o arquivo --
        BufferedReader arquivoBuffer = new BufferedReader(new FileReader(arquivo));
        
        str = arquivoBuffer.readLine();
        System.out.println(str);
        
        vetStr = str.split(" ");

        float matriz[][] = new float[Integer.parseInt(vetStr[0])][Integer.parseInt(vetStr[1])];

        for(int i = 0; i < matriz.length; i++){
            str = arquivoBuffer.readLine();
            vetStr = str.split(" ");
            for(int j = 0; j < matriz[0].length; j++){
                matriz[i][j] = Float.parseFloat(vetStr[j]);
            }
        }
        
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[0].length; j++){
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
