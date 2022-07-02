package controller;

import model.Cell;
import model.Direction;
import model.GameOverException;
import model.SModel;
import view.SView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Stack;

public class GameController {

    private final SModel model;
    private final SView view;
    private boolean paused = false;
    private final Timer snakeTimer = new Timer(1_000 / Config.getInstance().snakeFPS, this::run);
    private final Stack<Direction> directionStack = new Stack<>();

    public GameController(SModel model, SView view) {
        this.model = model;
        this.view = view;
        bindKeys();
    }

    private void setCellListeners() {
        int width = model.getGame().getBoard().getWidth();
        int height = model.getGame().getBoard().getHeight();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Cell modelCell = model.getGame().getBoard().getCell(x, y);
                int finalX = x;
                int finalY = y;
                modelCell.setListener(cell -> view.getGamePanel().getBoardPanel().getCellPanel(finalX, finalY).repaint());
            }
        }
    }

    private void setSnakeListener() {
        model.getGame().setSnakeListener(food -> {
            // TODO: Play Sound
            view.getGamePanel().updateScoreLabel();
        });
    }

    public void setListeners() {
        setCellListeners();
        setSnakeListener();
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
            if (direction == model.getGame().getSnake().getDirection() || direction == model.getGame().getSnake().getDirection().getOpposite()) return;
            directionStack.push(direction);
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
    }

    public void stopTimers() {
        snakeTimer.stop();
    }

    public void run(ActionEvent e) {
        if (paused) return;
        try {
            if (!directionStack.isEmpty()) model.changeDirection(directionStack.pop());
            model.run();
        } catch (GameOverException err) {
            gameOver(err);
        }
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
        model.createNewGame();
        view.createNewGamePanel();
        setListeners();
        show();
        resume();
    }

    public void show() {
        view.showGame();
    }

}
