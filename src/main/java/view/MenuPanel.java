package view;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends SPanel {

    public MenuPanel() {
        super();
        setLayout(new GridLayout(4, 1));

        JLabel snakeLabel = new JLabel("SNAKE", SwingConstants.CENTER);
        snakeLabel.setFont(new Font("Arial", Font.BOLD, 50));

        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> {
            if (buttonListener != null) buttonListener.startButtonPressed();
        });
        JButton scoreboardButton = new JButton("Scoreboard");
        scoreboardButton.addActionListener(e -> {
            if (buttonListener != null) buttonListener.scoreboardButtonPressed();
        });

        JLabel aboutLabel = new JLabel("<html>"
                + "Created By: <br>"
                + "AmirMohammad Hosseini Nasab" + ", "
                + "Karo Akhgar" + ", "
                + "MohammadMatin Shaabani"
                + "</html>", SwingConstants.CENTER);
        aboutLabel.setFont(new Font("Arial", Font.PLAIN, 10));

        add(snakeLabel);

        add(startButton);
        add(scoreboardButton);

        add(aboutLabel);

        validate();
    }
}
