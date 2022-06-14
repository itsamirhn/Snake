package model;

import java.util.LinkedList;

public class Snake {
    private final LinkedList<Body> body = new LinkedList<>();
    private Direction direction = Direction.RIGHT;

    public Snake(Cell start) {
        body.add(new Body(start));
    }

    public boolean move() {
        Body head = getHead();
        Cell next = head.getContainer().getNeighbor(direction);
        if (next == null) return false;
        if (!next.isEmpty() && !(next.getElement() instanceof Food)) return false;
        if (next.getElement() instanceof Food food) {
            food.remove();
            Body newHead = new Body(next);
            body.addFirst(newHead);
        } else {
            Body newHead = new Body(next);
            body.addFirst(newHead);
            Body tail = body.removeLast();
            tail.remove();
        }
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
