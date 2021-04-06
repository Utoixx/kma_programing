/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de1cau2;
import java.io.*;
import java.util.*;

import javax.management.QueryEval;

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
                String[] data= s.split("$");
                Question question= new Question(data[0], data[1], data[2].split("//"), data[3]);
                questionList.add(question);
            }
        }catch(FileNotFoundException e){
            System.out.println("question data error");
        }catch(IOException ex){
            System.out.println("Qus");
        }
        
    }
    public static void main(String[] args){
        
    }
}
