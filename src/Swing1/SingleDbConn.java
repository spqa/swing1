/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author QuangAnh
 */
public class SingleDbConn {

    Connection conn = null;
    static final String JDBC = "com.mysql.jdbc.Driver";
    static final String DBURL = "jdbc:mysql://localhost:3306/account";
    static final String User = "root";
    static final String Pass = "";

    public Connection getConn() {
        try {
            Class.forName(JDBC);
            conn = DriverManager.getConnection(DBURL, User, Pass);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

        return conn;
    }

}
