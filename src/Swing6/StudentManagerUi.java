/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing6;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author QuangAnh
 */
public class StudentManagerUi extends JFrame {
    
    JLabel lblId, lblName, lblClass, lblSearch, lblTitle;
    JTextField txtID, txtName, txtClass;
    JPanel pnlId, pnlName, pnlClass, pnlSearch, pnlBtn, pnlContainer, pnlSearchContainer, pnlBack;
    JTable tbl, tblSearch;
    DefaultTableModel dataTable, dataSearch;
    JComboBox<String> cbClass;
    DefaultComboBoxModel<String> dataCb;
    JButton btnOK, btnSearch, btnBack;
    JScrollPane scpTable, scpSearch;
    Vector<Student> arrStudent;
    Vector<String> arrClassId;
    CardLayout card;

    public StudentManagerUi() throws HeadlessException {
        arrStudent = new Vector<>();
        arrStudent.add(new Student("C1409l3544", "Quang Anh", "C1409l"));
        arrClassId = new Vector<>();
        arrClassId.addElement("C1408L");
        
        setTitle("Enter Information");
        setSize(500, 500);
        setLayout(new FlowLayout());
        
        lblTitle = new JLabel("Enter Student Information");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        getContentPane().add(lblTitle);
        
        lblId = new JLabel("Id");
        lblId.setPreferredSize(new Dimension(80, 25));
        txtID = new JTextField();
        txtID.setPreferredSize(new Dimension(200, 25));
        pnlId = new JPanel();
        pnlId.setPreferredSize(new Dimension(450, 25));
        pnlId.add(lblId);
        pnlId.add(txtID);
        getContentPane().add(pnlId);
        
        lblName = new JLabel("Name:");
        lblName.setPreferredSize(new Dimension(80, 25));
        txtName = new JTextField();
        txtName.setPreferredSize(new Dimension(200, 25));
        pnlName = new JPanel();
        pnlName.setPreferredSize(new Dimension(450, 25));
        pnlName.add(lblName);
        pnlName.add(txtName);
        getContentPane().add(pnlName);
        
        lblClass = new JLabel("Class:");
        lblClass.setPreferredSize(new Dimension(80, 25));
        txtClass = new JTextField();
        txtClass.setPreferredSize(new Dimension(200, 25));
        pnlClass = new JPanel();
        pnlClass.setPreferredSize(new Dimension(450, 25));
        pnlClass.add(lblClass);
        pnlClass.add(txtClass);
        getContentPane().add(pnlClass);
        
        btnOK = new JButton("Ok");
        pnlBtn = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlBtn.setPreferredSize(new Dimension(300, 50));
        pnlBtn.add(btnOK);
        getContentPane().add(pnlBtn);
        
        lblSearch = new JLabel("Search Class");
        lblSearch.setPreferredSize(new Dimension(80, 25));
        cbClass = new JComboBox<>(arrClassId);
        
        dataCb = new DefaultComboBoxModel<>(arrClassId);
        cbClass.setModel(dataCb);
        btnSearch = new JButton("Search");
        pnlSearch = new JPanel();
        pnlSearch.setPreferredSize(new Dimension(450, 50));
        pnlSearch.add(lblSearch);
        pnlSearch.add(cbClass);
        pnlSearch.add(btnSearch);
        getContentPane().add(pnlSearch);
        
        card = new CardLayout();
        pnlContainer = new JPanel(card);
        pnlContainer.setPreferredSize(new Dimension(450, 200));
        
        dataSearch = new DefaultTableModel();
        dataSearch.addColumn("ID");
        dataSearch.addColumn("Name");
        dataSearch.addColumn("Class");
        tblSearch = new JTable(dataSearch);
        scpSearch = new JScrollPane(tblSearch);
        scpSearch.setPreferredSize(new Dimension(450, 150));
        btnBack = new JButton("Back");
        pnlBack = new JPanel();
        pnlBack.setPreferredSize(new Dimension(450, 50));
        pnlBack.add(btnBack);
        pnlSearchContainer = new JPanel(new FlowLayout());
        pnlSearchContainer.setPreferredSize(new Dimension(450, 200));
        pnlSearchContainer.add(scpSearch);
        pnlSearchContainer.add(pnlBack);
        
        
        dataTable = new DefaultTableModel();
        dataTable.addColumn("ID");
        dataTable.addColumn("Name");
        dataTable.addColumn("Class");
        tbl = new JTable(dataTable);
        for (Student arrStudent1 : arrStudent) {
            dataTable.addRow(arrStudent1.getStringArr());
        }
        scpTable = new JScrollPane(tbl);
        scpTable.setPreferredSize(new Dimension(450, 150));
        pnlContainer.add(scpTable, "Table");
        pnlContainer.add(pnlSearchContainer, "Search");
        getContentPane().add(pnlContainer);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Function
        btnOK.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(pnlContainer, "Table");
                boolean isValid = false;
                String ID_regex = "^[C][0-9]{4}[A-Z][0-9]{4}$";
                Pattern p = Pattern.compile(ID_regex);
                Matcher m = p.matcher(txtID.getText());
                if (!m.matches()) {
                    JOptionPane.showMessageDialog(null, "Invalid ClassID");
                } else {
                    isValid = true;
                }
                if (isValid == true) {
                    arrStudent.add(new Student(txtID.getText(), txtName.getText(), txtClass.getText()));
                    dataTable.addRow(arrStudent.get(arrStudent.size() - 1).getStringArr());
                    for (Student arrStudent1 : arrStudent) {
                        boolean isExist = false;
                        for (String arrClassId1 : arrClassId) {
                            if (arrStudent1.getClassId().equalsIgnoreCase(arrClassId1)) {
                                isExist = true;
                            }
                        }
                        if (isExist == false) {
                            arrClassId.addElement(arrStudent1.getClassId());
                        }
                    }
                }
            }
        });
        
        btnSearch.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<dataSearch.getRowCount();i++){
                dataSearch.removeRow(i);
                }
                for (Student arrStudent1 : arrStudent) {
                    if(cbClass.getSelectedItem().equals(arrStudent1.getClassId())){
                    dataSearch.addRow(arrStudent1.getStringArr());
                    }
                }
                card.show(pnlContainer, "Search");
            }
        });
        btnBack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
         card.show(pnlContainer, "Table");
            }
        });
    }
    
    public static void main(String[] args) {
        new StudentManagerUi();
    }
}
