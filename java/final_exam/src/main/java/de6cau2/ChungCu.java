/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de6cau2;

/**
 *
 * @author oem
 */
public class ChungCu {
    private String soNha;
    private int giaBan;
    private boolean tinhTrang;
    
    public ChungCu(String soNha, int giaBan, boolean tinhTrang){
        this.soNha=soNha;
        this.giaBan=giaBan;
        this.tinhTrang=tinhTrang;
    }
    
    public String getSoNha(){
        return soNha;
    }
    public void setSoNha(String soNha){
        this.soNha=soNha;
    }
    public int getGiaBan(){
        return giaBan;
    }
    public void setGiaBan(int giaBan){
        this.giaBan= giaBan;
    }
    public boolean getTinhTrang(){
        return tinhTrang;
    }
    public void setTinhTrang(boolean tinhTrang){
        this.tinhTrang=tinhTrang;
    }
}
