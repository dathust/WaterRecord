 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.model;

/**
 *
 * @author HuyGL
 */
public class CustomerModel {
    private int maKhachHang;
    private String tenKhachHang;
    private String tenKhac;
    private String diaChi;
    private String dienThoai;
    private String maSoThue;
    private int maSoDongHo;
    private int maBangGia;
    private int maTram;
    private int tongChiSo;
    private float toaDoX;
    private float toaDoY;
    private String ghiChu;

    public CustomerModel() {
    }

    public CustomerModel(int maKhachHang, String tenKhachHang, String tenKhac, String diaChi, String dienThoai, String maSoThue, int maSoDongHo, int maBangGia, int maTram, int tongChiSo, float toaDoX, float toaDoY, String ghiChu) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.tenKhac = tenKhac;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
        this.maSoThue = maSoThue;
        this.maSoDongHo = maSoDongHo;
        this.maBangGia = maBangGia;
        this.maTram = maTram;
        this.tongChiSo = tongChiSo;
        this.toaDoX = toaDoX;
        this.toaDoY = toaDoY;
        this.ghiChu = ghiChu;
    }

    public String getTenKhac() {
        return tenKhac;
    }

    public void setTenKhac(String tenKhac) {
        this.tenKhac = tenKhac;
    }

    

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public int getMaSoDongHo() {
        return maSoDongHo;
    }

    public void setMaSoDongHo(int maSoDongHo) {
        this.maSoDongHo = maSoDongHo;
    }

    public int getMaBangGia() {
        return maBangGia;
    }

    public void setMaBangGia(int maBangGia) {
        this.maBangGia = maBangGia;
    }

    public int getMaTram() {
        return maTram;
    }

    public void setMaTram(int maTram) {
        this.maTram = maTram;
    }

    public int getTongChiSo() {
        return tongChiSo;
    }

    public void setTongChiSo(int tongChiSo) {
        this.tongChiSo = tongChiSo;
    }

    public float getToaDoX() {
        return toaDoX;
    }

    public void setToaDoX(float toaDoX) {
        this.toaDoX = toaDoX;
    }

    public float getToaDoY() {
        return toaDoY;
    }

    public void setToaDoY(float toaDoY) {
        this.toaDoY = toaDoY;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    
}
