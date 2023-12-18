package com.example.snakeGame;

public class Play {

    Controller controller;
    Model model;
    View view;
    ViewController viewController;

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

    public static void main(String[] args) {
        MusicPlayer.getMusicPlay("src/main/resources/com/example/snakeGame/Music/frogger.mp3");
        new Play();
    }
}