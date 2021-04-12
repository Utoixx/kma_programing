/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de2cau2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oem
 */
public class Client {
    public static void main(String[] args){
        try{
            Interface_tu_dien tuDien= (Interface_tu_dien)Naming.lookup("rmi://localhost:6789/app");
            while(true){
                System.out.println("Tu dien:");
                System.out.println("1. viet tat - viet thuong");
                System.out.println("2. viet thuong - viet tat");
                Scanner sc= new Scanner(System.in);
                String selection= sc.nextLine();
                if(selection.equals("1")){
                    System.out.println("Nhap tu viet tat:");
                     System.out.println(tuDien.sangVietThuong(sc.nextLine()));
                }
                if(selection.equals("2")){
                    System.out.println("Nhap tu viet thuong:");
                    System.out.println(tuDien.sangVietTat(sc.nextLine()));
                }
            }
        }catch(RemoteException | NotBoundException | MalformedURLException e){
            Logger.getLogger(de1cau1.Server.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
