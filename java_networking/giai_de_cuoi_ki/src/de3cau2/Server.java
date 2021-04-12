/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de3cau2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oem
 */
public class Server {
    public static void main(String[] args){
        try{
            ServerSocket sv= new ServerSocket(6066);
            Socket sk= sv.accept();
            DataInputStream dataIn= new DataInputStream(sk.getInputStream());
            DataOutputStream dataOut= new DataOutputStream(sk.getOutputStream());
            Scanner sc= new Scanner(System.in);
            dataOut.writeUTF("Hello!");
            while(true){
                String message=dataIn.readUTF();
                if(message.equals("tam biet")){
                    break;
                }
                System.out.println("Client: "+message);
                System.out.println("Server: ");
                dataOut.writeUTF(sc.nextLine());
                String sendMessage=sc.nextLine();
                dataOut.writeUTF(sendMessage);
                if(sendMessage.equals("tam biet")){
                    break;
                }
            }
        }catch(IOException e){
            Logger.getLogger(de1cau1.Server.class.getName()).log(Level.SEVERE, null, e);
        }
        
        
    }
}
