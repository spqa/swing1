/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing2;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author QuangAnh
 */
public class JoptionPaneDemo extends JFrame{
    JButton btnInput,btnShow;
    JLabel lblTitle;
    JPanel pnlBtn;
    public JoptionPaneDemo() throws HeadlessException {
        setTitle("Option");
        setSize(500,500);
        setLayout(new FlowLayout());
        
        lblTitle=new JLabel();
        lblTitle.setText("SU DUNG JOPTIONPANE");
        getContentPane().add(lblTitle);
        
        btnInput=new JButton("Show inputDialog");
        btnShow=new JButton("Show Modal Dialog");
        pnlBtn=new JPanel();
        pnlBtn.setPreferredSize(new Dimension(400, 100));
        pnlBtn.add(btnInput);
        pnlBtn.add(btnShow);
        getContentPane().add(pnlBtn);
        
        btnInput.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
         Object[] option={"C1009HV","dfsdfs","aaaaaaa","fsdsdfsfsd","gdfgdf"};
               Object temp= JOptionPane.showInputDialog(null, "Choose class","chon lop hoc",JOptionPane.INFORMATION_MESSAGE,null,option,option[0]);
                System.out.println(temp);
            }
        });
        
        
        btnShow.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(rootPane, "modal");
            }
        });
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        JoptionPaneDemo j=new JoptionPaneDemo();
    }
}
