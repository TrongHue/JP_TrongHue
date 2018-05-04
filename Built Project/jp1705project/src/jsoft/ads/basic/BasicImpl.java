package jsoft.ads.basic;

import java.sql.*;
import jsoft.*;

public class BasicImpl implements Basic {
    // Bo quan ly ket noi cua rieng Basic
    private ConnectionPool cp;

    // Ket noi ma Basic su dung
    protected Connection con;

    //Ten doi tuong lam viec voi Basic
    private String objectName;


    public BasicImpl(ConnectionPool cp, String objectName) {
        // Xac dinh doi tuong lam viec voi Basic
        this.objectName = objectName;

        // Xac dinh bo quan ly ket noi cho Basic
        if (cp == null) {
            this.cp = new ConnectionPoolImpl();
        } else {
            this.cp = cp;
        }

        //Xin ket noi de Basic lam viec
        try {
            this.con = this.cp.getConnection(this.objectName);
        } catch (SQLException ex) {
        }

        // huy che do thuc thi cua ket noi
        try {
            if (this.con.getAutoCommit()) {
                this.con.setAutoCommit(false);
            }
        } catch (SQLException ex1) {
            ex1.printStackTrace();
        }
    }

    private synchronized boolean exe(PreparedStatement pre) {
        if (pre != null) {
            try {
                int result = pre.executeUpdate();
                // kiem tra ket qua

                if (result == 0) {
                    this.con.rollback();
                    return false;
                }

                //Xac nhan sau cung cua he thong
                this.con.commit();
                return true;

            } catch (SQLException ex) {
                ex.printStackTrace();

                //quay tro lai trang thai an toan
                try {
                    this.con.rollback();

                } catch (SQLException ex1) {
                    ex1.printStackTrace();
                }
            } finally {
                pre = null;
                System.gc();
            }

        }
        return false;
    }

    public boolean add(PreparedStatement pre) {

        return this.exe(pre);
    }

    public boolean edit(PreparedStatement pre) {

        return this.exe(pre);
    }

    public boolean del(PreparedStatement pre) {
        return this.exe(pre);
    }

    public ResultSet get(String sql, int value) {
        // bien dich cau lenh
        try {
            PreparedStatement preGet = this.con.prepareStatement(sql);
            if (value > 0) {
                preGet.setInt(1, value);
            }
            return preGet.executeQuery();

        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                this.con.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
        }

        return null;
    }

    public ResultSet get(String sql, String username, String userpass) {
        try {
            PreparedStatement preGet = this.con.prepareStatement(sql);
            preGet.setString(1, username);
            preGet.setString(2, userpass);

            return preGet.executeQuery();

        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                this.con.rollback();
            } catch (SQLException ex1) {
            }
        }

        return null;
    }

    public ResultSet gets(String sql) {
        return this.get(sql, 0);
    }

    public ResultSet[] gets(String[] sqls) {
        ResultSet[] tmp = new ResultSet[sqls.length];
        for (int i = 0; i < sqls.length; i++) {
            tmp[i] = this.get(sqls[i], 0);
        }

        return tmp;
    }

    public ConnectionPool getCP() {
        return this.cp;
    }

    public void releaseConnection() {
        try {
            this.cp.releaseConnection(this.con, this.objectName);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }

}
