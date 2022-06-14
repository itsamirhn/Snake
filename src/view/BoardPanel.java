package view;

import model.Board;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {

    public BoardPanel(Board board) {
       super(new GridLayout(board.getHeight(), board.getWidth()));
        for (int i = 0; i < board.getHeight(); i++) {
            for (int j = 0; j < board.getWidth(); j++) {
                add(new CellPanel(board.getCell(i, j)));
            }
        }
        validate();
    }
}
