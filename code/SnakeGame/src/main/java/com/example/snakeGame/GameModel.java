package com.example.snakeGame;

public class GameModel implements Model{
    private static int highScore, score, snakeLength;
    private static String playerName;
    private static boolean hasFinished;
    private static boolean food;
    private static boolean start;

    @Override
    public void initialise() {
        score = 0;
        snakeLength = 1;
        highScore = 0;
    }

    @Override
    public void setPlayerName(String player) {
        playerName = player;
    }


    @Override
    public String getPlayerName() {
        return playerName;
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
        GameModel.food = food;
    }


    @Override
    public boolean getFood() {
        return food;
    }

    @Override
    public void setHighScore(int score) {
        highScore = score;
    }

    @Override
    public int getHighScore() {
        return highScore;
    }

    @Override
    public void setScore(int score) {
        GameModel.score = score;
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
        GameModel.start = start;
    }


}