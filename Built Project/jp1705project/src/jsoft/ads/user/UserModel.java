package jsoft.ads.user;


import jsoft.objects.*;
import jsoft.*;
import jsoft.ads.*;

import java.sql.*;
import java.util.*;

public class UserModel {

    private User u;

    public UserModel(ConnectionPool cp) {
        this.u = new UserImpl(cp);
    }

    protected void finalize() throws Throwable {
        this.u = null;
        super.finalize();
    }

    public ConnectionPool getCP(){
        return this.u.getCP();
    }

    public void releaseConnection(){
        this.u.releaseConnection();
    }

    //--------------------------------------------
    public boolean addUser(UserObject item) {
        return this.u.addUser(item);
    }

    public boolean editUser(UserObject item) {
        return this.u.editUser(item);
    }

    public boolean delUser(UserObject item) {
        return this.u.delUser(item);
    }

    //--------------------------------------------

    public UserObject getUserObject(short id){
        UserObject item = null;

        //Lay bang ghi doi tuong
        ResultSet rs = this.u.getUser(id);

        if(rs!= null){
            try {
                if (rs.next()) {
                    // Khoi tao bo nho luu tru
                    item = new UserObject();
                    item.setUser_id(rs.getShort("user_id"));
                    item.setUser_address(rs.getString("user_address"));
                    item.setUser_fullname(rs.getString("user_fullname"));
                    item.setUser_applyyear(rs.getShort("user_applyyear"));
                    item.setUser_birthday(rs.getString("user_birthday"));
                    item.setUser_email(rs.getString("user_email"));
                    item.setUser_homephone(rs.getString("user_homephone"));

                    item.setUser_permission(rs.getByte("user_permission"));
                    item.setUser_logined(rs.getShort("user_logined"));
                }
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return item;
    }

    public UserObject getUserObject(String username,String userpass){
       UserObject item = null;

       //Lay bang ghi doi tuong
       ResultSet rs = this.u.getUser(username,userpass);

       if(rs!= null){
           try {
               if (rs.next()) {
                   // Khoi tao bo nho luu tru
                   item = new UserObject();
                   item.setUser_id(rs.getShort("user_id"));
                   item.setUser_address(rs.getString("user_address"));
                   item.setUser_fullname(rs.getString("user_fullname"));
                   item.setUser_applyyear(rs.getShort("user_applyyear"));
                   item.setUser_birthday(rs.getString("user_birthday"));
                   item.setUser_email(rs.getString("user_email"));
                   item.setUser_homephone(rs.getString("user_homephone"));

                   item.setUser_permission(rs.getByte("user_permission"));
                   item.setUser_logined(rs.getShort("user_logined"));
               }
               rs.close();
           } catch (SQLException ex) {
               ex.printStackTrace();
           }
       }

       return item;
   }

   public ArrayList getUserObjects(UserObject similar, short page, byte total){

       ArrayList items = new ArrayList();

       UserObject item = null;

       //Lay danh sach bang ghi doi tuong
       int at = (page-1)*total;
       ResultSet rs = this.u.getUsers(similar,at,total);

       if(rs!= null){
           try {
               while (rs.next()) {
                   // Khoi tao bo nho luu tru
                   item = new UserObject();
                   item.setUser_id(rs.getShort("user_id"));
                   item.setUser_address(rs.getString("user_address"));
                   item.setUser_fullname(rs.getString("user_fullname"));
                   item.setUser_applyyear(rs.getShort("user_applyyear"));
                   item.setUser_birthday(rs.getString("user_birthday"));
                   item.setUser_email(rs.getString("user_email"));
                   item.setUser_homephone(rs.getString("user_homephone"));

                   item.setUser_permission(rs.getByte("user_permission"));
                   item.setUser_logined(rs.getShort("user_logined"));

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
        UserModel um = new UserModel(cp);
        ArrayList<UserObject> items = um.getUserObjects(null,(short)1,(byte)15);

        for(UserObject u : items){
            System.out.println(u.toString());
        }
    }
}
