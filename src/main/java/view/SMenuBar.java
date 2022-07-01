package view;

import controller.ButtonListener;

import javax.swing.*;

public class SMenuBar extends JMenuBar {
    protected ButtonListener buttonListener;

    public SMenuBar() {

        JMenu game = new JMenu("Game");
        JMenu setting = new JMenu("Setting");
        JMenu account = new JMenu("Account");

        JMenuItem menu = new JMenuItem("Menu");

        JMenu difficulty = new JMenu("Difficulty");
        JMenu snakeColor = new JMenu("Color");

        JRadioButtonMenuItem easy = new JRadioButtonMenuItem("Easy");
        JRadioButtonMenuItem normal = new JRadioButtonMenuItem("Normal");
        JRadioButtonMenuItem hard = new JRadioButtonMenuItem("Hard");

        ButtonGroup difficultyGroup = new ButtonGroup();

        JMenuItem blueColor = new JMenuItem("Blue");
        JMenuItem greenColor = new JMenuItem("Green");
        JMenuItem pinkColor = new JMenuItem("Pink");

        JMenuItem login = new JMenuItem("Login");
        JMenuItem logout = new JMenuItem("Logout");

        difficultyGroup.add(easy);
        difficultyGroup.add(normal);
        difficultyGroup.add(hard);
        normal.setSelected(true);

        game.add(menu);
        add(game);
        add(setting);
        add(account);
        setting.add(difficulty);
        setting.add(snakeColor);
        account.add(login);
        account.add(logout);
        difficulty.add(easy);
        difficulty.add(normal);
        difficulty.add(hard);
        snakeColor.add(blueColor);
        snakeColor.add(greenColor);
        snakeColor.add(pinkColor);

        menu.addActionListener(e -> {
            if (buttonListener != null) buttonListener.menuGamePressed();
        });
        easy.addActionListener(e -> {
            if (buttonListener != null) buttonListener.easyDifficultyPressed();
        });
        normal.addActionListener(e -> {
            if (buttonListener != null) buttonListener.normalDifficultyPressed();
        });
        hard.addActionListener(e -> {
            if (buttonListener != null) buttonListener.hardDifficultyPressed();
        });
        blueColor.addActionListener(e -> {
            if (buttonListener != null) buttonListener.blueColorPressed();
        });
        greenColor.addActionListener(e -> {
            if (buttonListener != null) buttonListener.greenColorPressed();
        });
        pinkColor.addActionListener(e -> {
            if (buttonListener != null) buttonListener.pinkColorPressed();
        });
        login.addActionListener(e -> {
            if (buttonListener != null) buttonListener.loginAccountPressed();
        });
        logout.addActionListener(e -> {
            if (buttonListener != null) buttonListener.logoutAccountPressed();
        });

    }
    public void setButtonListener(ButtonListener buttonListener) {
        this.buttonListener = buttonListener;
    }
}