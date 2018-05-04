package jsoft.ads.article.section;

import java.sql.*;

import jsoft.objects.*;
import jsoft.ads.basic.*;
import jsoft.*;

/**
 * <p>Title: jp1705</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2017</p>
 *
 * <p>Company: </p>
 *
 * @author Nguyen Trong Hue
 * @version 1.0
 */
public class SectionImpl extends BasicImpl implements Section {
    public SectionImpl(ConnectionPool cp, String objectName) {
        super(cp, objectName);
    }

    /**
     * addSection
     *
     * @param item SectionObject
     * @return boolean
     * @todo Implement this jsoft.ads.article.session.Section method
     */
    public boolean addSection(SectionObject item) {
        String sql = "INSERT INTO tblsection(";
        sql += "section_name,section_notes,";
        sql += "section_created_date,section_manager_id,";
        sql += "section_enable,section_delete,";
        sql += "section_last_modified,section_created_author_id,";
        sql += "section_name_en,section_language)";
        sql += " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        //bien dich cau lenh
        try {
            PreparedStatement pre = this.con.prepareStatement(sql);
            //truyen gia tri
            pre.setString(1, item.getSection_name());
            pre.setString(2, item.getSection_notes());
            pre.setString(3, item.getSection_created_date());
            pre.setShort(4, item.getSection_manager_id());
            pre.setBoolean(5, item.isSection_enable());
            pre.setBoolean(6, item.isSection_delete());
            pre.setString(7, item.getSection_last_modified());
            pre.setString(8, item.getSection_name_en());
            pre.setByte(9, item.getSection_language());
            return this.add(pre);

        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                this.con.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
        }

        return false;
    }


    /**
     * delSection
     *
     * @param item SectionObject
     * @return boolean
     * @todo Implement this jsoft.ads.article.session.Section method
     */
    public boolean delSection(SectionObject item) {
        if (!this.isEmpty(item)) {
            return false;
        }
        String sql = "DELETE FROM tblsection WHERE section_id = ? ";

        try {
            PreparedStatement pre = this.con.prepareStatement(sql);
            pre.setShort(1, item.getSection_id());
            return this.del(pre);
        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                this.con.rollback();
            } catch (SQLException ex1) {
            }
        }

        return false;
    }

    private boolean isEmpty(SectionObject item) {
        boolean flag = true;
        String sql = "SELECT category_id FROM tblcategory WHERE ";
        sql += "category_section_id = ?";
        ResultSet rs = this.get(sql, item.getSection_id());
        if (rs != null) {
            try {
                if (rs.next()) {
                    flag = true;
                }
            } catch (SQLException ex) {
            }
            try {
                rs.close();
            } catch (SQLException ex1) {
            }
        }
        return flag;
    }


    /**
     * editSection
     *
     * @param item SectionObject
     * @return boolean
     * @todo Implement this jsoft.ads.article.session.Section method
     */
    public boolean editSection(SectionObject item) {
        // ngay tao va nguoi tao ko dc phep sua
        String sql = "UPDATE tblsection SET ";
        sql += "section_name=?, section_notes=?, ";
        sql += "section_manager_id=?, ";
        sql += "section_enable=?, section_delete=?, section_last_modified=?, ";
        sql += "section_name_en=?, ";
        sql += "section_language=?";

        sql += "WHERE section_id=?";
        try {
            PreparedStatement pre = this.con.prepareStatement(sql);
            //truyen gia tri
            pre.setString(1, item.getSection_name());
            pre.setShort(2, item.getSection_manager_id());
            pre.setBoolean(3, item.isSection_enable());
            pre.setString(4, item.getSection_name());
            pre.setBoolean(5, item.isSection_delete());
            pre.setString(6, item.getSection_last_modified());
            pre.setString(7, item.getSection_name_en());
            pre.setByte(8, item.getSection_language());
            pre.setShort(9, item.getSection_id());

            return this.add(pre);

        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                this.con.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
        }

        return false;
    }

    /**
     * getSection
     *
     * @param username String
     * @param userpass String
     * @return ResultSet
     * @todo Implement this jsoft.ads.article.session.Section method
     */

    public ResultSet getSection(short id) {
        String sql = "SELECT * FROM  tblSection WHERE section_id =? ";
        return this.get(sql, id);
    }

    /**
     * getSections
     *
     * @param similar SectionObject
     * @param at int
     * @param total byte
     * @return ResultSet
     * @todo Implement this jsoft.ads.article.session.Section method
     */
    public ResultSet getSections(SectionObject similar, int at, byte total) {
        String sql = "SELECT * FROM tblsection ";
        sql += "ORDER BY section_id ASC ";
        sql += "LIMIT " + at + "," + total;
        return gets(sql);
    }

    public static void main(String[] args) {
    }
}
