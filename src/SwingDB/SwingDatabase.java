/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingDB;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author QuangAnh
 */
public class SwingDatabase extends JFrame{
    JButton btnGet;
    JTable tblData;
    DefaultTableModel dataTbl;
    JScrollPane scp;
    Vector<Student> arrStudent;
    ResultSet rs=null;
    String sql_getAll="select * from tblStudent where 1";
    Statement stmt=null;
    String[] columns;
    public SwingDatabase() throws HeadlessException, SQLException {
        setTitle("Getdata");
        setSize(500, 500);
        arrStudent=new Vector<>();
        SingleDBConn s=new SingleDBConn();
        stmt=s.getConnection().createStatement();
        rs=stmt.executeQuery(sql_getAll);
        while(rs.next()){
        arrStudent.addElement(new Student(String.valueOf(rs.getInt(1)), rs.getString(2), rs.getString(3)));
        }
        btnGet=new JButton("getData");
        getContentPane().add(btnGet,BorderLayout.NORTH);
        dataTbl=new DefaultTableModel();
        ResultSetMetaData meta=rs.getMetaData();
        int count=meta.getColumnCount();
        columns=new String[count];
        for(int i=1;i<=count;i++){
            dataTbl.addColumn(meta.getColumnLabel(i));            
        }
        
        tblData=new JTable(dataTbl);
        for (Student arrStudent1 : arrStudent) {
            dataTbl.addRow(arrStudent1.getStringArr());
        }
        scp=new JScrollPane(tblData);
        scp.setPreferredSize(new Dimension(450, 200));
        getContentPane().add(scp,BorderLayout.SOUTH);
        
        setVisible(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                String[] option={"Yes","No"};
                int get= JOptionPane.showOptionDialog(null, "Wanna exit?", "Warning", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE, null, option, option[1]);
              if(get==0){
              System.exit(0);
              }
            }
            
});
    }
    public static void main(String[] args) throws HeadlessException, SQLException {
        SwingDatabase s=new SwingDatabase();
    }
}
