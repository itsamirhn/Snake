package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private final Board board;
    private final Snake snake;
    private final List<Food> foods = new ArrayList<>();

    public Game(Dimension boardDimension) {
        board = new Board(boardDimension.width, boardDimension.height);
        snake = new Snake(board.getCell(boardDimension.width / 2, boardDimension.height / 2));
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

    public void forceGenerateFood() {
        Apple apple = new Apple(board.getRandomEmptyCell());
        foods.add(apple);
    }

    public void generateFoodIfNeeded() {
        if (foods.isEmpty() || foods.get(foods.size() - 1).isRemoved()) forceGenerateFood();
    }

    public int getScore() {
        return foods.stream().filter(Food::isEaten).mapToInt(Food::getScore).sum();
    }

}
