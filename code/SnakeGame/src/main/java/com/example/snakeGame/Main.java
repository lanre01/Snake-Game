package com.example.snakeGame;

public class Main {

    Controller controller;
    Model model;

    View view;

    public  Main() {
        model = new GameModel();
        controller = new GameController();
        view = new GameView();

        controller.initialise(view, model);
        view.initialise(model, controller, 800, 800);


        controller.startup();
    }

    public static void main(String[] args) {

        new Main();
    }
}