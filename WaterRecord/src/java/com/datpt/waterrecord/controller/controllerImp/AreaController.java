/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.controller.controllerImp;

import com.datpt.waterrecord.DAO.DaoImp.AreaDAO;
import com.datpt.waterrecord.DAO.DaoItf.AreaInterface;
import com.datpt.waterrecord.model.AreaModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DatPT
 */
public class AreaController {
    
    AreaInterface area = new AreaDAO();
    
    public List<AreaModel> getAllArea(){
        List<AreaModel> listArea = new ArrayList<>();
        
        listArea = area.getAllArea();
        return listArea;
    }
    
    public boolean InsertArea(String tenTram, String diaChi){
        AreaModel areaModel = new AreaModel();
        //Kiểm tra dữ liệu tenTram và diaChi
        areaModel.setTenTram(tenTram);
        areaModel.setDiaChi(diaChi);
        boolean result = area.InsertArea(areaModel);
        return result;
    }
    
    public boolean UpdateArea(int maTram, String tenTram, String diaChi){
         AreaModel areaModel = new AreaModel();
         //kiểm tra dữ liệu nhập vào
         areaModel = area.getArea(maTram);
         areaModel.setTenTram(tenTram);
         areaModel.setDiaChi(diaChi);
         boolean result = area.UpdateArea(areaModel);
         return result;
    }
    
    public boolean DeleteArea(int maTram){
        boolean result = area.DeleteArea(maTram);
        return result;
    }
}
