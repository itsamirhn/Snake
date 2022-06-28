package model;

import java.util.ArrayList;
import java.util.List;

public class SModel {

    private final Board board;
    private final Snake snake;
    private final List<Food> foods = new ArrayList<>();

    public SModel(int BOARD_WIDTH, int BOARD_HEIGHT, int SNAKE_STARTING_X, int SNAKE_STARTING_Y) {
        board = new Board(BOARD_WIDTH, BOARD_HEIGHT);
        snake = new Snake(board.getCell(SNAKE_STARTING_X, SNAKE_STARTING_Y));
    }

    public void changeDirection(Direction direction) {
        snake.changeDirection(direction);
    }

    public boolean move() throws GameOverException {
        return snake.move();
    }

    public Board getBoard() {
        return board;
    }

    public Snake getSnake() {
        return snake;
    }

    public void generateFood() {
        Food food = new Food(board.getRandomEmptyCell());
        foods.add(food);
    }

    public void generateFoodIfNeeded() {
        if (foods.isEmpty() || foods.get(foods.size() - 1).isRemoved()) generateFood();
    }

}
