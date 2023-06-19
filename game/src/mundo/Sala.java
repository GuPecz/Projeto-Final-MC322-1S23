package mundo;

import entidades.Inimigo;

public class Sala {
    
    private int id; // Índice na matriz linearizada para exibição na UI
    private String item;    
    private Inimigo inimigo;
    
    public Sala(int id) {
        this.id = id;
        this.item = null;
        this.inimigo = null;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
