import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConcatenarNomes {

    public static void main(String[] args) {
        // Nome do arquivo que será criado com a concatenação dos nomes
        String nomeArquivoConcatenado = "NomesCompletos.txt";

        // Cria o arquivo no diretório atual do projeto
        File arquivoConcatenado = new File(nomeArquivoConcatenado);

        try {
            // Abre os arquivos para leitura
            BufferedReader nomesReader = new BufferedReader(new FileReader("ArquivoNomes.txt"));
            BufferedReader sobrenomesReader = new BufferedReader(new FileReader("SobreNomes.txt"));

            // Abre o arquivo para escrita
            BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoConcatenado));

            String nome, sobrenome;
            // Lê cada linha dos arquivos de nomes e sobrenomes, concatena e escreve no arquivo de saída
            while ((nome = nomesReader.readLine()) != null && (sobrenome = sobrenomesReader.readLine()) != null) {
                String nomeCompleto = nome + " " + sobrenome;
                System.out.println(nomeCompleto); // adiciona essa linha para imprimir os nomes e sobrenomes
                writer.write(nomeCompleto);
                writer.newLine();
            }

            // Fecha os arquivos de leitura e escrita
            nomesReader.close();
            sobrenomesReader.close();
            writer.close();

            System.out.println("Nomes completos concatenados com sucesso no arquivo " + nomeArquivoConcatenado);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
