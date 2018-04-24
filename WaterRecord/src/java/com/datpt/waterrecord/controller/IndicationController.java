/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.controller;

import com.datpt.waterrecord.Dao.CustomerDAO;
import com.datpt.waterrecord.Dao.IndicationDAO;
import com.datpt.waterrecord.model.IndicationModel;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author DatPT
 */
public class IndicationController {

    public boolean InsertIndication(int maKH, int maNV, int chiSo, Date ngayGhiSo, String ghiChu) {
        if (maKH == 0 || maNV == 0 || chiSo == 0) {
            return false;
        } else {
            long millis = System.currentTimeMillis();
            ngayGhiSo = new Date(millis);
            IndicationDAO indicationDAO = new IndicationDAO();
            IndicationModel indicationModel = new IndicationModel();
            indicationModel.setMaKhachHang(maKH);
            indicationModel.setMaNhanVien(maNV);
            indicationModel.setChiSo(chiSo);
            indicationModel.setNgayGhiSo(ngayGhiSo);
            indicationModel.setGhiChu(ghiChu);
            boolean result = indicationDAO.insertIndication(indicationModel);
            if (result){
                CustomerDAO customer = new CustomerDAO();
                customer.UpdateCustomerStatus(1,maKH);                
            }
            return result;
        }
    }
    
    

    public boolean UpdateIndication(int maKH, int maNV, int chiSo, Date ngayGhiSo, String ghiChu) {
        if (maKH == 0 || maNV == 0 || chiSo == 0) {
            return false;
        } else {
            long millis = System.currentTimeMillis();
            ngayGhiSo = new Date(millis);
            IndicationDAO indicationDAO = new IndicationDAO();
            IndicationModel indicationModel = new IndicationModel();
            indicationModel.setMaKhachHang(maKH);
            indicationModel.setMaNhanVien(maNV);
            indicationModel.setChiSo(chiSo);
            indicationModel.setNgayGhiSo(ngayGhiSo);
            indicationModel.setGhiChu(ghiChu);
            boolean result = indicationDAO.updateIndication(indicationModel);
            return result;
        }
    }
    
    public List<IndicationModel> getIndicationModelCustomer(int maKhachHang){
        IndicationDAO indicationDAO = new IndicationDAO();
        List<IndicationModel> list = indicationDAO.getIndicationCustomer(maKhachHang);
        return list;
    }

    public static void main(String[] args) {
        IndicationController controller = new IndicationController();
        List<IndicationModel> list = controller.getIndicationModelCustomer(1);
        int month = list.get(1).getNgayGhiSo().getMonth();
        int year = list.get(1).getNgayGhiSo().getYear()+1900;
        System.out.println("result: " + year);
//        CustomerDAO customer = new CustomerDAO();
//        Date date = new Date(2018-04-20);
//        boolean c = controller.InsertIndication(6,3,4, date, "");
//        if (c){
//            customer.UpdateCustomerStatus(1,4);
//        } else {
//            System.out.println("error");
//        }
//        System.out.println("Check: " + c);
//
//        long millis = System.currentTimeMillis();
//        Date date1 = new Date(millis);
//
//        SimpleDateFormat timeFormat = new SimpleDateFormat("dd/MM/yyyy");
//        System.out.println("date: " + timeFormat.format(date1));

    }
}
