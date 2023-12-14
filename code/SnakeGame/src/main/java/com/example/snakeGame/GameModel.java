package com.example.snakeGame;

public class GameModel implements Model{
    private  int highScore, score, snakeLength, level;
    private  String playerName;
    private boolean hasFinished;
    private boolean food;
    private boolean start;
    private String[] playerNames;
    private final int[] maxScore = {10000, 5000, 3000};
    private int[] highScores;

    @Override
    public void initialise() {
        score = 0;
        snakeLength = 1;
        highScore = 0;
        playerNames = new String[3];
        highScores = new int[3];
    }

    @Override
    public void setPlayerName(String player, int level) {

        playerNames[level - 1] = player;
    }


    @Override
    public String getPlayerName(int level) {
        return playerNames[level - 1];
    }


    @Override
    public void setSnakeLength(int length) {
        snakeLength = length;
    }


    @Override
    public int getSnakeLength() {
        return snakeLength;
    }


    @Override
    public boolean hasFinished() {
        return hasFinished;
    }


    @Override
    public void setHasFinished(boolean finished) {
        hasFinished = finished;
    }


    @Override
    public void setFood(boolean food) {
        this.food = food;
    }


    @Override
    public boolean getFood() {
        return food;
    }

    @Override
    public void setHighScore(int score, int level) {
        highScores[level - 1] = score;
    }

    @Override
    public int getHighScore(int level) {
        return highScores[level - 1];
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public boolean start() {
        return start;
    }

    @Override
    public void setStart(boolean start) {
        this.start = start;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public int getLevel() {
        return level;
    }


}
