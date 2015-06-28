/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author QuangAnh
 */
public class draft extends JFrame{
    JPasswordField txtpass;
    JButton btn;
    char[] p;
    String pass;
    public draft() throws HeadlessException {
        setTitle("sdgfsdf");
        setSize(500,500);
        setLayout(new FlowLayout());
        txtpass=new JPasswordField();
        txtpass.setPreferredSize(new Dimension(125, 25));
        getContentPane().add(txtpass);
        
        btn=new JButton("dfsf");
        getContentPane().add(btn);
        
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pass=new String(txtpass.getPassword());
                JOptionPane.showMessageDialog(null, pass);
            }
        });
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        new draft();
    }
}
