/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing4;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileView;
import javax.swing.text.JTextComponent;

/**
 *
 * @author QuangAnh
 */
public class Menu1 extends JFrame {

    JMenuBar main;
    JMenu mnFile, mnEdit, mnInsert, mnFormat, mnAbout, iPic, fFont, fColor;
    JMenuItem fNew, fOpen, fSave, fSaveAs, fExit, eCut, eCopy, ePaste, eUndo, eRedo, iEquation, about;
    ButtonGroup bt, bt1;
    JRadioButtonMenuItem pClip, pFile, fRed, fGreen, fBlue;
    JCheckBoxMenuItem fItalic, fBold, fPlain;
    CardLayout card;
    JPanel pnlContainer, pnlEm, pnlTextArea;
    JScrollPane scpTxtArea;
    JTextArea txtNew;
    JFileChooser fiChooser;
    File f;

    public Menu1() throws HeadlessException {
        setTitle("Jmenu");
        setSize(500, 500);
        //MenuBar
        main = new JMenuBar();

        mnFile = new JMenu("File");
        fNew = new JMenuItem("New");
        fNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.CTRL_DOWN_MASK, KeyEvent.VK_N));
        fOpen = new JMenuItem("Open");
        fOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.CTRL_DOWN_MASK, KeyEvent.VK_O));
        fSave = new JMenuItem("Save");
        fSaveAs = new JMenuItem("Save As");
        fExit = new JMenuItem("Exit");
        mnFile.add(fNew);
        mnFile.add(fOpen);
        mnFile.add(fSave);
        mnFile.add(fSaveAs);
        mnFile.add(fExit);

        mnEdit = new JMenu("Edit");
        eCopy = new JMenuItem("Copy");
        eCut = new JMenuItem("Cut");
        ePaste = new JMenuItem("Paste");
        eRedo = new JMenuItem("Redo");
        eUndo = new JMenuItem("Undo");
        mnEdit.add(eCopy);
        mnEdit.add(eCut);
        mnEdit.add(eRedo);
        mnEdit.add(ePaste);
        mnEdit.add(eUndo);

        mnFormat = new JMenu("Format");
        fFont = new JMenu("Font");
        fItalic = new JCheckBoxMenuItem("Italic");
        fBold = new JCheckBoxMenuItem("bold");
        fPlain = new JCheckBoxMenuItem("plain");
        fFont.add(fItalic);
        fFont.add(fBold);
        fFont.add(fPlain);
        fColor = new JMenu("Color");
        fRed = new JRadioButtonMenuItem("red");
        fGreen = new JRadioButtonMenuItem("Green");
        fBlue = new JRadioButtonMenuItem("Blue");
        bt = new ButtonGroup();
        bt.add(fBlue);
        bt.add(fGreen);
        bt.add(fRed);
        fColor.add(fBlue);
        fColor.add(fRed);
        fColor.add(fGreen);
        mnFormat.add(fFont);
        mnFormat.add(fColor);

        mnInsert = new JMenu("Insert");
        iPic = new JMenu("Picture");
        pClip = new JRadioButtonMenuItem("Clip Art");
        pFile = new JRadioButtonMenuItem("From File");
        bt1 = new ButtonGroup();
        bt1.add(pClip);
        bt1.add(pFile);
        iEquation = new JMenuItem("Equation");
        mnInsert.add(iPic);
        mnInsert.add(iEquation);

        mnAbout = new JMenu("about");
        about = new JMenuItem("about me");

        main.add(mnFile);
        main.add(mnEdit);
        main.add(mnFormat);
        main.add(mnInsert);
        main.add(mnAbout);
        setJMenuBar(main);

        //Panel
        card = new CardLayout();
        pnlContainer = new JPanel(card);
        pnlContainer.setPreferredSize(new Dimension(400, 400));
        pnlEm = new JPanel();
        pnlTextArea = new JPanel();
        pnlTextArea.setPreferredSize(new Dimension(400, 400));
        txtNew = new JTextArea();
//        txtNew.setPreferredSize(new Dimension(400, 200));
        scpTxtArea = new JScrollPane(txtNew);
        scpTxtArea.setPreferredSize(new Dimension(400, 200));
        pnlTextArea.add(scpTxtArea);
        pnlContainer.add(pnlEm, "Em");
        pnlContainer.add(pnlTextArea, "txtArea");
        getContentPane().add(pnlContainer);

        //Function
        fNew.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(pnlContainer, "txtArea");
            }
        });

        fOpen.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                fiChooser = new JFileChooser();
                fiChooser.setFileFilter(new TxtFileFilter());
                fiChooser.setFileView(new FileView() {
                });
                fiChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                int returnValue = fiChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    f = fiChooser.getSelectedFile();
                    JOptionPane.showMessageDialog(null, "Successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid File chooser");
                }
            }
        });

        fRed.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                txtNew.setForeground(Color.red);
            }
        });
        fBlue.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                txtNew.setForeground(Color.BLUE);
            }
        });

        fGreen.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                txtNew.setForeground(Color.GREEN);
            }
        });
        fSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    try (BufferedWriter b = new BufferedWriter(new FileWriter(f))) {
                        String str = txtNew.getText();
                        txtNew.write(b);

                    }
                    System.out.println(txtNew.getText());
                    System.out.println(f.getName());
                } catch (IOException ex) {
                    Logger.getLogger(Menu1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        fItalic.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                txtNew.setFont(new Font(null, Font.ITALIC, 15));
                if (fBold.isSelected()) {
                    txtNew.setFont(new Font(null, Font.ITALIC + Font.BOLD, 15));

                }

            }
        });
        fBold.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                txtNew.setFont(new Font(null, Font.BOLD, 15));
                if (fItalic.isSelected()) {
                    txtNew.setFont(new Font(null, Font.ITALIC + Font.BOLD, 15));
                }
            }
        });
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        Menu1 m = new Menu1();
    }
}
