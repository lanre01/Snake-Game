package com.example.snakeproject;

public class GameModel implements Model{
    int highScore, score, snakeLength;
    String playerName;
    boolean hasFinished;
    boolean food;

    @Override
    public void setPlayerName(String player) {
        this.playerName = player;
    }


    @Override
    public String getPlayerName() {
        return playerName;
    }


    @Override
    public void setSnakeLength(int length) {
        this.snakeLength = length;
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
        this.hasFinished = finished;
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
    public void setHighScore(int score) {
        this.highScore = score;
    }

    @Override
    public int getHighScore() {
        return highScore;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int getScore() {
        return score;
    }



}
