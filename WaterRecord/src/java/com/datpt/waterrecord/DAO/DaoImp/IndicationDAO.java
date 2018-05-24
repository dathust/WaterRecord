/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.DAO.DaoImp;

import com.datpt.waterrecord.DAO.DaoItf.IndicationInterface;
import com.datpt.waterrecord.connectDB.ConnectDB;
import com.datpt.waterrecord.model.IndicationModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DatPT
 */
public class IndicationDAO implements IndicationInterface {

    @Override
    public int insertIndication(IndicationModel indicationModel) {
        int idLast = 0;
        try {
            Connection connection = ConnectDB.getConnection();
            String sql = "INSERT INTO soghi(MA_KH, MA_NV, CHI_SO, NGAY_GHI_SO, GHI_CHU) VALUES(?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, indicationModel.getMaKhachHang());
            ps.setInt(2, indicationModel.getMaNhanVien());
            ps.setInt(3, indicationModel.getChiSo());
            ps.setDate(4, (Date) indicationModel.getNgayGhiSo());
            ps.setString(5, indicationModel.getGhiChu());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                idLast = rs.getInt(1);
            }

            return idLast;
        } catch (SQLException ex) {
            Logger.getLogger(IndicationDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            ConnectDB.closeConnection();
        }
        return idLast;

    }

    @Override
    public boolean updateIndication(IndicationModel indicationModel) {
        try {
            Connection connection = ConnectDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE soghi SET MA_NV=?, CHI_SO=?, NGAY_GHI_SO=?, GHI_CHU=? WHERE MA_SG=?");
            ps.setInt(1, indicationModel.getMaNhanVien());
            ps.setInt(2, indicationModel.getChiSo());
            ps.setDate(3, (Date) indicationModel.getNgayGhiSo());
            ps.setString(4, indicationModel.getGhiChu());
            ps.setInt(5, indicationModel.getMaSoGhi());
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
    public boolean deleteIndication(int maSoGhi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IndicationModel> getIndicationCustomer(int maKhachHang) {
        List<IndicationModel> listIndication = new ArrayList<>();
        try {
            Connection connection = ConnectDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM soghi WHERE MA_KH=?");
            ps.setInt(1, maKhachHang);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                IndicationModel indicationModel = new IndicationModel();
                indicationModel.setMaSoGhi(rs.getInt(1));
                indicationModel.setMaKhachHang(rs.getInt(2));
                indicationModel.setMaNhanVien(rs.getInt(3));
                indicationModel.setChiSo(rs.getInt(4));
                indicationModel.setNgayGhiSo(rs.getDate(5));
                indicationModel.setGhiChu(rs.getString(6));
                listIndication.add(indicationModel);
            }
            return listIndication;
        } catch (SQLException ex) {
            Logger.getLogger(IndicationDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectDB.closeConnection();
        }
        return null;
    }

    @Override
    public IndicationModel getIndication(int maSoGhi) {
        IndicationModel indicationModel = new IndicationModel();
        try {
            Connection connection = ConnectDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM soghi WHERE MA_SG=?");
            ps.setInt(1, maSoGhi);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                indicationModel.setMaSoGhi(rs.getInt(1));
                indicationModel.setMaKhachHang(rs.getInt(2));
                indicationModel.setMaNhanVien(rs.getInt(3));
                indicationModel.setChiSo(rs.getInt(4));
                indicationModel.setNgayGhiSo(rs.getDate(5));
                indicationModel.setGhiChu(rs.getString(6));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectDB.closeConnection();
        }
        return indicationModel;
    }

    @Override
    public List<Integer> getMonth() {
        List<Integer> listMonth = new ArrayList<>();
        try {
            Connection connection = ConnectDB.getConnection();
            String sql = "SELECT DISTINCT MONTH(NGAY_GHI_SO) AS Month FROM soghi ORDER BY Month DESC";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int month = rs.getInt("Month");
                listMonth.add(month);
            }
            return listMonth;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectDB.closeConnection();
        }
        return null;
    }

    @Override
    public List<Integer> getYear() {
        List<Integer> listYear = new ArrayList<>();
        try {
            Connection connection = ConnectDB.getConnection();
            String sql = "SELECT DISTINCT YEAR(NGAY_GHI_SO) AS Year FROM soghi ORDER BY Year DESC";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int year = rs.getInt("Year");
                listYear.add(year);
            }
            return listYear;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectDB.closeConnection();
        }
        return null;
    }

    @Override
    public int getIndicationLastMonth(int maKH, int month, int year) {
        int indicationLastMonth = 0;
        try {
            Connection connection = ConnectDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT CHI_SO FROM soghi WHERE MA_KH = ? AND MONTH(NGAY_GHI_SO) = ? AND YEAR(NGAY_GHI_SO) = ?");
            ps.setInt(1, maKH);
            ps.setInt(2, month);
            ps.setInt(3, year);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                indicationLastMonth = rs.getInt("CHI_SO");
                return indicationLastMonth;
            }
        } catch (Exception e) {
        }
        return indicationLastMonth;
    }

}
