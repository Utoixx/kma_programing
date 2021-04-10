/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de4cau1;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author oem
 */
public class Server {
    public static void main(String[] args){
        try{
            InterfaceInt binhPhuong= new Remote();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("app", binhPhuong);
        }catch(RemoteException e){
            e.printStackTrace();
        }catch(MalformedURLException ex){
            ex.printStackTrace();
        }
        
    }
}
