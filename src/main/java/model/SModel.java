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

    public void run() throws GameOverException {
        game.run();
    }

    public void changeDirection(Direction direction) {
        game.changeDirection(direction);
    }

    public void createNewGame() {
        game = new Game(Config.getInstance().mapSchema);
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

    public User[] getLeaderboard() {
        return User.allUsers.stream().sorted((x, y) -> y.getHighestScore() - x.getHighestScore()).toArray(User[]::new);
    }
}
