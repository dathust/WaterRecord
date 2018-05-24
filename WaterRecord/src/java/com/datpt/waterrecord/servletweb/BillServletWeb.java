/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.servletweb;

import com.datpt.waterrecord.controller.controllerImp.AreaController;
import com.datpt.waterrecord.controller.controllerImp.BillController;
import com.datpt.waterrecord.controller.controllerImp.CustomerController;
import com.datpt.waterrecord.controller.controllerImp.IndicationController;
import com.datpt.waterrecord.model.AreaModel;
import com.datpt.waterrecord.model.BillModel;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DatPT
 */
@WebServlet(name = "BillServletWeb", urlPatterns = {"/BillServletWeb"})
public class BillServletWeb extends HttpServlet {

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
        String button = request.getParameter("command");
        String url = "";
        BillController billController = new BillController();
        AreaController areaController = new AreaController();
        IndicationController indicationController = new IndicationController();
        CustomerController customerController = new CustomerController();
        List<BillModel> listBill = new ArrayList<>();
        List<AreaModel> listArea = new ArrayList<>();
        List<Integer> listMonth = new ArrayList<>();
        List<Integer> listYear = new ArrayList<>();
        if (button.equals("billservlet")) {
            listArea = areaController.getAllArea();
            listMonth = indicationController.getMonth();
            listYear = indicationController.getYear();
            request.setAttribute("LISTAREA", listArea);
            request.setAttribute("MONTH", listMonth);
            request.setAttribute("YEAR", listYear);
            url = "bill.jsp";
            request.setAttribute("TAB", 6);
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
        if (button.equals("getBill")) {
            int maTram = Integer.parseInt(request.getParameter("maTram"));
            int thang = Integer.parseInt(request.getParameter("thang"));
            int nam = Integer.parseInt(request.getParameter("nam"));
            listBill = billController.getAllListCustomerAreaAndMonthYearForBill(maTram, thang, nam);
            url = "viewchild/tablebill.jsp";
            request.setAttribute("LIST", listBill);
            request.setAttribute("THANG", thang);
            request.setAttribute("NAM", nam);
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);

        }

        if (button.equals("createBill")) {
            int maTram = Integer.parseInt(request.getParameter("maTram"));
            int thang = Integer.parseInt(request.getParameter("thang"));
            int nam = Integer.parseInt(request.getParameter("nam"));

            listBill = billController.getAllListCustomerAreaAndMonthYearForBill(maTram, thang, nam);
            for (int i = 0; i < listBill.size(); i++) {
                int maKhachHang = listBill.get(i).getMaKhachHang();
                int maSoGhi = listBill.get(i).getMaSoGhi();
                float thue = listBill.get(i).getThueVAT();
                int donGia = listBill.get(i).getDonGia();
                Date ngay = listBill.get(i).getNgayLapHD();

                billController.InsertBill(maKhachHang, maSoGhi, thue, donGia, (java.sql.Date) ngay);

            }

            List<BillModel> listBillNew = billController.getAllListBillAreaAndMonth(maTram, thang, nam);
            url = "viewchild/tablebill.jsp";
            request.setAttribute("LIST", listBillNew);
            request.setAttribute("THANG", thang);
            request.setAttribute("NAM", nam);
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);

        }

        if (button.equals(
                "printbill")) {
            System.out.println("check1");
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", " inline; filename=hoadon.pdf");;
            int tram = Integer.parseInt(request.getParameter("tram"));
            int thang = Integer.parseInt(request.getParameter("thang"));
            int nam = Integer.parseInt(request.getParameter("nam"));
            ServletOutputStream out = response.getOutputStream();
            listBill = billController.getAllListBillAreaAndMonth(tram, thang, nam);
            Document document = new Document(PageSize.A6.rotate(), 20, 20, 20, 20);

            try {
                document.open();
                PdfWriter pdfWriter = PdfWriter.getInstance(document, out);
                document.open();
                Font chapterFont = FontFactory.getFont("C:/Windows/Fonts/Arial.ttf",
                        BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 18, Font.NORMAL, BaseColor.BLACK);
                Font paragraphFont = FontFactory.getFont("C:/Windows/Fonts/Arial.ttf",
                        BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 12, Font.NORMAL, BaseColor.BLACK);
                Font infoFont = FontFactory.getFont("C:/Windows/Fonts/Arial.ttf",
                        BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 12, Font.NORMAL, BaseColor.BLACK);
                Chunk chunk = new Chunk("Hóa đơn thanh toán tiền sử dụng nước", chapterFont);
                pdfWriter.setPageEvent(new BillController.PDFEventListener());
                for (int i = 0; i < listBill.size(); i++) {
                    Chapter chapter = new Chapter(new Paragraph(chunk), 1);
                    chapter.setNumberDepth(0);
                    chapter.add(new Paragraph("Thông tin khách hàng", paragraphFont));
                    chapter.add(new Paragraph("Tên khách hàng: " + listBill.get(i).getTenKhachHang()+"          Số điện thoại: " + listBill.get(i).getDienThoai(), infoFont));
              
                    chapter.add(new Paragraph("Địa chỉ: " + listBill.get(i).getDiaChi(), infoFont));
                    
                    chapter.add(new Paragraph("Ngày ghi số: " + listBill.get(i).getNgayGhiSo()+ "                 Ngày lập hóa đơn: " + listBill.get(i).getNgayLapHD(), infoFont));
                    chapter.add(new Paragraph("Bảng giá: " + listBill.get(i).getTenBangGia(), infoFont));
                    document.add(chapter);
                    PdfPTable t = new PdfPTable(6);
                    t.setWidths(new float[]{4, 4, 4, 3, 3, 4});
                    t.setSpacingBefore(25);
                    t.setSpacingAfter(25);
                    PdfPCell c7 = new PdfPCell(new Phrase("Chỉ số tháng trước", infoFont));
                    t.addCell(c7);
                    PdfPCell c8 = new PdfPCell(new Phrase("Chỉ số tháng này", infoFont));
                    t.addCell(c8);
                    PdfPCell c1 = new PdfPCell(new Phrase("Chỉ số sử dụng", infoFont));
                    t.addCell(c1);
                    PdfPCell c2 = new PdfPCell(new Phrase("Đơn giá", infoFont));
                    t.addCell(c2);
                    PdfPCell c3 = new PdfPCell(new Phrase("Thuế", infoFont));
                    t.addCell(c3);
                    PdfPCell c6 = new PdfPCell(new Phrase("Tổng thu", infoFont));
                    t.addCell(c6);
                    String chiSoThangTruoc = String.valueOf(listBill.get(i).getChiSoThangTruoc());
                    String chiSoThangNay = String.valueOf(listBill.get(i).getChiSoThangNay());
                    String chiSo = String.valueOf(listBill.get(i).getChiSoSuDung());
                    String donGia = String.valueOf(listBill.get(i).getDonGia());
                    String thue = String.valueOf(listBill.get(i).getThueVAT());           
                    String tong = String.valueOf(listBill.get(i).getTongThu());
                    t.addCell(chiSoThangTruoc);
                    t.addCell(chiSoThangNay);
                    t.addCell(chiSo);
                    t.addCell(donGia);
                    t.addCell(thue);                   
                    t.addCell(tong);
                    document.add(t);
                }

                document.close();

            } catch (DocumentException ex) {
                Logger.getLogger(BillServletProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
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
