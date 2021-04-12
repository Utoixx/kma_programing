/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de2cau1;

/**
 *
 * @author oem
 */
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Server {
    public static void main(String[] args){
        try{
            ServerSocket server= new ServerSocket(6066);
            Socket socket= server.accept();
            DataInputStream DataIn= new DataInputStream(socket.getInputStream());
            DataOutputStream DataOut= new DataOutputStream(socket.getOutputStream());
            int n= DataIn.readInt();
            int test=0;
            if(n%2==1){
                test=1;
            }
            DataOut.writeInt(test);
            server.close();
        }catch(IOException e){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
