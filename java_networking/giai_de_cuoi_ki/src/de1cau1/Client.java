/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de1cau1;

import java.io.*;
import java.util.logging.Logger;
import java.net.*;
import java.util.logging.Level;

public class Client{
    DatagramSocket socket;
    DatagramPacket packet;

    //Establis connection
    public void connect(){
        try{
            socket= new DatagramSocket();
        }catch(SocketException e){
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    //Send a message to server
    public void sendMessage(String message){
        try{
            byte[] data= new byte[1024];
            data=message.getBytes();
            InetAddress ip= InetAddress.getByName("localhost");
            packet= new DatagramPacket(data, data.length, ip, 6066);
            socket.send(packet);
        }catch(IOException e){
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    //Receive a message from server
    public String receiveMessage(){
        try{
            byte[] data= new byte[1024];
            packet= new DatagramPacket(data, data.length);
            socket.receive(packet);
            String message= new String(packet.getData()).trim();
            return message;
        }catch(IOException e){
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
            return "";
        }
    }
    public static void main(String[] args){
        Client client= new Client();
        client.connect();
        client.sendMessage(Character.toString('a'));
        System.out.println(client.receiveMessage());
    }
}
