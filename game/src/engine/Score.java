package engine;

import java.io.*;
import java.util.Formatter;

public class Score {
    /* Atributos */
    private static int score;
    private static int inimigosEliminados = 0;
    private static int danoRecebido = 0;
    private static int danoCausado = 0;
    private static int qtdSalasVisitadas = 0;
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
        String nomeArquivo = "score.text";
        Formatter output = null;
        try {
            output = new Formatter(nomeArquivo);
            output.format("Inimimigos eliminados = %d\nDano recebido = %d\nDano causado = %d\nSalas visitadas = %d\n"
            + "\nItens = %d\n\nScore = %d", inimigosEliminados, danoRecebido, danoCausado, qtdSalasVisitadas, qtdItensColetado, score);
            output.flush();
		} catch (IOException e) {
            e.printStackTrace();
        } finally {
            output.close();
        }
    }

    /*
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    */

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
