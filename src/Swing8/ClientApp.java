/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing8;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author QuangAnh
 */
public class ClientApp extends JFrame {

    JSlider lsd;
ServerInterface s;
    public ClientApp() throws NotBoundException, MalformedURLException, RemoteException {
        setTitle("Client");
        setSize(500, 500);

        lsd = new JSlider();
        lsd.setMajorTickSpacing(20);
        lsd.setPaintTicks(true);
        lsd.setPaintLabels(true);
        getContentPane().add(lsd);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        s = (ServerInterface) Naming.lookup("rmi://localhost:8989/server");
        s.ServerImplUI();
        lsd.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                try {
                    s.getSldValue(lsd.getValue());
                } catch (RemoteException ex) {
                    Logger.getLogger(ClientApp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {

        ClientApp c = new ClientApp();

    }
}
