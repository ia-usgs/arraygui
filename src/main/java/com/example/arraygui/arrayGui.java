package com.example.arraygui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class arrayGui extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(arrayGui.class.getResource("scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 625);
        stage.setTitle("Array GUI Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}