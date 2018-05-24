/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.controller.controllerImp;

import com.datpt.waterrecord.DAO.DaoImp.BillDAO;
import com.datpt.waterrecord.model.BillModel;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;

import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;

import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DatPT
 */
public class BillController extends PdfPageEventHelper {

    public boolean InsertBill(int maKhachHang, int maSoGhi, float thueVAT, int donGia, Date ngayLapHD) {
        BillDAO billDAO = new BillDAO();
        BillModel bill = new BillModel();
        //Kiểm tra dữ liệu
        bill.setMaSoGhi(maSoGhi);
        bill.setThueVAT(thueVAT);
        bill.setDonGia(donGia);
        bill.setNgayLapHD(ngayLapHD);
        boolean result = billDAO.InsertBill(bill);
        if (result) {
            CustomerController customerController = new CustomerController();
            customerController.UpdateCustomerStatus(2, maKhachHang);
        }
        return result;
    }

    public List<BillModel> getAllListBillAreaAndMonth(int maTram, int thang, int nam) {
        BillDAO bill = new BillDAO();
        //kiểm tra dữ liệu vào
        List<BillModel> list = new ArrayList<>();
        list = bill.getAllListBillAreaAndMonth(maTram, thang, nam);
        return list;
    }

    public List<BillModel> getAllListCustomerAreaAndMonthYearForBill(int maTram, int thang, int nam) {
        BillDAO bill = new BillDAO();
        //kiểm tra dữ liệu vào
        List<BillModel> list = new ArrayList<>();
        list = bill.getAllListCustomerAreaAndMonthYearForBill(maTram, thang, nam);
        return list;
    }

    public static class PDFEventListener extends PdfPageEventHelper {

        @Override
        public void onEndPage(PdfWriter pdfWriter, Document document) {
            PdfContentByte canvas = pdfWriter.getDirectContentUnder();
            Font font = FontFactory.getFont("C:/Windows/Fonts/Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED,
                    18, Font.NORMAL, BaseColor.LIGHT_GRAY);
            Phrase watermark = new Phrase("HTX dịch vụ nước sạch xã Thống Nhất", font);
            ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, watermark, 190, 150, -30);
        }
    }

    public void createBill(List<BillModel> list) {
        for (int i = 0; i < list.size(); i++) {
            try {
                Document document = new Document(PageSize.A6.rotate());
                // khởi tạo một PdfWriter truyền vào document và FileOutputStream
                PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(list.get(i).getTenKhachHang() + "HD.pdf"));

                // mở file để thực hiện viết
                document.open();
                pdfWriter.setPageEvent(new PDFEventListener());
                Font font = FontFactory.getFont("C:/Windows/Fonts/Arial.ttf",
                        BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 18, Font.NORMAL, BaseColor.BLACK);

// thêm nội dung sử dụng add function
                document.add(new Phrase(list.get(i).getTenKhachHang(), font));
                // đóng file
                document.close();

            } catch (DocumentException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException, DocumentException {

        BillController bc = new BillController();
        List<BillModel> list = bc.getAllListCustomerAreaAndMonthYearForBill(1, 5, 2018);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("list: " + list.get(i).getChiSoThangTruoc());
        }

    }

}
