/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing8;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author QuangAnh
 */
public class ServerApp {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {
        String name="rmi://localhost:8989/server";
        ServerImpl s=new ServerImpl();
        LocateRegistry.createRegistry(8989);
        Naming.bind(name, s);
    }
}
