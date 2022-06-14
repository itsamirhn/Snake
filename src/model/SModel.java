package model;

public class SModel {

    private final Board board;
    private final Snake snake;

    public SModel(int BOARD_WIDTH, int BOARD_HEIGHT, int SNAKE_STARTING_X, int SNAKE_STARTING_Y) {
        board = new Board(BOARD_WIDTH, BOARD_HEIGHT);
        snake = new Snake(board.getCell(SNAKE_STARTING_X, SNAKE_STARTING_Y));
    }

    public void setDirection(Direction direction) {
        snake.setDirection(direction);
    }

    public boolean move() {
        return snake.move();
    }

    public Board getBoard() {
        return board;
    }

    public Snake getSnake() {
        return snake;
    }

    public Food generateFood() {
        return board.generateRandomFood();
    }
}
