package view;

import model.Game;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public GamePanel(Game game) {
        setLayout(new GridLayout(1, 1));
        BoardPanel boardPanel = new BoardPanel(game.getBoard());
        add(boardPanel);
    }
}
