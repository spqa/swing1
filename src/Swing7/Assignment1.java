/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing7;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author c1409l3544
 */
public class Assignment1 extends JFrame {

    JMenuBar main;
    JMenu mnLang, mnSystem;
    JMenuItem mnExit, mnEng, mnVN;
    JSplitPane spp;
    JPanel pnlLeft, pnlRight, pnlID, pnlName, pnlYob, pnlBtn;
    JLabel lblAddStudent, lblId, lblName, lblYob, lblList;
    JTextField txtID, txtName;
    JFormattedTextField txtDate;
    JButton btnAdd;
    JTable tblStudent;
    DefaultTableModel dataTbl;
    Vector<Student> arrStudent;
    JScrollPane scp;
    Locale lc = Locale.US;
    ResourceBundle rs;

    public Assignment1() throws HeadlessException, ParseException {
        rs = ResourceBundle.getBundle("Swing7.language", lc);
        setTitle(rs.getString("AddStudent"));
        setSize(800, 500);
        main = new JMenuBar();
        mnSystem = new JMenu(rs.getString("System"));
        mnLang = new JMenu("Language");
        mnEng = new JMenuItem("English");
        mnEng.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_DOWN_MASK));
        mnVN = new JMenuItem("Tieng Viet");
        mnVN.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.ALT_DOWN_MASK));
        mnLang.add(mnEng);
        mnLang.add(mnVN);
        mnExit = new JMenuItem("exit");
        mnExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
        mnSystem.add(mnLang);
        mnSystem.add(mnExit);
        main.add(mnSystem);

        pnlLeft = new JPanel(new FlowLayout());
        pnlLeft.setPreferredSize(new Dimension(400, 450));
        pnlLeft.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblAddStudent = new JLabel("Add Student");
        lblAddStudent.setFont(new Font("arial", Font.BOLD, 25));
        pnlLeft.add(lblAddStudent);

        lblId = new JLabel("ID:");
        lblId.setPreferredSize(new Dimension(80, 30));
        txtID = new JTextField();
        txtID.setPreferredSize(new Dimension(200, 30));
        pnlID = new JPanel();
        pnlID.add(lblId);
        pnlID.add(txtID);
        pnlLeft.add(pnlID);

        lblName = new JLabel("Name:");
        lblName.setPreferredSize(new Dimension(80, 30));
        txtName = new JTextField();
        txtName.setPreferredSize(new Dimension(200, 30));
        pnlName = new JPanel();
        pnlName.add(lblName);
        pnlName.add(txtName);
        pnlLeft.add(pnlName);
        
        lblYob = new JLabel("BirthDay:");
        lblYob.setPreferredSize(new Dimension(80, 30));
        MaskFormatter mask = new MaskFormatter("##/##/####");
        txtDate = new JFormattedTextField(mask);
        txtDate.setPreferredSize(new Dimension(200, 30));
        pnlYob = new JPanel();
        pnlYob.add(lblYob);
        pnlYob.add(txtDate);
        pnlLeft.add(pnlYob);

        btnAdd = new JButton("Add");
        pnlBtn = new JPanel();
        pnlBtn.add(btnAdd);
        pnlBtn.setPreferredSize(new Dimension(354, 50));
        pnlLeft.add(pnlBtn);

        arrStudent = new Vector<>();
        pnlRight = new JPanel();
        pnlRight.setPreferredSize(new Dimension(400, 450));
        pnlRight.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblList = new JLabel("List Student");
        lblList.setFont(new Font("arial", Font.BOLD, 25));
        pnlRight.add(lblList);
        dataTbl = new DefaultTableModel();
        dataTbl.addColumn("ID");
        dataTbl.addColumn("Name");
        dataTbl.addColumn("BirthDay");
        tblStudent = new JTable(dataTbl);
        scp = new JScrollPane(tblStudent);
        scp.setPreferredSize(new Dimension(350, 300));
        pnlRight.add(scp);

        spp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnlLeft, pnlRight);
        spp.setOneTouchExpandable(false);
        //spp.setDividerLocation(0.9);
        //spp.setEnabled(false);

        getContentPane().add(spp);
        setJMenuBar(main);
        setVisible(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                String[] option = {"Yes", "No"};
                int get = JOptionPane.showOptionDialog(null, "Wanna Exit?", "Warning", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE, null, option, option[1]);
                if (get == 0) {
                    System.exit(0);
                }
            }

        });
        btnAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                arrStudent.addElement(new Student(txtID.getText(), txtName.getText(), txtDate.getText()));
                dataTbl.addRow(arrStudent.get(arrStudent.size() - 1).getStringArr());
            }
        });
        mnEng.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                lc = new Locale("en", "US");
                rs = ResourceBundle.getBundle("Swing7.language", lc);
                changeLanguage();
            }
        });

        mnVN.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                lc = new Locale("vi", "VN");
                rs = ResourceBundle.getBundle("Swing7.language", lc);
                changeLanguage();
            }
        });
        
        mnExit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
         System.exit(0);
            }
        });
    }

    private void changeLanguage() {
        lblId.setText(rs.getString("id"));
        lblName.setText(rs.getString("Name"));
        lblYob.setText(rs.getString("BirthDay"));
        mnSystem.setText(rs.getString("System"));
        mnLang.setText(rs.getString("Language"));
        mnExit.setText(rs.getString("exit"));
        lblAddStudent.setText(rs.getString("AddStudent"));
        lblList.setText(rs.getString("StudentList"));
        btnAdd.setText(rs.getString("AddStudent"));
        
        
    }

    public static void main(String[] args) throws HeadlessException, ParseException {
        new Assignment1();
    }

}
