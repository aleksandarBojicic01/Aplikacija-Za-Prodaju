package com.aco.aplikacijazaprodaju;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Aplikacija extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Aplikacija.class.getResource("pocetni-meni.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.getIcons().add(new Image("icon.jpg"));
        stage.setTitle("Toner Shop");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}