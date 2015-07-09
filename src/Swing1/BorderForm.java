/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author QuangAnh
 */
public class BorderForm extends JFrame{
    JLabel lblCode,lblClass,lblName;
    JPanel pnlInfo;
    JTextField txtName,txtClass,txtCode;
    public BorderForm() throws HeadlessException {
        setTitle("Form with border");
        setSize(500,500);
        setLayout(new FlowLayout());
        lblName=new JLabel();
        lblName.setText("Name");
        txtName=new JTextField();
        txtName.setPreferredSize(new Dimension(125, 25));
        lblClass=new JLabel();
        lblClass.setText("Class");
        txtClass=new JTextField();
        txtClass.setPreferredSize(new Dimension(125, 25));
        pnlInfo=new JPanel();
        pnlInfo.setPreferredSize(new Dimension(400, 200));
        pnlInfo.setBorder(BorderFactory.createTitledBorder("Information"));
        pnlInfo.add(lblName);
        pnlInfo.add(txtName);
        pnlInfo.add(lblClass);
        pnlInfo.add(txtClass);
        getContentPane().add(pnlInfo);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        BorderForm b=new BorderForm();
    }
}
