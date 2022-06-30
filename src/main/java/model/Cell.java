package model;

import controller.CellUpdateListener;

import java.util.EnumMap;

public class Cell {

    private Element element;
    private CellUpdateListener listener;
    private final EnumMap<Direction, Cell> neighborCells = new EnumMap<>(Direction.class);

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
        if (this.element != null && this.element.getContainer() != this) this.element.setContainer(this);
        if (listener != null) listener.cellUpdated(this);
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

    public void setListener(CellUpdateListener listener) {
        this.listener = listener;
    }

    @Override
    public String toString() {
        return element == null ? " " : element.toString();
    }
}
