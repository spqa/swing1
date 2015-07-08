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
public class ClientChat extends JFrame {

    JTextField txtChat;
    JTextArea txtArea;
    JPanel pnlChat;
    JScrollPane pnlArea;
    Socket sc = null;
    JButton btn,btnSetting;
    String Name;
    ObjectInputStream in;
    ObjectOutputStream out;
    boolean isRun=true;
    public ClientChat() throws HeadlessException, IOException, ClassNotFoundException {
        setTitle("Client");
        setSize(500, 500);
        setLayout(new FlowLayout());
        txtChat = new JTextField();
        txtChat.setPreferredSize(new Dimension(300, 30));
        txtChat.setBackground(Color.PINK);
        btn = new JButton("send");
        pnlChat = new JPanel();
        pnlChat.add(txtChat);
        pnlChat.add(btn);
        pnlChat.setPreferredSize(new Dimension(450, 50));
        getContentPane().add(pnlChat);

        txtArea = new JTextArea();
        //txtArea.setEditable(false);
        txtArea.setPreferredSize(new Dimension(450, 300));
        pnlArea = new JScrollPane(txtArea);
        pnlArea.setPreferredSize(new Dimension(450, 300));
        
        getContentPane().add(pnlArea);
        
        btnSetting=new JButton("Setting");
        getContentPane().add(btnSetting);
        
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        sc = new Socket("localhost", 9889);
             
        btnSetting.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
         Name=JOptionPane.showInputDialog("Enter Your Name:");
            }
        });
        
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    txtArea.append(Name+" : "+txtChat.getText()+"\r\n");
                    out = new ObjectOutputStream(sc.getOutputStream());
                    out.writeObject(Name+" : "+txtChat.getText());
                } catch (IOException ex) {
                    Logger.getLogger(ClientChat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        while(isRun==true){
        in = new ObjectInputStream(sc.getInputStream());
        String str=(String) in.readObject();
        txtArea.append(str+"\r\n");
        }

    }

    public static void main(String[] args) throws HeadlessException, IOException, ClassNotFoundException {
        ClientChat c = new ClientChat();
    }
}
