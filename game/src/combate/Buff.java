package combate;

import entidades.Personagem;

public class Buff extends EfeitoStatus {
    /* Construtor */
    public Buff(String nome, boolean habilitado, String msgUso, int aumentoStatus) {
        super(nome, habilitado, msgUso, aumentoStatus);
    }

    /*
     * Buffa o personagem alvo (aumenta o atq e a def em aumentoStatus)
     * PARAMETROS:
     * - personagemAlvo: personagem que receberá o buff
     */
    private void buffar(Personagem personagemAlvo) {
        personagemAlvo.aumentarAtq(getAlteracaoStatus());
        personagemAlvo.aumentarDefesa(getAlteracaoStatus());
    }

    /*
     * Executa o buff (aumenta o atq e a def do usuario em aumentoStatus)
     * PARAMETROS:
     * - usuario: personagem que usou o buff
     * - recebedor: oponente na batalha
     */
    @Override
    public int executar(Personagem usuario, Personagem recebedor) {
        // recebedor só é passado como argumento para sobrescrever
        // o método, não é utilizado para o buff
        buffar(usuario);
        return getAlteracaoStatus();
    }

}
