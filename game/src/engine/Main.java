package engine;

import java.awt.EventQueue;

import gui.GameFrame;

public class Main {
    public static void main(String[] args) {
        GameModel model = new GameModel();
        GameView view = new GameView();
        GameController controller = new GameController(model, view);
        controller.comecarJogo();
    }
}