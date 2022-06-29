package view;

import model.Board;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {

    CellPanel[][] cells;
    public BoardPanel(Board board) {
       super(new GridLayout(board.getHeight(), board.getWidth()));
       setBackground(Color.BLACK);
       cells = new CellPanel[board.getHeight()][board.getWidth()];
       for (int i = 0; i < board.getHeight(); i++) {
           for (int j = 0; j < board.getWidth(); j++) {
               cells[i][j] = new CellPanel(board.getCell(i, j));
               add(cells[i][j]);
           }
       }
       validate();
    }

    public CellPanel getCellPanel(int x, int y) {
        return cells[x][y];
    }
}
