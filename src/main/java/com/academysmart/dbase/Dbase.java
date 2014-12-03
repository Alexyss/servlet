package com.academysmart.dbase;

import com.academysmart.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            e.printStackTrace();
        }
        try {
            dbConnection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbConnection;
    }

    public static void execInsert (String query)  {
        Statement st = null;
        Connection dbConnection = null;
        try {
            dbConnection = getDBConnection();
            st = dbConnection.createStatement();
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.getMessage();
        }
        finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static List<Employee> execQueryEmployees (String query)  {
        Statement statement = null;
        Connection dbConnection = null;
        ResultSet rs = null;
        List<Employee> emp = new ArrayList<Employee>();
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()){
                Employee employee = new Employee();
                employee.setIdPerson(rs.getInt("IDPERSON"));
                employee.setName(rs.getString("NAME"));
                employee.setFamily(rs.getString("FAMILY"));
                employee.setEmail(rs.getString("EMAIL"));
                emp.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return emp;
    }
}

























//    private static Connection getDBConnection() {
//        Connection dbConnection = null;
//        url = "jdbc:oracle:thin:@" + server + ":" + port + ":" + sid;
//        try {
//            Class.forName(driverName);
//        } catch (ClassNotFoundException e) {
//        }
//        try {
//            dbConnection = DriverManager.getConnection(url, username, password);
//            return dbConnection;
//        } catch (SQLException e) {
//        }
//        return dbConnection;
//    }


//    public static void execUpdate (String query) {
//        try {
//            Connection dbConnection = getDBConnection();
//            Statement statement = dbConnection.createStatement();
//            statement.executeUpdate(query);
//        } catch (SQLException e) {
//            e.getMessage();
//        }
//    }



//while (rs.next()) {
//        String userid = rs.getString("USER_ID");
//        String username = rs.getString("USERNAME");
//
//        System.out.println("userid : " + userid);
//        System.out.println("username : " + username);
//        }


//    private static void createDbUserTable() throws SQLException {
//        Connection dbConnection = null;
//        Statement statement = null;
//        String createTableSQL = "CREATE TABLE Employees("
//                + "idPerson NUMBER(5) NOT NULL, "
//                + "name VARCHAR(50) , "
//                + "family VARCHAR(50) , "
//                + "email VARCHAR(50), " + "PRIMARY KEY (idPerson) "
//                + ")";
//        try {
//            dbConnection = getDBConnection();
//            statement = dbConnection.createStatement();
//
//            // выполнить SQL запрос
//            statement.execute(createTableSQL);
//        } catch (SQLException e) {
//        } finally {
//            if (statement != null) {
//                statement.close();
//            }
//            if (dbConnection != null) {
//                dbConnection.close();
//            }
//        }
//    }

//    private static void createDbUserTable() throws SQLException {
//        Connection dbConnection = null;
//        Statement statement = null;
//        String createTableSQL = "CREATE TABLE Employees("
//                + "idPerson NUMBER(5) NOT NULL, "
//                + "name VARCHAR(50) , "
//                + "family VARCHAR(50) , "
//                + "email VARCHAR(50), " + "PRIMARY KEY (idPerson) "
//                + ")";
//        try {
//            dbConnection = getDBConnection();
//            statement = dbConnection.createStatement();
//
//            // выполнить SQL запрос
//            statement.execute(createTableSQL);
//        } catch (SQLException e) {
//        } finally {
//            if (statement != null) {
//                statement.close();
//            }
//            if (dbConnection != null) {
//                dbConnection.close();
//            }
//        }
//    }