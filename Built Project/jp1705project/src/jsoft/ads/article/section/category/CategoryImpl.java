package jsoft.ads.article.section.category;

import java.sql.*;

import jsoft.objects.*;

import jsoft.ads.*;

import jsoft.ads.article.section.*;

import jsoft.*;

// Khac nhau o extends SectionImpl khong phai Basic
public class CategoryImpl extends SectionImpl implements Category {
    public CategoryImpl(ConnectionPool cp,String objectName) {
        super(cp, "Category");
    }

    /**
     * addCategory
     *
     * @param item CategoryObject
     * @return boolean
     * @todo Implement this jsoft.ads.article.category.Category method
     */
    public boolean addCategory(CategoryObject item) {
        if (this.isExisting(item)) {
            return false;
        }
        String sql = "INSERT INTO tblCategory(";
        sql += "category_name,category_section_id,";
        sql += "category_notes,category_created_date,";
        sql += "category_created_author_id,category_last_modified,";
        sql += "category_manager_id,category_enable,";
        sql += "category_delete,category_image,";
        sql += "category_name_en,category_language,";
        sql += ")";
        sql += " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        //bien dich cau lenh
        try {
            PreparedStatement pre = this.con.prepareStatement(sql);
            //truyen gia tri
            pre.setString(1, item.getCategory_name());
            pre.setShort(2, item.getCategory_section_id());
            pre.setString(3, item.getCategory_notes());
            pre.setString(4, item.getCategory_created_date());
            pre.setInt(5, item.getCategory_created_author_id());
            pre.setString(6, item.getCategory_last_modified());
            pre.setInt(7, item.getCategory_manager_id());
            pre.setBoolean(8, item.isCategory_enable());
            pre.setBoolean(9, item.isCategory_delete());
            pre.setString(10, item.getCategory_image());
            pre.setString(11, item.getCategory_name_en());
            pre.setByte(12, item.getCategory_language());

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

    public boolean isExisting(CategoryObject item) {
        boolean flag = false;

        String sql = "SELECT category_id FROM tblcategory ";
        sql += "WHERE category_name= '" + item.getCategory_name() + "'";
        ResultSet rs = this.gets(sql);
        if (rs != null) {
            try {
                if (rs.next()) {
                    flag = true;
                }
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return flag;
    }

    /**
     * delCategory
     *
     * @param item CategoryObject
     * @return boolean
     * @todo Implement this jsoft.ads.article.category.Category method
     */
    public boolean delCategory(CategoryObject item) {
        String sql = "DELETE FROM tblcategory WHERE category_id=?";
        try {
            PreparedStatement pre = this.con.prepareStatement(sql);
            pre.setShort(1, item.getCategory_id());
            return this.del(pre);
        } catch (SQLException ex) {
            try {
                this.con.rollback();
            } catch (SQLException ex1) {
            }
            ex.printStackTrace();
        }

        return false;
    }

    public boolean checkRoles(CategoryObject item) {
        boolean flag = false;
        return flag;
    }

    /**
     * editCategory
     *
     * @param item CategoryObject
     * @return boolean
     * @todo Implement this jsoft.ads.article.category.Category method
     */
    public boolean editCategory(CategoryObject item) {
        if (this.isEmpty(item)) {
            return false;
        }
        String sql = "UPDATE tblCategory SET ";
        sql += "category_name=?,category_section_id=?,";
        sql += "category_notes=?,";
        sql += "category_last_modified=?,";
        sql += "category_manager_id=?,category_enable=?,";
        sql += "category_delete=?,category_image=?,";
        sql += "category_name_en=?,category_language=?,";
        sql += "WHERE category_id=?)";

        //bien dich cau lenh
        try {
            PreparedStatement pre = this.con.prepareStatement(sql);
            //truyen gia tri
            pre.setString(1, item.getCategory_name());
            pre.setShort(2, item.getCategory_section_id());
            pre.setString(3, item.getCategory_notes());
            pre.setString(4, item.getCategory_last_modified());
            pre.setInt(5, item.getCategory_manager_id());
            pre.setBoolean(6, item.isCategory_enable());
            pre.setBoolean(7, item.isCategory_delete());
            pre.setString(8, item.getCategory_image());
            pre.setString(9, item.getCategory_name_en());
            pre.setByte(10, item.getCategory_language());
            pre.setShort(11, item.getCategory_id());
            return this.edit(pre);

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

    private boolean isEmpty(CategoryObject item) {
        boolean flag = true;
        String sql = "SELECT article_id FROM tblarticle WHERE ";
        sql += "article_category_id = ?";
        ResultSet rs = this.get(sql, item.getCategory_id());
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
     * getCategory
     *
     * @param username String
     * @param userpass String
     * @return ResultSet
     * @todo Implement this jsoft.ads.article.category.Category method
     */
    public ResultSet getCategory(short id) {
        String sql = "select * from tblCategory ";
        sql += "left join tblsection on category_section_id = section_id";
        sql += " where category_id = ?";
        return this.get(sql, id);
    }

    /**
     * getCategorys
     *
     * @param similar CategoryObject
     * @param at int
     * @param total byte
     * @return ResultSet
     * @todo Implement this jsoft.ads.article.category.Category method
     */
    public ResultSet getCategories(CategoryObject similar, int at, byte total) {
        String sql = "SELECT * FROM tblcategory ";
        sql += "LEFT JOIN tblsection ON tblcategory.category_section_id = tblsection.section_id ";
        sql += "ORDER BY category_name ASC ";
        sql += "LIMIT " + at + "," + total;
        return gets(sql);
    }

    public static void main(String[] args) {
    }
}
