/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.DAO.DaoItf;

import com.datpt.waterrecord.model.CustomerModel;
import java.util.List;

/**
 *
 * @author HuyGL
 */
public interface CustomerInterface {
    public List<CustomerModel> getListCustomerArea(int maTram);
    public List<CustomerModel> getListCustomer();
    public CustomerModel getCustomer(int maKhachHang);
    public boolean UpdateCustomerStatus(int trangThai, int maKhachHang);
    public boolean UpdateCustomer(CustomerModel customerModel);
    public boolean InsertCustomer(CustomerModel customerModel);
    public boolean DeleteCustomer(int maKhachHang);
    public int getCostOfCustomer(int maKhachHang);
    public boolean resetStatusCustomer(int status);
}
