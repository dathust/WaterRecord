/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.Dao;

import com.datpt.waterrecord.DaoItf.CustomerInterface;
import com.datpt.waterrecord.connectDB.ConnectDB;
import com.datpt.waterrecord.model.AreaModel;
import com.datpt.waterrecord.model.CustomerModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HuyGL
 */
public class CustomerDAO implements CustomerInterface {

    @Override
    public List<CustomerModel> getListCustomerArea(int maTram) {
        List<CustomerModel> listCustomer = new ArrayList<>();
        try {
            Connection connection = ConnectDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM khachhang WHERE MA_TRAM=?");
            ps.setInt(1, maTram);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CustomerModel customerModel = new CustomerModel();
                customerModel.setMaKhachHang(rs.getInt(1));
                customerModel.setTenKhachHang(rs.getString(2));
                customerModel.setTenKhac(rs.getString(3));
                customerModel.setDiaChi(rs.getString(4));
                customerModel.setDienThoai(rs.getString(5));
                customerModel.setMaSoThue(rs.getString(6));
                customerModel.setMaSoDongHo(rs.getInt(7));
                customerModel.setMaBangGia(rs.getInt(8));
                customerModel.setMaTram(rs.getInt(9));
                customerModel.setTongChiSo(rs.getInt(10));
                customerModel.setToaDoX(rs.getFloat(11));
                customerModel.setToaDoY(rs.getFloat(12));
                customerModel.setTrangThai(rs.getInt(13));
                customerModel.setGhiChu(rs.getString(14));
                listCustomer.add(customerModel);
            }
            return listCustomer;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectDB.closeConnection();
        }
        return null;
    }

    @Override
    public List<CustomerModel> getListCustomer() {
        List<CustomerModel> listCustomer = new ArrayList<>();
        try {
            Connection connection = ConnectDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM khachhang");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CustomerModel customerModel = new CustomerModel();
                customerModel.setMaKhachHang(rs.getInt(1));
                customerModel.setTenKhachHang(rs.getString(2));
                customerModel.setTenKhac(rs.getString(3));
                customerModel.setDiaChi(rs.getString(4));
                customerModel.setDienThoai(rs.getString(5));
                customerModel.setMaSoThue(rs.getString(6));
                customerModel.setMaSoDongHo(rs.getInt(7));
                customerModel.setMaBangGia(rs.getInt(8));
                customerModel.setMaTram(rs.getInt(9));
                customerModel.setTongChiSo(rs.getInt(10));
                customerModel.setToaDoX(rs.getFloat(11));
                customerModel.setToaDoY(rs.getFloat(12));
                customerModel.setTrangThai(rs.getInt(13));
                customerModel.setGhiChu(rs.getString(14));
                listCustomer.add(customerModel);
            }
            return listCustomer;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectDB.closeConnection();
        }
        return null;
    }

    @Override
    public CustomerModel getCustomer(int maKhachHang) {

        CustomerModel customerModel = new CustomerModel();
        try {
            Connection connection = ConnectDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM khachhang WHERE MA_KH=?");
            ps.setInt(1, maKhachHang);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                customerModel.setMaKhachHang(rs.getInt(1));
                customerModel.setTenKhachHang(rs.getString(2));
                customerModel.setTenKhac(rs.getString(3));
                customerModel.setDiaChi(rs.getString(4));
                customerModel.setDienThoai(rs.getString(5));
                customerModel.setMaSoThue(rs.getString(6));
                customerModel.setMaSoDongHo(rs.getInt(7));
                customerModel.setMaBangGia(rs.getInt(8));
                customerModel.setMaTram(rs.getInt(9));
                customerModel.setTongChiSo(rs.getInt(10));
                customerModel.setToaDoX(rs.getFloat(11));
                customerModel.setToaDoY(rs.getFloat(12));
                customerModel.setTrangThai(rs.getInt(13));
                customerModel.setGhiChu(rs.getString(14));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectDB.closeConnection();
        }
        return customerModel;
    }

    @Override
    public boolean UpdateCustomerStatus(int trangThai, int maKhachHang) {
        try {
            Connection connection = ConnectDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE khachhang SET TRANG_THAI=? WHERE MA_KH=?");
            ps.setInt(1, trangThai);
            ps.setInt(2, maKhachHang);
        int result = ps.executeUpdate();
            return result == 1;
        } catch (SQLException ex) {
            Logger.getLogger(IndicationDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            ConnectDB.closeConnection();
        }
        return false;
        
    }
}
