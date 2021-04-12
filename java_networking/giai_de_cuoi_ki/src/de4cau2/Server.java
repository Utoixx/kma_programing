/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de4cau2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
    ArrayList<NhanVien> list;
    
    public void docDuLieu(){
        list= new ArrayList<>();
        try{
            FileReader fr= new FileReader("nhanvien.txt");
            BufferedReader br= new BufferedReader(fr);
            String s;
            while((s=br.readLine())!=null){
                String[] arr= s.split("\\$");
                NhanVien nv= new NhanVien(arr[0], arr[1], arr[2]);
                list.add(nv);
            }
            br.close();
            fr.close();
        }catch(IOException e){
            Logger.getLogger(de1cau1.Server.class.getName()).log(Level.SEVERE, null, e);
        }    
    }
    public void ghiDuLieu(){
        try{
            FileWriter fw= new FileWriter("nhanvien.txt");
            BufferedWriter bw= new BufferedWriter(fw);
            for(NhanVien l: list){
                bw.write(l.getTen()+"$"+l.getNgaySinh()+"$"+l.getChucDanh()+"\n");
            }
            bw.close();
            fw.close();
        }catch(IOException e){
            Logger.getLogger(de1cau1.Server.class.getName()).log(Level.SEVERE, null, e);
        }
    }  
    public String danhSachNV(){
        String s="";
        for(NhanVien l: list){
            s+="\n"+l.getTen();
            s+="\n"+l.getNgaySinh();
            s+="\n"+l.getChucDanh();
        }
        return s;
    }
    public String timKiem(String ten){
        String ketQua="";
        for(NhanVien l: list){
            if(l.getTen().equals(ten)){
                ketQua+="Tim thay!";
                ketQua+="\n"+l.getTen();
                ketQua+="\n"+l.getNgaySinh();
                ketQua+="\n"+l.getChucDanh()+"\n";
                return ketQua;
            }
        }
        ketQua+="Khong tim thay!";
        return ketQua;
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
            String message;
            while(selection!=4){
                selection=dataIn.read();
                switch(selection){
                    case 1:
                        dataOut.writeUTF(sv.danhSachNV());
                        break;
                    case 2:
                        message= sv.timKiem(dataIn.readUTF());
                        dataOut.writeUTF(message);
                        break;
                    case 3:
                        message= dataIn.readUTF();
                        String[] arr= message.split("\\$");
                        NhanVien nv= new NhanVien(arr[0], arr[1], arr[2]);
                        sv.list.add(nv);
                        sv.ghiDuLieu();
                        break;
                }
            }
        }catch(IOException e){
            Logger.getLogger(de1cau1.Server.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
