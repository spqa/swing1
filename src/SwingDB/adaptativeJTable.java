/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingDB;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author QuangAnh
 */
public class adaptativeJTable extends JFrame{
    JTable tbl;
    DefaultTableModel dataTbl;
    JScrollPane scp;
    String sql="select * from tblStudent";
    ResultSet rs=null;
    Statement stmt=null;
    ResultSetMetaData meta=null;
    public adaptativeJTable() throws HeadlessException, SQLException {
        setTitle("Jtable with any dbTable");
        setSize(500,500);
        SingleDBConn s=new SingleDBConn();
        
        dataTbl=new DefaultTableModel();
        stmt=s.getConnection().createStatement();
        rs=stmt.executeQuery(sql);
        meta=rs.getMetaData();
        int count=meta.getColumnCount();
        for(int i=1;i<=count;i++){
            dataTbl.addColumn(meta.getColumnLabel(i));
        }
        while(rs.next()){
            String[] data=new String[count];
            for(int i=1;i<=count;i++){
                data[i-1]=rs.getString(i);
            }
            dataTbl.addRow(data);
        }
        tbl=new JTable(dataTbl);
        scp=new JScrollPane(tbl);
        scp.setPreferredSize(new Dimension(450, 300));
        getContentPane().add(scp);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }
    public static void main(String[] args) throws HeadlessException, SQLException {
        adaptativeJTable a=new adaptativeJTable();
    }
}
