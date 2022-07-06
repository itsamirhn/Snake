package view;

import model.*;

import javax.swing.*;
import java.awt.*;

public abstract class ElementGraphics {

    static int BODY_STROKE = 5;
    static int BODY_ARC_RADIUS = 10;

    public static void draw(JComponent container, Graphics2D g2d, Element element) {
        if(element instanceof BonusFood bonusFood){
            drawBonusFood(container, g2d, bonusFood);
        } else if (element instanceof Food food) {
            drawFood(container, g2d, food);
        } else if (element instanceof Head head) {
            drawHead(container, g2d, head);
        } else if (element instanceof Body body) {
            drawBody(container, g2d, body);
        } else if (element instanceof Block block) {
            drawBlock(container, g2d, block);
        }
    }

    private static void drawBlock(JComponent container, Graphics2D g2d, Block block) {
        g2d.setColor(Color.GRAY);
        g2d.fillRect(0, 0, container.getWidth(), container.getHeight());
    }

    private static void drawBody(JComponent container, Graphics2D g2d, Body body) {
        g2d.setColor(new Color(151,123,186).darker());
        g2d.setStroke(new BasicStroke(BODY_STROKE));
        g2d.drawRoundRect(BODY_STROKE, BODY_STROKE, container.getWidth() - 2 * BODY_STROKE, container.getHeight()- 2 * BODY_STROKE, BODY_ARC_RADIUS, BODY_ARC_RADIUS);
    }

    private static void drawHead(JComponent container, Graphics2D g2d, Head head) {
        g2d.setColor(new Color(151,123,186));
        g2d.setStroke(new BasicStroke(BODY_STROKE));
        g2d.drawRoundRect(BODY_STROKE, BODY_STROKE, container.getWidth() - 2 * BODY_STROKE, container.getHeight()- 2 * BODY_STROKE, BODY_ARC_RADIUS, BODY_ARC_RADIUS);
    }

    private static void drawFood(JComponent container, Graphics2D g2d, Food food) {
        g2d.setColor(Color.RED);
        int radius = Math.min(container.getWidth(), container.getHeight()) / 2;
        g2d.fillOval(container.getWidth() / 2 - radius, container.getHeight() / 2 - radius, 2 * radius, 2 * radius);
    }
    private static void drawBonusFood(JComponent container, Graphics2D g2d, BonusFood bonusFood) {
        g2d.setColor(Color.YELLOW);
        int radius = Math.min(container.getWidth(), container.getHeight()) / 2;
        int currentRadius = (int) (bonusFood.getAgeRatio() * radius);
        g2d.fillOval(container.getWidth() / 2 - currentRadius, container.getHeight() / 2 - currentRadius, 2 * currentRadius, 2 * currentRadius);
    }

}
