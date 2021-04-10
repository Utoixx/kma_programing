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

/**
 *
 * @author oem
 */
public class Server {
    private TaiKhoan account;
    DatagramSocket socket;
    DatagramPacket packet;
    
    public void connect(){
        try{
            socket= new DatagramSocket(6789);
        }catch(SocketException e){
            e.printStackTrace();
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
            e.printStackTrace();
        }
        return "";
    }
    public void sendData(String message){
        try{
            byte[] data= new byte[1024];
            data=message.getBytes();
            InetAddress ip=packet.getAddress();
            int port= packet.getPort();
            packet= new DatagramPacket(data, data.length, ip, port);
            socket.send(packet);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void TaiKhoanDemo(){
        account= new TaiKhoan(1000, "");
    }
    
    public void congTien(int tien){
        account.setTongTien(account.getTongTien()+tien);
        account.setLichSuGD("+"+Integer.toString(tien)); 
    }
    public void chiTien(int tien){
        account.setTongTien(account.getTongTien()-tien);
        account.setLichSuGD("-"+Integer.toString(tien)); 
    }
    public int xemSodu(){
        return account.getTongTien();
    }
    public String xemLichSu(){
        return account.getLichSuGD();
    }
    
    public static void main(String[] args){
        Server sv= new Server();
        sv.connect();
        sv.TaiKhoanDemo();
        int selection=0;
        String message;
        while(selection!=5){
            selection=Integer.parseInt(sv.receiveData());
            switch(selection){
                case 1:
                    message=sv.receiveData();
                    sv.congTien(Integer.parseInt(message));
                    break;
                case 2:
                    message=sv.receiveData();
                    sv.chiTien(Integer.parseInt(message));
                    break;
                case 3:
                    sv.sendData(Integer.toString(sv.xemSodu()));
                    break;
                case 4:
                    sv.sendData(sv.xemLichSu());
                    break;
            }
        }
    }
}
