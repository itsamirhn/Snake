package view;

import model.Game;

import javax.swing.*;

public class GamePanel extends JPanel {

    public GamePanel(Game game) {
        setLayout(new OverlayLayout(this));

        BoardPanel boardPanel = new BoardPanel(game.getBoard());
        add(boardPanel);
    }
}
