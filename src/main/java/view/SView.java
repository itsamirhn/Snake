package view;

import controller.EventListener;
import model.SModel;

import javax.swing.*;
import java.awt.*;

public class SView extends JFrame {

    private final SModel model;
    private final CardLayout cardLayout = new CardLayout();

    private final SMenuBar menuBar = new SMenuBar();
    private final MenuPanel menuPanel = new MenuPanel();
    private GamePanel gamePanel;
    private final PausePanel pausePanel = new PausePanel();
    private final GameOverPanel gameOverPanel = new GameOverPanel();
    private final LeaderboardPanel leaderboardPanel;
    private final JPanel glassPanel;

    private String currentViewName = "";

    public SView(SModel model) {
        super("Snake");
        setLayout(cardLayout);

        this.model = model;
        gamePanel = new GamePanel(model.getGame());
        leaderboardPanel = new LeaderboardPanel(model.getLeaderboard());

        glassPanel = new JPanel();
        glassPanel.setLayout(new GridLayout(1, 1));
        glassPanel.setOpaque(false);

        setJMenuBar(menuBar);
        add(menuPanel, "menu");
        add(gamePanel, "game");
        add(leaderboardPanel, "leaderboard");
        setGlassPane(glassPanel);

        showView("menu");

        pack();

        glassPanel.setBorder(BorderFactory.createEmptyBorder(menuBar.getHeight(), 0, 0, 0));

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showPauseDialog() {
        glassPanel.removeAll();
        glassPanel.add(pausePanel);
        glassPanel.setVisible(true);
    }

    public void hidePauseDialog() {
        glassPanel.removeAll();
        glassPanel.setVisible(false);
    }

    public void showGameOverDialog(String message) {
        glassPanel.removeAll();
        glassPanel.add(gameOverPanel);
        gameOverPanel.setMessage(message);
        glassPanel.setVisible(true);
    }

    private void showView(String viewName) {
        glassPanel.setVisible(false);
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
        leaderboardPanel.setUsers(model.getLeaderboard());
        showView("leaderboard");
    }

    public String getCurrentViewName() {
        return currentViewName;
    }

    public void setButtonListener(EventListener listener) {
        menuPanel.setButtonListener(listener);
        gameOverPanel.setButtonListener(listener);
        menuBar.setButtonListener(listener);
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public LeaderboardPanel getLeaderboardPanel() {
        return leaderboardPanel;
    }

    public SMenuBar getSMenuBar() {
        return menuBar;
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
