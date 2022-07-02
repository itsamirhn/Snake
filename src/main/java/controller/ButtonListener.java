package controller;

import java.awt.*;

public interface ButtonListener {
    void startButtonPressed();
    void restartButtonPressed();
    void saveScoreButtonPressed();
    void leaderboardButtonPressed();
    void changeDifficultyPressed(Difficulty difficulty);
    void changeColorPressed(Color color);
    void loginAccountPressed();
    void logoutAccountPressed();
    void menuGamePressed();
}
