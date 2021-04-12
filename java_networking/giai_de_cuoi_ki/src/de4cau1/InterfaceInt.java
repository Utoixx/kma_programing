/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de4cau1;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author oem
 */
public interface InterfaceInt extends Remote{
    public int binhPhuong(int n) throws RemoteException;
}
