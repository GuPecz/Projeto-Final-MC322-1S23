package engine;

import java.io.*;

public class Score {
    /* Atributos */
    private static int score;
    private static int inimigosEliminados = 0;
    private static int danoRecebido = 0;
    private static int danoCausado = 0;
    private static int qtdSalasVisitadas = 2; // Contando a sala inicial e a sala final a partir de onde você não se move
    private static int qtdItensColetado = 0;

	public static void incrementarInimigosEliminados() {
        inimigosEliminados++;
    }
    
    public static void incrementarDanoRecebido(int dano) {
        danoRecebido += dano;
    }

    public static void incrementarDanoCausado(int dano) {
        danoCausado += dano;
    }

    public static void incrementarSalasVisitadas() {
        qtdSalasVisitadas++;
    }

    public static void incrementarQtdItensColetado() {
        qtdItensColetado++;
    }

    public static void calcularScore() {
        score = 100 * inimigosEliminados + 20 * (danoCausado - danoRecebido) - 10 * (qtdSalasVisitadas - 40) - 5 * qtdItensColetado;
    }

    public static void escreverScore() {
        Score.calcularScore();
        BufferedWriter output = null;
        String nomeArquivo = "score.txt";
        String texto = String.format("Inimigos eliminados = %d\nDano recebido = %d\nDano causado = %d\nSalas visitadas = %d"
            + "\nItens = %d\n\nScore = %d", inimigosEliminados, danoRecebido, danoCausado, qtdSalasVisitadas, qtdItensColetado, score);
        try {
            output = new BufferedWriter(new FileWriter(new File(nomeArquivo)));
            output.write(texto);
		} catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getDanoCausado() {
        return danoCausado;
    }

    public static int getDanoRecebido() {
        return danoRecebido;
    }

    public static int getInimigosEliminados() {
        return inimigosEliminados;
    }

    public static int getQtdSalasVisitadas() {
        return qtdSalasVisitadas;
    }
    
    public static int getQtdItensColetado() {
		return qtdItensColetado;
	}
}
