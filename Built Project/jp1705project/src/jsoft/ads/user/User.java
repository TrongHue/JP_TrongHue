package jsoft.ads.user;
import jsoft.objects.*;
import java.sql.*;
import jsoft.*;

public interface User extends ShareControl {
    public boolean addUser(UserObject item);
    public boolean editUser(UserObject item);
    public boolean delUser(UserObject item);
    public ResultSet getUser(int id);
    public ResultSet getUser(String username, String userpass);
    public ResultSet getUsers(UserObject similar, int at, byte total);
}
