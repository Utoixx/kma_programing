/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de8cau2;

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
    public void menu(){
        System.out.println("App may tinh!");
        System.out.println("1. Tinh tong a + b");
        System.out.println("2. Tinh hieu a - b");
        System.out.println("3. Tinh tich a x b");
        System.out.println("4. Tinh thuong a : b");
        System.out.println("5. Tinh UCLN cua a va b");
        System.out.println("6. Exit!\n");
    }
    public static void main(String[] args){
        Client client= new Client();
        Scanner sc= new Scanner(System.in);
        int selection= 0;
        int a;
        int b;
        try{
            InterfaceRMI appRMI= (InterfaceRMI)Naming.lookup("rmi://localhost:1099/app");
            while(selection!=6){
                client.menu();
                selection= sc.nextInt();
                switch(selection){
                    case 1:
                        System.out.println("Nhap a");
                        a= sc.nextInt();
                        System.out.println("Nhap b");
                        b= sc.nextInt();
                        System.out.println("a + b = "+appRMI.cong(a, b));
                        break;
                    case 2:
                        System.out.println("Nhap a");
                        a= sc.nextInt();
                        System.out.println("Nhap b");
                        b= sc.nextInt();
                        System.out.println("a - b = "+appRMI.tru(a, b));
                        break;
                    case 3:
                        System.out.println("Nhap a");
                        a= sc.nextInt();
                        System.out.println("Nhap b");
                        b= sc.nextInt();
                        System.out.println("a x b = "+appRMI.nhan(a, b));
                        break;
                    case 4:
                        System.out.println("Nhap a");
                        a= sc.nextInt();
                        System.out.println("Nhap b");
                        b= sc.nextInt();
                        System.out.println("a : b = "+appRMI.chia(a, b));
                        break;
                    case 5:
                        System.out.println("Nhap a");
                        a= sc.nextInt();
                        System.out.println("Nhap b");
                        b= sc.nextInt();
                        System.out.println("UCLN cua a va b la "+appRMI.ucln(a, b));
                        break;
                }
            }
        }catch(RemoteException| MalformedURLException| NotBoundException e){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
