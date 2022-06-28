package view;

import javax.swing.*;
import java.awt.*;

public class PausePanel extends JPanel {
    public PausePanel() {
        super();
        setLayout(new GridLayout(2, 1));

        JLabel label = new JLabel("Paused", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 50));
        label.setForeground(Color.WHITE);
        add(label);

        label = new JLabel("Press Escape key to continue", SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        add(label);

        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(250, 250, 250, 80));
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}
