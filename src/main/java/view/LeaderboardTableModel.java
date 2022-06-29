package view;

import model.User;

import javax.swing.table.AbstractTableModel;

public class LeaderboardTableModel extends AbstractTableModel {

    private final String[] columnNames = {"Username", "Highest Score"};
    private final User[] users;

    public LeaderboardTableModel(User[] users) {
        this.users = users;
    }

    @Override
    public int getRowCount() {
        return users.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) return users[rowIndex].getUsername();
        else return users[rowIndex].getHighestScore();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
