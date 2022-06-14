package model;

import java.util.LinkedList;

public class Snake {
    private final LinkedList<Body> body = new LinkedList<>();
    private Direction direction = Direction.RIGHT;

    public Snake(Cell start) {
        body.add(new Body(start));
    }

    public void move() {
        Body head = getHead();
        Body next = new Body(head.getContainer().getNeighbor(direction));
        body.addFirst(next);
        body.removeLast();
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public Body getHead() {
        return body.getFirst();
    }
}
