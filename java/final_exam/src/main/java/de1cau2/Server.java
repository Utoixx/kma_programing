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
    
    ServerSocket sv;
    Socket sk;

    public void readDataBase(){
        questionList= new ArrayList<>();
        try{
            FileReader fr= new FileReader("question.txt");
            BufferedReader br= new BufferedReader(fr);
            String s=br.readLine();
            while(s!=null){
                String[] data= s.split("$");
                Question question= new Question(data[0], data[1], data[2].split("//"), data[3]);
                questionList.add(question);
            }
            br.close();
        }catch(FileNotFoundException e){
            System.out.println("question data error");
        }catch(IOException ex){
            System.out.println("Qus");
        }

    }
    public void connect(){
        try{
            sv= new ServerSocket(6066);
            sk=sv.accept();
        }catch(IOException e){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public static void main(String[] args){
        Server server = new Server();
        server.readDataBase();
        server.connect();
        System.out.println("Ket noi thanh cong!");

        try{
            DataInputStream dataIn= new DataInputStream(server.sk.getInputStream());
            DataOutputStream dataOut= new DataOutputStream(server.sk.getOutputStream());
        
            boolean checkEnd=false;
            while(true){
                for(int i=0; i<server.questionList.size(); i++){
                    Question question= server.questionList.get(i);
                    dataOut.writeUTF(question.getQuestionName());
                    dataOut.writeUTF(question.showQuestionAnswerList());
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
        }catch(IOException e){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
