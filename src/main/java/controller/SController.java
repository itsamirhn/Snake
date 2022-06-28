package controller;

import model.SModel;
import view.SView;

import javax.swing.*;

public class SController {

    private final SModel model = new SModel();
    private final SView view = new SView(model);

    private final GameController gameController = new GameController(model, view);

    public SController() {

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SController mainController = new SController();
            mainController.view.setVisible(true);
            mainController.gameController.startTimers();
        });
    }

}
