package jsoft.ads.user;

import jsoft.*;
import jsoft.objects.*;

import java.util.*;

public class UserControl {

    private UserModel um;

    public UserControl(ConnectionPool cp) {
        this.um = new UserModel(cp);
    }

    protected void finalize() throws Throwable {
        this.um = null;
        super.finalize();
    }

    public ConnectionPool getCP(){
       return this.um.getCP();
   }

   public void releaseConnection(){
       this.um.releaseConnection();
   }


    //--------------------------------------------
    public boolean addUser(UserObject item) {
        return this.um.addUser(item);
    }

    public boolean editUser(UserObject item) {
        return this.um.editUser(item);
    }

    public boolean delUser(UserObject item) {
        return this.um.delUser(item);
    }

    public UserObject getUserObject(String username, String userpass) {
        return this.um.getUserObject(username, userpass);
    }

    //--------------------------------------------


    public String viewUsers(UserObject similar, short page, byte total) {
        // lay danh sach doi tuong
        ArrayList<UserObject> items = this.um.getUserObjects(similar,page,total);
        return UserLibrary.viewUsers(items);
    }

    public static void main(String[] args) {
        ConnectionPool cp = new ConnectionPoolImpl();
        UserControl uc = new UserControl(cp);

        String view = uc.viewUsers(null,(short)1,(byte)15);
        System.out.println(view);
    }
}
