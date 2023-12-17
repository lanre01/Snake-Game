package com.example.snakeGame;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class GameController implements Controller {
    Model model;
    View view;
    private static final Image IMG_SNAKE_BODY = ImageUtil.images.get("snake-body");
    static Snake snake;
    Food food;
    Canvas canvas;
    GraphicsContext graphicsContext;
    Menu scoreMenu;
    MenuItem highScorer, Level1, Level2, Level3;
    Menu highScore, playerName;
    Pane endPane, ProgressPane;
    Paddle paddleA, paddleB, paddleC;
    boolean isPaddle = false;
    int minimumScore = 0;

    @Override
    public void initialise(View view, Model model) {
        this.model = model;
        this.view = view;

        model.setLevel(1);
        model.setHighScore(0);
    }

    @Override
     public void startup(ViewController.ObjectToNotify object) {
        this.initialiseViewObjects(object);

        endPane.setVisible(false);
        graphicsContext = canvas.getGraphicsContext2D();

        model.setScore(model.getMinimumScore(model.getLevel()), model.getLevel());
        highScore.setText("High Score: " + model.getHighScore());
        scoreMenu.setText("Score: " + model.getScore(model.getLevel()));
        snake = new Snake(20, 20, IMG_SNAKE_BODY);
        snake.setLength(1);
        snake.setFrameWidthHeight( canvas.getWidth(), canvas.getHeight() );
        food = new Food( canvas.getHeight(), canvas.getWidth());
        this.makePaddle();
        model.setStart(true);
        model.setHasFinished(false);
     }

    private void initialiseViewObjects(ViewController.ObjectToNotify object) {
        this.canvas = object.canvas;
        this.scoreMenu = object.scoreMenu;
        this.highScore = object.highScore;
        this.highScorer = object.highScorer;
        this.playerName = object.playerName;
        this.endPane = object.endPane;
        this.ProgressPane = object.ProgressPane;
        this.Level1 = object.Level1;
        this.Level2 = object.Level2;
        this.Level3 = object.Level3;
    }

    @Override
    public void update() {

        if(model.hasFinished())
            return;

        if(model.start()) {
            if(snake.eatBody() || snake.outOfBounds(model.getLevel()) || !paddleIsSafe()) {
                model.setHasFinished(true);
                model.setStart(false);
                canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

                snake.resetSnake();
                this.gameFinished();
                return;
            }

            if(food.eaten(snake)) {

                if(food.getFoodScore() != 0) {
                    model.setScore( model.getScore(model.getLevel()) + food.getFoodScore(), model.getLevel() );
                    snake.setLength( snake.getLength() + 1 );
                    scoreMenu.setText( "Score: " + model.getScore(model.getLevel()) );
                    if(!this.checkIfGameCanContinue())
                        return;
                }

                food = new Food( canvas.getHeight(), canvas.getWidth() );
            }

            canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            if( model.getLevel() != 1 )
                food.decrementTime();

            food.draw(graphicsContext);
            snake.draw(graphicsContext);
            snake.move(model.getLevel());
            this.drawPaddle();
        }

    }

    private boolean checkIfGameCanContinue() {
        if(model.getScore(model.getLevel()) < model.getMaxScore(model.getLevel()))
            return true;

        model.setStart(false);
        if(model.getLevel() + 1 > model.getMaxLevel())
            this.gameEnd();

        else {
            model.setLevel(model.getLevel() + 1);
            this.setLevelOptions();
            this.ProgressPane.setVisible(true);
        }
        return false;
    }

    private void setLevelOptions() {
        switch (model.getLevel()) {
            case 2:
                Level2.setDisable(false);
                break;
            case 3 :
                Level3.setDisable(false);
                break;
            default:
                break;
        }
    }


    private boolean paddleIsSafe() {
        if(!isPaddle)
            return  true;

        return !paddleA.eaten(snake)
                && !paddleB.eaten(snake)
                && !paddleC.eaten(snake);
    }

    private void gameFinished() {
        if(model.getScore(model.getLevel()) > model.getHighScore()) {
            model.setHighScore( model.getScore(model.getLevel()) );
        }

        endPane.setVisible(true);
    }

    @Override
    public void onKeyPressed(KeyEvent event) {
        if(event.getCode().isArrowKey())
            snake.keyPressed(event);
    }

    private void gameEnd() {
        
    }

    private void makePaddle() {
        if(model.getLevel() >= 3) {
            paddleA = new Paddle(100, 100);
            paddleB = new Paddle(400, 100);
            paddleC = new Paddle(250,300 );
            isPaddle = true;
        }

    }

    private void drawPaddle() {
        if(model.getLevel() == 3) {
            paddleA.draw(graphicsContext);
            paddleB.draw(graphicsContext);
            paddleC.draw(graphicsContext);
        }

    }


}
