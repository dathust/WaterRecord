/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.DaoItf;

import com.datpt.waterrecord.model.IndicationModel;
import java.util.List;

/**
 *
 * @author DatPT
 */
public interface IndicationInterface {
    public boolean insertIndication(IndicationModel indicationModel);
    public boolean updateIndication (IndicationModel indicationModel);
    public boolean deleteIndication(int maSoGhi);
    public List<IndicationModel> getIndicationCustomer(int maKhachHang);
    
}
