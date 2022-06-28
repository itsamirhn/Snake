package view;

import model.Body;

import java.awt.*;

public class BodyPanel extends ElementPanel {

    int STROKE = 2;
    int ARC_RADIUS = 10;

    public BodyPanel(Body element) {
        super(element);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.GREEN);
        g2d.setStroke(new BasicStroke(STROKE));
        g2d.drawRoundRect(STROKE, STROKE, getWidth() - 2 * STROKE, getHeight() - 2 * STROKE, ARC_RADIUS, ARC_RADIUS);
    }
}
