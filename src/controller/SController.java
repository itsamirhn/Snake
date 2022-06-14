package controller;

import model.Direction;
import model.SModel;
import view.SView;

import javax.swing.*;

public class SController implements DirectionListener {

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

    @Override
    public void directionPressed(Direction direction) {
        model.setDirection(direction);
    }

}
