/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de8cau2;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author oem
 */
public interface InterfaceRMI extends Remote{
    
    public int cong(int a, int b) throws RemoteException;
    
    public int tru(int a, int b) throws RemoteException;
    
    public int nhan(int a, int b) throws RemoteException;
    
    public int chia(int a, int b) throws RemoteException;
    
    public int ucln(int a, int b) throws RemoteException;
}
