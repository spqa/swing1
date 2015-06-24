/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing2;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author QuangAnh
 */
public class JSliderDemo extends JFrame{
    JSlider sld;
    JTextPane txtPane;
    JPanel pnlsld;
    public JSliderDemo() throws HeadlessException {
        setTitle("Change font size");
        setSize(500,500);
        setLayout(new FlowLayout());
        
        sld=new JSlider();
        sld.setPaintLabels(true);
        sld.setPaintTicks(true);
        sld.setPaintTrack(true);
        sld.setMajorTickSpacing(20);
        sld.setMinorTickSpacing(5);
        pnlsld=new JPanel();
        pnlsld.add(sld);
        getContentPane().add(pnlsld);
        
        txtPane=new JTextPane();
        
        txtPane.setPreferredSize(new Dimension(400, 200));
        getContentPane().add(txtPane);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        sld.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
         txtPane.setFont(new Font("arial", Font.BOLD, sld.getValue()));
            }
        });
   }
    public static void main(String[] args) {
        JSliderDemo j=new JSliderDemo();
    }
    
}
