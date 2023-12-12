module com.example.snakegame {
    requires javafx.controls;
    requires javafx.fxml;
    requires jlayer;
    requires java.desktop;


    opens com.example.snakeGame to javafx.fxml;
    exports com.example.snakeGame;
}