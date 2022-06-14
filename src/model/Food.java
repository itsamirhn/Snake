package model;

public class Food extends Element {
    public Food(Cell container) {
        super(container);
    }

    @Override
    public String toString() {
        return "$";
    }
}
