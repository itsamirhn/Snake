package model;

import controller.Config;

public class SModel {

    private Game game;
    private User user;

    public SModel() {
        createNewGame();
    }

    public Game getGame() {
        return game;
    }

    public User getUser() {
        return user;
    }

    public boolean move() throws GameOverException {
        return game.move();
    }

    public void generateFood() {
        game.generateFoodIfNeeded();
    }
    public void generateBonusFood(){
        game.generateBonusFoodIfNeeded();
    }
    public void changeDirection(Direction direction) {
        game.changeDirection(direction);
    }

    public void createNewGame() {
        game = new Game(Config.getInstance().boardDimension);
    }

    public int getScore() {
        return game.getScore();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setScore() {
        if (user == null) return;
        user.setScore(game.getScore());
        User.saveUsers();
    }
}
