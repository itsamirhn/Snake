package view;

import controller.ButtonListener;
import model.SModel;

import javax.swing.*;
import java.awt.*;

public class SView extends JFrame {

    private final SModel model;
    private final CardLayout cardLayout = new CardLayout();

    private final MenuPanel menuPanel;
    private GamePanel gamePanel;
    private final PausePanel pausePanel;
    private final GameOverPanel gameOverPanel;
    private final LeaderboardPanel leaderboardPanel;

    private String currentViewName = "";

    public SView(SModel model) {
        super("Snake");
        setLayout(cardLayout);

        this.model = model;

        menuPanel = new MenuPanel();
        gamePanel = new GamePanel(model.getGame());
        pausePanel = new PausePanel();
        gameOverPanel = new GameOverPanel();
        leaderboardPanel = new LeaderboardPanel(model.getLeaderboard());

        add(menuPanel, "menu");
        add(gamePanel, "game");
        add(leaderboardPanel, "leaderboard");
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
        repaint();
    }

    private void showView(String viewName) {
        getGlassPane().setVisible(false);
        currentViewName = viewName;
        cardLayout.show(getContentPane(), viewName);
        repaint();
    }

    public void showMenu() {
        showView("menu");
    }
    public void showGame() {
        showView("game");
    }

    public void showLeaderboard() {
        showView("leaderboard");
    }

    public String getCurrentViewName() {
        return currentViewName;
    }

    public void setButtonListener(ButtonListener listener) {
        menuPanel.setButtonListener(listener);
        gameOverPanel.setButtonListener(listener);
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void createNewGamePanel() {
        remove(gamePanel);
        gamePanel = new GamePanel(model.getGame());
        add(gamePanel, "game");
        repaint();
    }

    public String showAuth() {
        return JOptionPane.showInputDialog(this, "Username:");
    }

}
