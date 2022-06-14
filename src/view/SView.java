package view;

import model.SModel;

import javax.swing.*;

public class SView extends JFrame {
    public SView(SModel model) {
        super("Snake");
        add(new BoardPanel(model.getBoard()));
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
