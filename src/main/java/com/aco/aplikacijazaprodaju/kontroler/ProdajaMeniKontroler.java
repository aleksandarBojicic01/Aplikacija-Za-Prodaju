package com.aco.aplikacijazaprodaju.kontroler;

import com.aco.aplikacijazaprodaju.Aplikacija;
import com.aco.aplikacijazaprodaju.dao.ArtikliDAOImpl;
import com.aco.aplikacijazaprodaju.model.Artikl;
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

public class ProdajaMeniKontroler implements Initializable {
    @FXML
    private TableColumn<Artikl, String> tcBrend;

    @FXML
    private TableColumn<Artikl, String> tcKategorija;

    @FXML
    private TableColumn<Artikl, String> tcNaziv;

    @FXML
    private TableColumn<Artikl, Integer> tcSifra;

    @FXML
    private TableColumn<Artikl, Integer> tcStanje;

    @FXML
    private TableColumn<Artikl, Double> tcProdajnaCijena;

    @FXML
    private TableView<Artikl> twArtikli;

    private Stage stage;
    private Scene scene;
    private final ArtikliDAOImpl artikliDAO;
    {
        artikliDAO = ArtikliDAOImpl.getInstance();
    }

    @FXML
    void prikaziPregledIzlaza(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Aplikacija.class.getResource("pregled-izlaza.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void prikaziPregledUlaza(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Aplikacija.class.getResource("pregled-ulaza.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void prodajArtikl(ActionEvent event) {
        try {
            Artikl a = twArtikli.getSelectionModel().getSelectedItem();

            if (a != null) {
                IzlazniArtikl ia = new IzlazniArtikl();
                ia.setSifra(a.getSifra());
                ia.setNaziv(a.getNaziv());
                ia.setBrend(a.getBrend());

                FXMLLoader loader = new FXMLLoader(Aplikacija.class.getResource("prodaja-artikla-meni.fxml"));
                Stage prodajaArtiklaStage = new Stage();
                prodajaArtiklaStage.setTitle("Prodaja Artikla");
                prodajaArtiklaStage.setScene(new Scene(loader.load()));
                ProdajaArtiklaMeniKontroler kontroler = loader.getController();
                kontroler.initArtData(ia);
                prodajaArtiklaStage.show();
            } else {
                System.out.println("Artikl nije izabran");
            }
        } catch (IOException e) {
            System.out.println("Greska u ProdajaMeniKontroler.prodajArtikl(ActionEvent event)!");
            e.printStackTrace();
        }
    }

    @FXML
    void vratiNaPocetniMeni(ActionEvent event) {
        PocetniMeniKontroler.vratiNaPocetniMeni(event);
    }

    @FXML
    void osvjeziTabelu(ActionEvent event) {
        ObservableList<Artikl> artikli = artikliDAO.vratiSveArtikle();
        popuniTabelu(artikli);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tcSifra.setCellValueFactory(new PropertyValueFactory<>("sifra"));
        tcNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        tcBrend.setCellValueFactory(new PropertyValueFactory<>("brend"));
        tcKategorija.setCellValueFactory(new PropertyValueFactory<>("kategorija"));
        tcStanje.setCellValueFactory(new PropertyValueFactory<>("naStanju"));
        tcProdajnaCijena.setCellValueFactory(new PropertyValueFactory<>("prodajnaCijena"));

        ObservableList<Artikl> artikli = artikliDAO.vratiSveArtikle();
        popuniTabelu(artikli);
    }

    private void popuniTabelu(ObservableList<Artikl> list) {
        twArtikli.setItems(list);
    }

}
