/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de7cau1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

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
            InetAddress ip= InetAddress.getByName("localhost");
            packet= new DatagramPacket(data, data.length, ip, 6789);
            socket.send(packet);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        Client cl= new Client();
        cl.connect();
        cl.sendData(Integer.toString(5));
        System.out.println(cl.receiveData());
    }
}
