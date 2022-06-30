package controller;

import model.Direction;
import model.GameOverException;
import model.SModel;
import view.SView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class GameController {

    private final SModel model;
    private final SView view;
    private boolean paused = false;
    private final Timer snakeTimer = new Timer(Config.getInstance().snakeSpeed, this::move);
    private final Timer foodTimer = new Timer(Config.getInstance().foodSpeed, this::generateFood);
    private final Timer bonusFoodTimer = new Timer(Config.getInstance().bonusFoodSpeed, this::generateBonusFood);

    public GameController(SModel model, SView view) {
        this.model = model;
        this.view = view;
        bindKeys();
    }

    private void bindKeys() {
        view.getRootPane().getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "escapedPressed");
        view.getRootPane().getActionMap().put("escapedPressed", new EscapeAction());

        view.getRootPane().getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "upPressed");
        view.getRootPane().getActionMap().put("upPressed", new DirectionAction(Direction.UP));

        view.getRootPane().getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "downPressed");
        view.getRootPane().getActionMap().put("downPressed", new DirectionAction(Direction.DOWN));

        view.getRootPane().getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "leftPressed");
        view.getRootPane().getActionMap().put("leftPressed", new DirectionAction(Direction.LEFT));

        view.getGamePanel().getRootPane().getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "rightPressed");
        view.getGamePanel().getRootPane().getActionMap().put("rightPressed", new DirectionAction(Direction.RIGHT));
    }

    public void saveScore() {
        model.setScore();
    }

    public class DirectionAction extends AbstractAction {
        private final Direction direction;
        public DirectionAction(Direction direction) {
            this.direction = direction;
        }

        public void changeDirection(Direction direction) {
            if (paused) return;
            model.changeDirection(direction);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.getCurrentViewName().equals("game")) changeDirection(direction);
        }
    }

    public class EscapeAction extends AbstractAction {

        public void changePauseState() {
            if (paused) resume(); else pause();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.getCurrentViewName().equals("game")) changePauseState();
        }
    }


    public void startTimers() {
        snakeTimer.start();
        foodTimer.start();
        bonusFoodTimer.start();
    }

    public void stopTimers() {
        snakeTimer.stop();
        foodTimer.stop();
        bonusFoodTimer.stop();
    }

    public void move(ActionEvent e) {
        if (paused) return;
        try {
            if (model.move()) view.getGamePanel().repaint();
        } catch (GameOverException err) {
            gameOver(err);
        }
    }

    public void generateFood(ActionEvent e) {
        if (paused) return;
        model.generateFood();
        view.getGamePanel().repaint();
    }
    public void generateBonusFood(ActionEvent e) {
        if (paused) return;
//        System.out.println(bonusFoodTimer.getDelay());
        model.generateBonusFood();
        view.getGamePanel().repaint();
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

    public void start() {
        show();
        resume();
    }

    public void restart() {
        model.createNewGame();
        view.createNewGamePanel();
        start();
    }

    public void show() {
        view.showGame();
    }

}
