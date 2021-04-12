/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de4cau2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oem
 */
public class Client {
    public void menu(){
        System.out.println("App quan ly nhan vien!");
        System.out.println("1. Xem danh sach");
        System.out.println("2. Tim kiem");
        System.out.println("3. Them nhan vien");
        System.out.println("4. Thoat\n");
    }
    public String themNhanVien(){
        Scanner sc= new Scanner(System.in);
        NhanVien nv= new NhanVien();
        System.out.println("Nhap ten:");
        nv.setTen(sc.nextLine());
        System.out.println("Nhap ngay sinh:");
        nv.setNgaySinh(sc.nextLine());
        System.out.println("Nhap chuc danh:");
        nv.setChucDanh(sc.nextLine());
        String s=nv.getTen()+"$"+nv.getNgaySinh()+"$"+nv.getChucDanh();
        return s;
    }
    public static void main(String[] args){
        Client cl= new Client();
        try{
            Socket socket=new Socket("localhost",6789);
            DataInputStream dataIn= new DataInputStream(socket.getInputStream());
            DataOutputStream dataOut= new DataOutputStream(socket.getOutputStream());
            Scanner sc= new Scanner(System.in);
            int selection=0;
            String message;
            while(selection!=4){
                cl.menu();
                selection= sc.nextInt();
                dataOut.write(selection);
                switch(selection){
                    case 1:
                        System.out.println(dataIn.readUTF());
                        break;
                    case 2:
                        System.out.println("Nhap ten can tim: ");
                        sc.nextLine();
                        String ten= sc.nextLine();
                        dataOut.writeUTF(ten);
                        System.out.println(dataIn.readUTF());
                        break;
                    case 3:
                        dataOut.writeUTF(cl.themNhanVien());
                        break;
                }
            }
        }catch(IOException e){
            Logger.getLogger(de1cau1.Server.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
