/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de3cau1;

import java.io.IOException;
import java.net.*;

/**
 *
 * @author oem
 */
public class Server {
    DatagramSocket socket;
    DatagramPacket packet;
    public void connect(){
        try{
            socket = new DatagramSocket(6066);
        }catch(SocketException e){
            e.printStackTrace();
        }
    }
    public String receiveData(){
        try{
            byte[] data= new byte[1024];
            packet=new DatagramPacket(data, data.length);
            socket.receive(packet);
            String s= new String(packet.getData()).trim();
            return s;
        }catch(IOException e){
            e.printStackTrace();
        }
        return "";
    }
    public void sendData(String s){
        try{
            byte[] data= new byte[1024];
            data=s.getBytes();
            InetAddress ip= packet.getAddress();
            int port= packet.getPort();
            packet= new DatagramPacket(data, data.length, ip, port);
            socket.send(packet);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public int giaiThua(int n){
        int gt=1;
        for(int i=1; i<=n; i++){
            gt*=i;
        }
        return gt;
    }
    public static void main(String[] args){
        Server sv= new Server();
        sv.connect();
        int n= sv.giaiThua(Integer.parseInt(sv.receiveData()));
        sv.sendData(Integer.toString(n));
    }
}
