/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de2cau2;

import java.rmi.RemoteException;
import java.rmi.Remote;

/**
 *
 * @author oem
 */
public interface Interface_tu_dien extends Remote{
    public String sangVietThuong(String s)throws RemoteException;
    public String sangVietTat(String s)throws RemoteException;
}
