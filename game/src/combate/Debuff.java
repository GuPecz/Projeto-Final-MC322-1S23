package combate;

import entidades.Personagem;

public class Debuff extends EfeitoStatus {
    /* Construtor */
    public Debuff(String nome, boolean habilitado, String msgUso, int reducaoStatus) {
        super(nome, habilitado, msgUso, reducaoStatus);
    }

    /*
     * Deuffa o personagem alvo (reduz o atq e a def em aumentoStatus)
     * PARAMETROS:
     * - personagemAlvo: personagem que receberá o debuff
     */
    public void debuffar(Personagem personagemAlvo) {
        personagemAlvo.reduzirAtq(getAlteracaoStatus());
        personagemAlvo.reduzirDefesa(getAlteracaoStatus());
    }

    /*
     * Executa o debuff (reduz o atq e a def do usuario em aumentoStatus)
     * PARAMETROS:
     * - usuario: personagem que usou o debuff
     * - recebedor: personagem que receberá o debuff
     */
    @Override
    public String executar(Personagem usuario, Personagem recebedor) {
        // usuario só é passado como argumento para sobrescrever
        // o método, não é utilizado para o debuff
        debuffar(recebedor);
        return getMsgUso();
    }

}
