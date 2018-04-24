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
public class IndicationModel {
    private int maSoGhi;
    private int maKhachHang;
    private int maNhanVien;
    private int chiSo;
    private Date ngayGhiSo;
    private String ghiChu;

    public IndicationModel() {
    }

    public IndicationModel(int maSoGhi, int maKhachHang, int maNhanVien, int chiSo, Date ngayGhiSo, String ghiChu) {
        this.maSoGhi = maSoGhi;
        this.maKhachHang = maKhachHang;
        this.maNhanVien = maNhanVien;
        this.chiSo = chiSo;
        this.ngayGhiSo = ngayGhiSo;
        this.ghiChu = ghiChu;
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

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public int getChiSo() {
        return chiSo;
    }

    public void setChiSo(int chiSo) {
        this.chiSo = chiSo;
    }

    public Date getNgayGhiSo() {
        return ngayGhiSo;
    }

    public void setNgayGhiSo(Date ngayGhiSo) {
        this.ngayGhiSo = ngayGhiSo;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    
}
