/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de2cau2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author oem
 */
public class Remote extends UnicastRemoteObject implements Interface_tu_dien{
    ArrayList<TuDien> listWord;
    public Remote(ArrayList<TuDien> listWord) throws RemoteException{
        super();
        this.listWord=listWord;
    }
    @Override
    public String sangVietTat(String s)throws RemoteException{
        for(TuDien list: listWord){
            if(list.getVietThuong().equals(s)){
                return list.getVietTat();
            }
        }
        return "none";
    }
    @Override
    public String sangVietThuong(String s)throws RemoteException{
        for(TuDien list: listWord){
            if(list.getVietTat().equals(s)){
                return list.getVietThuong();
            }
        }
        return "none";
    }
    
}
