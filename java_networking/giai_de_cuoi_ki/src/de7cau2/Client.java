/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de7cau2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oem
 */
public class Client {
    public String themKhachHang(){
        String s="";
        Scanner sc= new Scanner(System.in);
        System.out.println("Them khach hang moi:");
        System.out.println("Nhap ma khach hang:");
        s+=sc.nextLine()+"$";
        System.out.println("Nhap ten khach hang");
        s+=sc.nextLine()+"$";
        String str="";
        while(str.equals("S")!=true||str.equals("A")!=true||str.equals("B")!=true){
            System.out.println("Nhap loai phong:");
            str=sc.nextLine();
            if(str.equals("S")||str.equals("A")||str.equals("B")){
                break;
            }else{
                System.out.println("Loai phong khong hop le! Nhap lai!");
            }
        }
        s+=str+"$";
        System.out.println("Nhap so ngay o:");
        s+=Integer.toString(sc.nextInt());
        return s;
    }
    public void menu(){
        System.out.println("App quan ly khach san!");
        System.out.println("1. Them khach hang!");
        System.out.println("2. Tinh tien!");
        System.out.println("3. Thoat!");
    }
    public static void main(String[] args){
        Client cl= new Client();
        try{
            Socket socket= new Socket("localhost",6789);
            DataInputStream dataIn= new DataInputStream(socket.getInputStream());
            Scanner sc= new Scanner(System.in);
            DataOutputStream dataOut= new DataOutputStream(socket.getOutputStream());
            int selection=0;
            while(selection!=3){
                cl.menu();
                selection=sc.nextInt();
                dataOut.write(selection);
                switch(selection){
                    case 1:
                        dataOut.writeUTF(cl.themKhachHang());
                        break;
                    case 2:
                        String tenKH;
                        System.out.println("Nhap ten khach hang:");
                        sc.nextLine();
                        tenKH=sc.nextLine();
                        dataOut.writeUTF(tenKH);
                        System.out.println(dataIn.readUTF());
                        break;
                }
            }
        }catch(IOException e){
            Logger.getLogger(de1cau1.Server.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
