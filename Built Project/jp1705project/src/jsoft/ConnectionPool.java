package jsoft;
import java.sql.*;

public interface ConnectionPool {
    // Xin 1 ket noi
    public Connection getConnection(String objectName) throws SQLException;

    // yeu cau tra lai ket noi
    public void releaseConnection(Connection con, String objectName) throws SQLException;
}
