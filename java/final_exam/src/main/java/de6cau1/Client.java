/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de6cau1;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author oem
 */
public class Client {
    public static void main(String[] args){
        try{
            InterfaceInt hieuAB= (InterfaceInt)Naming.lookup("rmi://localhost:1099/app");
            System.out.println(hieuAB.hieuAB(7, 2));
        }catch(RemoteException e){
            e.printStackTrace();
        }catch(MalformedURLException ex){
            ex.printStackTrace();
        }catch(java.rmi.NotBoundException exc){
            exc.printStackTrace();
        }
    }
}
