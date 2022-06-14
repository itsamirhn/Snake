package model;

import java.util.Collection;
import java.util.LinkedList;

public class Snake {
    private final LinkedList<Body> body = new LinkedList<>();
    private Direction direction = Direction.RIGHT;

    public Snake(Cell start) {
        body.add(new Body(start));
    }

    public void move() {
        Body head = getHead();
        Cell next = head.getContainer().getNeighbor(direction);
        if (next == null) return;
        if (!next.isEmpty()) return;
        Body newHead = new Body(next);
        body.addFirst(newHead);
        Body tail = body.removeLast();
        tail.getContainer().setElement(null);
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
