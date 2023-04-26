package com.aco.aplikacijazaprodaju.model;

import javafx.beans.property.*;

public class Artikl {
    private final IntegerProperty sifra;
    private final StringProperty naziv;
    private final StringProperty brend;
    private final StringProperty kategorija;
    private final IntegerProperty naStanju;
    private final DoubleProperty prodajnaCijena;

    public Artikl(int sifra, String naziv, String brend, String kategorija, int naStanju, double prodajnaCijena) {
        this.sifra = new SimpleIntegerProperty(sifra);
        this.naziv = new SimpleStringProperty(naziv);
        this.brend = new SimpleStringProperty(brend);
        this.kategorija = new SimpleStringProperty(kategorija);
        this.naStanju = new SimpleIntegerProperty(naStanju);
        this.prodajnaCijena = new SimpleDoubleProperty(prodajnaCijena);
    }

    public Artikl() {
        this.sifra = new SimpleIntegerProperty(0);
        this.naziv = new SimpleStringProperty("");
        this.brend = new SimpleStringProperty("");
        this.kategorija = new SimpleStringProperty("");
        this.naStanju = new SimpleIntegerProperty(0);
        this.prodajnaCijena = new SimpleDoubleProperty(0);
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

    public String getKategorija() {
        return kategorija.get();
    }

    public StringProperty kategorijaProperty() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija.set(kategorija);
    }

    public int getNaStanju() {
        return naStanju.get();
    }

    public IntegerProperty naStanjuProperty() {
        return naStanju;
    }

    public void setNaStanju(int naStanju) {
        this.naStanju.set(naStanju);
    }

    public double getProdajnaCijena() {
        return prodajnaCijena.get();
    }

    public DoubleProperty prodajnaCijenaProperty() {
        return prodajnaCijena;
    }

    public void setProdajnaCijena(double prodajnaCijena) {
        this.prodajnaCijena.set(prodajnaCijena);
    }
}
