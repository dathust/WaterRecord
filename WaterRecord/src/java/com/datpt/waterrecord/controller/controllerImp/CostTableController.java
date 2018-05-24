/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.controller.controllerImp;

import com.datpt.waterrecord.DAO.DaoImp.CostTableDAO;
import com.datpt.waterrecord.model.CostTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DatPT
 */
public class CostTableController {
    
    public List<CostTableModel> getList(){
        List<CostTableModel> list = new ArrayList<>();
        CostTableDAO costTable = new CostTableDAO();
        list = costTable.getList();
        return list;
    }
    public static void main(String[] args) {
        CostTableController c = new CostTableController();
        List<CostTableModel> list = new ArrayList<>();
        list = c.getList();
        for (int i = 0; i < list.size(); i++){
            System.out.println("List: " + list.get(i).getTenBangGia());
        }
    }
}
