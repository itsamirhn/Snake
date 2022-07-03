package model;

import controller.SnakeListener;
import javax.sound.sampled.*;
import java.io.File;
import java.util.LinkedList;

public class Snake {
    private final LinkedList<Body> body = new LinkedList<>();
    private Direction direction = Direction.RIGHT;
    private SnakeListener listener;
    public Snake(Cell start) {
        body.add(new Body(start));
    }

    public void move() throws GameOverException {
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
            if (body.size() > 1) body.set(0, new Body(body.getFirst().getContainer()));
            Head newHead = new Head(next);
            body.addFirst(newHead);
        } else {
            if (body.size() > 1) body.set(0, new Body(body.getFirst().getContainer()));
            Head newHead = new Head(next);
            body.addFirst(newHead);
            Body tail = body.removeLast();
            tail.remove();
        }
    }

    public void changeDirection(Direction direction) {
        if (direction == this.direction.getOpposite()) return;
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

    protected void setListener(SnakeListener listener) {
        this.listener = listener;
    }
}
