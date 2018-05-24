/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datpt.waterrecord.DAO.DaoImp;

import com.datpt.waterrecord.DAO.DaoItf.BillInterface;
import com.datpt.waterrecord.connectDB.ConnectDB;
import com.datpt.waterrecord.controller.controllerImp.IndicationController;
import com.datpt.waterrecord.model.BillModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DatPT
 */
public class BillDAO implements BillInterface {

    @Override
    public BillModel getBill(int maHoaDon) {
        BillModel bill = new BillModel();
        try {
            Connection connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM hoadon WHERE MA_HD=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, maHoaDon);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                bill.setMaHoaDon(rs.getInt(1));

            }
        } catch (Exception e) {
        } finally {
            ConnectDB.closeConnection();
        }
        return null;
    }

    @Override
    public List<BillModel> getAllListBill() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BillModel> getListBillCustomer(int maKhachHang) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean UpdateBill(BillModel billModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean InsertBill(BillModel billModel) {
        try {
            Connection connection = ConnectDB.getConnection();
            String sql = "INSERT INTO hoadon(MA_SG, THUE_VAT_HD, DON_GIA_BAN, NGAY_LAP_HD) VALUES(?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, billModel.getMaSoGhi());
            ps.setFloat(2, billModel.getThueVAT());
            ps.setInt(3, billModel.getDonGia());
            ps.setDate(4, (Date) billModel.getNgayLapHD());
            int result = ps.executeUpdate();
            return result == 1;
        } catch (SQLException ex) {
            Logger.getLogger(IndicationDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            ConnectDB.closeConnection();
        }
        return false;
    }

    @Override
    public List<BillModel> getAllListBillAreaAndMonth(int maTram, int thang, int nam) {
        List<BillModel> list = new ArrayList<>();
        try {
            Connection connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM hoadon INNER JOIN soghi ON hoadon.MA_SG = soghi.MA_SG"
                    + "                         INNER JOIN khachhang ON soghi.MA_KH = khachhang.MA_KH"
                    + "                             INNER JOIN banggia ON khachhang.MA_BG = banggia.MA_BG"
                    + "            WHERE khachhang.MA_TRAM = ?"
                    + "                  AND MONTH(soghi.NGAY_GHI_SO)=?"
                    + "                     AND YEAR(soghi.NGAY_GHI_SO) = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, maTram);
            ps.setInt(2, thang);
            ps.setInt(3, nam);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BillModel billModel = new BillModel();
                billModel.setMaHoaDon(rs.getInt("MA_HD"));
                billModel.setMaSoGhi(rs.getInt("MA_SG"));
                billModel.setMaKhachHang(rs.getInt("MA_KH"));
                billModel.setTenKhachHang(rs.getString("TEN_KH"));
                billModel.setDiaChi(rs.getString("DIA_CHI"));
                billModel.setDienThoai(rs.getString("DIEN_THOAI"));
                billModel.setMaSoDongHo(rs.getInt("MA_SO_DONG_HO"));
                billModel.setTenBangGia(rs.getString("TEN_BANG_GIA"));
                int chiSoThangNay = rs.getInt("CHI_SO");
                billModel.setChiSoThangNay(chiSoThangNay);
                IndicationController controller = new IndicationController();
                int chiSoThangTruoc = controller.getIndicationLastMonth(rs.getInt("MA_KH"), thang-1, nam);
                billModel.setChiSoThangTruoc(chiSoThangTruoc);
                int chiSoSuDung = chiSoThangNay - chiSoThangTruoc;
                billModel.setChiSoSuDung(chiSoSuDung);
                int donGiaBan = rs.getInt("DON_GIA_BAN");
                billModel.setDonGia(donGiaBan);
                float thueVATHD = rs.getFloat("THUE_VAT_HD");
                billModel.setThueVAT(thueVATHD);
                int tongThu = (int) (chiSoSuDung * donGiaBan + chiSoSuDung * donGiaBan * thueVATHD);
                billModel.setTongThu(tongThu);
                billModel.setNgayLapHD(rs.getDate("NGAY_LAP_HD"));
                billModel.setNgayGhiSo(rs.getDate("NGAY_GHI_SO"));
                billModel.setTrangThai(rs.getInt("TRANG_THAI"));
                billModel.setGhiChu(rs.getString("GHI_CHU"));
                list.add(billModel);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectDB.closeConnection();
        }
        return null;
    }

    @Override
    public List<BillModel> getAllListCustomerAreaAndMonthYearForBill(int maTram, int thang, int nam) {
        List<BillModel> list = new ArrayList<>();
        try {
            Connection connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM soghi INNER JOIN khachhang ON soghi.MA_KH = khachhang.MA_KH INNER JOIN banggia ON khachhang.MA_BG = banggia.MA_BG"
                    + "	WHERE khachhang.MA_TRAM = ?"
                    + "        AND MONTH(soghi.NGAY_GHI_SO) = ?"
                    + "    	AND YEAR(soghi.NGAY_GHI_SO) = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, maTram);
            ps.setInt(2, thang);
            ps.setInt(3, nam);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BillModel billModel = new BillModel();
                billModel.setMaSoGhi(rs.getInt("MA_SG"));
                billModel.setMaKhachHang(rs.getInt("MA_KH"));
                billModel.setTenKhachHang(rs.getString("TEN_KH"));
                billModel.setDiaChi(rs.getString("DIA_CHI"));
                billModel.setDienThoai(rs.getString("DIEN_THOAI"));
                billModel.setMaSoDongHo(rs.getInt("MA_SO_DONG_HO"));
                billModel.setTenBangGia(rs.getString("TEN_BANG_GIA"));
                int chiSoThangNay = rs.getInt("CHI_SO");
                billModel.setChiSoThangNay(chiSoThangNay);
                IndicationController controller = new IndicationController();
                int chiSoThangTruoc = controller.getIndicationLastMonth(rs.getInt("MA_KH"), thang-1, nam);
                billModel.setChiSoThangTruoc(chiSoThangTruoc);
                int chiSoSuDung = chiSoThangNay - chiSoThangTruoc;
                billModel.setChiSoSuDung(chiSoSuDung);
                int donGia = rs.getInt("DON_GIA");
                float thueVAT = rs.getFloat("THUE_VAT");
                int donGiaBan = (int) (donGia * thueVAT + donGia);
                billModel.setDonGia(donGiaBan);
                float thueVATHD = rs.getFloat("THUE_VAT");
                billModel.setThueVAT(thueVATHD);

                int tongThu = (int) (chiSoSuDung * donGiaBan + chiSoSuDung * donGiaBan * thueVATHD);
                billModel.setTongThu(tongThu);
                long millis = System.currentTimeMillis();
                Date ngayLapHD = new Date(millis);
                billModel.setNgayLapHD(ngayLapHD);
                billModel.setNgayGhiSo(rs.getDate("NGAY_GHI_SO"));
                billModel.setTrangThai(rs.getInt("TRANG_THAI"));
                billModel.setGhiChu(rs.getString("GHI_CHU"));
                list.add(billModel);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectDB.closeConnection();
        }
        return null;
    }

}
