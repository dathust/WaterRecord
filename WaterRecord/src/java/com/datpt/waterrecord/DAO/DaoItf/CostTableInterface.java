/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.DAO.DaoItf;

import com.datpt.waterrecord.model.CostTableModel;
import java.util.List;

/**
 *
 * @author DatPT
 */
public interface CostTableInterface {
    public List<CostTableModel> getList();
}
