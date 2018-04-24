/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.Dao;

import com.datpt.waterrecord.DaoItf.IndicationInterface;
import com.datpt.waterrecord.connectDB.ConnectDB;
import com.datpt.waterrecord.model.IndicationModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public boolean insertIndication(IndicationModel indicationModel) {
        try {
            Connection connection = ConnectDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO soghi(MA_KH, MA_NV, CHI_SO, NGAY_GHI_SO, GHI_CHU) VALUES(?,?,?,?,?)");
            ps.setInt(1, indicationModel.getMaKhachHang());
            ps.setInt(2, indicationModel.getMaNhanVien());
            ps.setInt(3, indicationModel.getChiSo());
            ps.setDate(4, (Date) indicationModel.getNgayGhiSo());
            ps.setString(5, indicationModel.getGhiChu());
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
    public boolean updateIndication(IndicationModel indicationModel) {
         try {
            Connection connection = ConnectDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE soghi SET MA_NV=?, CHI_SO=?, NGAY_GHI_SO=?, GHI_CHU=? WHERE MA_KH=?");
            ps.setInt(1, indicationModel.getMaNhanVien());
            ps.setInt(2, indicationModel.getChiSo());
            ps.setDate(3, (Date) indicationModel.getNgayGhiSo());
            ps.setString(4, indicationModel.getGhiChu());
            ps.setInt(5, indicationModel.getMaKhachHang());
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
        } finally{
            ConnectDB.closeConnection();
        }
        return null;
    }

}
