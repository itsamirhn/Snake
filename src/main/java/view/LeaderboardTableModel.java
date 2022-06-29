package view;

import model.User;

import javax.swing.table.AbstractTableModel;

public class LeaderboardTableModel extends AbstractTableModel {

    private final String[] columnNames = {"Rank", "Username", "Highest Score"};
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
        return switch (columnIndex) {
            case 0 -> rowIndex + 1;
            case 1 -> users[rowIndex].getUsername();
            case 2 -> users[rowIndex].getHighestScore();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }


}
