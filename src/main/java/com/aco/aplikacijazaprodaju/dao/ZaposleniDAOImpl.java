package com.aco.aplikacijazaprodaju.dao;

import com.aco.aplikacijazaprodaju.model.Zaposleni;
import com.aco.aplikacijazaprodaju.util.DBMenadzer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ZaposleniDAOImpl implements ZaposleniDAO {
    private final DBMenadzer dbm;
    private static ZaposleniDAOImpl instance;

    public ZaposleniDAOImpl(DBMenadzer dbm) {
        this.dbm = dbm;
    }

    public static ZaposleniDAOImpl getInstance() {
        if (instance == null) {
            instance = new ZaposleniDAOImpl(DBMenadzer.getInstance());
        }
        return instance;
    }

    @Override
    public boolean dodajZaposlenog(Zaposleni z) {
        Connection con = null;
        PreparedStatement ps = null;
        boolean uspjeh = false;
        try {
            con = dbm.getConnection();
            ps = con.prepareStatement("insert into vwZaposleniJavneInformacije" +
                    "(ime, prezime, [naziv sektora], grad, pol)" +
                    "values " +
                    "(?, ?, ?, ?, ?)");
            ps.setString(1, z.getIme());
            ps.setString(2, z.getPrezime());
            ps.setString(3, z.getSektor());
            ps.setString(4, z.getGrad());
            ps.setString(5, z.getPol());

            if (ps.executeUpdate() > 0) {
                uspjeh = true;
            }
        } catch (SQLException e) {
            System.out.println("Greska u ZaposleniDAOImpl.dodajZaposlenog()! \n" +
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
                System.out.println("Greska u zatvaranju konekcija u ZaposleniDAOImpl.dodajZaposlenog()!");
                e.printStackTrace();
            }
        }
        return uspjeh;
    }
    @Override
    public ObservableList<Zaposleni> vratiSveZaposlene() {
            String query = "select * from vwZaposleniJavneInformacije";

            ResultSet rs = dbm.dbExecQuery(query);
            return zaposleniKaoObsList(rs);
    }

    private ObservableList<Zaposleni> zaposleniKaoObsList(ResultSet rs) {
        ObservableList<Zaposleni> zapList = FXCollections.observableArrayList();
        try {
            while (rs.next()) {
                Zaposleni z = new Zaposleni();
                z.setId(rs.getInt("id"));
                z.setIme(rs.getString("ime"));
                z.setPrezime(rs.getString("prezime"));
                z.setDatumZaposlenja(rs.getString("datum zaposlenja"));
                z.setSektor(rs.getString("naziv sektora"));
                z.setGrad(rs.getString("grad"));
                z.setPol(rs.getString("pol"));

                zapList.add(z);
            }
        } catch (SQLException e) {
            System.out.println("Greska u ZaposleniDAOImpl.zaposleniKaoObsList() \n" + e.getMessage());
        }
        return zapList;
    }

    @Override
    public ObservableList<Zaposleni> pretraziZaposlenePoImenu(String ime) {
        Connection con = null;
        PreparedStatement ps = null;
        ObservableList<Zaposleni> pronadjeniZaposleni = null;
        try {
            con = dbm.getConnection();
            ps = con.prepareStatement("select * from vwZaposleniJavneInformacije where ime like CONCAT( '%',?,'%')");
            ps.setString(1, ime);
            ResultSet rs = ps.executeQuery();

            pronadjeniZaposleni = zaposleniKaoObsList(rs);
        } catch (SQLException e) {
            System.out.println("Greska u ZaposleniDAOImpl.pretraziZaposlenePoImenu()");
            e.printStackTrace();
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Greska u zatvaranju konekcija u ZaposleniDAOImpl.pretraziZaposlenePoImenu()");
                e.printStackTrace();
            }
        }
        return pronadjeniZaposleni;
    }

    @Override
    public void izbrisiZaposlenog(int id) {
        dbm.dbExecUpdate("delete from zaposleni where id = " + id);
    }

    @Override
    public void izmjeniInformacijeZaposlenog(Zaposleni z) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = dbm.getConnection();
            ps = con.prepareStatement("update vwZaposleniJavneInformacije set ime = ?, prezime = ?, " +
                    "[naziv sektora] = ?, grad = ?, pol = ? where id = ?");
            ps.setString(1, z.getIme());
            ps.setString(2, z.getPrezime());
            ps.setString(3, z.getSektor());
            ps.setString(4, z.getGrad());
            ps.setString(5, z.getPol());
            ps.setInt(6, z.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Greska u ZaposleniDAOImpl.izmjeniInformacijeZaposlenog(Zaposleni z)! \n" +
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
                System.out.println("Greska u zatvaranju konekcija u ZaposleniDAOImpl.dodajZaposlenog()!");
                e.printStackTrace();
            }
        }
    }
}
