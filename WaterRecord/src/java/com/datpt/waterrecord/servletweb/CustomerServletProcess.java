/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.servletweb;

import com.datpt.waterrecord.controller.controllerImp.AreaController;
import com.datpt.waterrecord.controller.controllerImp.CostTableController;
import com.datpt.waterrecord.controller.controllerImp.CustomerController;
import com.datpt.waterrecord.model.AreaModel;
import com.datpt.waterrecord.model.CostTableModel;
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
@WebServlet(name = "CustomerServletProcess", urlPatterns = {"/CustomerServletProcess"})
public class CustomerServletProcess extends HttpServlet {

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

        String url = "";
        CustomerController customer = new CustomerController();
        String button = request.getParameter("command");
        System.out.println("button: " + button);
        if (button.equals("addnewcustomer")) {
            String tenKhachHang = request.getParameter("tenKhachHang");
            String tenKhach = request.getParameter("tenKhac");
            String diaChi = request.getParameter("diaChi");
            String soDienThoai = request.getParameter("soDienThoai");
            String maSoThue = request.getParameter("maSoThue");
            int maDongHo = Integer.parseInt(request.getParameter("maDongHo"));
            int maTram = Integer.parseInt(request.getParameter("maTram"));
            int maBangGia = Integer.parseInt(request.getParameter("maBangGia"));
            int tongChiSo = Integer.parseInt(request.getParameter("tongChiSo"));
            String ghiChu = request.getParameter("ghiChu");

            boolean result = customer.InsertCustomer(tenKhachHang, tenKhach, diaChi, soDienThoai, maSoThue, maDongHo, maBangGia, maTram, tongChiSo, ghiChu);
            if (!result) {
               url = "viewchild/error.jsp";
                request.setAttribute("ERROR", "ERROR");
            } else {
                url = "CustomerServletWeb?maTram=" + maTram;
                request.setAttribute("SUCCESS", "SUCCESS");
            }
        }
        if (button.equals("editcustomer")) {
            int maKH = Integer.parseInt(request.getParameter("maKhachHang"));
            String tenKhachHang = request.getParameter("tenKhachHang");
            String tenKhac = request.getParameter("tenKhac");
            String diaChi = request.getParameter("diaChi");
            String soDienThoai = request.getParameter("soDienThoai");
            String maSoThue = request.getParameter("maSoThue");
            int maDongHo = Integer.parseInt(request.getParameter("maDongHo"));
            int maTram = Integer.parseInt(request.getParameter("maTram"));
            int maBangGia = Integer.parseInt(request.getParameter("maBangGia"));
            int tongChiSo = Integer.parseInt(request.getParameter("tongChiSo"));
            String ghiChu = request.getParameter("ghiChu");

            boolean result = customer.UpdateCustomer(maKH, tenKhachHang, tenKhac, diaChi, soDienThoai, maSoThue, maDongHo, maBangGia, maTram, tongChiSo, ghiChu);
            if (!result) {
                url = "viewchild/error.jsp";
                request.setAttribute("ERROR", "ERROR");
            } else {
                url = "CustomerServletWeb?maTram=" + maTram;
                request.setAttribute("SUCCESS", "SUCCESS");
            }
        }
        if (button.equals("deleteCustomer")) {
            int maKH = Integer.parseInt(request.getParameter("maKhachHang"));
            int maTram = Integer.parseInt(request.getParameter("maTram"));
            boolean result = customer.DeleteCustomer(maKH);
            if (!result) {
                url = "viewchild/error.jsp";
                request.setAttribute("ERROR", "ERROR");
            } else {
                url = "CustomerServletWeb?maTram=" + maTram;
                request.setAttribute("SUCCESS", "SUCCESS");
            }
        }
        if (button.equals("resetstatuscustomer")){
            customer.resetStatusCustomer(0);
        }

        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
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
