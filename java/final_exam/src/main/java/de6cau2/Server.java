/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de6cau2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

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
        String[] arr=s.split("$");
        boolean check;
        if(arr[2].equals("1")){
            check=true;
        }else{
            check=false;
        }
        ChungCu cc= new ChungCu(arr[0], Integer.parseInt(arr[1]), check);
        listCC.add(cc);
    }
    public void chuyenNha(String soNha){
        for(ChungCu list: listCC){
            if(list.getSoNha().equals(soNha)){
                list.setTinhTrang(false);
                break;
            }
        }
    }
    public static void main(String[] args){
        Server= new Server
        try{
            ServerSocket server= new ServerSocket(6789);
            Socket socket= server.accept();
            DataInputStream dataIn= new DataInputStream(socket.getInputStream());
            DataOutputStream dataOut= new DataOutputStream(socket.getOutputStream());
            int selection=0;
            while(selection!=4){
                
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
