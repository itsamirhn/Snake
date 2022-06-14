package controller;

import model.SModel;
import view.SView;

import javax.swing.*;

public class SController {

    private final SModel model = new SModel();
    private final SView view = new SView(model);

    public SController() {

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            SController mainController = new SController();
            mainController.getView().setVisible(true);
        });
    }

    public SView getView() {
        return view;
    }

}
