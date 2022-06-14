package model;

public class SModel {

    public static final int BOARD_WIDTH = 100;
    public static final int BOARD_HEIGHT = 100;

    public static final int SNAKE_STARTING_X = BOARD_WIDTH / 2;
    public static final int SNAKE_STARTING_Y = BOARD_HEIGHT / 2;

    private final Board board = new Board(BOARD_WIDTH, BOARD_HEIGHT);
    private final Snake snake = new Snake(this.board.getCell(SNAKE_STARTING_X, SNAKE_STARTING_Y));

    public SModel() {

    }

    public void setDirection(Direction direction) {
        snake.setDirection(direction);
    }

    public void move() {
        snake.move();
    }

    public Board getBoard() {
        return board;
    }
}
