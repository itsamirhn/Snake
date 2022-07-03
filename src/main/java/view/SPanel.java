package view;

import controller.EventListener;

import javax.swing.*;

public class SPanel extends JPanel {
    protected EventListener eventListener;

    public void setButtonListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }
}
