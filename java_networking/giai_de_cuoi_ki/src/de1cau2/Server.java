/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de1cau2;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.*;

/**
 *
 * @author oem
 */
public class Server {
    ArrayList<Question> questionList;

    public void readDataBase(){
        questionList= new ArrayList<>();
        try{
            FileReader fr= new FileReader("question.txt");
            BufferedReader br= new BufferedReader(fr);
            String s=br.readLine();
            while(s!=null){
                String[] data= s.split("\\$");
                Question question= new Question(data[0], data[1], data[2], data[3]);
                questionList.add(question);
                s=br.readLine();
            }
            br.close();
        }catch(FileNotFoundException e){
            System.out.println("question data error");
        }catch(IOException ex){
            System.out.println("Qus");
        }
    }
    public static void main(String[] args){
        Server server = new Server();
        server.readDataBase();

        try{
            ServerSocket sv= new ServerSocket(6066);
            Socket sk=sv.accept();
            System.out.println("Ket noi thanh cong!");
        
            DataInputStream dataIn= new DataInputStream(sk.getInputStream());
            DataOutputStream dataOut= new DataOutputStream(sk.getOutputStream());
        
            boolean checkEnd=false;
            while(true){
                for(int i=0; i<server.questionList.size(); i++){
                    Question question= server.questionList.get(i);
                    dataOut.writeUTF(question.getQuestionName());
                    dataOut.writeUTF(question.getQuestionAnswer());
                    String answer=dataIn.readUTF();
                    if(answer.compareTo(question.getAnswer())==0){
                        dataOut.writeUTF("true");
                    }else{
                        dataOut.writeUTF("false");
                        checkEnd=true;
                        break;
                    }
                }
                if(checkEnd){
                    break;
                }
            }
            sv.close();
        }catch(IOException e){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
