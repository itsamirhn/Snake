package controller;

import model.Direction;
import model.GameOverException;
import model.SModel;
import view.SView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SController {

    public static final int SNAKE_SPEED = 125;
    public static final int FOOD_SPEED = 100;

    public static final int BOARD_WIDTH = 20;
    public static final int BOARD_HEIGHT = 20;

    public static final int SNAKE_STARTING_X = BOARD_WIDTH / 2;
    public static final int SNAKE_STARTING_Y = BOARD_HEIGHT / 2;

    private final SModel model = new SModel(BOARD_WIDTH, BOARD_HEIGHT, SNAKE_STARTING_X, SNAKE_STARTING_Y);
    private final SView view = new SView(model);
    private boolean paused = false;
    private final Timer snakeTimer = new Timer(SNAKE_SPEED, this::move);
    private final Timer foodTimer = new Timer(FOOD_SPEED, this::generateFoodIfNeeded);

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
        try {
            if (model.move()) view.repaint();
        } catch (GameOverException err) {
            gameOver(err);
        }
    }

    public void generateFoodIfNeeded(ActionEvent e) {
        model.generateFoodIfNeeded();
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

    public void gameOver(GameOverException err) {
        paused = true;
        stopTimers();
        view.showGameOverDialog(err.getMessage());
    }

}
