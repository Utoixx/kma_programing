/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de6cau2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author oem
 */
public class Server {
    ArrayList<ChungCu> listCC;
    
    public String hienThiDanhSach(){
        String s="";
        for(ChungCu list: listCC){
            s+=list.getSoNha()+"\n";
            s+=Integer.toString(list.getGiaBan())+"\n";
            s+=Boolean.toString(list.getTinhTrang())+"\n";
        }
        return s;
    }
    public void themNha(String s){
        String[] arr=s.split("\\$");
        ChungCu cc= new ChungCu(arr[0], Integer.parseInt(arr[1]), Boolean.parseBoolean(arr[2]));
        listCC.add(cc);
        ghiDuLieu();
    }
    public void banNha(String soNha){
        for(ChungCu list: listCC){
            if(list.getSoNha().equals(soNha)){
                list.setTinhTrang(true);
                break;
            }
        }
    }
    public void docDuLieu(){
        listCC= new ArrayList<>();
        try{
            FileReader fr= new FileReader("chungcu.txt");
            BufferedReader br= new BufferedReader(fr);
            String s;
            while((s=br.readLine())!=null){
                String[] arr= s.split("\\$" );
                ChungCu cc= new ChungCu(arr[0], Integer.parseInt(arr[1]), Boolean.parseBoolean(arr[2]));
                listCC.add(cc);
            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void ghiDuLieu(){
        try{
            FileWriter fw= new FileWriter("chungcu.txt");
            BufferedWriter bw= new BufferedWriter(fw);
            for(ChungCu l: listCC){
                bw.write(l.getSoNha()+"$"+l.getGiaBan()+"$"+l.getTinhTrang()+"\n");
            }
            bw.close();
            fw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    } 
    public static void main(String[] args){
        Server sv= new Server();
        sv.docDuLieu();
        try{
            ServerSocket server= new ServerSocket(6789);
            Socket socket= server.accept();
            DataInputStream dataIn= new DataInputStream(socket.getInputStream());
            DataOutputStream dataOut= new DataOutputStream(socket.getOutputStream());
            int selection=0;
            while(selection!=4){
                selection=dataIn.read();
                switch(selection){
                    case 1:
                        dataOut.writeUTF(sv.hienThiDanhSach());
                        break; 
                    case 2: 
                        sv.themNha(dataIn.readUTF());
                        break;
                    case 3:
                        sv.banNha(dataIn.readUTF());
                        break;
                }
            }
            server.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
