package model;

public class GameOverException extends Exception {
    public enum Cause {
        WALL_HIT("Snake hit a wall"),
        SNAKE_HIT_ITSELF("Snake hit itself"),
        UNKNOWN("Unknown cause");

        public final String message;
        Cause (String message) {
            this.message = message;
        }
    }
    Cause cause;
    public GameOverException (Cause cause){
        super(cause.message);
        this.cause = cause;
    }
}
