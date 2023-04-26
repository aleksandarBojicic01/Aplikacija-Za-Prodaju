package com.aco.aplikacijazaprodaju.util;

import java.sql.*;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class DBMenadzer {
    private Connection con = null;
    private static DBMenadzer instance;

    public void connect() {
        try {
            String url = "jdbc:sqlserver://DESKTOP-J0J3PQP\\SQLEXPRESS;databaseName=Prodaja;integratedSecurity=true;encrypt=false;";
            con = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Greska u povezivanju sa bazom!");
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (con != null && !con.isClosed())
                con.close();
        } catch (SQLException e) {
            System.out.println("Greska u zatvaranju konekcije sa bazom!");
            e.printStackTrace();
        }
    }
    // insert/update/delete
    public void dbExecUpdate(String sqlQuery) {
        Statement st = null;
        try {
            connect();
            st = con.createStatement();
            st.executeUpdate(sqlQuery);
        } catch (Exception e) {
            System.out.println("Greska u ProdajaUtil.dbExecUpdate()" + e.getMessage());
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.out.println("Greska u zatvaranju ps u ProdajaUtil.dbExecUpdate()" + e.getMessage());
                }
            }
            disconnect();
        }
    }
    // za vracanje podataka
    public ResultSet dbExecQuery(String sqlQuery) {
        Statement st = null;
        ResultSet rs;
        CachedRowSet crs = null;
        try {
            connect();
            st = con.createStatement();
            rs = st.executeQuery(sqlQuery);
            crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.populate(rs);
        } catch (Exception e) {
            System.out.println("Greska u ProdajaUtil.dbExecQuery()" + e.getMessage());
        } finally {
            try {
                if (st != null)
                    st.close();
            } catch (SQLException e) {
                System.out.println("Greska u zatvaranju ps u ProdajaUtil.dbExecQuery()" + e.getMessage());
            }
            disconnect();
        }
        return crs;
    }

    public Connection getConnection() throws SQLException {
        if (con == null || con.isClosed()) {
            connect();
        }
        return con;
    }

    public static DBMenadzer getInstance() {
        if (instance == null) {
            instance = new DBMenadzer();
        }
        return instance;
    }

}
