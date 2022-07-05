package view;

import javax.swing.*;
import java.awt.*;

public class GameOverPanel extends SPanel {

    private final JLabel messageLabel = new JLabel("Good luck next time!", SwingConstants.CENTER);

    public GameOverPanel() {
        super();
        setLayout(new GridLayout(4, 1));

        JLabel titleLabel = new JLabel("Game Over :(", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 45));
        titleLabel.setForeground(new Color(151,123,186));

        messageLabel.setFont(new Font("Arial", Font.BOLD, 30));
        messageLabel.setForeground(Color.WHITE);

        JButton saveButton = new JButton("Save Score");
        saveButton.setBackground(new Color(151,123,186));
        saveButton.setForeground(Color.BLACK);
        saveButton.addActionListener(e -> {
            if (eventListener != null) eventListener.saveScoreButtonPressed();
        });

        JButton restartButton = new JButton("Restart");
        restartButton.setBackground(new Color(151,123,186));
        restartButton.setForeground(Color.BLACK);
        restartButton.addActionListener(e -> {
            if (eventListener != null) eventListener.restartButtonPressed();
        });

        add(titleLabel);
        add(messageLabel);
        add(saveButton);
        add(restartButton);

        setOpaque(false);
    }

    public void setMessage(String message) {
        this.messageLabel.setText(message);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(0, 0, 0, 150));
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}
