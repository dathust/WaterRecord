/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DatPT
 */
public class ConnectDB {
    private static Connection conn;
    
    public static Connection getConnection() {
        conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/waterrecord","root","");
        } catch(ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }
    public static void closeConnection() {
        try {
            if (conn != null)
                conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
