package view;

import model.User;

import javax.swing.*;
import java.awt.*;

public class LeaderboardPanel extends JPanel {

    private final JTable table;
    public LeaderboardPanel(User[] users) {
        super(new BorderLayout());
        table = new JTable(new LeaderboardTableModel(users));
        table.getColumnModel().getColumn(0).setMaxWidth(50);
        JScrollPane scrollPanel = new JScrollPane(table);
        add(scrollPanel, BorderLayout.CENTER);
    }

    public void setUsers(User[] users) {
        table.setModel(new LeaderboardTableModel(users));
    }

}
