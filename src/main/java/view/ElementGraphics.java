package view;

import model.Body;
import model.Element;
import model.Food;

import javax.swing.*;
import java.awt.*;

public abstract class ElementGraphics {

    static int BODY_STROKE = 5;
    static int BODY_ARC_RADIUS = 10;
    static int FOOD_RADIUS = 10;

    public static void draw(JComponent container, Graphics2D g2d, Element element) {
        if (element instanceof Food) {
            drawFood(container, g2d);
        } else if (element instanceof Body) {
            drawBody(container, g2d);
        }
    }

    private static void drawBody(JComponent container, Graphics2D g2d) {
        g2d.setColor(Color.GREEN);
        g2d.setStroke(new BasicStroke(BODY_STROKE));
        g2d.drawRoundRect(BODY_STROKE, BODY_STROKE, container.getWidth() - 2 * BODY_STROKE, container.getHeight()- 2 * BODY_STROKE, BODY_ARC_RADIUS, BODY_ARC_RADIUS);
    }

    private static void drawFood(JComponent container, Graphics2D g2d) {
        g2d.setColor(Color.RED);
        g2d.fillOval(container.getWidth() / 2 - FOOD_RADIUS, container.getHeight() / 2 - FOOD_RADIUS, 2 * FOOD_RADIUS, 2 * FOOD_RADIUS);
    }

}
