package view;

import model.Body;
import model.Cell;
import model.Element;
import model.Food;

import javax.swing.*;
import java.awt.*;

public class CellPanel extends JPanel {

    public static final Dimension SIZE = new Dimension(20, 20);

    private final Cell cell;

    private ElementPanel elementPanel;

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
        if (elementPanel != null) remove(elementPanel);
        elementPanel = ElementPanel.valueOf(cell.getElement());
        if (elementPanel != null) add(elementPanel, BorderLayout.CENTER);
        revalidate();
    }
}
