package view;

import model.Body;
import model.Element;
import model.Food;

import javax.swing.*;

public abstract class ElementPanel extends JPanel {
    public ElementPanel(Element element) {
        super();
    }
    public static ElementPanel valueOf(Element element) {
        if (element instanceof Food food) {
            return new FoodPanel(food);
        } else if (element instanceof Body body) {
            return new BodyPanel(body);
        }
        return null;
    }
}
