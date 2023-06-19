package combate;

import entidades.Personagem;

public class Buff extends EfeitoStatus {
    
    public Buff(String nome, boolean habilitado, String msgUso, int aumentoAtq, int aumentoDef) {
        super(nome, habilitado, msgUso, aumentoAtq, aumentoDef);
    }

    public void buffar(Personagem personagemAlvo) {
        personagemAlvo.aumentarAtq(getAlteracaoAtq());
        personagemAlvo.aumentarDefesa(getAlteracaoDef());
    }

    @Override
    public void usar(Personagem usuario, Personagem recebedor) {
        buffar(usuario);
    }

}
