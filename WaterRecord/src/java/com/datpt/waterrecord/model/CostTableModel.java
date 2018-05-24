/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.model;

/**
 *
 * @author DatPT
 */
public class CostTableModel {
    private int maBangGia;
    private String tenBangGia;
    private String tenVietTat;
    private int donGia;
    private int thueVAT;
    private int thue;
    private int giaBan;

    public CostTableModel() {
    }

    public CostTableModel(int maBangGia, String tenBangGia, String tenVietTat, int donGia, int thueVAT, int thue, int giaBan) {
        this.maBangGia = maBangGia;
        this.tenBangGia = tenBangGia;
        this.tenVietTat = tenVietTat;
        this.donGia = donGia;
        this.thueVAT = thueVAT;
        this.thue = thue;
        this.giaBan = giaBan;
    }

    public int getThue() {
        return thue;
    }

    public void setThue(int thue) {
        this.thue = thue;
    }

    public int getMaBangGia() {
        return maBangGia;
    }

    public void setMaBangGia(int maBangGia) {
        this.maBangGia = maBangGia;
    }

    public String getTenBangGia() {
        return tenBangGia;
    }

    public void setTenBangGia(String tenBangGia) {
        this.tenBangGia = tenBangGia;
    }

    public String getTenVietTat() {
        return tenVietTat;
    }

    public void setTenVietTat(String tenVietTat) {
        this.tenVietTat = tenVietTat;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getThueVAT() {
        return thueVAT;
    }

    public void setThueVAT(int thueVAT) {
        this.thueVAT = thueVAT;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }
    
    
}
