package com.example.snakeGame;

public class Main {

    Controller controller;
    Model model;
    View view;
    ViewController vController;

    public  Main() {
        model = new GameModel();
        controller = new GameController();
        view = new GameView();
        vController = new ViewController();

        vController.initialise(controller, model);
        model.initialise();
        controller.initialise(view, model);
        view.initialise(model, controller, vController);
    }

    public static void main(String[] args) {
        new Main();
    }
}