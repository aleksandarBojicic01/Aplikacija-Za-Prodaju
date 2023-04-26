package com.aco.aplikacijazaprodaju.kontroler;

import com.aco.aplikacijazaprodaju.dao.FinansijeMeniDAOImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class FinansijeMeniKontroler implements Initializable {

    @FXML
    private Label labelPrihodi;

    @FXML
    private Label labelProfit;

    @FXML
    private Label labelTroskovi;

    private final FinansijeMeniDAOImpl finansijeDAO;
    {
        finansijeDAO = FinansijeMeniDAOImpl.getInstance();
    }

    @FXML
    void osvjeziMeni(ActionEvent event) {
        labelPrihodi.setText("" + finansijeDAO.vratiPrihode());
        labelTroskovi.setText("" + finansijeDAO.vratiTroskove());
        labelProfit.setText("" + finansijeDAO.vratiProfit());
    }

    @FXML
    void vratiNaGlavniMeni(ActionEvent event) {
        PocetniMeniKontroler.vratiNaPocetniMeni(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelPrihodi.setText("" + finansijeDAO.vratiPrihode());
        labelTroskovi.setText("" + finansijeDAO.vratiTroskove());
        labelProfit.setText("" + finansijeDAO.vratiProfit());
    }
}
