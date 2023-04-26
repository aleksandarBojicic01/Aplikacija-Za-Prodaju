package com.aco.aplikacijazaprodaju.kontroler;

import com.aco.aplikacijazaprodaju.Aplikacija;
import com.aco.aplikacijazaprodaju.dao.UlazniArtikliDAOImpl;
import com.aco.aplikacijazaprodaju.model.UlazniArtikl;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PregledUlazaKontroler implements Initializable {

    @FXML
    private TableColumn<UlazniArtikl, String> tcAdresa;

    @FXML
    private TableColumn<UlazniArtikl, String> tcBrend;

    @FXML
    private TableColumn<UlazniArtikl, String> tcDatumNabavke;

    @FXML
    private TableColumn<UlazniArtikl, String> tcDobavljac;

    @FXML
    private TableColumn<UlazniArtikl, String> tcGrad;

    @FXML
    private TableColumn<UlazniArtikl, Integer> tcKolicina;

    @FXML
    private TableColumn<UlazniArtikl, String> tcNaziv;

    @FXML
    private TableColumn<UlazniArtikl, Double> tcNabavnaCijena;

    @FXML
    private TableColumn<UlazniArtikl, Integer> tcSifra;

    @FXML
    private TableColumn<UlazniArtikl, Integer> tcID;

    @FXML
    private TableView<UlazniArtikl> twUlazRobe;

    private final UlazniArtikliDAOImpl ulazniArtikliDAO;
    {
        ulazniArtikliDAO = UlazniArtikliDAOImpl.getInstance();
    }

    @FXML
    void vratiNaProdajniMeni(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Aplikacija.class.getResource("prodaja-meni.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tcID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcSifra.setCellValueFactory(new PropertyValueFactory<>("sifra"));
        tcNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        tcBrend.setCellValueFactory(new PropertyValueFactory<>("brend"));
        tcKolicina.setCellValueFactory(new PropertyValueFactory<>("kolicina"));
        tcDobavljac.setCellValueFactory(new PropertyValueFactory<>("dobavljac"));
        tcDatumNabavke.setCellValueFactory(new PropertyValueFactory<>("datumNabavke"));
        tcNabavnaCijena.setCellValueFactory(new PropertyValueFactory<>("nabavnaCijena"));
        tcGrad.setCellValueFactory(new PropertyValueFactory<>("grad"));
        tcAdresa.setCellValueFactory(new PropertyValueFactory<>("adresa"));

        ObservableList<UlazniArtikl> ulazniArtikli = ulazniArtikliDAO.vratiSveArtikle();
        popuniTabelu(ulazniArtikli);
    }

    private void popuniTabelu(ObservableList<UlazniArtikl> art) {
        twUlazRobe.setItems(art);
    }
}
