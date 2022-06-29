package view;

import controller.ButtonListener;

import javax.swing.*;

public class SPanel extends JPanel {
    protected ButtonListener buttonListener;

    public void setButtonListener(ButtonListener buttonListener) {
        this.buttonListener = buttonListener;
    }
}
