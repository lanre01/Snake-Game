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
            model.setHighScore(0);
            model.setDifficulty(1);
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

            if (model.getHighScore() < model.getScore()) {
               model.setHighScore(model.getScore());
               highScorer.setText(playerName.getText());
               highScore.setText("High Score: " + model.getHighScore());
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



    @Override
        public void update() {

            if(model.hasFinished())
                return;

            if(model.start()) {
                if(snake.eatBody() || snake.outOfBounds(model.getDifficulty()) || !paddleIsSafe()) {
                    model.setHasFinished(true);
                    model.setStart(false);
                    canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

                    snake.resetSnake();
                    this.gameFinished();
                    return;
                }

                /**
                 * check the food has been eaten
                 * check if the paddle has not been collided with
                 * in my startup function, i need to check if i should draw the paddle
                 */
                if(food.eaten(snake)) {

                    if(food.getFoodScore() != 0) {
                        model.setScore( model.getScore() + food.getFoodScore() );
                        snake.setLength( snake.getLength() + 1 );
                        scoreMenu.setText( "Score: " + model.getScore() );
                    }

                    food = new Food( canvas.getHeight(), canvas.getWidth() );
                }

                canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                if( model.getDifficulty() != 1 )
                    food.decrementTime();

                food.draw(graphicsContext);
                snake.draw(graphicsContext);
                snake.move(model.getDifficulty());
                this.drawPaddle();
            }

        }



    private boolean paddleIsSafe() {
        if(!isPaddle)
            return  true;

        return !paddleA.getRectangle().intersects(snake.getRectangle())
                && !paddleB.getRectangle().intersects(snake.getRectangle())
                && !paddleC.getRectangle().intersects(snake.getRectangle());
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
        if(model.getDifficulty() == 3) {
            paddleA = new Paddle(100, 100);
            paddleB = new Paddle(400, 100);
            paddleC = new Paddle(250,300 );
            isPaddle = true;
        }

    }

    private void drawPaddle() {
        if(model.getDifficulty() == 3) {
            paddleA.draw(graphicsContext);
            paddleB.draw(graphicsContext);
            paddleC.draw(graphicsContext);
        }

    }


}
