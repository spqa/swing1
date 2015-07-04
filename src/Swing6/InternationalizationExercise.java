/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing6;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author QuangAnh
 */
public class InternationalizationExercise extends JFrame {

    JLabel lblTitle, lblInter, lblCurr, lblPer, lblNum;
    JTextArea txtInter;
    JTextField txtCurrency, txtPercent, txtNumber;
    JPanel pnlcurr, pnlnum, pnlPer, pnlRD;
    JScrollPane scp;
    JRadioButton rdEng, rdVN;
    ButtonGroup bt;
    Locale lc = Locale.ENGLISH;

    public InternationalizationExercise() throws HeadlessException {
        setTitle("international");
        setSize(new Dimension(500, 500));
        setLayout(new FlowLayout());
        lblTitle = new JLabel("INPUT DATA");
        getContentPane().add(lblTitle);

        lblCurr = new JLabel("Currency:");
        lblCurr.setPreferredSize(new Dimension(80, 25));
        txtCurrency = new JTextField();
        txtCurrency.setPreferredSize(new Dimension(200, 25));
        pnlcurr = new JPanel();
        pnlcurr.setPreferredSize(new Dimension(450, 50));
        pnlcurr.add(lblCurr);
        pnlcurr.add(txtCurrency);
        getContentPane().add(pnlcurr);

        lblPer = new JLabel("Percent:");
        lblPer.setPreferredSize(new Dimension(80, 25));
        txtPercent = new JTextField();
        txtPercent.setPreferredSize(new Dimension(200, 25));
        pnlPer = new JPanel();
        pnlPer.setPreferredSize(new Dimension(450, 50));
        pnlPer.add(lblPer);
        pnlPer.add(txtPercent);
        getContentPane().add(pnlPer);

        lblNum = new JLabel("Number:");
        lblNum.setPreferredSize(new Dimension(80, 25));
        txtNumber = new JTextField();
        txtNumber.setPreferredSize(new Dimension(200, 25));
        pnlnum = new JPanel();
        pnlnum.setPreferredSize(new Dimension(450, 50));
        pnlnum.add(lblNum);
        pnlnum.add(txtNumber);
        getContentPane().add(pnlnum);

        rdEng = new JRadioButton("Eng");
        rdVN = new JRadioButton("VN");
        bt = new ButtonGroup();
        bt.add(rdVN);
        bt.add(rdEng);
        pnlRD = new JPanel();
        pnlRD.setPreferredSize(new Dimension(450, 25));
        pnlRD.add(rdEng);
        pnlRD.add(rdVN);
        getContentPane().add(pnlRD);

        txtInter = new JTextArea();

        scp = new JScrollPane(txtInter);
        scp.setPreferredSize(new Dimension(450, 200));
        getContentPane().add(scp);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //function
        txtCurrency.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                NumberFormat n = NumberFormat.getCurrencyInstance(lc);
                txtInter.append("Currency: " + n.format(Integer.parseInt(txtCurrency.getText())) + "\r\n");
            }
        });
        txtNumber.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                NumberFormat n = NumberFormat.getNumberInstance(lc);

                txtInter.append("Number: " + n.format(Integer.parseInt(txtCurrency.getText())) + "\r\n");
            }
        });
        txtPercent.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                NumberFormat n = NumberFormat.getPercentInstance(lc);
                txtInter.append(n.format(Integer.parseInt(txtPercent.getText())) + "\r\n");
            }
        });

        rdEng.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                lc = Locale.ENGLISH;
                Date d = new Date();
                DateFormat n = DateFormat.getDateInstance(DateFormat.LONG, lc);
                txtInter.setText(n.format(d));
            }
        });
        rdVN.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                lc = new Locale("vi", "VN");
                Date d = new Date();
                DateFormat n = DateFormat.getDateInstance(DateFormat.LONG, lc);
                txtInter.setText(n.format(d));
            }
        });
    }

    public static void main(String[] args) {
        new InternationalizationExercise();
    }
}
