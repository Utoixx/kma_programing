/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de1cau2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

/**
 *
 * @author oem
 */
public class Client {
    public static void main(String[] args){
        try{
            Socket socket= new Socket("localhost", 6066);
            System.out.println("Ket noi Server thanh cong!");
            DataInputStream dataIn= new DataInputStream(socket.getInputStream());
            Scanner sc= new Scanner(System.in);
            DataOutputStream dataOut= new DataOutputStream(socket.getOutputStream());
            while(true){
                System.out.println(dataIn.readUTF());
                System.out.println(dataIn.readUTF());
                String answer=sc.nextLine();
                dataOut.writeUTF(answer);
                if(dataIn.readUTF().compareTo("true")==0){
                    System.out.println("Dap an dung!");
                }else{
                    System.out.println("Dap an sai!");
                    break;
                }   

            }
            socket.close();
            sc.close();
        }catch(IOException e){
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
