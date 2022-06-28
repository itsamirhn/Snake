package controller;

import model.Direction;
import model.GameOverException;
import model.SModel;
import view.SView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SController {

    private final SModel model = new SModel();
    private final SView view = new SView(model);
    private boolean paused = false;
    private final Timer snakeTimer = new Timer(Config.getInstance().snakeSpeed, this::move);
    private final Timer foodTimer = new Timer(Config.getInstance().foodSpeed, this::generateFoodIfNeeded);

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
            JOptionPane.showMessageDialog(view, model.getGame().getScore());
            gameOver(err);
        }
    }

    public void generateFoodIfNeeded(ActionEvent e) {
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
