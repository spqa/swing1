/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing8.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author QuangAnh
 */
public class ServerManager extends UnicastRemoteObject implements ServerInterface{
public ServerManager() throws RemoteException{
super();
}
    @Override
    public double getInch(double Centi) throws RemoteException {
        return Centi/2.54;
    }
    
    
}
