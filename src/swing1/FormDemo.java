/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author QuangAnh
 */
public class FormDemo extends JFrame {

    JLabel lblName, lblGender, lblYob, lblCountry, lblTitle;
    JPanel pnlName, pnlGender, pnlCountry, pnlTitle, pnlYob, pnlbtn;
    JTextField txtName;
    JTextArea txtCountry;
    JFormattedTextField txtYob;
    JRadioButton rbMale, rbFemale;
    JScrollPane scp;
    JButton btnOK, btnReset;

    public FormDemo() throws HeadlessException {
        component();
    }

    private void component() {
        setTitle("Enter Information");
        setSize(500, 500);
        setLayout(new FlowLayout());

        lblTitle = new JLabel();
        lblTitle.setText("ENTER INFORMATION");
        pnlTitle = new JPanel();
        pnlTitle.setPreferredSize(new Dimension(500, 50));
        pnlTitle.add(lblTitle);
        getContentPane().add(pnlTitle);

        lblName = new JLabel();
        lblName.setText("Name :");
        txtName = new JTextField();
        txtName.setPreferredSize(new Dimension(200, 20));
        pnlName = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlName.setPreferredSize(new Dimension(400, 50));
        pnlName.add(lblName);
        pnlName.add(txtName);
        getContentPane().add(pnlName);

        lblGender = new JLabel();
        lblGender.setText("Gender:");
        rbMale = new JRadioButton("Male");
        rbFemale = new JRadioButton("Female");
        pnlGender = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlGender.setPreferredSize(new Dimension(400, 50));
        pnlGender.add(lblGender);
        pnlGender.add(rbMale);
        pnlGender.add(rbFemale);
        getContentPane().add(pnlGender);

        lblYob = new JLabel();
        lblYob.setText("Year of birth:");
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        txtYob = new JFormattedTextField(df);
        txtYob.setPreferredSize(new Dimension(100, 20));
        pnlYob = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlYob.setPreferredSize(new Dimension(400, 50));
        pnlYob.add(lblYob);
        pnlYob.add(txtYob);
        getContentPane().add(pnlYob);

        lblCountry = new JLabel();
        lblCountry.setText("Country:");
        txtCountry = new JTextArea();
        scp = new JScrollPane(txtCountry);
        scp.setPreferredSize(new Dimension(400, 100));
        pnlCountry = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlCountry.setPreferredSize(new Dimension(400, 200));
        pnlCountry.add(lblCountry);
        pnlCountry.add(scp);
        getContentPane().add(pnlCountry);

        btnOK = new JButton("ok");
        btnReset = new JButton("Reset");
        pnlbtn = new JPanel();
        pnlbtn.setPreferredSize(new Dimension(400, 75));
        pnlbtn.add(btnOK);
        pnlbtn.add(btnReset);
        getContentPane().add(pnlbtn);

        btnOK.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               if(txtName==null){
                   
               }
            }
        });
        
        btnReset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              
            }
        });
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        FormDemo f = new FormDemo();
    }
}
