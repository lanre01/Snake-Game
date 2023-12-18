package com.example.snakeGame;

/**
 * This class is responsible for building the whole component of the game.
 */
public class Play {

    Controller controller;
    Model model;
    View view;
    ViewController viewController;

    /**
     * The constructor create necessary objects needed for the game.
     * It also initialises the objects.
     */
    public Play() {
        model = new GameModel();
        controller = new GameController();
        view = new GameView();
        viewController = new ViewController();

        viewController.initialise(controller, model);
        model.initialise();
        controller.initialise(view, model);
        view.initialise(model, controller);
    }

    /**
     * The main method that starts the game.
     * @param args is the string from command line.
     */
    public static void main(String[] args) {
        MusicPlayer.getMusicPlay("src/main/resources/com/example/snakeGame/Music/frogger.mp3");
        new Play();
    }
}