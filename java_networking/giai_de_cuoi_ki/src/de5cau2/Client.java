/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de5cau2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oem
 */
public class Client {
    private TaiKhoan account;
    DatagramSocket socket;
    DatagramPacket packet;
    
    public void connect(){
        try{
            socket= new DatagramSocket();
        }catch(SocketException e){
            Logger.getLogger(de1cau1.Server.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    public String receiveData(){
        try{
            byte[] data= new byte[1024];
            packet= new DatagramPacket(data, data.length);
            socket.receive(packet);
            String s= new String(packet.getData()).trim();
            return s;
        }catch(IOException e){
            Logger.getLogger(de1cau1.Server.class.getName()).log(Level.SEVERE, null, e);
        }
        return "";
    }
    public void sendData(String message){
        try{
            byte[] data= new byte[1024];
            data=message.getBytes();
            InetAddress ip= InetAddress.getByName("localhost");
            packet= new DatagramPacket(data, data.length, ip, 6789);
            socket.send(packet);
        }catch(IOException e){
            Logger.getLogger(de1cau1.Server.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void menu(){
        System.out.println("Quan ly so tai chinh!");
        System.out.println("1. Cong tien");
        System.out.println("2. Tru tien");
        System.out.println("3. Xem so du");
        System.out.println("4. Xem lich su thu chi");
        System.out.println("5. Thoat\n");
    }
    public static void main(String[] args){
        Client cl= new Client();
        cl.connect();
        int selection=0;
        String message;
        int tien;
        Scanner sc= new Scanner(System.in);
        while(selection!=5){
            cl.menu();
            selection=sc.nextInt();
            cl.sendData(Integer.toString(selection));
            switch(selection){
                case 1:
                    System.out.println("Nhap so tien can cong:");
                    tien= sc.nextInt();
                    cl.sendData(Integer.toString(tien));
                    break;
                case 2:
                    System.out.println("Nhap so tien can chi");
                    tien= sc.nextInt();
                    cl.sendData(Integer.toString(tien));
                    break;
                case 3:
                    System.out.println(cl.receiveData());
                    break;
                case 4:
                    System.out.println(cl.receiveData());
                    break;
            }
        }
    }
}
