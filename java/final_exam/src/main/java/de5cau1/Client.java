package de5cau1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oem
 */
public class Client {
    public static void main(String[] args){
        try{
            Socket socket= new Socket("localhost",6789);
            DataInputStream dataIn= new DataInputStream(socket.getInputStream());
            DataOutputStream dataOut= new DataOutputStream(socket.getOutputStream());
            dataOut.writeUTF("hello");
            System.out.println(dataIn.read());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
