/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kma.final_exam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author quoct
 */
public class Client {
    public static void main(String[] args){
        try{
            Socket socket= new Socket("localhost",6066);
            DataInputStream dataIn= new DataInputStream(socket.getInputStream());
            DataOutputStream dataOut= new DataOutputStream(socket.getOutputStream());
            int n;
            Scanner sc= new Scanner(System.in);
            n=sc.nextInt();
            dataOut.write(n);
            System.out.println(dataIn.readUTF());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
