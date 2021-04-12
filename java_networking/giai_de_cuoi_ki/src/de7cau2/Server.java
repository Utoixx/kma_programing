/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de7cau2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oem
 */
public class Server {
    ArrayList<KhachHang> listKH;
    
    public void docDuLieu(){
        listKH= new ArrayList<>();
        try{
            FileReader fr= new FileReader("khachsan.txt");
            BufferedReader br= new BufferedReader(fr);
            String s;
            while((s=br.readLine())!=null){
                String[] arr= s.split("\\$" );
                KhachHang kh= new KhachHang(arr[0], arr[1], arr[2], Integer.parseInt(arr[3]));
                listKH.add(kh);
            }
            br.close();
        }catch(IOException e){
            Logger.getLogger(de1cau1.Server.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void ghiDuLieu(){
        try{
            FileWriter fw= new FileWriter("khacsan.txt");
            BufferedWriter bw= new BufferedWriter(fw);
            for(KhachHang l: listKH){
                bw.write(l.getMaKH()+"$"+l.getTenKH()+"$"+l.getloaiPhong()+"$"+l.getSoNgayO()+"\n");
            }
            bw.close();
            fw.close();
        }catch(IOException e){
            Logger.getLogger(de1cau1.Server.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public int tinhTienPhong(KhachHang kh){
       switch(kh.getloaiPhong()){
           case "S":
               return kh.getSoNgayO()*500000;
           case "A":
               return kh.getSoNgayO()*250000;
           case "B":
               return kh.getSoNgayO()*100000;
       }
       return 0;
    }
    public void themKhachHang(String s){
        String[] arr= s.split("\\$");
        KhachHang kh= new KhachHang(arr[0], arr[1], arr[2], Integer.parseInt(arr[3]));
        listKH.add(kh);
        ghiDuLieu();
    }
    public KhachHang timKiem(String tenKH){
        for(KhachHang list: listKH){
            if(list.getTenKH().equals(tenKH)){
                return list;
            }
        }
        return null;
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
            while(selection!=3){
                selection=dataIn.read();
                switch(selection){
                    case 1:
                        sv.themKhachHang(dataIn.readUTF());
                        break;
                    case 2:
                        KhachHang kh= sv.timKiem(dataIn.readUTF());
                        if(kh!=null){
                            dataOut.writeUTF(Integer.toString(sv.tinhTienPhong(kh)));
                        }else{
                            dataOut.writeUTF("Khach hang khong ton tai");
                        }
                        break;
                }
            }
        }catch(IOException e){
            Logger.getLogger(de1cau1.Server.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
