package view;

import utilitis.SUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class MenuPanel extends SPanel {

    public MenuPanel() {
        super();
        setLayout(new GridLayout(4, 1));

        JLabel snakeLabel = new JLabel("Snake", SwingConstants.CENTER);
        snakeLabel.setFont(new Font("Arial", Font.BOLD, 50));

        try {
            ImageIcon gameIcon = new ImageIcon(ImageIO.read(SUtils.getIconAsStream()));
            Image image = gameIcon.getImage();
            Image resizedImage = image.getScaledInstance(120, 120,  Image.SCALE_SMOOTH);
            gameIcon = new ImageIcon(resizedImage);
            snakeLabel.setIcon(gameIcon);
        } catch (Exception e) {
            e.printStackTrace();
        }



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
