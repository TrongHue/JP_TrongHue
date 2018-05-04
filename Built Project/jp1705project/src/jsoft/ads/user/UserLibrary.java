package jsoft.ads.user;

import jsoft.objects.*;
import java.util.*;

public class UserLibrary {
    public UserLibrary() {
    }

    public static String viewUsers(ArrayList<UserObject> items) {
        String tmp = "";
        int no = 0;

        for (UserObject item : items) {
            no++;
            tmp += "<tr>";
            tmp += "<td>"+no+"</td>";
            tmp += "<td>" + item.getUser_name() + "</td>";
            tmp += "<td>" + item.getUser_address() + "</td>";
            tmp += "<td>" + item.getUser_email() + "</td>";
            tmp += "<td>" + item.getUser_homephone() + "</td>";
            tmp += "<td>" + item.getUser_fullname() + "</td>";
            tmp += "<td>" + item.getUser_logined() + "</td>";
            tmp += "<td>Sua</td>";
            tmp += "<td>Xoa</td>";
            tmp += "<td>" + item.getUser_id() + "</td>";
            tmp += "<tr>";

            tmp+="\n"; //sau nay len servlet thi bo di
        }

        return tmp;
    }

    public static void main(String[] args) {
        UserLibrary userlibrary = new UserLibrary();
    }
}
