/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing5;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author QuangAnh
 */
public class JcomboBoxdemo extends JFrame{
    JComboBox<ImageClass> cbImg;
    DefaultComboBoxModel<ImageClass> dataCb;
    JPanel pnlTop,pnlBot;
    JLabel lblSelect,lblImg;
    ImageClass[] arrImg;
    public JcomboBoxdemo() throws HeadlessException {
        setTitle("gdfdf");
        setSize(500,500);
        arrImg=new ImageClass[5];
        arrImg[0]=new ImageClass("Image1","src/swing5/img/1.jpg");
        arrImg[1]=new ImageClass("Image2","src/swing5/img/2.jpg");
        arrImg[2]=new ImageClass("Image3","src/swing5/img/3.jpg");
        arrImg[3]=new ImageClass("Image4","src/swing5/img/4.jpg");
        arrImg[4]=new ImageClass("Image5","src/swing5/img/5.jpg");
        
        lblSelect=new JLabel("Select Image");
        cbImg=new JComboBox<>(arrImg);
        dataCb=new DefaultComboBoxModel<>(arrImg);
        cbImg.setModel(dataCb);
        pnlTop=new JPanel(new FlowLayout());
        pnlTop.setPreferredSize(new Dimension(400, 100));
        pnlTop.add(lblSelect);
        pnlTop.add(cbImg);
        getContentPane().add(pnlTop,BorderLayout.NORTH);
        
        pnlBot=new JPanel();
        lblImg=new JLabel();
        pnlBot.setPreferredSize(new Dimension(400, 300));
        pnlBot.add(lblImg);
        getContentPane().add(pnlBot,BorderLayout.SOUTH);
        
        cbImg.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
         lblImg.setIcon(new ImageIcon(arrImg[cbImg.getSelectedIndex()].getUrl()));
            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        JcomboBoxdemo d=new JcomboBoxdemo();
    }
    
    
}
