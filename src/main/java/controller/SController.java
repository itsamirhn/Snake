package controller;

import model.SModel;
import view.SView;

import javax.swing.*;

public class SController implements ButtonListener {

    private final SModel model = new SModel();
    private final SView view = new SView(model);

    private final GameController gameController = new GameController(model, view);

    public SController() {
        view.setButtonListener(this);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SController mainController = new SController();
            mainController.view.setVisible(true);
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
        gameController.restart();
    }

    @Override
    public void saveScoreButtonPressed() {

    }

    @Override
    public void scoreboardButtonPressed() {

    }
}
