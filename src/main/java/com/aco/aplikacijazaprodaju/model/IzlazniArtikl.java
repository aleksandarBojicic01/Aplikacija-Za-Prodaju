package com.aco.aplikacijazaprodaju.model;

import javafx.beans.property.*;

public class IzlazniArtikl {
    private final IntegerProperty id;
    private final IntegerProperty sifra;
    private final StringProperty naziv;
    private final StringProperty brend;
    private final IntegerProperty kolicina;
    private final StringProperty datumProdaje;
    private final StringProperty kupac;
    private final StringProperty grad;
    private final StringProperty adresa;

    public IzlazniArtikl(int id, int sifra, String naziv, String brend, int kolicina, String datumProdaje, String kupac, String grad, String adresa) {
        this.id = new SimpleIntegerProperty(id);
        this.sifra = new SimpleIntegerProperty(sifra);
        this.naziv = new SimpleStringProperty(naziv);
        this.brend = new SimpleStringProperty(brend);
        this.kolicina = new SimpleIntegerProperty(kolicina);
        this.datumProdaje = new SimpleStringProperty(datumProdaje);
        this.kupac = new SimpleStringProperty(kupac);
        this.grad = new SimpleStringProperty(grad);
        this.adresa = new SimpleStringProperty(adresa);
    }

    public IzlazniArtikl() {
        this.id = new SimpleIntegerProperty(0);
        this.sifra = new SimpleIntegerProperty(0);
        this.naziv = new SimpleStringProperty("");
        this.brend = new SimpleStringProperty("");
        this.kolicina = new SimpleIntegerProperty(0);
        this.datumProdaje = new SimpleStringProperty("");
        this.kupac = new SimpleStringProperty("");
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

    public String getDatumProdaje() {
        return datumProdaje.get();
    }

    public StringProperty datumProdajeProperty() {
        return datumProdaje;
    }

    public void setDatumProdaje(String datumProdaje) {
        this.datumProdaje.set(datumProdaje);
    }

    public String getKupac() {
        return kupac.get();
    }

    public StringProperty kupacProperty() {
        return kupac;
    }

    public void setKupac(String kupac) {
        this.kupac.set(kupac);
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
