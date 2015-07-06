/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingDB;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author QuangAnh
 */
public class Draft {
    SingleDBConn s=new SingleDBConn();
    String sql="select * from tblStudent";
    ResultSet rs=null;
    Statement stmt=null;
    public void test() throws SQLException{
    stmt=s.getConnection().createStatement();
    rs=stmt.executeQuery(sql);
        ResultSetMetaData meta=rs.getMetaData();
        String cl1=meta.getColumnLabel(1);
        System.out.println(cl1);
    }
    public static void main(String[] args) throws SQLException {
        Draft d=new Draft();
        d.test();
    }
}
