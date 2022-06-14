package controller;

import model.Direction;
import model.SModel;
import view.SView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SController implements DirectionListener {

    private final SModel model = new SModel();
    private final SView view = new SView(model);

    public SController() {
        view.addKeyListener(this);
        Timer t = new Timer(10, this::move);
        t.start();
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

    public void move(ActionEvent e) {
        model.move();
        view.repaint();
    }
}
