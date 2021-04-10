/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de4cau2;

/**
 *
 * @author oem
 */
public class NhanVien {
    private String ten;
    private String ngaySinh;
    private String chucDanh;
    
    public NhanVien(){
        
    }
    
    public NhanVien(String ten, String ngaySinh, String chucDanh){
        this.ten=ten;
        this.ngaySinh=ngaySinh;
        this.chucDanh=chucDanh;
    }
    
    public void showInf(){
        System.out.println("Ten: "+ten);
        System.out.println("Ngay sinh: "+ngaySinh);
        System.out.println("Chuc danh: "+chucDanh);
    }
    public String getTen(){
        return ten;
    }
    public void setTen(String ten){
        this.ten=ten;
    }
    public String getNgaySinh(){
        return ngaySinh;
    }
    public void setNgaySinh(String ngaySinh){
        this.ngaySinh= ngaySinh;
    }
    public String getChucDanh(){
        return chucDanh;
    }
    public void setChucDanh(String chucDanh){
        this.chucDanh=chucDanh;
    }
}
