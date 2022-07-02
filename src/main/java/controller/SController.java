package controller;

import model.SModel;
import view.SView;

import javax.swing.*;
import java.awt.*;

public class SController implements ButtonListener {

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
        if (authController.isAuthenticated()) gameController.saveScore();
        else authController.show();
    }

    @Override
    public void leaderboardButtonPressed() {
        view.showLeaderboard();
    }

    @Override
    public void changeDifficultyPressed(Difficulty difficulty) {
        // TODO
    }

    @Override
    public void changeColorPressed(Color color) {
        // TODO
    }

    @Override
    public void loginAccountPressed() {
        // TODO
    }

    @Override
    public void logoutAccountPressed() {
        // TODO
    }

    @Override
    public void menuGamePressed() {
        view.showMenu();
    }
}
