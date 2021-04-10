/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de5cau1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author oem
 */
public class Server {
    public static void main(String[] args){
        try{
            ServerSocket server= new ServerSocket(6789);
            Socket socket= server.accept();
            DataInputStream dataIn= new DataInputStream(socket.getInputStream());
            DataOutputStream dataOut= new DataOutputStream(socket.getOutputStream());
            String s=dataIn.readUTF();
            dataOut.write(s.length());
        }catch(IOException e){
            e.printStackTrace();
        }
        
        
    }
}
