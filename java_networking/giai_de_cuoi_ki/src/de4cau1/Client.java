/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de4cau1;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author oem
 */
public class Client {
    public static void main(String[] args){
        try{
            InterfaceInt binhPhuong= (InterfaceInt)Naming.lookup("rmi://localhost:1099/app");
            System.out.println(binhPhuong.binhPhuong(3));
        }catch(RemoteException | MalformedURLException | NotBoundException e){
            Logger.getLogger(de1cau1.Server.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
