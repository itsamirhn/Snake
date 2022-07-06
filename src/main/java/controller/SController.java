package controller;

import model.SModel;
import view.SView;

import javax.swing.*;

public class SController implements EventListener {

    private final SModel model = new SModel();
    private final SView view = new SView(model);

    private final GameController gameController = new GameController(model, view);
    private final AuthController authController = new AuthController(model, view);

    public SController() {
        view.setButtonListener(this);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SController mainController = new SController();
            mainController.view.setVisible(true);
//            mainController.gameController.start(); // Temporary
        });
    }

    public SModel getModel() {
        return model;
    }

    @Override
    public void startButtonPressed() {
        gameController.start();
    }

    @Override
    public void restartButtonPressed() {
        gameController.start();
    }

    @Override
    public void saveScoreButtonPressed() {
        if (!authController.isAuthenticated() && authController.login()) {
            gameController.saveScore();
            JOptionPane.showMessageDialog(view, "Your score has been saved!");
        }
    }

    @Override
    public void leaderboardButtonPressed() {
        view.showLeaderboard();
    }

    @Override
    public void changeDifficultyPressed(Difficulty difficulty) {
        Config.getInstance().setDifficulty(difficulty);
        JOptionPane.showMessageDialog(view, "Difficulty will apply next time you start the game.");
    }

    @Override
    public void loginAccountPressed() {
        authController.login();
    }

    @Override
    public void logoutAccountPressed() {
        authController.logout();
    }

    @Override
    public void menuGamePressed() {
        view.showMenu();
    }
}
