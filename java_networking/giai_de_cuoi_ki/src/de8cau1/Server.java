/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de8cau1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oem
 */
public class Server {
    DatagramSocket socket;
    DatagramPacket packet;
    
    public void connect(){
        try{
            socket= new DatagramSocket(6789);
        }catch(SocketException e){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void sendData(String message){
        try{
            byte[] data= new byte[1024];
            data= message.getBytes();
            InetAddress ip= packet.getAddress();
            int port= packet.getPort();
            packet= new DatagramPacket(data, data.length, ip, port);
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
        Server sv= new Server();
        sv.connect();
        float n= Float.parseFloat(sv.receiveData());
        if(n<0){
            n*=-1;
        }
        sv.sendData(Float.toString(n));
    }
}
