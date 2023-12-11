package com.example.snakeGame;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class GameController implements Controller {

        Model model;
        View view;
        private static final Image IMG_SNAKE_HEAD = ImageUtil.images.get("snake-body");
        Snake snake = new Snake(20, 20, IMG_SNAKE_HEAD);
        Food food;
        Canvas canvas;
        GraphicsContext graphicsContext;



        @Override
        public void initialise(View view, Model model) {
                this.model = model;
                this.view = view;
                model.setScore(0);
                model.setHighScore(0);
                //snake = new Snake(20, 20, IMG_SNAKE_HEAD);
        }

        @Override
        public void startup(Canvas canvas) {
                this.canvas = canvas;
                graphicsContext = canvas.getGraphicsContext2D();

                if (model.getHighScore() < model.getScore()) {
                   model.setHighScore(model.getScore());
                }


                model.setScore(0);
                model.setStart(true);
                model.setFood(true);
                model.setHasFinished(false);
                model.setSnakeLength(1);
                snake.setFrameWidthHeight( canvas.getWidth(), canvas.getHeight() );
                food = new Food( canvas.getHeight(), canvas.getWidth());

                //food.draw(graphicsContext);
          }

        @Override
        public void update() {
                /*
                * checks if the game has ended show the end scene if true else continue.
                * checks if the food has been eaten.
                * update the score of the game.
                * draw the snake and the food.
                */
                if(model.hasFinished()) {
                        this.gameFinished();
                }
                else if(model.start()) {
                        if(snake.eatBody() || snake.outOfBounds()) {
                                model.setHasFinished(true);
                                this.gameFinished();
                                return;
                        }
                        if(food.eaten(snake)) {
                                model.setScore( model.getScore() + 500 );
                                model.setSnakeLength(model.getSnakeLength() + 1 );
                                snake.setLength(model.getSnakeLength());
                                food = new Food( canvas.getHeight(), canvas.getWidth() );
                        }

                        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                        //GraphicsContext gc = canvas.getGraphicsContext2D();
                        food.draw(graphicsContext);
                        snake.draw(graphicsContext);
                        snake.move();
                }



        }

        private void gameFinished() {

        }

        @Override
        public void onKeyPressed(KeyEvent event) {
                /**
                 * This is used by the view to send key pressed to the controller.
                 * Checks if any of the arrow key has been pressed.
                 * It may be used to check for other keys in later updates.
                 */
                if(event.getCode() == KeyCode.ENTER)
                {
                        model.setStart(!model.start());
                }
                else
                        snake.keyPressed(event);
        }

}
