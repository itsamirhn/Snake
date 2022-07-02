package view;

import controller.ButtonListener;
import controller.Difficulty;
import utilitis.SUtils;

import javax.swing.*;

public class SMenuBar extends JMenuBar {

    private final String[] availableColorsName = {
            "BLACK",
            "BLUE",
            "CYAN",
            "DARK_GRAY",
            "GRAY",
            "GREEN",
            "LIGHT_GRAY",
            "MAGENTA",
            "ORANGE",
            "PINK",
            "RED",
            "WHITE",
            "YELLOW"
    };
    protected ButtonListener buttonListener;

    public SMenuBar() {

        JMenu gameMenu = new JMenu("Game");
        JMenu settingMenu = new JMenu("Setting");
        JMenu accountMenu = new JMenu("Account");

        JMenuItem menuItem = new JMenuItem("Menu");

        JMenu difficultyMenu = new JMenu("Difficulty");
        JMenu snakeColorMenu = new JMenu("Color");


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

        for (String colorName : availableColorsName) {
            JMenuItem colorItem = new JMenuItem(colorName);
            colorItem.addActionListener(e -> {
                if (buttonListener != null) buttonListener.changeColorPressed(SUtils.getColorByName(colorName));
            });
            snakeColorMenu.add(colorItem);
        }


        JMenuItem loginItem = new JMenuItem("Login");
        JMenuItem logoutItem = new JMenuItem("Logout");

        gameMenu.add(menuItem);
        add(gameMenu);
        add(settingMenu);
        add(accountMenu);

        settingMenu.add(difficultyMenu);
        settingMenu.add(snakeColorMenu);

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