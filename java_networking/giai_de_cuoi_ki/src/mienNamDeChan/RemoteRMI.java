/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mienNamDeChan;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.*;
import java.rmi.Remote;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quoct
 */
public class RemoteRMI extends UnicastRemoteObject implements InterfaceRMI{

    public File fin;
    public FileInputStream finStream;
    public FileOutputStream foutStream;
    public BufferedReader finBuff;
    public BufferedWriter foutBuff;
    public FileReader fileReader;
    public FileWriter fileWiter;
    public RemoteRMI() throws RemoteException{
        super();
    }
    @Override
    public int writeFileStream(String strFileName, String strBuf) throws RemoteException {
        fin = new File(strFileName);
        try{
            fin.createNewFile();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        try{
            foutStream = new FileOutputStream(fin);
            foutStream.write(strBuf.getBytes());
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e1){
            e1.printStackTrace();
        }
        return 0;
    }

    @Override
    public byte[] ReadFileStream(String strFileName) throws RemoteException {
        fin = new File(strFileName);
        if(fin.exists()==false){
                String strErr = "Erro: File not found!";
                byte[] messageBuff = strErr.getBytes();
                return messageBuff;
        }
        int fileSize =(int) fin.length();
        byte[] buff= new byte[fileSize];
        try{
            finStream = new FileInputStream(fin);
            finStream.read(buff);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e1){
            e1.printStackTrace();
        }
       return buff;
    }
    @Override
    public int writeFileBuff(String strFileName, String strBuf) throws RemoteException {
        try {
            fileWiter = new FileWriter(strFileName);
            foutBuff = new BufferedWriter(fileWiter);
            foutBuff.write(strBuf);
        }catch (IOException e) {
            e.printStackTrace();
        }
       
       return 0;
    }

    @Override
    public String ReadFileBuff(String strFileName) throws RemoteException {
        try {
            fileReader = new FileReader(strFileName);
        }catch (FileNotFoundException e) {
            String strErr= "Erro: File not found!";
            return strErr;
        }
       finBuff = new BufferedReader(fileReader);
       String buff = "";
       try{
          String strData;
          while((strData = finBuff.readLine())!=null){
              buff+="\n";
              buff+=strData;
          }
       }catch(IOException e){
           e.printStackTrace();
       }
       return buff;
    }
    
}
