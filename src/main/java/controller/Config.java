package controller;

import utilitis.SUtils;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;

public class Config {

    private static final String FILE_PATH = "config.toml";
    private static final Config instance = new Config(FILE_PATH);

    private int bonusFoodMoveTimer = 50;
    private float bonusFoodChance = 0.008f;

    private boolean wallHit = false;

    private Dimension cellDimension = new Dimension(20, 20);

    private Difficulty difficulty = Difficulty.NORMAL;
    private LinkedHashMap<Difficulty, Integer> snakeFPSByDifficulty = new LinkedHashMap<>() {
        {
            put(Difficulty.EASY, 10);
            put(Difficulty.NORMAL, 15);
            put(Difficulty.HARD, 20);
        }
    };

    private LinkedHashMap<Difficulty, String[]> mapSchemaByDifficulty = new LinkedHashMap<>() {
        {
            put(Difficulty.EASY, new String[]
                    {
                            "                    ",
                            "                    ",
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
                            "                    ",
                            "                    ",
                            "                    ",
                            "                    ",
                            "                    ",
                            "                    ",
                            "                    ",
                            "                    "
                    });
            put(Difficulty.NORMAL, new String[]
                    {
                            "                    ",
                            "                    ",
                            "      B      B      ",
                            "                    ",
                            "                    ",
                            "                    ",
                            "                    ",
                            "                    ",
                            "                    ",
                            "         S          ",
                            "                    ",
                            "                    ",
                            "                    ",
                            "                    ",
                            "                    ",
                            "                    ",
                            "                    ",
                            "      B      B      ",
                            "                    ",
                            "                    "
                    });
            put(Difficulty.HARD, new String[]
                    {
                            "                    ",
                            "             B      ",
                            "                    ",
                            "                    ",
                            "    B               ",
                            "                    ",
                            "                    ",
                            "                    ",
                            "                    ",
                            "         S          ",
                            "                    ",
                            "                    ",
                            "             B      ",
                            "                    ",
                            "    B               ",
                            "                    ",
                            "                    ",
                            "  B                 ",
                            "                    ",
                            "                    "
                    });
        }
    };

    public Config() { }
    public Config(String filePath) {
        loadFrom(filePath);
    }

    public void loadFrom(String filePath) {
        try {
            Config config = SUtils.loadFromTOML(filePath, Config.class);
            this.difficulty = config.difficulty;
            this.snakeFPSByDifficulty = config.snakeFPSByDifficulty;
            this.mapSchemaByDifficulty = config.mapSchemaByDifficulty;
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

    public int getSnakeFPS() {
        return snakeFPSByDifficulty.get(difficulty);
    }

    public String[] getMapSchema() {
        return mapSchemaByDifficulty.get(difficulty);
    }

    public int getBonusFoodMoveTimer() {
        return bonusFoodMoveTimer;
    }

    public void setBonusFoodMoveTimer(int bonusFoodMoveTimer) {
        this.bonusFoodMoveTimer = bonusFoodMoveTimer;
        save();
    }

    public float getBonusFoodChance() {
        return bonusFoodChance;
    }

    public void setBonusFoodChance(float bonusFoodChance) {
        this.bonusFoodChance = bonusFoodChance;
        save();
    }

    public boolean canHitWall() {
        return wallHit;
    }

    public void setWallHit(boolean wallHit) {
        this.wallHit = wallHit;
        save();
    }

    public Dimension getCellDimension() {
        return cellDimension;
    }

    public void setCellDimension(Dimension cellDimension) {
        this.cellDimension = cellDimension;
        save();
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
        save();
    }
}
