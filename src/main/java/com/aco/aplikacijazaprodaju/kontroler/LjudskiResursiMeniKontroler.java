package com.aco.aplikacijazaprodaju.kontroler;

import com.aco.aplikacijazaprodaju.Aplikacija;
import com.aco.aplikacijazaprodaju.dao.ZaposleniDAOImpl;
import com.aco.aplikacijazaprodaju.model.Zaposleni;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LjudskiResursiMeniKontroler implements Initializable {
    @FXML
    private TextField pretragaPoImenuTF;

    @FXML
    private TextArea rezultatTA;

    @FXML
    private TextField unosImenaTF;

    @FXML
    private TextField unosLokacijeTF;

    @FXML
    private TextField unosPolaTF;

    @FXML
    private TextField unosPrezimenaTF;

    @FXML
    private TextField unosSektoraTF;

    @FXML
    private TableView<Zaposleni> twZaposleni;

    @FXML
    private TableColumn<Zaposleni, String> tcDatumZaposlenja;

    @FXML
    private TableColumn<Zaposleni, Integer> tcID;

    @FXML
    private TableColumn<Zaposleni, String> tcIme;

    @FXML
    private TableColumn<Zaposleni, String> tcLokacija;

    @FXML
    private TableColumn<Zaposleni, String> tcPol;

    @FXML
    private TableColumn<Zaposleni, String> tcPrezime;

    @FXML
    private TableColumn<Zaposleni, String> tcSektor;


    private final ZaposleniDAOImpl zaposleniDAO;
    {
        zaposleniDAO = ZaposleniDAOImpl.getInstance();
    }

    @FXML
    private void dodajNovogZaposlenog(ActionEvent event) {
        Zaposleni z = new Zaposleni(unosImenaTF.getText(), unosPrezimenaTF.getText(),
                unosSektoraTF.getText(), unosLokacijeTF.getText(), unosPolaTF.getText());

        if (zaposleniDAO.dodajZaposlenog(z)) {
            rezultatTA.setText("Zaposleni uspjesno dodan!");
            ObservableList<Zaposleni> zaposleniList = zaposleniDAO.vratiSveZaposlene();
            popuniTabelu(zaposleniList);
        } else {
            rezultatTA.setText("Greska u dodavanju! Provjerite unesene podatke!");
        }
    }

    @FXML
    private void ocistiPoljaZaUnosZaposlenog(ActionEvent event) {
        unosImenaTF.setText("");
        unosPrezimenaTF.setText("");
        unosSektoraTF.setText("");
        unosLokacijeTF.setText("");
        unosPolaTF.setText("");
    }

    @FXML
    private void vratiNaPocetniMeni(ActionEvent event) {
        PocetniMeniKontroler.vratiNaPocetniMeni(event);
    }

    @FXML
    private void prikaziSveZaposlene(ActionEvent event) {
        ObservableList<Zaposleni> zaposleniList = zaposleniDAO.vratiSveZaposlene();
        popuniTabelu(zaposleniList);
    }

    @FXML
    private void pretraziZaposlenePoImenu(ActionEvent event) {
        ObservableList<Zaposleni> zaposleniList = zaposleniDAO.pretraziZaposlenePoImenu(pretragaPoImenuTF.getText());
        popuniTabelu(zaposleniList);
        if (zaposleniList.size() > 0) {
            rezultatTA.setText("Pretraga uspjesna!");
        } else {
            rezultatTA.setText("Nije pronadjen ni jedan zaposleni sa takvim imenom!");
        }
    }

    @FXML
    private void izbrisiIzabranogZaposlenog(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Brisanje zaposlenog");
        alert.setHeaderText("Kliktanjem na dugme OK zaposleni ce biti izbrisan!");
        alert.setContentText("Zaposleni se ne moze vratiti nakon brisanja, da li ste sigurni da ga zelite izbrisati?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            Zaposleni z = twZaposleni.getSelectionModel().getSelectedItem();
            if (z != null) {
                zaposleniDAO.izbrisiZaposlenog(z.getId());
                twZaposleni.getItems().remove(z);
                rezultatTA.setText("Zaposleni uspjesno izbrisan!");
            } else {
                rezultatTA.setText("Prvo izaberite zaposlenog kojeg zelite izbrisati!");
            }
        }
    }

    @FXML
    private void prikaziMeniZaIzmjenuPodatakaZaposlenog(ActionEvent event) {
        try {
            Zaposleni z = twZaposleni.getSelectionModel().getSelectedItem();

            if (z != null) {
                FXMLLoader loader = new FXMLLoader(Aplikacija.class.getResource("izmjena-podataka-zaposlenog-meni.fxml"));

                Stage izmjenaPodatakaZaposlenogStage = new Stage();
                izmjenaPodatakaZaposlenogStage.setTitle("Izmjena podataka zaposlenog");
                izmjenaPodatakaZaposlenogStage.setScene(new Scene(loader.load()));

                IzmjenaPodatakaZaposlenogMeniKontroler kontroler = loader.getController();
                kontroler.initZapData(z);

                izmjenaPodatakaZaposlenogStage.show();
            } else {
                rezultatTA.setText("Prvo izaberite zaposlenog iz tabele kojeg zelite izmjeniti!");
            }
        } catch (IOException e) {
            System.out.println("Greska u LjudskiResursiMeniKontroler.prikaziMeniZaIzmjenuPodatakaZaposlenog(ActionEvent event)!");
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tcID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcIme.setCellValueFactory(new PropertyValueFactory<>("ime"));
        tcPrezime.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        tcDatumZaposlenja.setCellValueFactory(new PropertyValueFactory<>("datumZaposlenja"));
        tcSektor.setCellValueFactory(new PropertyValueFactory<>("sektor"));
        tcLokacija.setCellValueFactory(new PropertyValueFactory<>("grad"));
        tcPol.setCellValueFactory(new PropertyValueFactory<>("pol"));

        ObservableList<Zaposleni> zaposleniList = zaposleniDAO.vratiSveZaposlene();
        popuniTabelu(zaposleniList);
    }

    public void setRezultatTATekst(String tekst) {
        rezultatTA.setText(tekst);
    }

    private void popuniTabelu(ObservableList<Zaposleni> list) {
        twZaposleni.setItems(list);
    }
}
