package de2cau2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oem
 */
public class Server {
    ArrayList<TuDien> listWord;
    public void docDuLieu(){
        listWord= new ArrayList<>();
        try{
            FileReader file= new FileReader("tudien.txt");
            BufferedReader br= new BufferedReader(file);
            String s;
            while((s=br.readLine())!=null){
                String[] arr=s.split(" ");
                TuDien word= new TuDien(arr[0], arr[1]);
                listWord.add(word);
            }
            br.close();
            file.close();
        }catch(IOException e){
            Logger.getLogger(de1cau1.Server.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public static void main(String[] args){
        Server sv= new Server();
        sv.docDuLieu();
        try{
            Interface_tu_dien obj= new Remote(sv.listWord);
            LocateRegistry.createRegistry(6789);
            Naming.rebind("app", obj);
        }catch(RemoteException | MalformedURLException e){
            Logger.getLogger(de1cau1.Server.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
