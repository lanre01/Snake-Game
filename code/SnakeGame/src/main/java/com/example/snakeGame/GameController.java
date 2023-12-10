package com.example.snakeGame;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

public class GameController implements Controller {

        Model model;
        View view;
        private static final Image IMG_SNAKE_HEAD = ImageUtil.images.get("snake-head-right");
        static Snake snake = new Snake(20, 20, IMG_SNAKE_HEAD);
        Food food;
        Canvas canvas;



        @Override
        public void initialise(View view, Model model) {
                this.model = model;
                this.view = view;
                model.setScore(0);
                model.setHighScore(0);
        }

        @Override
        public void startup(Canvas canvas) {
                this.canvas = canvas;

                if (model.getHighScore() < model.getScore()) {
                   model.setHighScore(model.getScore());
                }

                model.setScore(0);
                model.setStart(true);
                model.setFood(true);
                model.setHasFinished(false);
                model.setSnakeLength(1);
                snake.setFrameWidthHeight( canvas.getHeight(), canvas.getWidth() );
                food = new Food( canvas.getHeight(), canvas.getWidth());
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
                                model.setSnakeLength( model.getSnakeLength() + 1 );
                                food = new Food( canvas.getHeight(), canvas.getWidth() );
                        }

                        snake.draw(canvas.getGraphicsContext2D());
                        food.draw(canvas.getGraphicsContext2D());
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
                snake.keyPressed(event);
        }

}
