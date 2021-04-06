/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de1cau1;

/**
 *
 * @author quoct
 */
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    private DatagramSocket socket;
    private DatagramPacket packet;

    public void connect(){
        try{
            socket= new DatagramSocket(6066);
        }catch(SocketException e){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void sendMessage(String message){
        try{
            byte[] data= new byte[1024];
            data=message.getBytes();
            InetAddress ip= packet.getAddress();
            int port= packet.getPort();
            packet= new DatagramPacket(data, data.length, ip, port);
            socket.send(packet);
        }catch(IOException e){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public String receiveMessage(){
        try{
            byte[] data= new byte[1024];
            packet= new DatagramPacket(data, data.length);
            socket.receive(packet);
            String message= new String(packet.getData()).trim();
            return message;
        }catch(IOException e){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
            return "";
        }
    }
    public static void main(String[] args){
        Server sv= new Server();
        sv.connect();
        char data=Character.toUpperCase(sv.receiveMessage().charAt(0));
        sv.sendMessage(Character.toString(data));
    }
}
