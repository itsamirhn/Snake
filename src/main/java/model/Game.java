package model;

import controller.Config;
import controller.SnakeListener;
import utilitis.SUtils;

import java.util.LinkedList;
import java.util.List;

public class Game implements SnakeListener {

    private final Board board;
    private final Snake snake;
    private SnakeListener snakeListener;
    private final List<Food> availableFoods = new LinkedList<>();
    private final float bonusFoodChance = Config.getInstance().getBonusFoodChance();
    private int score = 0;

    public Game(String[] mapSchema) {
        int height = mapSchema.length;
        int width = mapSchema[0].length();
        board = new Board(height, width);
        Cell snakeHeadCell = null;
        for (int i = 0; i < height; i++) {
            if (mapSchema[i].length() != width) throw new IllegalArgumentException("Map schema is not rectangular");
            for (int j = 0; j < width; j++) {
                char c = mapSchema[i].charAt(j);
                if (c == 'S') snakeHeadCell = board.getCell(i, j);
                else if (c == 'B') new Block(board.getCell(i, j));
            }
        }
        if (snakeHeadCell == null) throw new IllegalArgumentException("Map schema does not contain snake");
        snake = new Snake(snakeHeadCell);
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
