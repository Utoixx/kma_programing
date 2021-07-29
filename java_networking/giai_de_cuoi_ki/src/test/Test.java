/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.*;
/**
 *
 * @author quoct
 */
public class Test {
    public static void main(String[] args) throws IOException{
        File fin;
        FileInputStream finStream;
        String strFileName = "test.txt";
        fin = new File(strFileName);
        FileReader file = new FileReader("Hello.txt");
    }
}
