/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.model;

import java.util.Date;

/**
 *
 * @author DatPT
 */
public class BillModel {
    
    private int maHoaDon;
    private int maSoGhi;
    private int maKhachHang;
    private String tenKhachHang;
    private String diaChi;
    private String dienThoai;
    private int maSoDongHo;
    private String tenBangGia;
    private int chiSoThangNay;
    private int chiSoThangTruoc;
    private int chiSoSuDung;
    private int donGia;
    private float thueVAT;
    private int phuPhi;
    private int tongThu;
    private Date ngayGhiSo;
    private Date ngayLapHD;
    private int trangThai;
    private String ghiChu;  

    public BillModel() {
    }

    public BillModel(int maHoaDon, int maSoGhi, int maKhachHang, String tenKhachHang, String diaChi, String dienThoai, int maSoDongHo, String tenBangGia, int chiSoThangNay, int chiSoThangTruoc, int chiSoSuDung, int donGia, float thueVAT, int phuPhi, int tongThu, Date ngayGhiSo, Date ngayLapHD, int trangThai, String ghiChu) {
        this.maHoaDon = maHoaDon;
        this.maSoGhi = maSoGhi;
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
        this.maSoDongHo = maSoDongHo;
        this.tenBangGia = tenBangGia;
        this.chiSoThangNay = chiSoThangNay;
        this.chiSoThangTruoc = chiSoThangTruoc;
        this.chiSoSuDung = chiSoSuDung;
        this.donGia = donGia;
        this.thueVAT = thueVAT;
        this.phuPhi = phuPhi;
        this.tongThu = tongThu;
        this.ngayGhiSo = ngayGhiSo;
        this.ngayLapHD = ngayLapHD;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
    }

    public int getChiSoThangNay() {
        return chiSoThangNay;
    }

    public void setChiSoThangNay(int chiSoThangNay) {
        this.chiSoThangNay = chiSoThangNay;
    }

    public int getChiSoSuDung() {
        return chiSoSuDung;
    }

    public void setChiSoSuDung(int chiSoSuDung) {
        this.chiSoSuDung = chiSoSuDung;
    }

   

    public int getChiSoThangTruoc() {
        return chiSoThangTruoc;
    }

    public void setChiSoThangTruoc(int chiSoThangTruoc) {
        this.chiSoThangTruoc = chiSoThangTruoc;
    }

    
    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

   

    public Date getNgayGhiSo() {
        return ngayGhiSo;
    }

    public void setNgayGhiSo(Date ngayGhiSo) {
        this.ngayGhiSo = ngayGhiSo;
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

    public int getMaSoDongHo() {
        return maSoDongHo;
    }

    public void setMaSoDongHo(int maSoDongHo) {
        this.maSoDongHo = maSoDongHo;
    }

    public String getTenBangGia() {
        return tenBangGia;
    }

    public void setTenBangGia(String tenBangGia) {
        this.tenBangGia = tenBangGia;
    }

    

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaSoGhi() {
        return maSoGhi;
    }

    public void setMaSoGhi(int maSoGhi) {
        this.maSoGhi = maSoGhi;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public float getThueVAT() {
        return thueVAT;
    }

    public void setThueVAT(float thueVAT) {
        this.thueVAT = thueVAT;
    }

    public int getPhuPhi() {
        return phuPhi;
    }

    public void setPhuPhi(int phuPhi) {
        this.phuPhi = phuPhi;
    }

    public int getTongThu() {
        return tongThu;
    }

    public void setTongThu(int tongThu) {
        this.tongThu = tongThu;
    }

    public Date getNgayLapHD() {
        return ngayLapHD;
    }

    public void setNgayLapHD(Date ngayLapHD) {
        this.ngayLapHD = ngayLapHD;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    
}
