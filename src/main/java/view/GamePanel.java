package view;

import model.Game;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private final Game game;
    private final BoardPanel boardPanel;
    private final JLabel scoreLabel = new JLabel("Score: 0", SwingConstants.CENTER);

    public GamePanel(Game game) {
        this.game = game;

        setBackground(Color.BLACK);
        setLayout(new BorderLayout(0, 5));

        scoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        scoreLabel.setForeground(Color.WHITE);

        boardPanel = new BoardPanel(game.getBoard());

        add(scoreLabel, BorderLayout.NORTH);
        add(boardPanel, BorderLayout.CENTER);
    }

    public BoardPanel getBoardPanel() {
        return boardPanel;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        scoreLabel.setText("Score: " + game.getScore());
    }
}
