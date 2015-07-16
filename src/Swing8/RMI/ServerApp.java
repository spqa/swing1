/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing8.RMI;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author QuangAnh
 */
public class ServerApp {
    
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {
        String name="rmi://localhost:8888/server";
        Registry r=LocateRegistry.createRegistry(8888);
        ServerManager s=new ServerManager();
        Naming.bind(name, s);
    }
}
