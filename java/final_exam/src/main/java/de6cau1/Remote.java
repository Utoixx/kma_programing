/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de6cau1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author oem
 */
public class Remote extends UnicastRemoteObject implements InterfaceInt {
    @Override
    public int hieuAB(int a, int b) throws RemoteException{
        return a-b;
    }
}
