/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de3cau2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oem
 */
public class Client {
    public static void main(String[] args){
        try{
            Socket sk= new Socket("localhost",6066);
            DataInputStream dataIn= new DataInputStream(sk.getInputStream());
            DataOutputStream dataOut= new DataOutputStream(sk.getOutputStream());
            Scanner sc= new Scanner(System.in);
            while(true){
                String message=dataIn.readUTF();
                if(message.equals("tam biet")){
                    break;
                }
                System.out.println("Server: "+message);
                System.out.println("Client: ");
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
