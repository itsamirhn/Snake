package view;

import controller.ButtonListener;
import controller.Difficulty;
import model.User;

import javax.swing.*;

public class SMenuBar extends JMenuBar {
    protected ButtonListener buttonListener;

    private final JMenuItem loginItem = new JMenuItem("Login");
    private final JMenuItem logoutItem = new JMenuItem("Logout");

    public SMenuBar() {

        JMenu gameMenu = new JMenu("Game");
        JMenu settingMenu = new JMenu("Setting");
        JMenu accountMenu = new JMenu("Account");

        JMenuItem menuItem = new JMenuItem("Menu");

        JMenu difficultyMenu = new JMenu("Difficulty");

        ButtonGroup difficultyGroup = new ButtonGroup();

        for (Difficulty difficulty : Difficulty.values()) {
            JRadioButton difficultyItem = new JRadioButton(difficulty.toString());
            difficultyItem.addActionListener(e -> {
                if (buttonListener != null) buttonListener.changeDifficultyPressed(difficulty);
            });
            difficultyGroup.add(difficultyItem);
            difficultyMenu.add(difficultyItem);
            if (difficulty == Difficulty.NORMAL) difficultyItem.setSelected(true);
        }

        gameMenu.add(menuItem);
        add(gameMenu);
        add(settingMenu);
        add(accountMenu);

        settingMenu.add(difficultyMenu);

        accountMenu.add(loginItem);
        accountMenu.add(logoutItem);
        logoutItem.setVisible(false);

        menuItem.addActionListener(e -> {
            if (buttonListener != null) buttonListener.menuGamePressed();
        });
        loginItem.addActionListener(e -> {
            if (buttonListener != null) buttonListener.loginAccountPressed();
        });
        logoutItem.addActionListener(e -> {
            if (buttonListener != null) buttonListener.logoutAccountPressed();
        });

    }

    public void setUser(User user) {
        if (user == null) {
            loginItem.setText("Login");
            loginItem.setEnabled(true);
            logoutItem.setVisible(false);
        } else {
            loginItem.setText("User: " + user.getUsername());
            loginItem.setEnabled(false);
            logoutItem.setVisible(true);
        }
    }

    public void setButtonListener(ButtonListener buttonListener) {
        this.buttonListener = buttonListener;
    }
}