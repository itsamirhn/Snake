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
        setJMenuBar(createMenuBar());

        this.model = model;
        setJMenuBar(createMenuBar());
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
        setGlassPane(pausePanel);
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

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu setting = new JMenu("Setting");
        JMenu difficulty = new JMenu("Difficulty");
        JMenu snakeColor = new JMenu("Color");

        JRadioButtonMenuItem easy = new JRadioButtonMenuItem("Easy");
        JRadioButtonMenuItem normal = new JRadioButtonMenuItem("Normal");
        JRadioButtonMenuItem hard = new JRadioButtonMenuItem("Hard");
        ButtonGroup difficultyGroup = new ButtonGroup();
        difficultyGroup.add(easy);
        difficultyGroup.add(normal);
        difficultyGroup.add(hard);
        normal.setSelected(true);

        JMenuItem blueColor = new JMenuItem("Blue");
        JMenuItem greenColor = new JMenuItem("Green");
        JMenuItem pinkColor = new JMenuItem("Pink");


        menuBar.add(setting);
        setting.add(difficulty);
        setting.add(snakeColor);
        difficulty.add(easy);
        difficulty.add(normal);
        difficulty.add(hard);
        snakeColor.add(blueColor);
        snakeColor.add(greenColor);
        snakeColor.add(pinkColor);

        return menuBar;
    }


    public String showAuth() {
        return JOptionPane.showInputDialog(this, "Username:");
    }

}
