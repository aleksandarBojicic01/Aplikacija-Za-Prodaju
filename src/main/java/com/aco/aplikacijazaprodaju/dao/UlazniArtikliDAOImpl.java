package com.aco.aplikacijazaprodaju.dao;

import com.aco.aplikacijazaprodaju.model.UlazniArtikl;
import com.aco.aplikacijazaprodaju.util.DBMenadzer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UlazniArtikliDAOImpl implements ArtikliDAO {
    private final DBMenadzer dbm;
    private static UlazniArtikliDAOImpl instance;

    public UlazniArtikliDAOImpl(DBMenadzer dbm) {
        this.dbm = dbm;
    }

    public static UlazniArtikliDAOImpl getInstance() {
        if (instance == null) {
            instance = new UlazniArtikliDAOImpl(DBMenadzer.getInstance());
        }
        return instance;
    }

    @Override
    public ObservableList<UlazniArtikl> vratiSveArtikle() {
        String sql = "select * from vwPregledUlaza";

        ResultSet rs = dbm.dbExecQuery(sql);
        return artikliKaoObsList(rs);
    }

    private ObservableList<UlazniArtikl> artikliKaoObsList(ResultSet rs) {
        ObservableList<UlazniArtikl> ulArtikli = FXCollections.observableArrayList();
        try {
            while (rs.next()) {
                UlazniArtikl a = new UlazniArtikl();
                a.setId(rs.getInt("id"));
                a.setSifra(rs.getInt("sifra"));
                a.setNaziv(rs.getString("naziv"));
                a.setBrend(rs.getString("brend"));
                a.setKolicina(rs.getInt("kolicina"));
                a.setDobavljac(rs.getString("dobavljac"));
                a.setDatumNabavke(rs.getString("datum nabavke"));
                a.setNabavnaCijena(rs.getDouble("nabavna cijena"));
                a.setGrad(rs.getString("grad"));
                a.setAdresa(rs.getString("lokacija"));

                ulArtikli.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Greska u UlazniArtikliDAOImpl.ulazniArtikliKaoObsList(ResultSet rs) \n" + e.getMessage());
        }
        return ulArtikli;
    }
}
