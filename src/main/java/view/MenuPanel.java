package view;

import utilitis.SUtils;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends SPanel {

    public MenuPanel() {
        super();
        setLayout(new GridLayout(4, 1));

        ImageIcon gameIcon = new ImageIcon(SUtils.getIconPath());
        Image image = gameIcon.getImage();
        Image resizedImage = image.getScaledInstance(120, 120,  Image.SCALE_SMOOTH);
        gameIcon = new ImageIcon(resizedImage);
        JLabel snakeLabel = new JLabel("SNAKE", gameIcon, SwingConstants.CENTER);
        snakeLabel.setFont(new Font("Arial", Font.BOLD, 50));

        JButton startButton = new JButton("Start");
        startButton.setBackground(new Color(151,123,186));
        startButton.setForeground(Color.BLACK);
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
