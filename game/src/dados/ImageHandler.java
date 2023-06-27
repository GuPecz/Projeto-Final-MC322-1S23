package dados;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ImageHandler {
    public static Icon imagemInimigo(String inimigo) {
        String arquivo = String.format("game/assets/inimigo/%s.png", inimigo);
        Icon imagem = new ImageIcon(arquivo);
        return imagem;
    }
    
    public static Icon imagemItem(String item) {
        String arquivo = String.format("game/assets/inimigo/%s.png", item);
        Icon imagem = new ImageIcon(arquivo);
        return imagem;
    }
}
