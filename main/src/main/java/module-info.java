module com.example.main {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.main to javafx.fxml;
    exports com.example.main.controllers;
    opens com.example.main.controllers to javafx.fxml;
    exports com.example.main.models;
    opens com.example.main.models to javafx.fxml;
    exports com.example.main;
}