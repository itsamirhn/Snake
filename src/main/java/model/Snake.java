package model;

import controller.SnakeListener;

import java.util.LinkedList;

public class Snake {
    private final LinkedList<Body> body = new LinkedList<>();
    private Direction direction = Direction.RIGHT;
    private SnakeListener listener;
    public Snake(Cell start) {
        body.add(new Body(start));
    }

    public boolean move() throws GameOverException {
        Body head = getHead();
        Cell next = head.getContainer().getNeighbor(direction);
        if (next == null) throw new GameOverException(GameOverException.Cause.WALL_HIT);
        Element nextElement = next.getElement();
        if (nextElement != null) {
            if (nextElement instanceof Body) throw new GameOverException(GameOverException.Cause.SNAKE_HIT_ITSELF);
            if (!(nextElement instanceof Food)) throw new GameOverException(GameOverException.Cause.UNKNOWN);
        }
        if (nextElement instanceof Food food) {
            food.eat();
            if (listener != null) listener.foodEaten(food);
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

    public void changeDirection(Direction direction) {
        if (direction == this.direction.opposite()) return;
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

    public void setListener(SnakeListener listener) {
        this.listener = listener;
    }
}
