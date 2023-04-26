package com.aco.aplikacijazaprodaju.dao;

import com.aco.aplikacijazaprodaju.model.IzlazniArtikl;
import com.aco.aplikacijazaprodaju.util.DBMenadzer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IzlazniArtikliDAOImpl implements ArtikliDAO {
    private final DBMenadzer dbm;
    private static IzlazniArtikliDAOImpl instance;

    public IzlazniArtikliDAOImpl(DBMenadzer dbm) {
        this.dbm = dbm;
    }

    public static IzlazniArtikliDAOImpl getInstance() {
        if (instance == null) {
            instance = new IzlazniArtikliDAOImpl(DBMenadzer.getInstance());
        }
        return instance;
    }

    public boolean prodajArtikl(IzlazniArtikl izlazniArtikl) {
        Connection con = null;
        PreparedStatement ps = null;
        boolean uspjeh = false;
        try {
            con = dbm.getConnection();
            ps = con.prepareStatement("insert into vwPregledIzlaza " +
                    "(kolicina, kupac, Grad, Sifra)" +
                    "values " +
                    "(?, ?, ?, ?)");

            ps.setInt(1, izlazniArtikl.getKolicina());
            ps.setString(2, izlazniArtikl.getKupac());
            ps.setString(3, izlazniArtikl.getGrad());
            ps.setInt(4, izlazniArtikl.getSifra());

            if (ps.executeUpdate() > 0) {
                uspjeh = true;
            }
        } catch (SQLException e) {
            System.out.println("Greska u IzlazniArtikliDAOImpl.prodajArtikl(IzlazniArtikl izlazniArtikl)! \n" +
                    "Uzrok: " + e.getMessage());
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Greska u zatvaranju konekcija u  IzlazniArtikliDAOImpl.prodajArtikl(IzlazniArtikl izlazniArtikl)!");
                e.printStackTrace();
            }
        }
        return uspjeh;
    }

    @Override
    public ObservableList<IzlazniArtikl> vratiSveArtikle() {
        String sql = "select * from vwPregledIzlaza";

        ResultSet rs = dbm.dbExecQuery(sql);
        return izlazniArtikliKaoObsList(rs);
    }

    private ObservableList<IzlazniArtikl> izlazniArtikliKaoObsList(ResultSet rs) {
        ObservableList<IzlazniArtikl> izlArtikli = FXCollections.observableArrayList();
        try {
            while (rs.next()) {
                IzlazniArtikl a = new IzlazniArtikl();
                a.setId(rs.getInt("id"));
                a.setSifra(rs.getInt("sifra"));
                a.setNaziv(rs.getString("naziv"));
                a.setBrend(rs.getString("brend"));
                a.setKolicina(rs.getInt("kolicina"));
                a.setDatumProdaje(rs.getString("datum prodaje"));
                a.setKupac(rs.getString("kupac"));
                a.setGrad(rs.getString("grad"));
                a.setAdresa(rs.getString("lokacija"));

                izlArtikli.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Greska u IzlazniArtikliDAOImpl.izlazniArtikliKaoObsList(ResultSet rs) \n" + e.getMessage());
        }
        return izlArtikli;
    }

}
