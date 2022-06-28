package model;

public class Food extends Element {

    private boolean eaten = false;

    public boolean isEaten() {
        return eaten;
    }

    public void eat() {
        this.eaten = true;
        this.remove();
    }

    public int getScore() {
        return 1;
    }

    public Food(Cell container) {
        super(container);
    }

    @Override
    public String toString() {
        return "$";
    }
}
