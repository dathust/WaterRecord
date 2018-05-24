/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.controller.controllerImp;

import com.datpt.waterrecord.DAO.DaoImp.CustomerDAO;
import com.datpt.waterrecord.DAO.DaoImp.IndicationDAO;
import com.datpt.waterrecord.DAO.DaoItf.CustomerInterface;
import com.datpt.waterrecord.DAO.DaoItf.IndicationInterface;
import com.datpt.waterrecord.model.CustomerModel;
import com.datpt.waterrecord.model.IndicationModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DatPT
 */
public class CustomerController {

    public CustomerModel getCustomer(int maKhachHang) {
        CustomerInterface c = new CustomerDAO();
        IndicationInterface indi = new IndicationDAO();
        CustomerModel customer = c.getCustomer(maKhachHang);
        List<IndicationModel> list = new ArrayList<>();
        list = indi.getIndicationCustomer(customer.getMaKhachHang());
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        int monthCurrent = date.getMonth() + 1;
        int yearCurrent = date.getYear() + 1900;

        for (int i = 0; i < list.size(); i++) {
            int year = list.get(i).getNgayGhiSo().getYear() + 1900;
            int month = list.get(i).getNgayGhiSo().getMonth() + 1;
            if ((year == yearCurrent) && (month == monthCurrent)) {
                int chiSoThangNay = list.get(i).getChiSo();
                customer.setChiSoThangNay(chiSoThangNay);
            }
            if ((year == yearCurrent) && (month == (monthCurrent - 1))) {
                int chiSoThangTruoc = list.get(i).getChiSo();
                customer.setChiSoThangTruoc(chiSoThangTruoc);
            }
        }
        return customer;
    }

    public List<CustomerModel> getListCustomerArea(int maTram) {
        List<CustomerModel> listCustomer = new ArrayList<>();
        CustomerInterface c = new CustomerDAO();
        IndicationInterface indi = new IndicationDAO();
        listCustomer = c.getListCustomerArea(maTram);
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        int monthCurrent = date.getMonth() + 1;
        int yearCurrent = date.getYear() + 1900;
        for (int i = 0; i < listCustomer.size(); i++) {
            List<IndicationModel> list = new ArrayList<>();
            list = indi.getIndicationCustomer(listCustomer.get(i).getMaKhachHang());
            for (int j = 0; j < list.size(); j++) {
                int year = list.get(j).getNgayGhiSo().getYear() + 1900;
                int month = list.get(j).getNgayGhiSo().getMonth() + 1;
                if ((year == yearCurrent) && (month == monthCurrent)) {
                    int chiSoThangNay = list.get(j).getChiSo();
                    listCustomer.get(i).setChiSoThangNay(chiSoThangNay);
                }
                if ((year == yearCurrent) && (month == (monthCurrent - 1))) {
                    int chiSoThangTruoc = list.get(j).getChiSo();
                    listCustomer.get(i).setChiSoThangTruoc(chiSoThangTruoc);
                }
            }
        }
        return listCustomer;

    }
    
    public boolean InsertCustomer(String tenKhachHang, String tenKhac, String diaChi, String dienThoai, String maSoThue, int maSoDongHo, int maBangGia, int maTram,int tongChiSo, String ghiChu){
        CustomerDAO customer = new CustomerDAO();
        CustomerModel customerModel = new CustomerModel();
        //Kieemr tra duw lieu
        customerModel.setTenKhachHang(tenKhachHang);
        customerModel.setTenKhac(tenKhac);
        customerModel.setDiaChi(diaChi);
        customerModel.setDienThoai(dienThoai);
        customerModel.setMaSoThue(maSoThue);
        customerModel.setMaSoDongHo(maSoDongHo);
        customerModel.setMaBangGia(maBangGia);
        customerModel.setMaTram(maTram);
        customerModel.setTongChiSo(0);
        customerModel.setToaDoX1(0);
        customerModel.setToaDoX2(0);
        customerModel.setToaDoY1(0);
        customerModel.setToaDoY2(0);
        customerModel.setTrangThai(0);
        customerModel.setTongChiSo(tongChiSo);
        customerModel.setGhiChu(ghiChu);
        
        boolean result = customer.InsertCustomer(customerModel);
        return result;
    }
    
    public boolean UpdateCustomer(int maKH, String tenKhachHang, String tenKhac, String diaChi, String dienThoai, String maSoThue, int maSoDongHo, int maBangGia, int maTram,int tongChiSo, String ghiChu){
        CustomerDAO customer = new CustomerDAO();
        CustomerModel customerModel = new CustomerModel();
        //Kieemr tra duw lieu
        customerModel = customer.getCustomer(maKH);
        customerModel.setTenKhachHang(tenKhachHang);
        customerModel.setTenKhac(tenKhac);
        customerModel.setDiaChi(diaChi);
        customerModel.setDienThoai(dienThoai);
        customerModel.setMaSoThue(maSoThue);
        customerModel.setMaSoDongHo(maSoDongHo);
        customerModel.setMaBangGia(maBangGia);
        customerModel.setMaTram(maTram);
        customerModel.setTongChiSo(tongChiSo);
        customerModel.setGhiChu(ghiChu);
        boolean result = customer.UpdateCustomer(customerModel);
        return result;
    }
    
    public boolean DeleteCustomer(int maKhachHang){
        CustomerDAO customer = new CustomerDAO();
        boolean result = customer.DeleteCustomer(maKhachHang);
        return result;
    }
    
    public int getCostOfCustomer(int maKhachHang){
        CustomerDAO customer = new CustomerDAO();
        int cost = customer.getCostOfCustomer(maKhachHang);
        return cost;
    }

    public boolean UpdateCustomerStatus(int trangThai, int maKH){
        CustomerDAO customer = new CustomerDAO();
        boolean result = customer.UpdateCustomerStatus(trangThai, maKH);
        return result;
    }
    
    public boolean resetStatusCustomer(int status) {
        CustomerDAO customer = new CustomerDAO();
        boolean result = customer.resetStatusCustomer(status);
        return result;
    }
    public static void main(String[] args) {
        CustomerController cc = new CustomerController();
        cc.DeleteCustomer(7);
    }
}
