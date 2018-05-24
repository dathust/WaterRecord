/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.DAO.DaoItf;

import com.datpt.waterrecord.model.AreaModel;
import java.util.List;

/**
 *
 * @author DatPT
 */
public interface AreaInterface {
    public List<AreaModel> getAllArea();
    public AreaModel getArea(int maTram);
    public boolean InsertArea(AreaModel areaModel);
    public boolean UpdateArea(AreaModel areaModel);
    public boolean DeleteArea(int maTram);
}
