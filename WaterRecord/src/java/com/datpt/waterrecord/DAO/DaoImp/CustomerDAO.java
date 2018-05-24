/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.DAO.DaoImp;

import com.datpt.waterrecord.DAO.DaoItf.CustomerInterface;
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
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM khachhang WHERE MA_TRAM=? AND XOA=0");
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
                customerModel.setToaDoX1(rs.getFloat(11));
                customerModel.setToaDoX2(rs.getFloat(12));
                customerModel.setToaDoY1(rs.getFloat(13));
                customerModel.setToaDoY2(rs.getFloat(14));
                customerModel.setTrangThai(rs.getInt(15));
                customerModel.setGhiChu(rs.getString(16));
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
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM khachhang WHERE XOA=0");
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
                customerModel.setToaDoX1(rs.getFloat(11));
                customerModel.setToaDoX2(rs.getFloat(12));
                customerModel.setToaDoY1(rs.getFloat(13));
                customerModel.setToaDoY2(rs.getFloat(14));
                customerModel.setTrangThai(rs.getInt(15));
                customerModel.setGhiChu(rs.getString(16));
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
                customerModel.setToaDoX1(rs.getFloat(11));
                customerModel.setToaDoX2(rs.getFloat(12));
                customerModel.setToaDoY1(rs.getFloat(13));
                customerModel.setToaDoY2(rs.getFloat(14));
                customerModel.setTrangThai(rs.getInt(15));
                customerModel.setGhiChu(rs.getString(16));

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

    @Override
    public boolean InsertCustomer(CustomerModel customerModel) {
        try {
            Connection connection = ConnectDB.getConnection();
            String sql = "INSERT INTO `khachhang` (`TEN_KH`, `TEN_KHAC`, `DIA_CHI`, `DIEN_THOAI`, `MA_SO_THUE`, `MA_SO_DONG_HO`, `MA_BG`, `MA_TRAM`, `TONG_SO`, `TOA_DO_X1`, `TOA_DO_X2`, `TOA_DO_Y1`, `TOA_DO_Y2`, `TRANG_THAI`, `GHI_CHU`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, customerModel.getTenKhachHang());
            ps.setString(2, customerModel.getTenKhac());
            ps.setString(3, customerModel.getDiaChi());
            ps.setString(4, customerModel.getDienThoai());
            ps.setString(5, customerModel.getMaSoThue());
            ps.setInt(6, customerModel.getMaSoDongHo());
            ps.setInt(7, customerModel.getMaBangGia());
            ps.setInt(8, customerModel.getMaTram());
            ps.setInt(9, customerModel.getTongChiSo());
            ps.setDouble(10, customerModel.getToaDoX1());
            ps.setDouble(11, customerModel.getToaDoX2());
            ps.setDouble(12, customerModel.getToaDoY1());
            ps.setDouble(13, customerModel.getToaDoY2());
            ps.setInt(14, customerModel.getTrangThai());
            ps.setString(15, customerModel.getGhiChu());

            int result = ps.executeUpdate();

            return result == 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectDB.closeConnection();
        }
        return false;
    }

    @Override
    public boolean UpdateCustomer(CustomerModel customerModel) {
        try {
            Connection connection = ConnectDB.getConnection();
            String sql = "UPDATE `khachhang` SET `TEN_KH` = ?, `TEN_KHAC` = ?, `DIA_CHI` = ?, `DIEN_THOAI` = ?, `MA_SO_THUE` = ?, `MA_SO_DONG_HO` = ?, `MA_BG` = ?, `MA_TRAM` = ?, `TONG_SO` = ?, `GHI_CHU` = ? WHERE `khachhang`.`MA_KH` = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, customerModel.getTenKhachHang());
            ps.setString(2, customerModel.getTenKhac());
            ps.setString(3, customerModel.getDiaChi());
            ps.setString(4, customerModel.getDienThoai());
            ps.setString(5, customerModel.getMaSoThue());
            ps.setInt(6, customerModel.getMaSoDongHo());
            ps.setInt(7, customerModel.getMaBangGia());
            ps.setInt(8, customerModel.getMaTram());
            ps.setInt(9, customerModel.getTongChiSo());
            ps.setString(10, customerModel.getGhiChu());
            ps.setInt(11, customerModel.getMaKhachHang());
            int result = ps.executeUpdate();
            return result == 1;
        } catch (SQLException ex) {
            Logger.getLogger(IndicationDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            ConnectDB.closeConnection();
        }
        return false;
    }

    @Override
    public boolean DeleteCustomer(int maKhachHang) {
        try {
            Connection connection = ConnectDB.getConnection();
            String sql = "UPDATE khachhang SET XOA=? WHERE MA_KH=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setInt(2, maKhachHang);
            int result = ps.executeUpdate();
            return result == 1;
        } catch (Exception ex) {
            Logger.getLogger(IndicationDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectDB.closeConnection();
        }
        return false;

    }

    @Override
    public int getCostOfCustomer(int maKhachHang) {
        int costOfCustomer = 0, donGia = 0;
        float thueVAT = 0;
        try {
            Connection connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM khachhang INNER JOIN banggia ON khachhang.MA_BG = banggia.MA_BG WHERE khachhang.MA_KH=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, maKhachHang);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                donGia = rs.getInt("DON_GIA");
                thueVAT = rs.getFloat("THUE_VAT");
            }
            costOfCustomer = (int) (donGia + donGia * thueVAT);
            return costOfCustomer;
        } catch (Exception e) {
        }
        return costOfCustomer;
    }

    @Override
    public boolean resetStatusCustomer(int status) {
        try {
            Connection connection = ConnectDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE khachhang SET TRANG_THAI=?");
            ps.setInt(1, status);
            int result = ps.executeUpdate();
            return result == 1;
        } catch (Exception e) {
        }
        return false;
    }
}
