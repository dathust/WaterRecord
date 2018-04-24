/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.controller;

import com.datpt.waterrecord.Dao.CustomerDAO;
import com.datpt.waterrecord.Dao.IndicationDAO;
import com.datpt.waterrecord.DaoItf.CustomerInterface;
import com.datpt.waterrecord.DaoItf.IndicationInterface;
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

    public static void main(String[] args) {
        CustomerController cc = new CustomerController();
        CustomerModel cus = cc.getCustomer(1);
        System.out.println("ust: " + cus.getTenKhachHang());
        System.out.println("cus: " + cus.getChiSoThangNay());
        System.out.println("cus: " + cus.getChiSoThangTruoc());
    }
}
