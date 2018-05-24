/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.servletweb;

import com.datpt.waterrecord.controller.controllerImp.AreaController;
import com.datpt.waterrecord.model.AreaModel;
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
@WebServlet(name = "AreaServletProcess", urlPatterns = {"/AreaServletProcess"})
public class AreaServletProcess extends HttpServlet {

    AreaController area = new AreaController();
    List<AreaModel> listArea = new ArrayList<>();

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
        if (button.equals("addnewarea")) {
            String tenTram = request.getParameter("tenTram");
            String diaChi = request.getParameter("diaChi");
            boolean result = area.InsertArea(tenTram, diaChi);
            if (!result) {
                url = "viewchild/error.jsp";
                request.setAttribute("ERROR", "ERROR");
            } else {
                url = "AreaServletWeb";
                request.setAttribute("SUCCESS", "SUCCESS");
                
            }
        }
        if (button.equals("editarea")) {
            int maTram = Integer.parseInt(request.getParameter("maTram"));
            String tenTram = request.getParameter("tenTram");
            String diaChi = request.getParameter("diaChi");
            boolean result = area.UpdateArea(maTram, tenTram, diaChi);
            if (!result) {
                url = "viewchild/error.jsp";
                request.setAttribute("ERROR", "ERROR");
            } else {
                url = "AreaServletWeb";
                request.setAttribute("SUCCESS", "SUCCESS");
               
            }
        }
        if (button.equals("deleteArea")) {
            int maTram = Integer.parseInt(request.getParameter("maTram"));
            System.out.println("maTram: " + maTram);
            boolean result = area.DeleteArea(maTram);
            if (!result) {
                url = "viewchild/error.jsp";
                request.setAttribute("ERROR", "ERROR");
            } else {
                url = "AreaServletWeb";
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
