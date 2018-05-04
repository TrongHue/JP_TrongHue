package jsoft.ads.article.section.category;


import jsoft.objects.*;
import jsoft.*;
import jsoft.ads.*;

import java.sql.*;
import java.util.*;

public class CategoryModel {

    private Category c;

    public CategoryModel(ConnectionPool cp) {
        this.c = new CategoryImpl(cp,"Category");
    }

    protected void finalize() throws Throwable {
        this.c = null;
        super.finalize();
    }

    public ConnectionPool getCP(){
    return this.c.getCP();
}

public void releaseConnection(){
    this.c.releaseConnection();
}


    //--------------------------------------------
    public boolean addCategory(CategoryObject item) {
        return this.c.addCategory(item);
    }

    public boolean editCategory(CategoryObject item) {
        return this.c.editCategory(item);
    }

    public boolean delCategory(CategoryObject item) {
        return this.c.delCategory(item);
    }

    //--------------------------------------------

    public CategoryObject getCategoryObject(short id) {
        CategoryObject item = null;

        //Lay bang ghi doi tuong
        ResultSet rs = this.c.getCategory(id);

        if (rs != null) {
            try {
                if (rs.next()) {
                    // Khoi tao bo nho luu tru
                    item = new CategoryObject();
                    item.setCategory_id(rs.getShort("category_id"));
                    item.setCategory_name(rs.getString("category_name"));
                }
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return item;
    }


    public ArrayList getCategoryObjects(CategoryObject similar, short page,
                                        byte total) {

        ArrayList items = new ArrayList();

        CategoryObject item = null;

        //Lay danh sach bang ghi doi tuong
        int at = (page - 1) * total;
        ResultSet rs = this.c.getCategories(similar, at, total);

        if (rs != null) {
            try {
                while (rs.next()) {
                    // Khoi tao bo nho luu tru
                    item = new CategoryObject();
                    item.setCategory_id(rs.getShort("category_id"));
                    item.setCategory_name(rs.getString("category_name"));

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
        CategoryModel cm = new CategoryModel(cp);
        ArrayList<CategoryObject>
                items = cm.getCategoryObjects(null, (short) 1, (byte) 15);

        for (CategoryObject item : items) {
            System.out.println(item.toString());
        }
    }
}
