package com.example.snakeGame;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class GameController implements Controller {
        Model model;
        View view;
        private static final Image IMG_SNAKE_BODY = ImageUtil.images.get("snake-body");
        static Snake snake = new Snake(20, 20, IMG_SNAKE_BODY);
        Food food;
        Canvas canvas;
        GraphicsContext graphicsContext;
        Menu scoreMenu;
        Button exitButton, restartButton;
        ImageView endScene;

        @Override
        public void initialise(View view, Model model) {
                this.model = model;
                this.view = view;
                model.setScore(0);
                model.setHighScore(0);
        }

        @Override
         public void startup(ViewController.ObjectToNotify object) {
            this.canvas = object.canvas;
            this.scoreMenu = object.scoreMenu;
            this.endScene = object.imageView;
            this.restartButton = object.RestartButton;
            this.exitButton = object.ExitButton;
            exitButton.setVisible(false);
            restartButton.setVisible(false);
            endScene.setVisible(false);

            graphicsContext = canvas.getGraphicsContext2D();

            if (model.getHighScore() < model.getScore()) {
               model.setHighScore(model.getScore());
            }

            model.setScore(0);
            model.setStart(true);
            model.setHasFinished(false);
            model.setSnakeLength(1);
            snake = new Snake(20, 20, IMG_SNAKE_BODY);
            snake.setLength(1);
            snake.setFrameWidthHeight( canvas.getWidth(), canvas.getHeight() );
            food = new Food( canvas.getHeight(), canvas.getWidth());
         }

        @Override
        public void update() {

            if(model.hasFinished())
                return;

            if(model.start()) {
                if(snake.eatBody() || snake.outOfBounds()) {
                    model.setHasFinished(true);
                    model.setStart(false);
                    canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                    scoreMenu.setText("Score: 0");
                    snake.resetSnake();
                    this.gameFinished();
                    return;
                }
                if(food.eaten(snake)) {
                    model.setScore( model.getScore() + 500 );
                    model.setSnakeLength(model.getSnakeLength() + 1 );
                    snake.setLength(model.getSnakeLength());
                    scoreMenu.setText("Score: " + model.getScore());
                    food = new Food( canvas.getHeight(), canvas.getWidth() );
                }

                canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                food.draw(graphicsContext);
                snake.draw(graphicsContext);
                snake.move();
            }

        }

        private void gameFinished() {
                restartButton.setVisible(true);
                exitButton.setVisible(true);
                endScene.setVisible(true);
        }

        @Override
        public void onKeyPressed(KeyEvent event) {
                snake.keyPressed(event);
        }

}
