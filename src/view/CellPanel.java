package view;

import model.Body;
import model.Cell;
import model.Element;
import model.Food;

import javax.swing.*;
import java.awt.*;

public class CellPanel extends JPanel {

    public static final Dimension SIZE = new Dimension(5, 5);

    private final Cell cell;

    public CellPanel(Cell cell) {
        super(new BorderLayout());
        this.cell = cell;
        setPreferredSize(SIZE);
        setBackground(Color.BLACK);
        validate();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        removeAll();
        ElementPanel elementPanel = ElementPanel.valueOf(cell.getElement());
        if (elementPanel != null) {
            elementPanel.setSize(SIZE);
            add(elementPanel, BorderLayout.CENTER);
        }
    }
}
