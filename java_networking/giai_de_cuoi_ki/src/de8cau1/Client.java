package de8cau1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oem
 */
public class Client {
    DatagramSocket socket;
    DatagramPacket packet;
    
    public void connect(){
        try{
            socket= new DatagramSocket();
        }catch(SocketException e){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void sendData(String message){
        try{
            byte[] data= new byte[1024];
            data= message.getBytes();
            InetAddress ip= InetAddress.getByName("localhost");
            packet= new DatagramPacket(data, data.length, ip, 6789);
            socket.send(packet);
        }catch(IOException e){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
        }
        return "";
    }
    public static void main(String[] args){
        Client client= new Client();
        client.connect();
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhap so n:");
        float n= sc.nextFloat();
        client.sendData(Float.toString(n));
        System.out.println(client.receiveData());
        
    }
}
