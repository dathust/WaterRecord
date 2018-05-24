/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.DAO.DaoImp;

import com.datpt.waterrecord.DAO.DaoItf.StaffInterface;
import com.datpt.waterrecord.connectDB.ConnectDB;
import com.datpt.waterrecord.model.AreaModel;
import com.datpt.waterrecord.model.StaffModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DatPT
 */
public class StaffDAO implements StaffInterface{

    @Override
    public List<StaffModel> getListStaff() {
        List<StaffModel> listStaff = new ArrayList<>();
        try {
            Connection connection = ConnectDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM nhanvien WHERE XOA=?");
            ps.setInt(1, 0);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StaffModel staffModel = new StaffModel();
                staffModel.setMaNhanVien(rs.getInt(1));
                staffModel.setTenNhanVien(rs.getString(2));
                staffModel.setSoDienThoai(rs.getString(3));
                staffModel.setDiaChi(rs.getString(4));
                staffModel.setTaiKhoan(rs.getString(5));
                staffModel.setMatKhau(rs.getString(6));
                
                listStaff.add(staffModel);
            }
            return listStaff;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectDB.closeConnection();
        }
        return null;
    }

    @Override
    public boolean InsertStaff(StaffModel staffModel) {
        try {
            Connection connection = ConnectDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO nhanvien(TEN_NV,SO_DIEN_THOAI,DIA_CHI,TAI_KHOAN,MAT_KHAU) VALUES(?,?,?,?,?)");
            ps.setString(1, staffModel.getTenNhanVien());
            ps.setString(2, staffModel.getSoDienThoai());
            ps.setString(3, staffModel.getDiaChi());
            ps.setString(4, staffModel.getTaiKhoan());
            ps.setString(5, staffModel.getMatKhau());
            int result = ps.executeUpdate();
            
            return result==1;
        }catch(SQLException ex) {
            ex.printStackTrace();
        }finally {
            ConnectDB.closeConnection();
        }
        return false;
    }
    
    public StaffModel CheckLogin(String taiKhoan, String matKhau){
        try {
            Connection connection = ConnectDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM nhanvien WHERE TAI_KHOAN=? AND MAT_KHAU=?");
            ps.setString(1, taiKhoan);
            ps.setString(2, matKhau);
            ResultSet rs = ps.executeQuery();
            StaffModel staffModel = null;
            while (rs.next()){
                staffModel = new StaffModel();
                staffModel.setMaNhanVien(rs.getInt(1));
                staffModel.setTenNhanVien(rs.getString(2));
                staffModel.setSoDienThoai(rs.getString(3));
                staffModel.setDiaChi(rs.getString(4));
                staffModel.setTaiKhoan(rs.getString(5));
                staffModel.setMatKhau(rs.getString(6));
            }
           return staffModel;
        } catch (Exception e) {
        } finally {
            ConnectDB.closeConnection();
        }
        return null;
    }

    @Override
    public List<StaffModel> getListStaffID(int maNhanVien) {
        return null;
    }
    
}
