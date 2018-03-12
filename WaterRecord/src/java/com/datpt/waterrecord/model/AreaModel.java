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
public class AreaModel {
    private int maTram;
    private String tenTram;
    private String diaChi;
    private int tongKH;

    public AreaModel() {
    }

    public AreaModel(int maTram, String tenTram, String diaChi, int tongKH) {
        this.maTram = maTram;
        this.tenTram = tenTram;
        this.diaChi = diaChi;
        this.tongKH = tongKH;
    }

    public int getMaTram() {
        return maTram;
    }

    public void setMaTram(int maTram) {
        this.maTram = maTram;
    }

    public String getTenTram() {
        return tenTram;
    }

    public void setTenTram(String tenTram) {
        this.tenTram = tenTram;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getTongKH() {
        return tongKH;
    }

    public void setTongKH(int tongKH) {
        this.tongKH = tongKH;
    }
    
}
