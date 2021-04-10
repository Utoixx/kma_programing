/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de5cau2;

/**
 *
 * @author oem
 */
public class TaiKhoan {
    private int tongTien;
    private String lichSuGD;
    
    public TaiKhoan(int tongTien, String lichSuGD){
        this.tongTien=tongTien;
        this.lichSuGD=lichSuGD;
    }
    public int getTongTien(){
        return tongTien;
    }
    public void setTongTien(int tongTien){
        this.tongTien=tongTien;
    }
    public String getLichSuGD(){
        return lichSuGD;
    }
    public void setLichSuGD(String lichSuGD){
        this.lichSuGD+=lichSuGD;
    }
}
