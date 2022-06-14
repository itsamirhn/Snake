package model;

import java.util.EnumMap;

public class Cell {

    private Element element;
    private final EnumMap<Direction, Cell> neighborCells = new EnumMap<>(Direction.class);

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
        if (this.element != null && this.element.getContainer() != this) this.element.setContainer(this);
    }

    public Cell getNeighbor(Direction direction) {
        return neighborCells.get(direction);
    }

    public void setNeighbor(Direction direction, Cell cell) {
        neighborCells.put(direction, cell);
    }

    public boolean isEmpty() {
        return element == null;
    }

    @Override
    public String toString() {
        return element == null ? " " : element.toString();
    }
}
