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

    public Direction changeDirection(Direction direction) {
        if (direction == this.direction.opposite()) return this.direction;
        this.direction = direction;
        return this.direction;
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
