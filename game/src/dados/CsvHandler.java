package dados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvHandler {
    public static double getMultiplicador(String elementoAtq, String elementoDef) {
        String tabela = "game/resources/efetividade-elementos-varias-linhas.csv";
        String strLinha;
        try (BufferedReader br = new BufferedReader(new FileReader(tabela))) {
            br.readLine(); // pular primeira linha
            while ((strLinha = br.readLine()) != null) {
                String[] linha = strLinha.split(","); // separa colunas por ","
                if (linha[0].equals(elementoAtq) && linha[1].equals(elementoDef))
                    return Double.parseDouble(linha[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0.;
    }

    public static void main(String[] args) {
        System.out.println(getMultiplicador("agua", "fogo"));
    }
}
