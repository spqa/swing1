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
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author QuangAnh
 */
public class TimerSlideShow extends JFrame{
    Timer tmr;
    JLabel lblimg,lblTitle;
    JPanel pnlimg,pnlTitle;
    ImageIcon icon[];
    int i=0;

    public TimerSlideShow() throws HeadlessException {
        setTitle("slide Show");
        setSize(500,500);
        setLayout(new FlowLayout());
        
        lblTitle=new JLabel();
        lblTitle.setText("Using timer to create Slide Show");
        pnlTitle=new JPanel();
        pnlTitle.setPreferredSize(new Dimension(500, 100));
        pnlTitle.add(lblTitle);
        getContentPane().add(pnlTitle);
        
        icon=new ImageIcon[5];
        icon[0]=new ImageIcon("src/swing2/1.jpg");
        icon[1]=new ImageIcon("src/swing2/2.jpg");
        icon[2]=new ImageIcon("src/swing2/3.jpg");
        icon[3]=new ImageIcon("src/swing2/4.jpg");
        icon[4]=new ImageIcon("src/swing2/5.jpg");
        lblimg=new JLabel();
        pnlimg=new JPanel();
        pnlimg.setPreferredSize(new Dimension(400,200 ));
        pnlimg.add(lblimg);
        getContentPane().add(pnlimg);
        tmr=new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
           if(i<4){
           lblimg.setIcon(icon[i]);
           i++;
           }else{
           i=0;
           }
            }
        });
        tmr.start();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        TimerSlideShow t=new TimerSlideShow();
    }
}
