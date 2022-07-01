package view;

import controller.ButtonListener;

import javax.swing.*;

public class SMenuBar extends JMenuBar {
    protected ButtonListener buttonListener;
    private JMenu setting;
    private JMenu account;
    private JMenu menu;
    private JMenu difficulty;
    private JMenu snakeColor;
    private JRadioButtonMenuItem easy;
    private JRadioButtonMenuItem normal;
    private JRadioButtonMenuItem hard;
    private ButtonGroup difficultyGroup;
    private JMenuItem blueColor;
    private JMenuItem greenColor;
    private JMenuItem pinkColor;
    private JMenuItem login;
    private JMenuItem logout;

    public SMenuBar() {
        setting = new JMenu("Setting");
        account = new JMenu("Account");
        menu = new JMenu("Menu");


        difficulty = new JMenu("Difficulty");
        snakeColor = new JMenu("Color");


        easy = new JRadioButtonMenuItem("Easy");
        normal = new JRadioButtonMenuItem("Normal");
        hard = new JRadioButtonMenuItem("Hard");


        difficultyGroup = new ButtonGroup();

        blueColor = new JMenuItem("Blue");
        greenColor = new JMenuItem("Green");
        pinkColor = new JMenuItem("Pink");


        login = new JMenuItem("Login");
        logout = new JMenuItem("Logout");

        difficultyGroup.add(easy);
        difficultyGroup.add(normal);
        difficultyGroup.add(hard);
        normal.setSelected(true);

        add(menu);
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
            if (buttonListener != null) buttonListener.menuMenuPressed();
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