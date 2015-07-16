/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.mailapi;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author toan.hk
 */
public class SendMailApp extends JFrame {
    
    JLabel lblTitle, lblFrom, lblPassword, lblTo, lblCC, lblBCC, lblSubject;
    JTextField txtFrom, txtTo, txtCC, txtBcc, txtSubject;
    JPasswordField txtPassword;
    JTextArea txaContent;
    JButton btnSend;
    JPanel pnlFrom, pnlPassword, pnlTo, pnlCC, pnlBCC, pnlSubject, pnlButton;
    
    JScrollPane scpScroll;
    Container c;
    
    public SendMailApp() throws HeadlessException {
        setTitle("Send mail using JAVAMAIL API");
        setSize(500, 400);
        c = getContentPane();
        setLayout(new FlowLayout());
        lblTitle = new JLabel("Demo gui mail bang ung dung JAVA");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        
        c.add(lblTitle);

        //from
        lblFrom = new JLabel("From");
        lblFrom.setPreferredSize(new Dimension(100, 20));
        txtFrom = new JTextField();
        txtFrom.setPreferredSize(new Dimension(300, 20));
        
        pnlFrom = new JPanel();
        pnlFrom.setPreferredSize(new Dimension(480, 25));
        pnlFrom.add(lblFrom);
        pnlFrom.add(txtFrom);
        
        c.add(pnlFrom);

        //password;
        lblPassword = new JLabel("Password");
        lblPassword.setPreferredSize(new Dimension(100, 20));
        txtPassword = new JPasswordField();
        txtPassword.setPreferredSize(new Dimension(300, 20));
        
        pnlPassword = new JPanel();
        pnlPassword.setPreferredSize(new Dimension(480, 25));
        pnlPassword.add(lblPassword);
        pnlPassword.add(txtPassword);
        
        c.add(pnlPassword);

        //to
        lblTo = new JLabel("To:");
        lblTo.setPreferredSize(new Dimension(100, 20));
        txtTo = new JTextField();
        txtTo.setPreferredSize(new Dimension(300, 20));
        
        pnlTo = new JPanel();
        pnlTo.setPreferredSize(new Dimension(480, 25));
        pnlTo.add(lblTo);
        pnlTo.add(txtTo);
        
        c.add(pnlTo);

        //CC
        lblCC = new JLabel("CC:");
        lblCC.setPreferredSize(new Dimension(100, 20));
        txtCC = new JTextField();
        txtCC.setPreferredSize(new Dimension(300, 20));
        
        pnlCC = new JPanel();
        pnlCC.setPreferredSize(new Dimension(480, 25));
        pnlCC.add(lblCC);
        pnlCC.add(txtCC);
        
        c.add(pnlCC);

        //bcc
        lblBCC = new JLabel("Bcc:");
        lblBCC.setPreferredSize(new Dimension(100, 20));
        txtBcc = new JTextField();
        txtBcc.setPreferredSize(new Dimension(300, 20));
        
        pnlBCC = new JPanel();
        pnlBCC.setPreferredSize(new Dimension(480, 25));
        pnlBCC.add(lblBCC);
        pnlBCC.add(txtBcc);
        
        c.add(pnlBCC);

        //subject
        lblSubject = new JLabel("Subject:");
        lblSubject.setPreferredSize(new Dimension(100, 20));
        txtSubject = new JTextField();
        txtSubject.setPreferredSize(new Dimension(300, 20));
        
        pnlSubject = new JPanel();
        pnlSubject.setPreferredSize(new Dimension(480, 25));
        pnlSubject.add(lblSubject);
        pnlSubject.add(txtSubject);
        
        c.add(pnlSubject);

        //content
        txaContent = new JTextArea();
        txaContent.setPreferredSize(new Dimension(450, 100));
        
        scpScroll = new JScrollPane(txaContent);
        c.add(scpScroll);

        //button
        btnSend = new JButton("Send");
        c.add(btnSend);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        btnSend.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                String from = txtFrom.getText().trim();
                char[] pass = txtPassword.getPassword();
                //String p = new String(pass);//
                String to = txtTo.getText();
                String cc = txtCC.getText();
                String bcc = txtBcc.getText();
                String subject = txtSubject.getText();
                String content = txaContent.getText();
                
                String error = "";
                if (from.equals("")) {
                    error += "\nBan phai nhap dia chi email";
                }
                
                if (!error.equals("")) {
                    JOptionPane.showMessageDialog(null, error);
                } else {
                    String host = "smtp.gmail.com";
                    String port = "465";
                    Properties prop = new Properties();
                    prop.put("mail.smtp.user", from);
                    prop.put("mail.smtp.host", host);
                    prop.put("mail.smtp.port", port);
                    prop.put("mail.smtp.starttls", "true");
                    prop.put("mail.smtp.auth", "true");
                    prop.put("mail.smtp.socketFactory.port", port);
                    prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                    
                    Session session = Session.getDefaultInstance(prop, null);
                    MimeMessage message = new MimeMessage(session);
                    try {
                        message.setFrom(new InternetAddress(from));
                        message.setSubject(subject);
                        InternetAddress[] addressCc = null;
                        InternetAddress[] addressBCC = null;
                        
                        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
                        if (!cc.equals("")) {
                            addressCc = InternetAddress.parse(cc);
                            message.setRecipients(Message.RecipientType.CC, addressCc);
                        }
                        if (!bcc.equals("")) {
                            addressBCC = InternetAddress.parse(bcc);
                            message.setRecipients(Message.RecipientType.BCC, addressBCC);
                        }
                        message.setText(content);
                        message.saveChanges();
                        
                        Transport tranport = session.getTransport("smtp");
                        tranport.connect(host, from, new String(pass));
                        tranport.sendMessage(message, message.getAllRecipients());
                        tranport.close();
                        
                        JOptionPane.showMessageDialog(null, "Message send successful");
                    } catch (MessagingException ex) {
                        JOptionPane.showMessageDialog(null, "Message couldn't sent");
                    }
                    
                }
                
            }
        });
    }
    
    public static void main(String[] args) {
        new SendMailApp();
    }
    
}
