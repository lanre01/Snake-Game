package com.example.snakeGame;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GameModel implements Model{
    private  int highScore, snakeLength, level, totalScore;
    private  String playerName;
    private int[] score;
    private boolean hasFinished;
    private boolean food;
    private boolean start;
    private String[] playerNames;
    private final int[] maxScore = {300, 400, 500};

    final public int MaxLevel = 3;

    @Override
    public void initialise() {
        score = new int[MaxLevel];
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
        this.food = food;
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
    public void setScore(int score, int level) {
        this.score[level - 1] = score;
    }

    @Override
    public int getScore(int Level) {
        if(Level <= 0)
            return 0;

        return score[Level - 1];
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

    @Override
    public int getMaxScore(int level) {
        return maxScore[level - 1];
    }


    @Override
    public int getMinimumScore( int Level ) {
        if(level == 1)
            return 0;
        return maxScore[level - 2];
    }

    @Override
    public int getMaxLevel() {
        return MaxLevel;
    }

}
