package ua.kiev.prog.jdbc.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
    Driver
    DriverManager
    DataSource
    Connection
    Statement
        PreparedStatement
        CallableStatement
    ResultSet
    SQLException
    close
 */
public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",
                    "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
