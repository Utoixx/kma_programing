/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de7cau2;

/**
 *
 * @author oem
 */
public class KhachHang {
    private String maKH;
    private String tenKH;
    private String loaiPhong;
    private int soNgayO;
    
    public KhachHang(String maKH, String tenKH, String loaiPhong, int soNgayO){
        this.maKH=maKH;
        this.tenKH=tenKH;
        this.loaiPhong=loaiPhong;
        this.soNgayO=soNgayO;
    }
    
    public void setMaKH(String maKH){
        this.maKH= maKH;
    }
    public String getMaKH(){
        return maKH;
    }
    public void setTenKH(String tenKH){
        this.tenKH= tenKH;
    }
    public String getTenKH(){
        return tenKH;
    }
    public void setLoaiPhong(String loaiPhong){
        this.loaiPhong=loaiPhong;
    }
    public String getloaiPhong(){
        return loaiPhong;
    }
    public void setSoNgayO(int soNgayO){
        this.soNgayO=soNgayO;
    }
    public int getSoNgayO(){
        return soNgayO;
    }
}
