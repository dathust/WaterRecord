/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.servletweb;

import com.datpt.waterrecord.controller.controllerImp.IndicationController;
import com.datpt.waterrecord.model.IndicationModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "IndicationServletProcess", urlPatterns = {"/IndicationServletProcess"})
public class IndicationServletProcess extends HttpServlet {

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
        String button = request.getParameter("command");
        if (button.equals("editindication")) {
            System.out.println("check1");
            IndicationController indicationController = new IndicationController();
            int maSG = Integer.parseInt(request.getParameter("maSoGhi"));
            int maKH = Integer.parseInt(request.getParameter("maKhachHang"));
            int maNV = Integer.parseInt(request.getParameter("maNhanVien"));
            String stChiSo = request.getParameter("chiSo");
            int chiSo = Integer.parseInt(stChiSo);
            //
            
            String stGhiChu = request.getParameter("ghiChu");
            // 
            long millis = System.currentTimeMillis();
            Date ngayGhiSo = new Date(millis);
            boolean result = indicationController.UpdateIndication(maSG, maKH, maNV, chiSo, ngayGhiSo, stGhiChu);
            if (!result) {
                url = "viewchild/error.jsp";
                request.setAttribute("ERROR", "ERROR");
            } else {
                url = "IndicationServletWeb?command=selectCustomer";
                request.setAttribute("SUCCESS", "SUCCESS");
            }
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
