/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.servletweb;

import com.datpt.waterrecord.controller.controllerImp.AreaController;
import com.datpt.waterrecord.controller.controllerImp.CustomerController;
import com.datpt.waterrecord.controller.controllerImp.IndicationController;
import com.datpt.waterrecord.controller.controllerImp.StaffController;
import com.datpt.waterrecord.model.AreaModel;
import com.datpt.waterrecord.model.CustomerModel;
import com.datpt.waterrecord.model.IndicationModel;
import com.datpt.waterrecord.model.StaffModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DatPT
 */
@WebServlet(name = "IndicationServletWeb", urlPatterns = {"/IndicationServletWeb"})
public class IndicationServletWeb extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String url = "";
        AreaController area = new AreaController();
        CustomerController customer = new CustomerController();
        IndicationController indication = new IndicationController();
        StaffController staff = new StaffController();
        List<AreaModel> listArea = new ArrayList<>();
        List<CustomerModel> listCustomer = new ArrayList<>();
        List<IndicationModel> listIndication = new ArrayList<>();
        List<StaffModel> listStaff = new ArrayList<>();
        CustomerModel customerModel = new CustomerModel();
        int maTram, maKhachHang;
        String stMaTram = request.getParameter("maTram");
        String stMaKH = request.getParameter("maKhachHang");
        String button = request.getParameter("command");
        if (stMaTram == null) {
            maTram = 1;
        } else {
            maTram = Integer.parseInt(stMaTram);
        }
        if (stMaKH == null) {
            maKhachHang = 1;
        } else {
            maKhachHang = Integer.parseInt(stMaKH);
        }
        if (button.equals("selectArea")) {
            System.out.println("button " + button);
            url = "viewchild/getcustomerindication.jsp";
            stMaTram = request.getParameter("maTram");
            maTram = Integer.parseInt(stMaTram);
            listCustomer = customer.getListCustomerArea(maTram);
            listIndication = indication.getIndicationModelCustomer(listCustomer.get(0).getMaKhachHang());
            
            request.setAttribute("LIST", listIndication);
            request.setAttribute("MAKH", maKhachHang);
            request.setAttribute("LISTCUSTOMER", listCustomer);
            request.setAttribute("MATRAM", maTram);
            
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
        if (button.equals("selectCustomer")){
            url = "viewchild/tableindication.jsp";
            stMaKH = request.getParameter("maKhachHang");
            maKhachHang = Integer.parseInt(stMaKH);
            listIndication = indication.getIndicationModelCustomer(maKhachHang);
            listStaff = staff.getListStaff();
            customerModel = customer.getCustomer(maKhachHang);
            request.setAttribute("LIST", listIndication);
            request.setAttribute("LISTSTAFF", listStaff);
            request.setAttribute("MAKH", maKhachHang);
            request.setAttribute("TENKH", customerModel.getTenKhachHang());
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
        if (button.equals("first")) {
            System.out.println("button " + button);
            url = "indication.jsp";
            listArea = area.getAllArea();
            listCustomer = customer.getListCustomerArea(maTram);
            listIndication = indication.getIndicationModelCustomer(maKhachHang);
            request.setAttribute("LIST", listIndication);
            request.setAttribute("LISTAREA", listArea);
            request.setAttribute("LISTCUSTOMER", listCustomer);
            request.setAttribute("MATRAM", maTram);
            request.setAttribute("MAKH", maKhachHang);
            request.setAttribute("TAB", 5);
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
