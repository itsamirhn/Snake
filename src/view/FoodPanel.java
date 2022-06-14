package view;

import model.Food;

import java.awt.*;

public class FoodPanel extends ElementPanel {
    public FoodPanel(Food element) {
        super(element);
        setBackground(Color.RED);
    }
}
