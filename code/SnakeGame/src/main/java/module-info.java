module com.example.snakeproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jlayer;


    opens com.example.snakeGame to javafx.fxml;
    exports com.example.snakeGame;
}