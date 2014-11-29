package com.academysmart.dbase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by User on 29.11.14.
 */
public class Dbase {
    final private static String driverName = "oracle.jdbc.driver.OracleDriver";
    private static String url;
    final private static String server = "localhost";
    final private static String port = "1521";
    final private static String sid = "XE";
    final private static String username = "Borovik";
    final private static String password = "123";

    private static Connection getDBConnection() {
        Connection dbConnection = null;
        url = "jdbc:oracle:thin:@" + server + ":" + port + ":" + sid;
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            //System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(url, username, password);
            return dbConnection;
        } catch (SQLException e) {
           // System.out.println(e.getMessage());
        }
        return dbConnection;
    }

    private static void createDbUserTable() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String createTableSQL = "CREATE TABLE Employees("
                + "idPerson NUMBER(5) NOT NULL, "
                + "name VARCHAR(50) , "
                + "family VARCHAR(50) , "
                + "email VARCHAR(50), " + "PRIMARY KEY (idPerson) "
                + ")";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.execute(createTableSQL);
            //System.out.println("Table \"dbuser\" is created!");
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
}
