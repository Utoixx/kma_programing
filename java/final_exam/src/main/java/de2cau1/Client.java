/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de2cau1;

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
            Socket socket= new Socket("localhost", 6066);
            DataInputStream DataIn= new DataInputStream(socket.getInputStream());
            DataOutputStream DataOut= new DataOutputStream(socket.getOutputStream());
            Scanner sc= new Scanner(System.in);
            DataOut.writeInt(sc.nextInt());
            int check=DataIn.readInt();
            if(check==0){
                System.out.println("So chan!");
            }else{
                System.out.println("So Le!");
            }
        }catch(IOException e){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
}
