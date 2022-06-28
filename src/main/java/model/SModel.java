package model;

import controller.Config;

public class SModel {

    private Game game;

    public SModel() {
        newGame();
    }

    public Game getGame() {
        return game;
    }

    public boolean move() throws GameOverException {
        return game.move();
    }

    public void generateFood() {
        game.generateFoodIfNeeded();
    }

    public void changeDirection(Direction direction) {
        game.changeDirection(direction);
    }

    public void newGame() {
        game = new Game(Config.getInstance().boardDimension);
    }

    public int getScore() {
        return game.getScore();
    }
}
