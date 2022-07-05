package view;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends SPanel {

    public MenuPanel() {
        super();
        setLayout(new GridLayout(4, 1));

        JLabel snakeLabel = new JLabel("SNAKE", SwingConstants.CENTER);
        snakeLabel.setForeground(new Color(151,123,186));
        snakeLabel.setFont(new Font("Arial", Font.BOLD, 30));

        JButton startButton = new JButton("Start");
        startButton.setBackground(new Color(151,123,186));
        startButton.setForeground(Color.BLACK);
        startButton.addActionListener(e -> {
            if (eventListener != null) eventListener.startButtonPressed();
        });
        JButton leaderboardButton = new JButton("Leaderboard");
        leaderboardButton.setBackground(new Color(151,123,186));
        leaderboardButton.setForeground(Color.BLACK);
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
