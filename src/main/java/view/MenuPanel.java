package view;

import controller.MenuListener;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    private MenuListener menuListener;

    private JLabel aboutLabel = new JLabel("Created By: "
            + "AmirMohammad Hosseini Nasab" + ", "
            + "Karo Akhgar" + ", "
            + "MohammadMatin Shaabani"
            , SwingConstants.CENTER);
    public MenuPanel() {
        super();
        setLayout(new GridLayout(4, 1));

        JLabel snakeLabel = new JLabel("SNAKE", SwingConstants.CENTER);
        snakeLabel.setFont(new Font("Arial", Font.BOLD, 50));

        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> {
            if (menuListener != null) menuListener.startButtonPressed();
        });
        JButton scoreboardButton = new JButton("Scoreboard");
        scoreboardButton.addActionListener(e -> {
            if (menuListener != null) menuListener.scoreboardButtonPressed();
        });

        add(snakeLabel);

        add(startButton);
        add(scoreboardButton);

        add(aboutLabel);

        validate();
    }

    public void setMenuListener(MenuListener menuListener) {
        this.menuListener = menuListener;
    }
}
