package com.example.snake;

public class Main {

    Controller controller;
    Model model;

    View view;

    public  Main() {
        model = new GameModel();
        controller = new GameController();
        //view = new GameView();
        view = new HelloApplication();

        controller.initialise(view, model);
        view.initialise(model, controller, 800, 800);


        controller.startup();
    }

    public static void main(String[] args) {

        new Main();
    }
}