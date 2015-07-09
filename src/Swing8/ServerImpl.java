/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing8;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author QuangAnh
 */
public class ServerImpl extends UnicastRemoteObject implements ServerInterface {

    JFrame fr;
    JSlider sld;
    JTextArea txt;

    public ServerImpl() throws RemoteException {
        super();
    }

    @Override
    public void ServerImplUI() throws RemoteException{
        fr = new JFrame("Server");
        fr.setSize(500, 500);
        fr.setLayout(new FlowLayout());
        sld = new JSlider();
        sld.setMajorTickSpacing(20);
        sld.setPaintLabels(true);
        sld.setPaintTicks(true);
        fr.getContentPane().add(sld);

        txt = new JTextArea();
        txt.setPreferredSize(new Dimension(300, 300));
        fr.getContentPane().add(txt);

        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null);
        sld.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
         txt.setFont(new Font("arial", Font.PLAIN, sld.getValue()));
            }
        });
    }

    @Override
    public void getSldValue(int value) throws RemoteException {
        txt.setFont(new Font("arial", Font.PLAIN , value));
        sld.setValue(value);
    }
}
