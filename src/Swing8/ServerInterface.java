/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing8;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author QuangAnh
 */
public interface ServerInterface extends Remote{
    public void getSldValue(int value) throws RemoteException;
    public void ServerImplUI()throws RemoteException;
}
