/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing4.DCJTest;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author QuangAnh
 */
public class StudentManagerUI extends JFrame {

    JLabel lblAccount, lblPassword;
    JPanel pnlAcc, pnlPass, pnlBtnLogin;
    JTextField txtAcc;
    JPasswordField txtPass;
    JButton btnLogin, btnCancel;
    JMenuBar main;
    JMenu mnFile, mnAbout;
    JLabel lblName, lblGender, lblAddress, lblAge, lblTitle;
    JPanel pnlName, pnlAge, pnlAddress, pnlGender, pnlBtnInput;
    JTextField txtName, txtAge, txtAddress;
    JComboBox<String> cbGender;
    DefaultComboBoxModel<String> dataCB;
    JButton btnAdd, btnClear;

    public StudentManagerUI() throws HeadlessException {
        setTitle("System Login");
        setSize(500, 500);
        setLayout(new FlowLayout());
        LoginWindow();
        setVisible(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        CloseOption();

    }

    public void CloseOption() {
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                String[] option = {"Yes", "NO"};
                int get = JOptionPane.showOptionDialog(null, "Are u sure want to exit", "Confirm", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE, null, option, option[1]);
                if (get == 0) {
                    System.exit(0);
                }
            }

        });
    }

    public void LoginWindow() {
        lblAccount = new JLabel("Account");
        lblAccount.setPreferredSize(new Dimension(80, 25));
        txtAcc = new JTextField();
        txtAcc.setPreferredSize(new Dimension(300, 25));
        pnlAcc = new JPanel();
        pnlAcc.setPreferredSize(new Dimension(450, 25));
        pnlAcc.add(lblAccount);
        pnlAcc.add(txtAcc);
        getContentPane().add(pnlAcc);

        lblPassword = new JLabel("Password");
        lblPassword.setPreferredSize(new Dimension(80, 25));
        txtPass = new JPasswordField();
        txtPass.setPreferredSize(new Dimension(300, 25));
        pnlPass = new JPanel();
        pnlPass.setPreferredSize(new Dimension(450, 25));
        pnlPass.add(lblPassword);
        pnlPass.add(txtPass);
        getContentPane().add(pnlPass);

        btnLogin = new JButton("Login");
        btnCancel = new JButton("Cancel");
        pnlBtnLogin = new JPanel();
        pnlBtnLogin.setPreferredSize(new Dimension(450, 50));
        pnlBtnLogin.add(btnLogin);
        pnlBtnLogin.add(btnCancel);
        getContentPane().add(pnlBtnLogin);

        //function
        btnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtAcc.getText().equals("") || txtPass.getPassword().equals("")) {
                    JOptionPane.showMessageDialog(null, "Wrong Input dude", "Error", JOptionPane.WARNING_MESSAGE);
                } else {
                    InputWindow();
                }
            }
        });

    }

    public void InputWindow() {
        setTitle("Input");
        setSize(500, 500);
        setLayout(new FlowLayout());
        lblTitle = new JLabel("Input Data");
        lblTitle.setFont(new Font("arial", Font.BOLD, 25));
        lblTitle.setPreferredSize(new Dimension(100, 50));
        getContentPane().add(lblTitle);

        lblName = new JLabel("Name:");
        lblName.setPreferredSize(new Dimension(100, 30));
        txtName = new JTextField();
        txtName.setPreferredSize(new Dimension(200, 30));
        pnlName = new JPanel();
        pnlName.setPreferredSize(new Dimension(450, 30));
        pnlName.add(lblName);
        pnlName.add(txtName);

        lblAddress = new JLabel("Address:");
        lblAddress.setPreferredSize(new Dimension(100, 30));
        txtAddress = new JTextField();
        txtAddress.setPreferredSize(new Dimension(200, 30));
        pnlAddress = new JPanel();
        pnlAddress.setPreferredSize(new Dimension(450, 30));
        pnlAddress.add(lblAddress);
        pnlAddress.add(txtAddress);

        lblAge = new JLabel("Age:");
        lblAge.setPreferredSize(new Dimension(100, 30));
        txtAge = new JTextField();
        txtAge.setPreferredSize(new Dimension(200, 30));
        pnlAge = new JPanel();
        pnlAge.setPreferredSize(new Dimension(450, 30));
        pnlAge.add(lblAge);
        pnlAge.add(txtAge);
        getContentPane().add(pnlName);
        getContentPane().add(pnlAddress);
        getContentPane().add(pnlAge);

        lblGender = new JLabel("Gender");
        lblGender.setPreferredSize(new Dimension(80, 30));
        String[] gender = {"Male", "Female", "Unknown"};
        dataCB = new DefaultComboBoxModel<>(gender);
        cbGender = new JComboBox<>();
        cbGender.setModel(dataCB);
        pnlGender = new JPanel();
        pnlGender.setPreferredSize(new Dimension(450, 30));
        pnlGender.add(lblGender);
        pnlGender.add(cbGender);
        getContentPane().add(pnlGender);
        
        setVisible(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        CloseOption();
    }

    public static void main(String[] args) {
        new StudentManagerUI();
    }
}
