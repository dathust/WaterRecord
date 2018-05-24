<%-- 
    Document   : tablebill
    Created on : May 20, 2018, 12:27:28 AM
    Author     : DatPT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="info1" value="${requestScope.LIST}"/>
<table class="table table-bordered table-hover" align="center">
    <thead>
        <tr>
            <th>Trạng thái</th>
            <th class="col-md-1">Tên khách hàng</th>
            <th class="col-md-2">Địa chỉ</th>
            <th class="col-md-1">Số điện thoại</th>
            <th class="col-md-1">Bảng Giá</th>                      
            <th>Chỉ số</th>                      
            <th>Đơn giá</th>                      
            <th>Thuế</th>                                          
            <th class="col-md-1">Tổng thu</th>                      
            <th class="col-md-1">Ngày ghi số</th>                      
                                  
            <th class="col-md-1">Ngày lập hóa đơn</th>                      
            <th class="col-md-1">Ghi chú</th>
        </tr>
    </thead>               
    <tbody id="datatable">
        <c:forEach var="rows" items="${info1}">
            <tr>  
                <c:if test="${rows.trangThai == 1}">
                    <c:set var="trangThai" value="Chưa tạo"/>
                </c:if>
                 <c:if test="${rows.trangThai == 0}">
                    <c:set var="trangThai" value="Chưa tạo"/>
                </c:if>
                <c:if test="${rows.trangThai == 2}">
                    <c:set var="trangThai" value="Đã tạo"/>
                </c:if>
                <td id="maHDTb">${trangThai}</td>
                <td id="maHDTb">${rows.tenKhachHang}</td>
                <td id="maHDTb">${rows.diaChi}</td>
                <td id="maHDTb">${rows.dienThoai}</td>
                <td id="maHDTb">${rows.tenBangGia}</td>
                <td id="maHDTb">${rows.chiSoSuDung}</td>
                <td id="maHDTb">${rows.donGia}</td>
                <td id="maHDTb">${rows.thueVAT}</td>
                <td id="maHDTb">${rows.tongThu}</td>
                <td id="maHDTb">${rows.ngayGhiSo}</td>
                <td id="maHDTb">${rows.ngayLapHD}</td>
                <td id="maHDTb">${rows.ghiChu}</td>              
            </tr>
        </c:forEach>

    </tbody>
</table>
<script>
    
  
</script>