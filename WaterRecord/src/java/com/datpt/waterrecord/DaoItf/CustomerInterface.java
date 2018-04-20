/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.DaoItf;

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
}
