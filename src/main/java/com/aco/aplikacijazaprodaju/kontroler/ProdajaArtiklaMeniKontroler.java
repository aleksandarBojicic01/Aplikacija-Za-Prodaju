package com.aco.aplikacijazaprodaju.kontroler;

import com.aco.aplikacijazaprodaju.dao.IzlazniArtikliDAOImpl;
import com.aco.aplikacijazaprodaju.model.IzlazniArtikl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProdajaArtiklaMeniKontroler {

    @FXML
    private TextField imeGradaTF;

    @FXML
    private TextField imeKupcaTF;

    @FXML
    private TextField kolicinaArtiklaTF;

    @FXML
    private TextArea rezultatProdajeTA;

    @FXML
    private Button dugmeOtkazi;

    @FXML
    private Button dugmePotvrdi;

    private IzlazniArtikl a;
    private final IzlazniArtikliDAOImpl izlazniArtikliDAO;
    {
        izlazniArtikliDAO = IzlazniArtikliDAOImpl.getInstance();
    }

    public void initArtData(IzlazniArtikl a) {
        this.a = a;
    }

    @FXML
    void prodajArtikl(ActionEvent event) {
        a.setKupac(imeKupcaTF.getText());
        a.setGrad(imeGradaTF.getText());
        a.setKolicina(Integer.parseInt(kolicinaArtiklaTF.getText()));

        if (izlazniArtikliDAO.prodajArtikl(a)) {
            Stage stage = (Stage) dugmePotvrdi.getScene().getWindow();
            stage.close();
        } else {
            rezultatProdajeTA.setText("Greska u prodaju artikla! Provjerite da li artikla ima dovoljno na stanju kao i postojanje kupca i grada!");
        }
    }

    @FXML
    void vratiNaProdajniMeni(ActionEvent event) {
        Stage stage = (Stage) dugmeOtkazi.getScene().getWindow();
        stage.close();
    }
}
