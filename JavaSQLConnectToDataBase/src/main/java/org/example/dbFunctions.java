package org.example;

import java.sql.*;

public class dbFunctions {

    public Connection connectToDb(String dataaBaseName, String user, String pass) {
        Connection conn = null;

        try {

            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dataaBaseName, user, pass);
            if (conn != null) {
                System.out.println("Connection Established!");
            } else {
                System.out.println("Connection Failed!");
            }


        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

    public void insertTable(Connection conn, String tableName, String customerID, String firstName, String lastName, String email) {
        Statement statement;
        try {

            String query = "insert into %s(customerid, firstName, lastName, email) values ('%s','%s','%s','%s')";
            String insertCommand = String.format(query, tableName, customerID, firstName, lastName, email);
            statement = conn.createStatement();
            statement.executeUpdate(insertCommand);
            System.out.println("Row Inserted!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void selectTable(Connection conn, String whichRow, String nameTable) {
        Statement statement;
        ResultSet resultSet = null;
        try {

            String query = "select %s from %s";
            String finalQuery = String.format(query, whichRow, nameTable);
            statement = conn.createStatement();
            resultSet = statement.executeQuery(finalQuery);
            System.out.println("Select Table Success!");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("customerid") + " ");
                System.out.println(resultSet.getString("firstName") + " ");
                System.out.println(resultSet.getString("lastName") + " ");
                System.out.println(resultSet.getString("email") + " ");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


