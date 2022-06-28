package view;

import model.Body;
import model.Food;

import java.awt.*;

public class FoodPanel extends ElementPanel {

    int RADIUS = 10;
    public FoodPanel(Food element) {
        super(element);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.RED);
        g2d.fillOval(getWidth() / 2 - RADIUS, getHeight() / 2 - RADIUS, 2 * RADIUS, 2 * RADIUS);
    }
}
