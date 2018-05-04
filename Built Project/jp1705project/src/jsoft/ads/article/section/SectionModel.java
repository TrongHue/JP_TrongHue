package jsoft.ads.article.section;

import jsoft.*;
import jsoft.objects.*;

import java.sql.*;
import java.util.*;

public class SectionModel {
    private Section s;

    public SectionModel(ConnectionPool cp) {
        this.s = new SectionImpl(cp, "Section");
    }


    protected void finalize() throws Throwable {
        this.s = null;
        super.finalize();
    }


    public ConnectionPool getCP(){
        return this.s.getCP();
    }

    public void releaseConnection(){
        this.s.releaseConnection();
    }


    //--------------------------------------------
    public boolean addSection(SectionObject item) {
        return this.s.addSection(item);
    }

    public boolean editSection(SectionObject item) {
        return this.s.editSection(item);
    }

    public boolean delSection(SectionObject item) {
        return this.s.delSection(item);
    }

    //--------------------------------------------

    public SectionObject getSectionObject(short id) {
        SectionObject item = null;

        //Lay bang ghi doi tuong
        ResultSet rs = this.s.getSection(id);

        if (rs != null) {
            try {
                if (rs.next()) {
                    // Khoi tao bo nho luu tru
                    item = new SectionObject();
                    item.setSection_id(rs.getShort("section_id"));
                    item.setSection_manager_id(rs.getShort("section_manager_id"));
                    item.setSection_name(rs.getString("section_name"));
                }
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return item;
    }


    public ArrayList getSectionObjects(SectionObject similar, short page,
                                       byte total) {

        ArrayList items = new ArrayList();

        SectionObject item = null;

        //Lay danh sach bang ghi doi tuong
        int at = (page - 1) * total;
        ResultSet rs = this.s.getSections(similar,page,total);

        if (rs != null) {
            try {
                while (rs.next()) {
                    // Khoi tao bo nho luu tru
                    item = new SectionObject();
                    item.setSection_id(rs.getShort("section_id"));
                    item.setSection_manager_id(rs.getShort("section_manager_id"));
                    item.setSection_name(rs.getString("section_name"));
                    // dua doi tuong vao items
                    items.add(item);
                }
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return items;
    }


    public static void main(String[] args) {
        ConnectionPool cp = new ConnectionPoolImpl();
        SectionModel sm = new SectionModel(cp);
        ArrayList<SectionObject> items = sm.getSectionObjects(null,(short)1,(byte)15);

        for(SectionObject s : items){
            System.out.println(s.toString());
        }

    }
}
