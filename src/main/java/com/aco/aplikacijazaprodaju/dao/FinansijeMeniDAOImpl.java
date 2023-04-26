package com.aco.aplikacijazaprodaju.dao;

import com.aco.aplikacijazaprodaju.util.DBMenadzer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class FinansijeMeniDAOImpl implements FinansijeDAO {
    private final DBMenadzer dbm;
    private static FinansijeMeniDAOImpl instance;

    public FinansijeMeniDAOImpl(DBMenadzer dbm) {
        this.dbm = dbm;
    }

    public static FinansijeMeniDAOImpl getInstance() {
        if (instance == null) {
            instance = new FinansijeMeniDAOImpl(DBMenadzer.getInstance());
        }
        return instance;
    }

    @Override
    public double vratiTroskove() {
        Connection con = null;
        CallableStatement cls = null;
        double troskovi = 0;
        try {
            con = dbm.getConnection();
            cls = con.prepareCall("{? = call dbo.fn_troskoviZadnjih30Dana()}");
            cls.registerOutParameter(1, Types.DECIMAL);
            cls.execute();
            troskovi = cls.getDouble(1);
        } catch (SQLException e) {
            System.out.println("Greska u FinansijeMeniDAOImpl.vratiTroskove()! \n" + e.getMessage());
        } finally {
            try {
                if (cls != null && !cls.isClosed()) {
                    cls.close();
                }
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Greska u zatvaranju FinansijeMeniDAOImpl.vratiTroskove()! \n");
                e.printStackTrace();
            }
        }
        return troskovi;
    }

    @Override
    public double vratiPrihode() {
        Connection con = null;
        CallableStatement cls = null;
        double prihodi = 0;
        try {
            con = dbm.getConnection();
            cls = con.prepareCall("{? = call dbo.fn_prihodiZadnjih30Dana()}");
            cls.registerOutParameter(1, Types.DECIMAL);
            cls.execute();
            prihodi = cls.getDouble(1);
        } catch (SQLException e) {
            System.out.println("Greska u FinansijeMeniDAOImpl.vratiPrihode()! \n" + e.getMessage());
        } finally {
            try {
                if (cls != null && !cls.isClosed()) {
                    cls.close();
                }
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Greska u zatvaranju FinansijeMeniDAOImpl.vratiPrihode()! \n");
                e.printStackTrace();
            }
        }
        return prihodi;
    }

    @Override
    public double vratiProfit() {
        Connection con = null;
        CallableStatement cls = null;
        double profit = 0;
        try {
            con = dbm.getConnection();
            cls = con.prepareCall("{? = call dbo.fn_profitZadnjih30Dana()}");
            cls.registerOutParameter(1, Types.DECIMAL);
            cls.execute();
            profit = cls.getDouble(1);
        } catch (SQLException e) {
            System.out.println("Greska u FinansijeMeniDAOImpl.vratiProfit()! \n" + e.getMessage());
        } finally {
            try {
                if (cls != null && !cls.isClosed()) {
                    cls.close();
                }
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Greska u zatvaranju FinansijeMeniDAOImpl.vratiProfit()! \n");
                e.printStackTrace();
            }
        }
        return profit;
    }
}
