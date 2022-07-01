package model;

import controller.Config;
import controller.SnakeListener;
import utilitis.SUtils;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Game implements SnakeListener {

    private final Board board;
    private final Snake snake;
    private SnakeListener snakeListener;
    private final List<Food> availableFoods = new LinkedList<>();
    private final float bonusFoodChance = Config.getInstance().bonusFoodChance;
    private int score = 0;

    public Game(Dimension boardDimension) {
        board = new Board(boardDimension.width, boardDimension.height);
        snake = new Snake(board.getCell(boardDimension.width / 2, boardDimension.height / 2));
        snake.setListener(this);
    }

    public void changeDirection(Direction direction) {
        snake.changeDirection(direction);
    }

    public void run() throws GameOverException {
        tiktokBonusFoods();
        clearRemovedFoods();
        snake.move();
        generateFoodIfNeeded();
        generateBonusFoodIfNeeded();
    }

    public void clearRemovedFoods() {
        availableFoods.removeIf(Food::isRemoved);
    }

    public void tiktokBonusFoods() {
        for (Food food: availableFoods) if (food instanceof BonusFood bonusFood) bonusFood.tiktok();
    }

    public Board getBoard() {
        return board;
    }

    public Snake getSnake() {
        return snake;
    }

    public void forceGenerateFood() {
        Food food = new Food(board.getRandomEmptyCell());
        availableFoods.add(food);
    }
    public void forceGenerateBonusFood(){
        BonusFood bonusfood = new BonusFood(board.getRandomEmptyCell());
        availableFoods.add(bonusfood);
    }

    public void generateBonusFoodIfNeeded(){
        boolean c = availableFoods.stream().noneMatch(food -> food instanceof BonusFood);
        if (c && SUtils.getRandomProbability(bonusFoodChance)) forceGenerateBonusFood();
    }
    public void generateFoodIfNeeded() {
        boolean c = availableFoods.stream().allMatch(food -> food instanceof BonusFood);
        if (c) forceGenerateFood();
    }

    public int getScore() {
        return score;
    }

    public void setSnakeListener(SnakeListener snakeListener) {
        this.snakeListener = snakeListener;
    }

    @Override
    public void foodEaten(Food food) {
        score += food.getScore();
        if (snakeListener != null) snakeListener.foodEaten(food);
    }
}
