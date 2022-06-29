package view;

import javax.swing.*;
import java.awt.*;

public class GameOverPanel extends JPanel {

    private final JLabel messageLabel = new JLabel("Good luck next time!", SwingConstants.CENTER);

    public GameOverPanel() {
        super();
        setLayout(new GridLayout(3, 1));

        JLabel label = new JLabel("GameOver", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 50));
        label.setForeground(Color.WHITE);
        add(label);

        messageLabel.setForeground(Color.WHITE);
        add(messageLabel);

        JButton button = new JButton("Restart");
        add(button);

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
