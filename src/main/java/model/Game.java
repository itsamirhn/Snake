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
        for(Food food: foods){
            if(food instanceof BonusFood){
                ((BonusFood) food).setDestroy(((BonusFood) food).getDestroy() -1);
                ((BonusFood) food).checkdestroy();
            }
        }

        return snake.move();
    }

    public Board getBoard() {
        return board;
    }

    public Snake getSnake() {
        return snake;
    }

    public void forceGenerateFood() {
        Food food = new Food(board.getRandomEmptyCell());
        foods.add(food);
    }
    public void forceGenerateBonusFood(){
        BonusFood bonusfood = new BonusFood(board.getRandomEmptyCell());
        foods.add(bonusfood);
    }

    public void generateBonusFoodIfNeeded(){
        boolean c = true;
        for(Food food : foods){
            if(food instanceof BonusFood && !(food.isRemoved())){
                c = false;
                break;
            }
        }
        if(c) {
            forceGenerateBonusFood();
        }
    }
    public void generateFoodIfNeeded() {
        boolean c = true;
        for(Food food : foods){
            if(!(food instanceof BonusFood) && !(food.isEaten())){
                c = false;
            }
        }
        if (foods.isEmpty() || c) forceGenerateFood();
    }

    public int getScore() {
        return foods.stream().filter(Food::isEaten).mapToInt(Food::getScore).sum();
    }

}
