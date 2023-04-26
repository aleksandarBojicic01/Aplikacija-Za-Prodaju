package com.aco.aplikacijazaprodaju.dao;

import com.aco.aplikacijazaprodaju.model.Artikl;
import com.aco.aplikacijazaprodaju.util.DBMenadzer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtikliDAOImpl implements ArtikliDAO {
    private final DBMenadzer dbm;
    private static ArtikliDAOImpl instance;

    public ArtikliDAOImpl(DBMenadzer dbm) {
            this.dbm = dbm;
    }

    public static ArtikliDAOImpl getInstance() {
        if (instance == null) {
            instance = new ArtikliDAOImpl(DBMenadzer.getInstance());
        }
        return instance;
    }

    @Override
    public ObservableList<Artikl> vratiSveArtikle() {
        String sql = "select * from vwPregledStanja";

        ResultSet rs = dbm.dbExecQuery(sql);
        return artikliKaoObsList(rs);
    }

    private ObservableList<Artikl> artikliKaoObsList(ResultSet rs) {
        ObservableList<Artikl> artList = FXCollections.observableArrayList();
        try {
            while (rs.next()) {
                Artikl a = new Artikl();
                a.setSifra(rs.getInt("sifra"));
                a.setNaziv(rs.getString("naziv"));
                a.setBrend(rs.getString("brend"));
                a.setKategorija(rs.getString("kategorija"));
                a.setNaStanju(rs.getInt("na stanju"));
                a.setProdajnaCijena(rs.getDouble("prodajna cijena"));

                artList.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Greska u ArtikliDAOImpl.artikliKaoObsList(ResultSet rs) \n" + e.getMessage());
        }
        return artList;
    }
}
