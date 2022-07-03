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
            if (eventListener != null) eventListener.startButtonPressed();
        });
        JButton leaderboardButton = new JButton("Leaderboard");
        leaderboardButton.addActionListener(e -> {
            if (eventListener != null) eventListener.leaderboardButtonPressed();
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
        add(leaderboardButton);

        add(aboutLabel);

        validate();
    }
}
