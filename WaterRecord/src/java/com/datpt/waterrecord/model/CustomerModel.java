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
    private double toaDoX1;
    private double toaDoX2;
    private double toaDoY1;
    private double toaDoY2;
    private int trangThai;
    private String ghiChu;
    private int chiSoThangTruoc;
    private int chiSoThangNay;

    public CustomerModel(int maKhachHang, String tenKhachHang, String tenKhac, String diaChi, String dienThoai, String maSoThue, int maSoDongHo, int maBangGia, int maTram, int tongChiSo, double toaDoX1, double toaDoX2, double toaDoY1, double toaDoY2, int trangThai, String ghiChu, int chiSoThangTruoc, int chiSoThangNay) {
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
        this.toaDoX1 = toaDoX1;
        this.toaDoX2 = toaDoX2;
        this.toaDoY1 = toaDoY1;
        this.toaDoY2 = toaDoY2;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
        this.chiSoThangTruoc = chiSoThangTruoc;
        this.chiSoThangNay = chiSoThangNay;
    }


    
    public CustomerModel() {
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

    public double getToaDoX1() {
        return toaDoX1;
    }

    public void setToaDoX1(double toaDoX1) {
        this.toaDoX1 = toaDoX1;
    }

    public double getToaDoX2() {
        return toaDoX2;
    }

    public void setToaDoX2(double toaDoX2) {
        this.toaDoX2 = toaDoX2;
    }

    public double getToaDoY1() {
        return toaDoY1;
    }

    public void setToaDoY1(double toaDoY1) {
        this.toaDoY1 = toaDoY1;
    }

    public double getToaDoY2() {
        return toaDoY2;
    }

    public void setToaDoY2(double toaDoY2) {
        this.toaDoY2 = toaDoY2;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
     public int getChiSoThangTruoc() {
        return chiSoThangTruoc;
    }

    public void setChiSoThangTruoc(int chiSoThangTruoc) {
        this.chiSoThangTruoc = chiSoThangTruoc;
    }

    public int getChiSoThangNay() {
        return chiSoThangNay;
    }

    public void setChiSoThangNay(int chiSoThangNay) {
        this.chiSoThangNay = chiSoThangNay;
    }

    
    
}
