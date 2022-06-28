package view;

import model.SModel;

import javax.swing.*;

public class SView extends JFrame {
    private final BoardPanel boardPanel;

    public SView(SModel model) {
        super("Snake");

        boardPanel = new BoardPanel(model.getBoard());
        add(boardPanel);

        pack();

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public BoardPanel getBoardPanel() {
        return boardPanel;
    }

    public void showPauseDialog() {
        // TODO
    }

    public void hidePauseDialog() {
        // TODO
    }

    public void showGameOverDialog(String message) {
        // TODO
        System.err.println(message);
    }
}
