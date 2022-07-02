package view;

import controller.ButtonListener;
import controller.Difficulty;

import javax.swing.*;

public class SMenuBar extends JMenuBar {
    protected ButtonListener buttonListener;

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

        JMenuItem loginItem = new JMenuItem("Login");
        JMenuItem logoutItem = new JMenuItem("Logout");

        gameMenu.add(menuItem);
        add(gameMenu);
        add(settingMenu);
        add(accountMenu);

        settingMenu.add(difficultyMenu);

        accountMenu.add(loginItem);
        accountMenu.add(logoutItem);

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
    public void setButtonListener(ButtonListener buttonListener) {
        this.buttonListener = buttonListener;
    }
}