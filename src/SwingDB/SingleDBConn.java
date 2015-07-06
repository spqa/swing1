/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author QuangAnh
 */
public class SingleDBConn {
    Connection conn;
    
    private static final String JBDC="com.mysql.jdbc.Driver";
    private static final String DBURL="jdbc:mysql://sql6.freemysqlhosting.net:3306/sql682900";
    private static  final String user="sql682900";
    private static  final String pass="dL7!bR1%";
    public Connection getConnection(){
        try {
            Class.forName(JBDC);
            conn=DriverManager.getConnection(DBURL, user, pass);
            return conn;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SingleDBConn.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }
    public static void main(String[] args) {
        SingleDBConn f=new SingleDBConn();
        f.getConnection();
    }
}
