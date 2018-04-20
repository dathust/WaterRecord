/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.Dao;

import com.datpt.waterrecord.DaoItf.AreaInterface;
import com.datpt.waterrecord.connectDB.ConnectDB;
import com.datpt.waterrecord.model.AreaModel;
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
public class AreaDAO implements AreaInterface{

    @Override
    public List<AreaModel> getAllArea() {
        List<AreaModel> listArea = new ArrayList<>();
        try {
            Connection connection = ConnectDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM tram");
            ResultSet rs =ps.executeQuery();
            while (rs.next()) {
                AreaModel areaModel = new AreaModel();
                areaModel.setMaTram(rs.getInt("MA_TRAM"));
                areaModel.setTenTram(rs.getString(2));
                areaModel.setDiaChi(rs.getString(3));
                areaModel.setTongKH(rs.getInt(4));
                listArea.add(areaModel);
            }
            return listArea;
        }catch(SQLException ex) {
            ex.printStackTrace();
        }finally {
            ConnectDB.closeConnection();
        }
        return null;
    }
    
//    public static void main(String[] args) {
//        AreaDAO areaDAO = new AreaDAO();
//        ArrayList<AreaModel> list = areaDAO.getAllArea();
//        for (int i=0; i<list.size(); i++){
//            System.out.println("Name: " + list.get(i).getDiaChi());
//        }
//    }
    
}
