package mundo;

import entidades.Inimigo;
import itens.Item;

public class Sala {
    
    private int id; // Índice na matriz linearizada para exibição na UI
    private Item item;
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
}
