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
    private final GameOverPanel gameOverPanel;

    private String currentViewName = "";

    public SView(SModel model) {
        super("Snake");
        setLayout(cardLayout);

        this.model = model;

        menuPanel = new MenuPanel();
        gamePanel = new GamePanel(model.getGame());
        pausePanel = new PausePanel();
        gameOverPanel = new GameOverPanel();

        add(menuPanel, "menu");
        add(gamePanel, "game");
        setGlassPane(pausePanel);
        showView("menu");

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
        setGlassPane(gameOverPanel);
        gameOverPanel.setMessage(message);
        gameOverPanel.setVisible(true);
    }

    public void showView(String viewName) {
        currentViewName = viewName;
        cardLayout.show(getContentPane(), viewName);
    }

    public String getCurrentViewName() {
        return currentViewName;
    }

    public void setMenuListener(MenuListener listener) {
        menuPanel.setMenuListener(listener);
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }
}
