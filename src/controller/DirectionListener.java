package controller;

import model.Direction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public interface DirectionListener extends KeyListener {

    void directionPressed(Direction direction);

    @Override
    default void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_UP -> directionPressed(Direction.UP);
            case KeyEvent.VK_DOWN -> directionPressed(Direction.DOWN);
            case KeyEvent.VK_LEFT -> directionPressed(Direction.LEFT);
            case KeyEvent.VK_RIGHT -> directionPressed(Direction.RIGHT);
        }
    }

    @Override
    default void keyReleased(KeyEvent e) {
        // Not Used
    }

    @Override
    default void keyTyped(KeyEvent e) {
        // Not Used
    }
}
