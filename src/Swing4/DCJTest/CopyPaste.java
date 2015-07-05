/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing4.DCJTest;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;


/**
 *
 * @author QuangAnh
 */
public class CopyPaste extends JFrame {

    JMenu mnFile;
    JMenuBar main;
    JMenuItem fCopy, fCut, fPaste, pCopy, pCut, pPaste;
    JPopupMenu pmnmenu;
    JTextArea txt1, txt2;
    String clipBoard;
    JTextField txtField;

    public CopyPaste() throws HeadlessException {
        setTitle("Copy Paste");
        setSize(500, 500);
        setLayout(new FlowLayout());
        mnFile = new JMenu("File");
        fCopy = new JMenuItem("copy");
        fCut = new JMenuItem("Cut");
        fPaste = new JMenuItem("Paste");
        mnFile.add(fCut);
        mnFile.add(fCopy);
        mnFile.add(fPaste);

        txt1 = new JTextArea();
        txt1.setName("txt1");
        txt1.setPreferredSize(new Dimension(450, 200));
        getContentPane().add(txt1);

        txt2 = new JTextArea();
        txt2.setName("txt2");
        txt2.setPreferredSize(new Dimension(450, 100));
        getContentPane().add(txt2);

        pmnmenu = new JPopupMenu("Options");
        pCopy = new JMenuItem("copy");
        pCut = new JMenuItem("Cut");
        pPaste = new JMenuItem("Paste");
        pmnmenu.add(pCopy);
        pmnmenu.add(pCut);
        pmnmenu.add(pPaste);
        txt1.setComponentPopupMenu(pmnmenu);
        txt2.setComponentPopupMenu(pmnmenu);
//        popupListener pop = new popupListener();
//        addMouseListener(pop);
        
        txtField=new JTextField();
        txtField.setPreferredSize(new Dimension(450, 50));
        txtField.setComponentPopupMenu(pmnmenu);
        getContentPane().add(txtField);

        getContentPane().add(pmnmenu);
        main = new JMenuBar();
        main.add(mnFile);
        setJMenuBar(main);
        setVisible(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                String[] option = {"Yes", "No"};
                int get = JOptionPane.showOptionDialog(null, "U really want to exit?", "Warning", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE, null, option, option[1]);
                if (get == 0) {
                    System.exit(0);
                }
            }

        });
        pCopy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JTextComponent cp= (JTextComponent) pmnmenu.getInvoker();
                clipBoard = cp.getSelectedText();
                System.out.println(pmnmenu.getInvoker().getName());
            }
        });

        pPaste.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JTextComponent temp=(JTextComponent) pmnmenu.getInvoker();
                temp.replaceSelection(clipBoard);
            }
        });

        pCut.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JTextComponent temp=(JTextComponent) pmnmenu.getInvoker();
                clipBoard = temp.getSelectedText();
                temp.replaceSelection("");
            }
        });
        

    }
//    class popupListener extends MouseAdapter{
//
//        @Override
//        public void mouseReleased(java.awt.event.MouseEvent e) {
//            if(e.isPopupTrigger()){
//                doPOP(e);
//            }
//        }
//
//        @Override
//        public void mousePressed(java.awt.event.MouseEvent e) {
//            super.mousePressed(e); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        @Override
//        public void mouseClicked(java.awt.event.MouseEvent e) {
//            super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
//        }
//        
//        private void doPOP(MouseEvent e){
//            pmnmenu.show(e.getComponent(), e.getX(), e.getY());
//        }
//        
//    }

    public static void main(String[] args) {
        CopyPaste c = new CopyPaste();
    }

}
