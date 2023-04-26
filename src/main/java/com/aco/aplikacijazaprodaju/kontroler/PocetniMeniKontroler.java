package com.aco.aplikacijazaprodaju.kontroler;

import com.aco.aplikacijazaprodaju.Aplikacija;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PocetniMeniKontroler {
    Stage stage;
    Scene scene;

    @FXML
    void prebaciNaFinMeni(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Aplikacija.class.getResource("finansije-meni.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void prebaciNaProdajniMeni(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Aplikacija.class.getResource("prodaja-meni.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void prebaciNaLJRMeni(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Aplikacija.class.getResource("ljudski-resursi-meni.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    static void vratiNaPocetniMeni(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Aplikacija.class.getResource("pocetni-meni.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
