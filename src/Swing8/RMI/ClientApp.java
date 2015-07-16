/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing8.RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author QuangAnh
 */
public class ClientApp {
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        ServerInterface s=(ServerInterface) Naming.lookup("rmi://localhost:8888/server");
        System.out.println("Enter Centimeter:");
        Scanner sc=new Scanner(System.in);
        double Centi=sc.nextDouble();
        double Inch=s.getInch(Centi);
        System.out.println(Inch);
        
    }
}
