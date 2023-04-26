package com.aco.aplikacijazaprodaju.model;

import javafx.beans.property.*;

public class UlazniArtikl {
    private final IntegerProperty id;
    private final IntegerProperty sifra;
    private final StringProperty naziv;
    private final StringProperty brend;
    private final IntegerProperty kolicina;
    private final StringProperty dobavljac;
    private final StringProperty datumNabavke;
    private final DoubleProperty nabavnaCijena;
    private final StringProperty grad;
    private final StringProperty adresa;

    public UlazniArtikl(int id, int sifra, String naziv, String brend, int kolicina, String dobavljac, String datumNabavke, double nabavnaCijena, String grad, String adresa) {
        this.id = new SimpleIntegerProperty(id);
        this.sifra = new SimpleIntegerProperty(sifra);
        this.naziv = new SimpleStringProperty(naziv);
        this.brend = new SimpleStringProperty(brend);
        this.kolicina = new SimpleIntegerProperty(kolicina);
        this.dobavljac = new SimpleStringProperty(dobavljac);
        this.datumNabavke = new SimpleStringProperty(datumNabavke);
        this.nabavnaCijena = new SimpleDoubleProperty(nabavnaCijena);
        this.grad = new SimpleStringProperty(grad);
        this.adresa = new SimpleStringProperty(adresa);
    }

    public UlazniArtikl() {
        this.id = new SimpleIntegerProperty(0);
        this.sifra = new SimpleIntegerProperty(0);
        this.naziv = new SimpleStringProperty("");
        this.brend = new SimpleStringProperty("");
        this.kolicina = new SimpleIntegerProperty(0);
        this.dobavljac = new SimpleStringProperty("");
        this.datumNabavke = new SimpleStringProperty("");
        this.nabavnaCijena = new SimpleDoubleProperty(0);
        this.grad = new SimpleStringProperty("");
        this.adresa = new SimpleStringProperty("");
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

    public int getSifra() {
        return sifra.get();
    }

    public IntegerProperty sifraProperty() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra.set(sifra);
    }

    public String getNaziv() {
        return naziv.get();
    }

    public StringProperty nazivProperty() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv.set(naziv);
    }

    public String getBrend() {
        return brend.get();
    }

    public StringProperty brendProperty() {
        return brend;
    }

    public void setBrend(String brend) {
        this.brend.set(brend);
    }

    public int getKolicina() {
        return kolicina.get();
    }

    public IntegerProperty kolicinaProperty() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina.set(kolicina);
    }

    public String getDobavljac() {
        return dobavljac.get();
    }

    public StringProperty dobavljacProperty() {
        return dobavljac;
    }

    public void setDobavljac(String dobavljac) {
        this.dobavljac.set(dobavljac);
    }

    public String getDatumNabavke() {
        return datumNabavke.get();
    }

    public StringProperty datumNabavkeProperty() {
        return datumNabavke;
    }

    public void setDatumNabavke(String datumNabavke) {
        this.datumNabavke.set(datumNabavke);
    }

    public double getNabavnaCijena() {
        return nabavnaCijena.get();
    }

    public DoubleProperty nabavnaCijenaProperty() {
        return nabavnaCijena;
    }

    public void setNabavnaCijena(double nabavnaCijena) {
        this.nabavnaCijena.set(nabavnaCijena);
    }

    public String getGrad() {
        return grad.get();
    }

    public StringProperty gradProperty() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad.set(grad);
    }

    public String getAdresa() {
        return adresa.get();
    }

    public StringProperty adresaProperty() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa.set(adresa);
    }
}
