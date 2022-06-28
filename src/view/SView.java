package view;

import model.SModel;

import javax.swing.*;

public class SView extends JFrame {
    private final BoardPanel boardPanel;

    public SView(SModel model) {
        super("Snake");

        setJMenuBar(createMenuBar());

        boardPanel = new BoardPanel(model.getBoard());
        add(boardPanel);

        pack();

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public BoardPanel getBoardPanel() {
        return boardPanel;
    }

    public void showPauseDialog() {
        // TODO
    }

    public void hidePauseDialog() {
        // TODO
    }

    public void showGameOverDialog(String message) {
        // TODO
        System.err.println(message);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu config = new JMenu("Config");

        JMenu level = new JMenu("Level");
        JMenuItem slow = new JMenuItem("Slow");
        JMenuItem medium = new JMenuItem("Medium");
        JMenuItem fast = new JMenuItem("Fast");

        menuBar.add(config);
        config.add(level);
        level.add(slow);
        level.add(medium);
        level.add(fast);

        return menuBar;
    }
}
