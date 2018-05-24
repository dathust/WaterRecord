/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.DAO.DaoImp;

import com.datpt.waterrecord.DAO.DaoItf.AreaInterface;
import com.datpt.waterrecord.connectDB.ConnectDB;
import com.datpt.waterrecord.model.AreaModel;
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
 * @author DatPT
 */
public class AreaDAO implements AreaInterface {

    @Override
    public AreaModel getArea(int maTram) {
        AreaModel areaModel = new AreaModel();
        try {
            Connection connection = ConnectDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM tram WHERE MA_TRAM=?");
            ps.setInt(1, maTram);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                areaModel.setMaTram(rs.getInt("MA_TRAM"));
                areaModel.setTenTram(rs.getString(2));
                areaModel.setDiaChi(rs.getString(3));
                areaModel.setTongKH(rs.getInt(4));            
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectDB.closeConnection();
        }
        return areaModel;
    }

    @Override
    public List<AreaModel> getAllArea() {
        List<AreaModel> listArea = new ArrayList<>();
        try {
            Connection connection = ConnectDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM tram WHERE XOA=?");
            ps.setInt(1, 0);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AreaModel areaModel = new AreaModel();
                areaModel.setMaTram(rs.getInt("MA_TRAM"));
                areaModel.setTenTram(rs.getString(2));
                areaModel.setDiaChi(rs.getString(3));
                areaModel.setTongKH(rs.getInt(4));
                listArea.add(areaModel);
            }
            return listArea;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectDB.closeConnection();
        }
        return null;
    }

    @Override
    public boolean InsertArea(AreaModel areaModel) {
        try {
            Connection connection = ConnectDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO tram(TEN_TRAM,DIA_CHI) VALUES(?,?)");
            ps.setString(1, areaModel.getTenTram());
            ps.setString(2, areaModel.getDiaChi());
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
    public boolean UpdateArea(AreaModel areaModel) {
        try {
            Connection connection = ConnectDB.getConnection();
            String sql = "UPDATE `tram` SET `TEN_TRAM` = ?, `DIA_CHI` = ? WHERE `tram`.`MA_TRAM` = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, areaModel.getTenTram());
            ps.setString(2, areaModel.getDiaChi());
            ps.setInt(3, areaModel.getMaTram());
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
    public boolean DeleteArea(int maTram) {
        try {
            Connection connection = ConnectDB.getConnection();
            String sql = "UPDATE tram SET XOA=? WHERE MA_TRAM=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setInt(2, maTram);
            int result = ps.executeUpdate();
            return result == 1;
        } catch (Exception ex) {
            Logger.getLogger(IndicationDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectDB.closeConnection();
        }
        return false;
    }

}
