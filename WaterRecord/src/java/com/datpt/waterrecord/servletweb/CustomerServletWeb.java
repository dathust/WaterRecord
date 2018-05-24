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
import com.datpt.waterrecord.model.CustomerModel;
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
@WebServlet(name = "CustomerServletWeb", urlPatterns = {"/CustomerServletWeb"})
public class CustomerServletWeb extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

        String url = "customer.jsp";
        int maTram;
        CustomerController customerArea = new CustomerController();
        AreaController area = new AreaController();
        CostTableController costTableController = new CostTableController();
        List<AreaModel> listArea = new ArrayList<>();
        List<CostTableModel> listCost = new ArrayList<>();
        listArea = area.getAllArea();
        listCost = costTableController.getList();
        String stMaTram = request.getParameter("maTram");
        if (stMaTram == null) {
            maTram = 1;
        } else {
            maTram = Integer.parseInt(stMaTram);
        }
        for (int i = 0; i < listArea.size(); i++) {
            if (listArea.get(i).getMaTram() == maTram){
                request.setAttribute("AREANAME", listArea.get(i).getTenTram());
            }
        }
        List<CustomerModel> listCustomerArea = customerArea.getListCustomerArea(maTram);

        request.setAttribute("LIST", listCustomerArea);
        request.setAttribute("TAB", 3);
        request.setAttribute("LISTAREA", listArea);
        request.setAttribute("LISTCOST", listCost);
        request.setAttribute("MATRAM", maTram);
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
