/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kimdungstory.servlet;

import com.kimdungstory.DAO.ChapterDAO;
import com.kimdungstory.DAO.TestSQL;
import com.kimdungstory.controller.ChapterController;
import com.kimdungstory.model.ChaptersModel;
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
@WebServlet(name = "ChapterServlet", urlPatterns = {"/ChapterServlet"})
public class ChapterServlet extends HttpServlet {

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
        String idChapter = request.getParameter("idStory");
        String key = request.getParameter("key");
        ChapterDAO chapter = new ChapterDAO();
        ChapterController cc = new ChapterController();
        ChaptersModel chap = chapter.getChapter(idChapter);
        List<String> subS = cc.subChapterContent(chap.getChapter_content());
        //
        String para = subS.get(cc.findKeyInParagraph(key, subS));
        System.out.println("chap: " + chap.getChapter_content());
        List<String> listKey = cc.findKeyMatch(key, para);
        String editPara = cc.replaceKeyContent(para, listKey);
        String chapContent = cc.replacePara(chap.getChapter_content(), para, editPara);
        //String editContent = cc.editContent(chap.getChapter_content());
//String para = test.get(1);
        
        request.setAttribute("Chapter", chapContent);
        request.setAttribute("Chap", para);
        request.setAttribute("ListKey", listKey);
        request.setAttribute("KEY", editPara);
        RequestDispatcher rd = request.getRequestDispatcher("/chapter.jsp");
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
