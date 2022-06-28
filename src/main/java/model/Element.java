package model;

public abstract class Element {
    private Cell container;

    private boolean removed = false;

    public boolean isRemoved() {
        return removed;
    }

    public Element(Cell container) {
        this.setContainer(container);
    }

    public Cell getContainer() {
        return container;
    }

    public void setContainer(Cell container) {
        this.container = container;
        if (this.container != null && this.container.getElement() != this) this.container.setElement(this);
    }

    public void remove() {
        this.removed = true;
        this.container.setElement(null);
    }
}
