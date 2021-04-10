/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de6cau2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

/**
 *
 * @author oem
 */
public class Client {
    public void hienThiDanhSach(String data){
        System.out.println(data);
    }
    public String themNha(){
        String s="";
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhap so nha:");
        s+=sc.nextLine()+"$";
        System.out.println("Nhap gia tien:");
        s+=sc.nextLine()+"$";
        System.out.println("Nhap tinh trang:");
        s+=sc.nextLine()+"$";
        return s;
    }
    public void menu(){
        System.out.println("App quan ly chung cu!");
        System.out.println("1. Xem du lieu!");
        System.out.println("2. Them nha!");
        System.out.println("3. Ban nha!");
        System.out.println("4. Thoat");
    }
    public static void main(String[] args){
        Client cl= new Client();
        try{
            Socket socket= new Socket("localhost",6789);
            DataInputStream dataIn= new DataInputStream(socket.getInputStream());
            DataOutputStream dataOut= new DataOutputStream(socket.getOutputStream());
            int selection=0;
            Scanner sc= new Scanner(System.in);
            while(selection!=4){
                cl.menu();
                selection=sc.nextInt();
                dataOut.write(selection);
                String soNha;
                switch(selection){
                    case 1:
                        cl.hienThiDanhSach(dataIn.readUTF());
                        break; 
                    case 2: 
                        dataOut.writeUTF(cl.themNha());
                        break;
                    case 3:
                        System.out.println("Nhap so nha can ban:");
                        sc.nextLine();
                        soNha=sc.nextLine();
                        dataOut.writeUTF(soNha);
                        break;
                }
            }
            socket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
