package combate;

import entidades.Personagem;

public class Debuff extends EfeitoStatus {
    
    public Debuff(String nome, boolean habilitado, String msgUso, int reducaoAtq, int reducaoDef) {
        super(nome, habilitado, msgUso, reducaoAtq, reducaoDef);
    }

    public void debuffar(Personagem personagemAlvo) {
        personagemAlvo.reduzirAtq(getAlteracaoAtq());
        personagemAlvo.reduzirDefesa(getAlteracaoDef());
    }

    @Override
    public void usar(Personagem usuario, Personagem recebedor) {
        debuffar(recebedor);
    }

}
