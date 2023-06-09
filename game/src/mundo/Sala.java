package mundo;

import entidades.Inimigo;

public class Sala {
    private boolean jaVisitada;
    private boolean temEscada; // Indica se é possível descer ou subir de andar no mapa
    private String item;    
    private Inimigo inimigo;
    
    public Sala(boolean temEscada, String item, Inimigo inimigo) {
        jaVisitada = false;
        this.temEscada = temEscada;
        this.item = item;
        this.inimigo = inimigo;
    }

    public boolean getJaVisitada() {
        return jaVisitada;
    }

    public void setJaVisitada(boolean jaVisitada) {
        this.jaVisitada = jaVisitada;
    }

    public boolean getTemEscada() {
        return temEscada;
    }

    public void setTemEscada(boolean temEscada) {
        this.temEscada = temEscada;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    
    public Inimigo getInimigo() {
        return inimigo;
    }
    
    public void setInimigo(Inimigo inimigo) {
        this.inimigo = inimigo;
    }
}
