/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de2cau2;

/**
 *
 * @author oem
 */
public class TuDien {
    private String vietTat;
    private String vietThuong;
    
    public TuDien(String vietTat, String vietThuong){
        this.vietTat=vietTat;
        this.vietThuong=vietThuong;
    }
    public void setVietThuong(String vietThuong){
        this.vietThuong=vietThuong;
    }
    public String getVietThuong(){
        return vietThuong;
    }
    public void setVietTat(String vietTat){
        this.vietTat=vietTat;
    }
    public String getVietTat(){
        return vietTat;
    }
}
