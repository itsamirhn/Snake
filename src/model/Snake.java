package model;

import java.util.Collection;
import java.util.LinkedList;

public class Snake {
    private final LinkedList<Body> body = new LinkedList<>();
    private Direction direction = Direction.RIGHT;

    public Snake(Cell start) {
        body.add(new Body(start));
    }

    public boolean move() {
        if (!grow()) return false;
        Body tail = body.removeLast();
        tail.getContainer().setElement(null);
        return true;
    }

    public boolean grow() {
        Body head = getHead();
        Cell next = head.getContainer().getNeighbor(direction);
        if (next == null) return false;
        if (!next.isEmpty()) return false;
        Body newHead = new Body(next);
        body.addFirst(newHead);
        return true;
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

    public LinkedList<Body> getBody() {
        return body;
    }
}
