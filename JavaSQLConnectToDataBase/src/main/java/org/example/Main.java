package org.example;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        dbFunctions db = new dbFunctions();
        Connection conn = db.connectToDb("tim", "timapam", "12345");
        db.insertTable(conn,"customer","5","Vanya","IVanya","stgfdbe@gmail.com");
        db.selectTable(conn, "*", "customer");
    }
}