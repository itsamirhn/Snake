package controller;

import com.moandjiezana.toml.Toml;
import com.moandjiezana.toml.TomlWriter;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Config {

    private static final String FILE_PATH = "./config.toml";
    private static final Config instance = new Config(FILE_PATH);

    public int snakeSpeed = 80;
    public int foodSpeed = 100;

    public Dimension boardDimension = new Dimension(20, 20);
    public Dimension cellDimension = new Dimension(20, 20);


    public Config() { }
    public Config(String filePath) {
        loadConfig(filePath);
        try {
            saveConfig(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void loadConfig(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) { return; }

        Toml toml = new Toml().read(file);
        Config config = toml.to(Config.class);
        this.snakeSpeed = config.snakeSpeed;
        this.foodSpeed = config.foodSpeed;
        this.boardDimension = config.boardDimension;
        this.cellDimension = config.cellDimension;
    }

    private void saveConfig(String filePath) throws IOException {
        File file = new File(filePath);
        new TomlWriter().write(this, file);
    }

    public static Config getInstance() {
        return instance;
    }
}
