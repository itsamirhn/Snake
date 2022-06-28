package controller;

import java.awt.*;

public class Config {

//    private static final String FILE_PATH = "~/.snake/config.json";
    private static final Config instance = new Config();

    public final int foodSpeed = 100;

    public final Dimension boardDimension = new Dimension(20, 20);
    public final Dimension cellDimension = new Dimension(20, 20);

    public final int snakeSpeed = 80;

    private Config() {
        loadConfig();
    }

    private void loadConfig() {
        // TODO
    }

    private void saveConfig() {
        // TODO
    }

    public static Config getInstance() {
        return instance;
    }
}
