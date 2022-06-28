package controller;

import model.Direction;
import model.GameOverException;
import model.SModel;
import view.SView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class GameController {

    private final SModel model;
    private final SView view;
    private boolean paused = false;
    private final Timer snakeTimer = new Timer(Config.getInstance().snakeSpeed, this::move);
    private final Timer foodTimer = new Timer(Config.getInstance().foodSpeed, this::generateFood);

    public GameController(SModel model, SView view) {
        this.model = model;
        this.view = view;
        view.addKeyListener((DirectionListener) this::changeDirection);
        view.addKeyListener((EscapeListener) this::changePauseState);
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

    public void gameOver(GameOverException err) {
        paused = true;
        stopTimers();
        view.showGameOverDialog(err.getMessage());
    }

}
