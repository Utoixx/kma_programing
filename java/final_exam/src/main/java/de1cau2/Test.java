package de1cau2;

public class Test{
    public static void main(String[] args){
        String s="he//loo";
        String[] arr= s.split("//");
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);        
        }
    }
}