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
        MenuItem highScorer;
        Menu highScore, playerName;
        Pane endPane;
        Paddle paddleA, paddleB, paddleC;
        boolean isPaddle = false;

        @Override
        public void initialise(View view, Model model) {
            this.model = model;
            this.view = view;
            model.setScore(0);
            model.setLevel(1);
            model.setHighScore(0, model.getLevel());
        }

        @Override
         public void startup(ViewController.ObjectToNotify object) {
            this.canvas = object.canvas;
            this.scoreMenu = object.scoreMenu;
            this.highScore = object.highScore;
            this.highScorer = object.highScorer;
            this.playerName = object.playerName;
            this.endPane = object.endPane;

            endPane.setVisible(false);
            graphicsContext = canvas.getGraphicsContext2D();

            if (model.getHighScore(model.getLevel()) < model.getScore()) {
               model.setHighScore(model.getScore(), model.getLevel());
               highScorer.setText(playerName.getText());
               highScore.setText("High Score: " + model.getHighScore(model.getLevel()));
            }

            model.setScore(0);
            scoreMenu.setText("Score: 0");
            model.setStart(true);
            model.setHasFinished(false);
            snake = new Snake(20, 20, IMG_SNAKE_BODY);
            snake.setLength(1);
            snake.setFrameWidthHeight( canvas.getWidth(), canvas.getHeight() );
            food = new Food( canvas.getHeight(), canvas.getWidth());
            this.makePaddle();
         }

    /**
     * check if the game is finished ? return : continue
     * check if game has started
     * then - check if the game should stil continue - out of bounds, eaten itself, paddle not safe.
     * check if food has been eaten
     *      -- update the score
     *      --i want to compare the score if the game can move to the next level
     *      -- case true
     *          -- model.setLevel = model.getLevel + 1
         *          if model.getLevel > 3 ---game has finished -player won
         *          otherwise i want to start the next leave.
     *
     *       -- case false
     *       draw the food
     *       draw the snake
     *       draw the paddle
     */

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
                    model.setScore( model.getScore() + food.getFoodScore() );
                    this.checkGameScore();
                    snake.setLength( snake.getLength() + 1 );
                    scoreMenu.setText( "Score: " + model.getScore() );
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

    private void checkGameScore() {

    }


    private boolean paddleIsSafe() {
        if(!isPaddle)
            return  true;

        return !paddleA.eaten(snake)
                && !paddleB.eaten(snake)
                && !paddleC.eaten(snake);
    }

    private void gameFinished() {
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
        if(model.getLevel() == 3) {
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
