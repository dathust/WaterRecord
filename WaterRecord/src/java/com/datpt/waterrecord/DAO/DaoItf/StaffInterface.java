/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.DAO.DaoItf;

import com.datpt.waterrecord.model.StaffModel;
import java.util.List;

/**
 *
 * @author DatPT
 */
public interface StaffInterface {
    public List<StaffModel> getListStaff();
    public List<StaffModel> getListStaffID(int maNhanVien);
    public boolean InsertStaff(StaffModel staffModel);
}
