/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de8cau2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author oem
 */
public class RemoteRMI extends UnicastRemoteObject implements InterfaceRMI{

    public RemoteRMI() throws RemoteException{
        super();
    }
    @Override
    public int cong(int a, int b) throws RemoteException {
        return a+ b;
    }

    @Override
    public int tru(int a, int b) throws RemoteException {
        return a- b;
    }

    @Override
    public int nhan(int a, int b) throws RemoteException {
        return a* b;
    }

    @Override
    public int chia(int a, int b) throws RemoteException {
        return a/ b;
    }

    @Override
    public int ucln(int a, int b) throws RemoteException {
        while(a!=b){
            if(a>b){
                a=a-b;
            }else{
                b=b-a;
            }
            ucln(a, b);
        }
        return a;
    }
}
