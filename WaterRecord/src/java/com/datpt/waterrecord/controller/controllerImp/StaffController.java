/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.controller.controllerImp;

import com.datpt.waterrecord.DAO.DaoImp.StaffDAO;
import com.datpt.waterrecord.model.IndicationModel;
import com.datpt.waterrecord.model.StaffModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DatPT
 */
public class StaffController {
    
    public List<StaffModel> getListStaff(){
        List<StaffModel> list = new ArrayList<>();
        StaffDAO staff = new StaffDAO();
        list = staff.getListStaff();
        return list;
    }

    public boolean InsertStaffController(String tenNV, String soDienThoai, String diaChi, String taiKhoan, String matKhau) {
        if ((tenNV.equals("")) || (soDienThoai.equals("")) || (diaChi.equals("")) || (taiKhoan.equals("")) || (matKhau.equals(""))) {
            return false;
        } else {
            StaffDAO staffDAO = new StaffDAO();
            StaffModel staffModel = new StaffModel();
            staffModel.setTenNhanVien(tenNV);
            staffModel.setSoDienThoai(soDienThoai);
            staffModel.setDiaChi(diaChi);
            staffModel.setTaiKhoan(taiKhoan);
            staffModel.setMatKhau(matKhau);

            boolean result = staffDAO.InsertStaff(staffModel);
            if (result) {
                return true;
            } else {
                return false;
            }
        }

    }

    public StaffModel CheckLogin(String taiKhoan, String matKhau) {
        if ("".equals(taiKhoan) || "".equals(matKhau)) {
            return null;
        } else {
            StaffDAO staffDAO = new StaffDAO();
            StaffModel staffModel = staffDAO.CheckLogin(taiKhoan, matKhau);
            return staffModel;
        }
    }

    public static void main(String[] args) {
        StaffController sc = new StaffController();
//       String r = sc.InsertStaffController("Nguyen Van Huy", "0985123587", "Doi 1 - Vo Luong", "huynv", "huynv");
        StaffModel c = sc.CheckLogin("datpt", "datpt");
        System.out.println("c:" + c);

    }
}
