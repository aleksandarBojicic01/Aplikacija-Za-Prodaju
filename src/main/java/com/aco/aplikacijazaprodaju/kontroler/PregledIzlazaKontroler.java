package com.aco.aplikacijazaprodaju.kontroler;

import com.aco.aplikacijazaprodaju.Aplikacija;
import com.aco.aplikacijazaprodaju.dao.IzlazniArtikliDAOImpl;
import com.aco.aplikacijazaprodaju.model.IzlazniArtikl;
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

public class PregledIzlazaKontroler implements Initializable {

    @FXML
    private TableColumn<IzlazniArtikl, String> tcAdresa;

    @FXML
    private TableColumn<IzlazniArtikl, String> tcBrend;

    @FXML
    private TableColumn<IzlazniArtikl, String> tcDatumProdaje;

    @FXML
    private TableColumn<IzlazniArtikl, String> tcGrad;

    @FXML
    private TableColumn<IzlazniArtikl, Integer> tcID;

    @FXML
    private TableColumn<IzlazniArtikl, Integer> tcKolicina;

    @FXML
    private TableColumn<IzlazniArtikl, String> tcKupac;

    @FXML
    private TableColumn<IzlazniArtikl, String> tcNaziv;

    @FXML
    private TableColumn<IzlazniArtikl, Integer> tcSifra;

    @FXML
    private TableView<IzlazniArtikl> twIzlazRobe;

    private final IzlazniArtikliDAOImpl izlazniArtikliDAO;
    {
        izlazniArtikliDAO = IzlazniArtikliDAOImpl.getInstance();
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
        tcDatumProdaje.setCellValueFactory(new PropertyValueFactory<>("datumProdaje"));
        tcKupac.setCellValueFactory(new PropertyValueFactory<>("kupac"));
        tcGrad.setCellValueFactory(new PropertyValueFactory<>("grad"));
        tcAdresa.setCellValueFactory(new PropertyValueFactory<>("adresa"));

        ObservableList<IzlazniArtikl> izlazniArtikli = izlazniArtikliDAO.vratiSveArtikle();
        popuniTabelu(izlazniArtikli);
    }

    private void popuniTabelu(ObservableList<IzlazniArtikl> art) {
        twIzlazRobe.setItems(art);
    }

}
