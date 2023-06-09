package dados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.Random;

import combate.Ataque;
import combate.Buff;
import combate.Debuff;
import combate.EfeitoStatus;

public class LeituraCsv {
    /* Retorna o arquivo com nomeArquivo */
    private static BufferedReader abrirArquivo(String nomeArquivo) {
        try {
            return new BufferedReader(new FileReader(nomeArquivo));
        } catch (IOException e) {
            return null;
        }
    }

    /* Fecha o arquivo referenciado pelo BufferedReader br */
    private static void fecharArquivo(BufferedReader br) {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* Le uma linha do arquivo e a retorna */
    private static String lerLinha(BufferedReader br) {
        try {
            return br.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    /*
     * retorna o multiplicador de um elemento sobre o outro
     * PARAMETROS:
     * elementoAtq - elemento da magia
     * elementoDef - elemento do inimigo defendendo
     */
    public static double getMultiplicador(String elementoAtq, String elementoDef) {
        String tabela = "game/resources/efetividade-elementos-varias-linhas.csv";
        String strLinha;
        BufferedReader br = abrirArquivo(tabela);
        lerLinha(br); // pular primeira linha
        while ((strLinha = lerLinha(br)) != null) {
            String[] linha = strLinha.split(","); // separa colunas por ","
            if (linha[0].equals(elementoAtq) && linha[1].equals(elementoDef)) {
                fecharArquivo(br);
                return Double.parseDouble(linha[2]);
            }
        }
        throw new MissingResourceException("Elemento nao existe", "String", elementoAtq);
    }

    /*
     * Retorna uma lista com os ataques do personagem
     * PARAMETROS:
     * - nomePersonagem: nome do personagem
     */
    public static List<Ataque> getAtaques(String nomePersonagem) {
        List<Ataque> listaAtaques = new ArrayList<Ataque>();
        // csv com: [0] personagem, [1] nomeAtaque, [2] multiplicador, [3] habilitado,
        // [4] msgUso
        String tabela = "game/resources/ataques.csv";
        String strLinha;
        BufferedReader br = abrirArquivo(tabela);
        lerLinha(br);
        while ((strLinha = lerLinha(br)) != null) {
            String[] linha = strLinha.split(",");
            if (linha[0].equals(nomePersonagem))
                // replaceAll("]", ",") para deixar msg com vírgula
                listaAtaques.add(new Ataque(linha[1], Boolean.parseBoolean(linha[3]),
                        linha[4].replaceAll("]", ","), Double.parseDouble(linha[2])));
        }
        fecharArquivo(br);
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
        BufferedReader br = abrirArquivo(tabela);
        lerLinha(br);
        while ((strLinha = lerLinha(br)) != null) {
            String[] linha = strLinha.split(",");
            // buff
            if (linha[0].equals(nomePersonagem) && linha[1].equals("buff"))
                // replaceAll("]", ",") para deixar msg com vírgula
                listaEfeitoStatus.add(new Buff(linha[2], Boolean.valueOf(linha[3]),
                                                linha[5].replaceAll("]", ","),
                                                Integer.valueOf(linha[4])));
            // debuff
            else if (linha[0].equals(nomePersonagem))
                listaEfeitoStatus.add(new Debuff(linha[2], Boolean.valueOf(linha[3]),
                                                linha[5].replaceAll("]", ","),
                                                Integer.valueOf(linha[4])));
        }
        fecharArquivo(br);
        return listaEfeitoStatus;
    }

    /*
     * Retorna um vetor com os dados para inicialização do inimigo todos como
     * String,
     * ints precisam ser convertidos
     */
    public static String[] getDadosInimigo(String nomeInimigo) {
        String[] dados = {};
        // csv com: [0] nome, [1] hpMax, [2] def, [3] atq, [4] item, [5] elemento
        String[] elementos = {"fogo", "agua", "vento", "gelo", "natureza", "terra", "eletricidade"};
        String tabela = "game/resources/dados-inimigos.csv";
        String strLinha;
        Random random = new Random();
        BufferedReader br = abrirArquivo(tabela);
        lerLinha(br);
        while ((strLinha = lerLinha(br)) != null) {
            String[] linha = strLinha.split(",");
            if (linha[0].equals(nomeInimigo)) {
                if (! linha[5].equals("random"))
                    dados = linha;
                else {
                    // define elemento aleatorio
                    linha[5] = elementos[Math.abs(random.nextInt()) % 6];
                    dados = linha;
                }
                break;
            }
        }
        fecharArquivo(br);
        return dados;
    }

    /*
     * Retorna uma matriz com as Strings do conteúdo em cada sala,
     * a partir dela inicializamos as salas no mapa
     * PARAMETROS:
     * ordem = ordem da matriz quadrada do mapa
     */
    public static String[][] getDadosSalas(int ordem) {
        String[][] dados = new String[ordem][ordem];
        // csv com o conteúdo da matriz de Salas
        String tabela = "game/resources/dados-salas.csv";
        String strLinha;
        BufferedReader br = abrirArquivo(tabela);
        for (int i = 0; (strLinha = lerLinha(br)) != null; i++)
            dados[i] = strLinha.split(",");
        fecharArquivo(br);
        return dados;
    }
}