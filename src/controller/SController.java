package controller;

import model.Direction;
import model.SModel;
import view.SView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SController implements DirectionListener {

    public static final int SPEED = 15;

    public static final int BOARD_WIDTH = 100;
    public static final int BOARD_HEIGHT = 100;

    public static final int SNAKE_STARTING_X = BOARD_WIDTH / 2;
    public static final int SNAKE_STARTING_Y = BOARD_HEIGHT / 2;

    private final SModel model = new SModel(BOARD_WIDTH, BOARD_HEIGHT, SNAKE_STARTING_X, SNAKE_STARTING_Y);
    private final SView view = new SView(model);

    public SController() {
        view.addKeyListener(this);
        Timer t = new Timer(SPEED, this::move);
        t.start();
        Timer tt = new Timer(1000, this::grow);
        tt.start();
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
        if (model.move()) {
            view.repaint();
        }
    }

    public void grow(ActionEvent e) {
        if (model.getSnake().grow()) {
            view.repaint();
        }
    }
}
