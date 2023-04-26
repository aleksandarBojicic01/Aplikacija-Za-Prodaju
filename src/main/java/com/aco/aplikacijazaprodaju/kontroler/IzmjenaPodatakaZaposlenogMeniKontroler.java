package com.aco.aplikacijazaprodaju.kontroler;

import com.aco.aplikacijazaprodaju.dao.ZaposleniDAOImpl;
import com.aco.aplikacijazaprodaju.model.Zaposleni;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class IzmjenaPodatakaZaposlenogMeniKontroler {
    @FXML
    private TextField novaLokacijaTF;

    @FXML
    private TextField noviPolTF;

    @FXML
    private TextField noviSektorTF;

    @FXML
    private TextField novoImeTF;

    @FXML
    private TextField novoPrezimeTF;

    @FXML
    private Button dugmeOtkazi;

    @FXML
    private Button dugmePotvrdi;

    private Zaposleni z;
    private final ZaposleniDAOImpl zaposleniDAO;
    {
        zaposleniDAO = ZaposleniDAOImpl.getInstance();
    }

    public void initZapData(Zaposleni z) {
        this.z = z;
        novoImeTF.setText(z.getIme());
        novoPrezimeTF.setText(z.getPrezime());
        noviSektorTF.setText(z.getSektor());
        novaLokacijaTF.setText(z.getGrad());
        noviPolTF.setText(z.getPol());
    }

    @FXML
    void potvrdiNovePodatke(ActionEvent event) {
        z.setIme(novoImeTF.getText());
        z.setPrezime(novoPrezimeTF.getText());
        z.setSektor(noviSektorTF.getText());
        z.setGrad(novaLokacijaTF.getText());
        z.setPol(noviPolTF.getText());

        zaposleniDAO.izmjeniInformacijeZaposlenog(z);

        Stage stage = (Stage) dugmePotvrdi.getScene().getWindow();
        stage.close();
    }

    @FXML
    void vratiNaLJRMeni(ActionEvent event) {
        Stage stage = (Stage) dugmeOtkazi.getScene().getWindow();
        stage.close();
    }

}
