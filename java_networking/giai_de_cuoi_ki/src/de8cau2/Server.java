/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de8cau2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oem
 */
public class Server {
    public static void main(String[] args){
        try{
            InterfaceRMI rmiApp= new RemoteRMI();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("app", rmiApp);
        }catch(RemoteException| MalformedURLException e){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
