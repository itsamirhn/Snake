package model;

public class Board {
    private final int width;
    private final int height;
    private final Cell[][] cells;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;

        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell();
            }
        }

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (x > 0) cells[x][y].setNeighbor(Direction.LEFT, cells[x - 1][y]);
                if (x + 1 < width) cells[x][y].setNeighbor(Direction.RIGHT, cells[x + 1][y]);
                if (y > 0) cells[x][y].setNeighbor(Direction.UP, cells[x][y - 1]);
                if (y + 1 < height) cells[x][y].setNeighbor(Direction.DOWN, cells[x][y + 1]);
            }
        }

    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
