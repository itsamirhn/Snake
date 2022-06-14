package view;

import model.Body;
import model.Cell;
import model.Element;
import model.Food;

import javax.swing.*;
import java.awt.*;

public class CellPanel extends JPanel {

    public static final Dimension SIZE = new Dimension(5, 5);

    public CellPanel(Cell cell) {
        super(new BorderLayout());
        setPreferredSize(SIZE);
        setBackground(Color.BLACK);
        ElementPanel elementPanel = getElementPanel(cell.getElement());
        if (elementPanel != null) add(elementPanel, BorderLayout.CENTER);
        validate();
    }

    public ElementPanel getElementPanel(Element element) {
        if (element instanceof Food food) {
            return new FoodPanel(food);
        } else if (element instanceof Body body) {
            return new BodyPanel(body);
        }
        return null;
    }
}
