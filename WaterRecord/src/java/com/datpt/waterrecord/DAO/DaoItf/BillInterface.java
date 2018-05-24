/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.DAO.DaoItf;

import com.datpt.waterrecord.model.BillModel;
import java.util.List;

/**
 *
 * @author DatPT
 */
public interface BillInterface {
    public BillModel getBill(int maHoaDon);
    public List<BillModel> getAllListBill();
    public List<BillModel> getAllListBillAreaAndMonth(int maTram, int thang, int nam);
    public List<BillModel> getAllListCustomerAreaAndMonthYearForBill(int maTram, int thang, int nam);
    public List<BillModel> getListBillCustomer(int maKhachHang);
    public boolean InsertBill(BillModel billModel);
    public boolean UpdateBill(BillModel billModel);
}
