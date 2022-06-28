package model;

import utilitis.SUtils;

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
                cells[x][y].setNeighbor(Direction.UP, cells[(x - 1 + width) % width][y]);
                cells[x][y].setNeighbor(Direction.DOWN, cells[(x + 1) % width][y]);
                cells[x][y].setNeighbor(Direction.LEFT, cells[x][(y - 1 + height) % height]);
                cells[x][y].setNeighbor(Direction.RIGHT, cells[x][(y + 1) % height]);
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

    public Cell getRandomEmptyCell() {
        int x = SUtils.getRandomInt(width);
        int y = SUtils.getRandomInt(height);
        if (cells[x][y].isEmpty()) {
            return cells[x][y];
        }
        return getRandomEmptyCell();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                sb.append(cells[x][y]);
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
