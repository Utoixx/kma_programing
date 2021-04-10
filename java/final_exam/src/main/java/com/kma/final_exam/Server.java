/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kma.final_exam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author quoct
 */
public class Server {
    static boolean snt(int n){
        boolean check=true;
        if(n==2||n==3){
            return check;
        }
        for(int i=2; i<n; i++){
            if(n%i==0){
                check=false;
            }
        }
        return check;
    }
    public static void main(String[] args){
        try{
            ServerSocket server= new ServerSocket(6066);
            Socket socket= server.accept();
            DataInputStream dataIn= new DataInputStream(socket.getInputStream());
            DataOutputStream dataOut= new DataOutputStream(socket.getOutputStream());
            int n=dataIn.read();
            String s="";
            for(int i=2; i<=n; i++){
                if(snt(i)){
                    s+= Integer.toString(i)+" ";
                }
            }
            dataOut.writeUTF(s);
        }catch(IOException e){
            e.printStackTrace();
        }
    }       
}
