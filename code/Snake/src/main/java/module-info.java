module com.example.snakeproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.snakeproject to javafx.fxml;
    exports com.example.snakeproject;
}