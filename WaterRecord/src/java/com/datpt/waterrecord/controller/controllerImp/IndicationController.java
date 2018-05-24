/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.controller.controllerImp;

import com.datpt.waterrecord.DAO.DaoImp.CustomerDAO;
import com.datpt.waterrecord.DAO.DaoImp.IndicationDAO;
import com.datpt.waterrecord.model.IndicationModel;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DatPT
 */
public class IndicationController {

    public IndicationModel getIndication(int maSoGhi) {
        IndicationModel indicationModel = new IndicationModel();
        IndicationDAO indicationDAO = new IndicationDAO();
        indicationModel = indicationDAO.getIndication(maSoGhi);
        return indicationModel;
    }

    public int InsertIndication(int maKH, int maNV, int chiSo, Date ngayGhiSo, String ghiChu) {
        if (maKH == 0 || maNV == 0 || chiSo == 0) {
            return 0;
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
            int result = indicationDAO.insertIndication(indicationModel);
            if (result !=0) {
                //update status customer
                CustomerController customer = new CustomerController();
                customer.UpdateCustomerStatus(1, maKH);                                
            }
            return result;
        }
    }

    public boolean UpdateIndication(int maSG, int maKH, int maNV, int chiSo, Date ngayGhiSo, String ghiChu) {
        if (maKH == 0 || maNV == 0 || chiSo == 0) {
            return false;
        } else {           
            long millis = System.currentTimeMillis();
            ngayGhiSo = new Date(millis);
            IndicationDAO indicationDAO = new IndicationDAO();
            IndicationModel indicationModel = new IndicationModel();
            indicationModel = indicationDAO.getIndication(maSG);
            indicationModel.setMaKhachHang(maKH);
            indicationModel.setMaNhanVien(maNV);
            indicationModel.setChiSo(chiSo);
            indicationModel.setNgayGhiSo(ngayGhiSo);
            indicationModel.setGhiChu(ghiChu);
            boolean result = indicationDAO.updateIndication(indicationModel);
            return result;
        }
    }

    public List<IndicationModel> getIndicationModelCustomer(int maKhachHang) {
        IndicationDAO indicationDAO = new IndicationDAO();
        List<IndicationModel> list = indicationDAO.getIndicationCustomer(maKhachHang);
        return list;
    }
    
    public List<Integer> getMonth(){
        IndicationDAO indicationDAO = new IndicationDAO();
        List<Integer> listMonth = new ArrayList<>();
        listMonth = indicationDAO.getMonth();
        return listMonth;
    }
    
     public List<Integer> getYear(){
        IndicationDAO indicationDAO = new IndicationDAO();
        List<Integer> listYear = new ArrayList<>();
        listYear = indicationDAO.getYear();
        return listYear;
    }

      public int getIndicationLastMonth(int maKH, int month, int year) {
          IndicationDAO indicationDAO = new IndicationDAO();
          int indicationLastMonth = indicationDAO.getIndicationLastMonth(maKH, month, year);
          return indicationLastMonth;
      }
    public static void main(String[] args) {
    
            IndicationController controller = new IndicationController();
            System.out.println("idi: " + controller.getIndicationLastMonth(1, 4, 2018));
            
       

    }
}
