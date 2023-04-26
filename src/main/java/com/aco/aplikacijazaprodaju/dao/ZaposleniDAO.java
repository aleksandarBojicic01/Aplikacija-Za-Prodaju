package com.aco.aplikacijazaprodaju.dao;

import com.aco.aplikacijazaprodaju.model.Zaposleni;
import javafx.collections.ObservableList;

public interface ZaposleniDAO {
    boolean dodajZaposlenog(Zaposleni z);
    ObservableList<Zaposleni> vratiSveZaposlene();
    ObservableList<Zaposleni> pretraziZaposlenePoImenu(String ime);
    void izbrisiZaposlenog(int id);
    void izmjeniInformacijeZaposlenog(Zaposleni z);
}
