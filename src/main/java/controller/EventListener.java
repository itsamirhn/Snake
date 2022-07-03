package controller;

public interface EventListener {
    void startButtonPressed();
    void restartButtonPressed();
    void saveScoreButtonPressed();
    void leaderboardButtonPressed();
    void changeDifficultyPressed(Difficulty difficulty);
    void loginAccountPressed();
    void logoutAccountPressed();
    void menuGamePressed();
}
