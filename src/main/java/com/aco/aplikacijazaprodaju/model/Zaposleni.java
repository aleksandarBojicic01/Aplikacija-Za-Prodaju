package com.aco.aplikacijazaprodaju.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Zaposleni {
    private final IntegerProperty id;
    private final StringProperty ime;
    private final StringProperty prezime;
    private final StringProperty datumZaposlenja;
    private final StringProperty sektor;
    private final StringProperty grad;
    private final StringProperty pol;

    public Zaposleni(String ime, String prezime, String sektor, String grad, String pol) {
        this.ime = new SimpleStringProperty(ime);
        this.prezime = new SimpleStringProperty(prezime);
        this.sektor = new SimpleStringProperty(sektor);
        this.grad = new SimpleStringProperty(grad);
        this.pol = new SimpleStringProperty(pol);
        this.id = new SimpleIntegerProperty(-1);
        this.datumZaposlenja = new SimpleStringProperty("");
    }

    public Zaposleni() {
        this.ime = new SimpleStringProperty("");
        this.prezime = new SimpleStringProperty("");
        this.sektor = new SimpleStringProperty("");
        this.grad = new SimpleStringProperty("");
        this.pol = new SimpleStringProperty("");
        this.id = new SimpleIntegerProperty(0);
        this.datumZaposlenja = new SimpleStringProperty("");
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public StringProperty imeProperty() {
        return ime;
    }

    public StringProperty prezimeProperty() {
        return prezime;
    }

    public StringProperty datumZaposlenjaProperty() {
        return datumZaposlenja;
    }

    public StringProperty sektorProperty() {
        return sektor;
    }

    public StringProperty gradProperty() {
        return grad;
    }

    public StringProperty polProperty() {
        return pol;
    }

    public String getIme() {
        return ime.get();
    }

    public void setIme(String ime) {
        this.ime.set(ime);
    }

    public String getPrezime() {
        return prezime.get();
    }

    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }

    public String getDatumZaposlenja() {
        return datumZaposlenja.get();
    }

    public void setDatumZaposlenja(String datumZaposlenja) {
        this.datumZaposlenja.set(datumZaposlenja);
    }

    public String getSektor() {
        return sektor.get();
    }

    public void setSektor(String sektor) {
        this.sektor.set(sektor);
    }

    public String getGrad() {
        return grad.get();
    }

    public void setGrad(String grad) {
        this.grad.set(grad);
    }

    public String getPol() {
        return pol.get();
    }

    public void setPol(String pol) {
        this.pol.set(pol);
    }
}
