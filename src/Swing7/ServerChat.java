/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing7;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author QuangAnh
 */
public class ServerChat extends JFrame {

    JTextField txtChat;
    JTextArea txtRecord;
    JPanel pnlChat ;
    JScrollPane pnlrecord;
    ServerSocket ss = null;
    Socket client;
    String Name;
    JButton btn,btnSetting;
    ObjectOutputStream out;
    ObjectInputStream in;
    boolean isrun=true;
    public ServerChat() throws HeadlessException, IOException, ClassNotFoundException {

        setTitle("Server Chat");
        setSize(500, 500);
        setLayout(new FlowLayout());

        txtChat = new JTextField();
        txtChat.setBackground(Color.PINK);
        txtChat.setPreferredSize(new Dimension(300, 30));
        btn=new JButton("Send");
        pnlChat = new JPanel();
        pnlChat.setPreferredSize(new Dimension(450, 50));
        pnlChat.add(txtChat);
        pnlChat.add(btn);
        getContentPane().add(pnlChat);

        txtRecord = new JTextArea();
        //txtRecord.setEditable(false);
        txtRecord.setPreferredSize(new Dimension(450, 300));
        pnlrecord = new JScrollPane(txtRecord);
        pnlrecord.setPreferredSize(new Dimension(450, 300));
        
        getContentPane().add(pnlrecord);

        btnSetting=new JButton("Setting");
        getContentPane().add(btnSetting);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ss = new ServerSocket(9889);
        client = ss.accept();
        
        btnSetting.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              Name=  JOptionPane.showInputDialog(null, "Enter your name:");
            }
        });
        
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    out=new ObjectOutputStream(client.getOutputStream());
                    txtRecord.append(Name+" : "+txtChat.getText()+"\r\n");
                    out.writeObject(Name+" : "+ txtChat.getText());
                } catch (IOException ex) {
                    Logger.getLogger(ServerChat.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        while(isrun==true){
        in=new ObjectInputStream(client.getInputStream());
        txtRecord.append(in.readObject()+"\r\n");
        }
    }

    public void closeServer() {
        
    }

    public static void main(String[] args) throws HeadlessException, IOException, ClassNotFoundException {
        ServerChat s = new ServerChat();

    }
}
