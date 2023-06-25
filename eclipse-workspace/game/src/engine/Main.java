package engine;

import java.awt.EventQueue;

import gui.GameFrame;
import gui.GameView;

public class Main {
    public static void main(String[] args) {
        GameView view = new GameView();
        GameController controller = new GameController(view);
        controller.comecarJogo();
    }
}