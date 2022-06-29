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
    public void forceGenerateBonusFood(){
        Carrot carrot = new Carrot(board.getRandomEmptyCell());
        foods.add(carrot);
    }

    public void generateBonusFoodIfNeeded(){
        boolean c = true;
        for(int i = 0;i < foods.size();i++){
            if(foods.get(i) instanceof BonusFood && !(foods.get(i).isEaten())){
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
        for(int i = 0; i < foods.size();i++){
            if(foods.get(i) instanceof Food && !(foods.get(i) instanceof BonusFood) && !(foods.get(i).isEaten())    ){
                c = false;
            }
        }
        if (foods.isEmpty() || c) forceGenerateFood();
    }

    public int getScore() {
        return foods.stream().filter(Food::isEaten).mapToInt(Food::getScore).sum();
    }

}
