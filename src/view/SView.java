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

        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public BoardPanel getBoardPanel() {
        return boardPanel;
    }

    public void hidePauseDialog() {
        // TODO
    }

    public void showPauseDialog() {
        // TODO
    }
}
