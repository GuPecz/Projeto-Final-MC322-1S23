package dados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import combate.Ataque;
import combate.Buff;
import combate.Debuff;
import combate.EfeitoStatus;

/* TODO - implementacoes estao parecidas, deve dar pra reutilizar, boa sorte se alguem for tentar */

public class CsvHandler {
    /*
     * retorna o multiplicador de um elemento sobre o outro
     * PARAMETROS:
     * elementoAtq - elemento da magia
     * elementoDef - elemento do inimigo defendendo
     */
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

    /*
     * Retorna uma lista com os ataques do personagem
     * PARAMETROS:
     * - nomePersonagem: nome do personagem
     */
    public static List<Ataque> getAtaques(String nomePersonagem) {
        List<Ataque> listaAtaques = new ArrayList<Ataque>();
        // csv com: [0] personagem, [1] nomeAtaque, [2] multiplicador, [3] habilitado, [4] msgUso
        String tabela = "game/resources/ataques.csv";
        String strLinha;
        try (BufferedReader br = new BufferedReader(new FileReader(tabela))) {
            br.readLine(); // pular primeira linha
            while ((strLinha = br.readLine()) != null) {
                String[] linha = strLinha.split(",");
                if (linha[0].equals(nomePersonagem))
                    // replaceAll("]", ",") para deixar msg com vírgula
                    listaAtaques.add(new Ataque(linha[1], Boolean.parseBoolean(linha[3]), 
                        linha[4].replaceAll("]", ","), Double.parseDouble(linha[2])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaAtaques;
    }

    /*
     * Retorna uma lista com os efeitos de status do personagem
     * PARAMETROS:
     * - nomePersonagem: nome do personagem
     */
    public static List<EfeitoStatus> getEfeitosStatus(String nomePersonagem) {
        List<EfeitoStatus> listaEfeitoStatus = new ArrayList<EfeitoStatus>();
        // csv com: [0] personagem, [1] tipoEfeito, [2] nomeEfeito, [3] habilitado,
        // [4] alteracaoStatus, [5] msgUso
        String tabela = "game/resources/efeitos-status.csv";
        String strLinha;
        try (BufferedReader br = new BufferedReader(new FileReader(tabela))) {
            br.readLine(); // pular primeira linha
            while ((strLinha = br.readLine()) != null) {
                String[] linha = strLinha.split(",");
                // buff
                if (linha[0].equals(nomePersonagem) && linha[1].equals("buff"))
                    // replaceAll("]", ",") para deixar msg com vírgula
                    listaEfeitoStatus.add(new Buff(linha[2].replaceAll("]", ","),
                        Boolean.valueOf(linha[3]), linha[5], Integer.valueOf(linha[4])));
                // debuff
                else if (linha[0].equals(nomePersonagem))
                    listaEfeitoStatus.add(new Debuff(linha[2].replaceAll("]", ","),
                        Boolean.valueOf(linha[3]), linha[5], Integer.valueOf(linha[4])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaEfeitoStatus;
    }

}
