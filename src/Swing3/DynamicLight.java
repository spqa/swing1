/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author QuangAnh
 */
public class DynamicLight extends JFrame {

    JPanel[] pnl;
    Random colorRan;
    Timer tmr;

    public DynamicLight() throws HeadlessException {
        setTitle("Suffle Lamp");
        setSize(500, 500);
        setLayout(new GridLayout(12, 9));
        pnl = new JPanel[99];
        colorRan = new Random();
        for (int i = 0; i < pnl.length; i++) {
            pnl[i] = new JPanel();
            pnl[i].setPreferredSize(new Dimension(20, 20));
            pnl[i].setBackground(new Color(colorRan.nextInt(255), colorRan.nextInt(255), colorRan.nextInt(255)));
            getContentPane().add(pnl[i]);
        }

        tmr = new Timer(0, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < pnl.length; i++) {
                         pnl[i].setBackground(new Color(colorRan.nextInt(255), colorRan.nextInt(255), colorRan.nextInt(255)));
                        
                    }
 
            }
        });
        tmr.start();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        JFrame.setDefaultLookAndFeelDecorated(true);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                DynamicLight d = new DynamicLight();
                d.setOpacity(0.70f);
            }
        });
    }
}
