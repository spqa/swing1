/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author QuangAnh
 */
public class Swing1 extends JFrame {

    JLabel lblUser, lblPass;
    JTextField txtUser;
    JPasswordField txtPass;
    JPanel pnlUser, pnlPass, pnlBtn;
    JButton btnSubmit, btnReset;
    ResultSet rs=null;
    Statement stmt=null;

    public Swing1() throws HeadlessException {
        setTitle("Login Form");
        setSize(500, 500);
        setLayout(new FlowLayout());
        lblUser = new JLabel();
        lblUser.setText("User :");
        txtUser = new JTextField();
        txtUser.setPreferredSize(new Dimension(125, 25));
        pnlUser = new JPanel();
        pnlUser.add(lblUser);
        pnlUser.add(txtUser);
        pnlUser.setPreferredSize(new Dimension(450, 30));
        getContentPane().add(pnlUser);

        lblPass = new JLabel();
        lblPass.setText("Password :");
        txtPass=new JPasswordField();
        txtPass.setPreferredSize(new Dimension(125, 25));
        pnlPass=new JPanel();
        pnlPass.add(lblPass);
        pnlPass.add(txtPass);
        pnlPass.setPreferredSize(new Dimension(450, 30));
        getContentPane().add(pnlPass);
        
        btnSubmit=new JButton("Submit");
        btnReset=new JButton("Reset");
        pnlBtn=new JPanel();
        pnlBtn.add(btnReset);
        pnlBtn.add(btnSubmit);
        getContentPane().add(pnlBtn);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //event btn
        btnSubmit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SingleDbConn s=new SingleDbConn();
                String sql="Select * from tbluser where user=? and password=?";
                try {
                    PreparedStatement pre=s.getConn().prepareStatement(sql);
                    pre.setString(1, txtUser.getText());
                    pre.setString(2, String.valueOf(txtPass.getPassword()));          
                    rs= pre.executeQuery();
                    if(rs.next()){
                        JOptionPane.showMessageDialog(null, "successfully!!");
                    }else{
                        JOptionPane.showMessageDialog(null, "wrong input");
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Swing1.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
        });
    }

    public static void main(String[] args) {
        Swing1 s = new Swing1();
    }

}
