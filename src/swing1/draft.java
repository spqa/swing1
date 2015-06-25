/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author QuangAnh
 */
public class draft {
    SingleDbConn s=new SingleDbConn();
    ResultSet rs=null;
    ResultSet rs1=null;
    PreparedStatement pre=null;
    PreparedStatement pre1=null;
    public void test() throws SQLException{
        String sql="select * from `tbluser` where `user`=? and `password`=?";
        String sql1="select * from `tbluser` where 1";
        System.out.println("enter name");
        Scanner sc=new Scanner(System.in);
        String name=sc.nextLine();
        System.out.println("Enter password");
        String pass=sc.nextLine();
        pre=s.getConn().prepareStatement(sql);
        pre.setString(1, name);
        pre.setString(2, pass);
        pre1=s.getConn().prepareStatement(sql1);
        rs1=pre1.executeQuery();
        
        rs=pre.executeQuery();               
        boolean value =pre.execute();
        System.out.println(value);
       
        while(rs.next()){
            System.out.println(rs);
        System.out.println(rs.getString(2));
        }
        
    }
    public static void main(String[] args) throws SQLException {
        draft d=new draft();
        d.test();
    }
}
