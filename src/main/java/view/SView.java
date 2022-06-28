package view;

import model.SModel;

import javax.swing.*;

public class SView extends JFrame {

    private final SModel model;
    private final GamePanel gamePanel;

    public SView(SModel model) {
        super("Snake");

        this.model = model;

        gamePanel = new GamePanel(model.getGame());
        setContentPane(gamePanel);

        pack();

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showPauseDialog() {
        // TODO
    }

    public void hidePauseDialog() {
        // TODO
    }

    public void showGameOverDialog(String message) {
        //TODO
        JOptionPane.showMessageDialog(this, "Your score is: " + model.getScore());
        System.err.println(message);
    }
}
