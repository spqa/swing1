/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing3;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author QuangAnh
 */
public class LoginForm extends JFrame{
    JPanel pnlRadio,pnlName,pnlPass,pnlbtn,pnl1,pnl2;
    JRadioButton rdLogin,rdDisplay;
    JLabel lblName,lblPass;
    JTextField txtname;
    JPasswordField txtPass;
    JButton btnLogin,btnDisplay;
    CardLayout card;
    String pass;
    public LoginForm() throws HeadlessException {
        setTitle("Login");
        setSize(500,500);
        setLayout(new FlowLayout());
        
        rdDisplay=new JRadioButton("Login");
        rdLogin=new JRadioButton("Display");
        pnlRadio=new JPanel();
        pnlRadio.setPreferredSize(new Dimension(400, 100));
        pnlRadio.setBorder(BorderFactory.createTitledBorder("Toggle"));
        pnlRadio.add(rdDisplay);
        pnlRadio.add(rdLogin);
        
        lblName=new JLabel("UserName");
        txtname=new JTextField();
        txtname.setPreferredSize(new Dimension(300, 25));
        pnlName=new JPanel();
        pnlName.setPreferredSize(new Dimension(400, 100));
        pnlName.add(lblName);
        pnlName.add(txtname);
        
        lblPass=new JLabel("Password");
        txtPass=new JPasswordField();
        txtPass.setPreferredSize(new Dimension(300  , 25));
        pnlPass=new JPanel();
        pnlPass.setPreferredSize(new Dimension(400 , 100));
        pnlPass.add(lblPass);
        pnlPass.add(txtPass);
        
        card=new CardLayout();
        btnDisplay=new JButton("Display");
        pnl1=new JPanel();
        pnl1.setPreferredSize(new Dimension(50, 50));
        pnl1.add(btnDisplay);
        btnLogin=new JButton("Login");
        pnl2=new JPanel();
        pnl2.setPreferredSize(new Dimension(50, 50));
        pnl2.add(btnLogin);
        pnlbtn=new JPanel(card);
        pnlbtn.setPreferredSize(new Dimension(400, 100));
        pnlbtn.add(pnl1,"Login");
        pnlbtn.add(pnl2,"Display");
        
        getContentPane().add(pnlRadio);
        getContentPane().add(pnlName);
        getContentPane().add(pnlPass);
        getContentPane().add(pnlbtn);
        
        btnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 pass=new String(txtPass.getPassword());
         if(txtname.getText().equals("admin")&&pass.equals("admin")){
             JOptionPane.showMessageDialog(null, "Valid");
         }else{
             JOptionPane.showMessageDialog(null, "Invalid");
         }
            }
        });
        
        btnDisplay.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pass=new String(txtPass.getPassword());
         JOptionPane.showMessageDialog(null, "Name: "+txtname.getText()+"- Pass:"+pass);
            }
        });
        
        rdLogin.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                card.show(pnlbtn,"Login" );
            }
        });
        
        rdDisplay.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
         card.show(pnlbtn, "Display");
            }
        });
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }
    public static void main(String[] args) {
        GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd=ge.getDefaultScreenDevice();
        JFrame.setDefaultLookAndFeelDecorated(true);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
         LoginForm l=new LoginForm();
         l.setOpacity(0.55f);
            }
        });
    }
}
