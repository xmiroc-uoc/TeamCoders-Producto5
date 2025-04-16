package DAO.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
    private static String url = "jdbc:mysql://localhost:3306/TeamCodersBD";
    private static String user = "root";
    private static String password = "root123";

    private DBConnection(){

    }

    public static Connection getConnection() throws SQLException{
        Connection connection = null;
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
}
