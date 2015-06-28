/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
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
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author QuangAnh
 */
public class Assign1 extends JFrame{
    JPanel pnlLeft,pnlRight,pnlFont,pnlSize,pnlProgress,pnlSubmit;
    JLabel lblName;
    JTextField txtName;
    JRadioButton rdBold,rdItalic;
    JSlider sldSize;
    JProgressBar pgb;
    JButton btnSubmit;
    Timer tmr;
    int n;
    public Assign1() throws HeadlessException {
        setTitle("Form");
        setSize(700,400);
        setLayout(new BorderLayout());
        
        lblName=new JLabel();
        lblName.setText("Your name");
        lblName.setPreferredSize(new Dimension(370, 350));
        txtName=new JTextField();       
        pnlLeft=new JPanel(new BorderLayout());
        pnlLeft.setPreferredSize(new Dimension(370, 400));
        pnlLeft.setBackground(Color.cyan);
        pnlLeft.add(lblName,BorderLayout.NORTH);
        pnlLeft.add(txtName,BorderLayout.SOUTH);
        getContentPane().add(pnlLeft,BorderLayout.WEST);
        
        rdBold=new JRadioButton("Bold");
        rdBold.setBackground(Color.red);
        rdItalic=new JRadioButton("Italic");
        rdItalic.setBackground(Color.red);
        pnlFont=new JPanel();
        pnlFont.add(rdBold);
        pnlFont.add(rdItalic);
        pnlFont.setPreferredSize(new Dimension(300, 75));
        pnlFont.setBackground(Color.red);
        pnlFont.setBorder(BorderFactory.createTitledBorder("Font Style"));
        
        sldSize=new JSlider();
        sldSize.setMajorTickSpacing(50);
        sldSize.setBackground(Color.magenta);
        sldSize.setPaintTicks(true);
        pnlSize=new JPanel();
        pnlSize.add(sldSize);
        pnlSize.setPreferredSize(new Dimension(300, 75));
        pnlSize.setBackground(Color.MAGENTA);
        pnlSize.setBorder(BorderFactory.createTitledBorder("Size"));
        
        btnSubmit=new JButton("Submit");
        btnSubmit.setBackground(Color.GREEN);
        pnlSubmit=new JPanel();
        pnlSubmit.add(btnSubmit);
        pnlSubmit.setPreferredSize(new Dimension(300, 75));
        pnlSubmit.setBorder(BorderFactory.createTitledBorder("Submit"));
        
        pgb=new JProgressBar(0, 60);
        pnlProgress=new JPanel();
        pnlProgress.setPreferredSize(new Dimension(300, 75));
        pnlProgress.setBackground(Color.LIGHT_GRAY);
        pnlProgress.add(pgb);
        pnlProgress.setBorder(BorderFactory.createTitledBorder("Progress"));
        
        pnlRight=new JPanel(new GridLayout(4, 1));
        pnlRight.setPreferredSize(new Dimension(300, 400));
        pnlRight.add(pnlFont);
        pnlRight.add(pnlSize);
        pnlRight.add(pnlProgress);
        pnlRight.add(pnlSubmit);
        getContentPane().add(pnlRight,BorderLayout.EAST);
        
        tmr=new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
           pgb.setValue(n);
           n++;
           if(pgb.getValue()>=60){
               JOptionPane.showMessageDialog(null,"Game Over!");
               tmr.stop();
           }
            }
        });
        tmr.start();
        
        sldSize.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
         lblName.setFont(new Font("arial", Font.ITALIC, sldSize.getValue()));
            }
        });
        
        rdBold.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
         lblName.setFont(new Font("serif", Font.BOLD,sldSize.getValue()));
            }
        });
        
        rdItalic.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
         lblName.setFont(new Font("serif", Font.ITALIC, sldSize.getValue()));
            }
        });
        
        btnSubmit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
         if(txtName.getText().equals("")){
         JOptionPane.showMessageDialog(null, "pls Enter name");
         }else{
             JOptionPane.showMessageDialog(null, "Your name:"+txtName.getText());
         }
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
        Assign1 a=new Assign1();
        a.setOpacity(0.70f);
            }
        });
    }
}
