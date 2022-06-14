package controller;

import model.Direction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public interface EscapeListener extends KeyListener {

    void escapedPressed();

    @Override
    default void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_ESCAPE) {
            escapedPressed();
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
