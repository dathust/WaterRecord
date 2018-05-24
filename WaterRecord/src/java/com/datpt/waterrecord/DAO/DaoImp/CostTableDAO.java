/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.DAO.DaoImp;

import com.datpt.waterrecord.DAO.DaoItf.CostTableInterface;
import com.datpt.waterrecord.connectDB.ConnectDB;
import com.datpt.waterrecord.model.CostTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DatPT
 */
public class CostTableDAO implements CostTableInterface{

    @Override
    public List<CostTableModel> getList() {
        List<CostTableModel> list = new ArrayList<>();
        try {
            Connection connection = ConnectDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM banggia");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CostTableModel costTableModel = new CostTableModel();
                costTableModel.setMaBangGia(rs.getInt(1));
                costTableModel.setTenBangGia(rs.getString(2));
                costTableModel.setTenVietTat(rs.getString(3));
                costTableModel.setDonGia(rs.getInt(4));
                costTableModel.setThueVAT(rs.getInt(5));
                list.add(costTableModel);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            ConnectDB.closeConnection();
        }
        return null;
    }
    
}
