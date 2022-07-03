package controller;

import utilitis.SUtils;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Config {

    private static final String FILE_PATH = "config.toml";
    private static final Config instance = new Config(FILE_PATH);

    public int snakeFPS = 15;
    public int bonusFoodMoveTimer = 50;
    public float bonusFoodChance = 0.008f;

    public boolean wallHit = false;

    public Dimension cellDimension = new Dimension(20, 20);
    public String[] mapSchema = new String[]
            {
            "                    ",
            "             B      ",
            "                    ",
            "                    ",
            "                    ",
            "                    ",
            "                    ",
            "                    ",
            "                    ",
            "         S          ",
            "                    ",
            "                    ",
            "             B      ",
            "                    ",
            "                    ",
            "                    ",
            "                    ",
            "  B                 ",
            "                    ",
            "                    "
            };


    public Config() { }
    public Config(String filePath) {
        loadFrom(filePath);
    }

    public void loadFrom(String filePath) {
        try {
            Config config = SUtils.loadFromTOML(filePath, Config.class);
            this.snakeFPS = config.snakeFPS;
            this.bonusFoodMoveTimer = config.bonusFoodMoveTimer;
            this.bonusFoodChance = config.bonusFoodChance;
            this.wallHit = config.wallHit;
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
