/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing5;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author QuangAnh
 */
public class JlistDemo extends JFrame{
    JPanel pnlLeft,pnlRight;
    JLabel lblImg;
    JList<ImageClass> listImg;
    Vector<ImageClass> tempImg;
    JScrollPane scp;
    public JlistDemo() throws HeadlessException {
        setTitle("Form");
        setSize(500,500);
        
        tempImg=new Vector<>();
        tempImg.addElement(new ImageClass("image1", "src/swing5/img/1.jpg"));
        tempImg.addElement(new ImageClass("image2", "src/swing5/img/2.jpg"));
        tempImg.addElement(new ImageClass("image3", "src/swing5/img/3.jpg"));
        tempImg.addElement(new ImageClass("image4", "src/swing5/img/4.jpg"));
        tempImg.addElement(new ImageClass("image5", "src/swing5/img/5.jpg"));
        
        listImg=new JList<>(tempImg);
        listImg.setListData(tempImg);
        listImg.setPreferredSize(new Dimension(120, 150));
        scp=new JScrollPane(listImg);
        pnlLeft=new JPanel();
        pnlLeft.setPreferredSize(new Dimension(200, 500));
        pnlLeft.add(scp);
        getContentPane().add(pnlLeft,BorderLayout.WEST);
        
        lblImg=new JLabel();
        pnlRight=new JPanel();
        pnlRight.setPreferredSize(new Dimension(300, 500));
        pnlRight.add(lblImg);
        getContentPane().add(pnlRight,BorderLayout.EAST);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        listImg.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
lblImg.setIcon(new ImageIcon(tempImg.get(listImg.getSelectedIndex()).getUrl()));
            }
        });
    }
    public static void main(String[] args) {
        GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd=ge.getDefaultScreenDevice();
        JFrame.setDefaultLookAndFeelDecorated(true);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
         JlistDemo f=new JlistDemo();
         f.setOpacity(0.70f);
            }
        });
    }
}
