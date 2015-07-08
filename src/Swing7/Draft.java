/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing7;

import java.awt.Dimension;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextPane;

/**
 *
 * @author QuangAnh
 */
public class Draft extends JFrame{
    JTextPane pnltest;
    public Draft() {
        setTitle("fgsdfsd");
        setSize(500,500);
        
        pnltest=new JTextPane();
        pnltest.setPreferredSize(new Dimension(450, 300));
        
        getContentPane().add(pnltest);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    
    public static void main(String[] args) throws MalformedURLException {
        Draft d=new Draft();
        
    }
}
