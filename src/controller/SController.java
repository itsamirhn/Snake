package controller;

import model.Direction;
import model.SModel;
import view.SView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SController {

    public static final int SNAKE_SPEED = 30;
    public static final int FOOD_SPEED = 4000;

    public static final int BOARD_WIDTH = 100;
    public static final int BOARD_HEIGHT = 100;

    public static final int SNAKE_STARTING_X = BOARD_WIDTH / 2;
    public static final int SNAKE_STARTING_Y = BOARD_HEIGHT / 2;

    private final SModel model = new SModel(BOARD_WIDTH, BOARD_HEIGHT, SNAKE_STARTING_X, SNAKE_STARTING_Y);
    private final SView view = new SView(model);
    private boolean paused = false;
    private final Timer snakeTimer = new Timer(SNAKE_SPEED, this::move);
    private final Timer foodTimer = new Timer(FOOD_SPEED, this::generateFood);

    public SController() {
        view.addKeyListener((DirectionListener) this::changeDirection);
        view.addKeyListener((EscapeListener) this::changePauseState);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SController mainController = new SController();
            mainController.getView().setVisible(true);
            mainController.startTimers();
        });
    }

    public SView getView() {
        return view;
    }

    public void changeDirection(Direction direction) {
        if (paused) return;
        model.changeDirection(direction);
    }

    public void changePauseState() {
        if (paused) resume(); else pause();
    }

    public void startTimers() {
        snakeTimer.start();
        foodTimer.start();
    }

    public void stopTimers() {
        snakeTimer.stop();
        foodTimer.stop();
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

    public void pause() {
        paused = true;
        stopTimers();
        view.showPauseDialog();
    }

    public void resume() {
        paused = false;
        view.hidePauseDialog();
        startTimers();
    }

}
