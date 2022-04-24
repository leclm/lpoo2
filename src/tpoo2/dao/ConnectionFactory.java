package tpoo2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
    private ConnectionFactory(){}
    
    private static final String host = "jdbc:mysql://localhost/tpoo2?useSSL=false";
    private static final String user = "root";
    private static final String pwd = "Tuti19";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(host, user, pwd);
    }
    
    public static void close(Connection con, PreparedStatement st, ResultSet rs) throws SQLException{
        if (rs != null) con.close();
        if (st != null) st.close();
        if (con != null) con.close();
    }
}
