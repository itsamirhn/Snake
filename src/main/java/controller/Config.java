package controller;

import utilitis.SUtils;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Config {

    private static final String FILE_PATH = "./config.toml";
    private static final Config instance = new Config(FILE_PATH);

    public int snakeFPS = 15;
    public int foodFPS = 3;

    public boolean wallHit = false;

    public Dimension boardDimension = new Dimension(20, 20);
    public Dimension cellDimension = new Dimension(20, 20);


    public Config() { }
    public Config(String filePath) {
        loadFrom(filePath);
    }

    public void loadFrom(String filePath) {
        try {
            Config config = SUtils.loadFromTOML(filePath, Config.class);
            this.snakeFPS = config.snakeFPS;
            this.foodFPS = config.foodFPS;
            this.wallHit = config.wallHit;
            this.boardDimension = config.boardDimension;
            this.cellDimension = config.cellDimension;
        } catch (FileNotFoundException e) {
            saveTo(filePath);
        }
    }

    public void saveTo(String filePath) {
        try {
            SUtils.saveToTOML(filePath, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void save() {
        instance.saveTo(FILE_PATH);
    }

    public static Config getInstance() {
        return instance;
    }
}
