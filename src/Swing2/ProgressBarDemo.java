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
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

/**
 *
 * @author QuangAnh
 */
public class ProgressBarDemo extends JFrame {
    
    JProgressBar pgb;
    Timer tmr;
    JPanel pnlPro, pnlbtn;
    JLabel lblTitle;
    int n;
    JButton btnStart, btnStop, btnPause;
    
    public ProgressBarDemo() throws HeadlessException {
        setTitle("Progress");
        setSize(500, 500);
        setLayout(new FlowLayout());
        
        lblTitle = new JLabel();
        lblTitle.setText("Progress Bar");
        getContentPane().add(lblTitle);
        
        pgb = new JProgressBar();
        pnlPro = new JPanel();
        pnlPro.setPreferredSize(new Dimension(500, 100));
        pnlPro.add(pgb);
        getContentPane().add(pnlPro);
        
        tmr = new Timer(1000, new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                pgb.setValue(n);
                n += 10;
                
            }
        });
        
        btnPause = new JButton("Pause");
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");
        pnlbtn = new JPanel();
        pnlbtn.setPreferredSize(new Dimension(500, 100));
        pnlbtn.add(btnStart);
        pnlbtn.add(btnPause);
        pnlbtn.add(btnStop);
        getContentPane().add(pnlbtn);
        
        btnStart.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                tmr.start();
            }
        });
        
        btnPause.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                tmr.stop();
            }
        });
        
        btnStop.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        ProgressBarDemo p = new ProgressBarDemo();
        
    }
}
