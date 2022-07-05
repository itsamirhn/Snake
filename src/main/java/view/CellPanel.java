package view;

import controller.Config;
import model.Cell;

import javax.swing.*;
import java.awt.*;

public class CellPanel extends JPanel {

    public static int DOT_RADIUS = 1;

    private final Cell cell;

    public CellPanel(Cell cell) {
        this.cell = cell;
        setPreferredSize(Config.getInstance().getCellDimension());
        setBackground(Color.BLACK);
        validate();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.GRAY);
        g2d.fillOval(- DOT_RADIUS, - DOT_RADIUS, 2 * DOT_RADIUS, 2 * DOT_RADIUS);
        g2d.fillOval(getWidth() - DOT_RADIUS, - DOT_RADIUS, 2 * DOT_RADIUS, 2 * DOT_RADIUS);
        g2d.fillOval(- DOT_RADIUS, getHeight() - DOT_RADIUS, 2 * DOT_RADIUS, 2 * DOT_RADIUS);
        g2d.fillOval(getWidth() - DOT_RADIUS, getHeight() - DOT_RADIUS, 2 * DOT_RADIUS, 2 * DOT_RADIUS);

        ElementGraphics.draw(this, g2d, cell.getElement());
    }
}
