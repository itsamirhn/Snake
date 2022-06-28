package view;

import controller.MenuListener;
import model.SModel;

import javax.swing.*;
import java.awt.*;

public class SView extends JFrame {

    private final SModel model;
    private final CardLayout cardLayout = new CardLayout();

    private final MenuPanel menuPanel;
    private final GamePanel gamePanel;
    private final PausePanel pausePanel;

    public SView(SModel model) {
        super("Snake");
        setLayout(cardLayout);

        this.model = model;

        menuPanel = new MenuPanel();
        gamePanel = new GamePanel(model.getGame());
        pausePanel = new PausePanel();

        add(menuPanel, "menu");
        add(gamePanel, "game");
        setGlassPane(pausePanel);

        pack();

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showPauseDialog() {
        pausePanel.setVisible(true);
        repaint();
    }

    public void hidePauseDialog() {
        pausePanel.setVisible(false);
        repaint();
    }

    public void showGameOverDialog(String message) {
        //TODO
        JOptionPane.showMessageDialog(this, "Your score is: " + model.getScore());
        System.err.println(message);
    }

    public void showView(String viewName) {
        cardLayout.show(getContentPane(), viewName);
    }

    public void setMenuListener(MenuListener listener) {
        menuPanel.setMenuListener(listener);
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }
}
