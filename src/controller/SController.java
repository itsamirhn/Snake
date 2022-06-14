package controller;

import model.Direction;
import model.SModel;
import view.SView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SController implements DirectionListener {

    public static final int SNAKE_SPEED = 20;
    public static final int FOOD_SPEED = 4000;

    public static final int BOARD_WIDTH = 100;
    public static final int BOARD_HEIGHT = 100;

    public static final int SNAKE_STARTING_X = BOARD_WIDTH / 2;
    public static final int SNAKE_STARTING_Y = BOARD_HEIGHT / 2;

    private final SModel model = new SModel(BOARD_WIDTH, BOARD_HEIGHT, SNAKE_STARTING_X, SNAKE_STARTING_Y);
    private final SView view = new SView(model);

    public SController() {
        view.addKeyListener(this);
        Timer snakeTimer = new Timer(SNAKE_SPEED, this::move);
        snakeTimer.start();

        Timer foodTimer = new Timer(FOOD_SPEED, this::generateFood);
        foodTimer.start();
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

    public void generateFood(ActionEvent e) {
        model.generateFood();
        view.repaint();
    }
}
