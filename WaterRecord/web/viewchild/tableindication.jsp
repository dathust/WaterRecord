<%-- 
    Document   : tableindication
    Created on : May 18, 2018, 4:42:51 PM
    Author     : DatPT
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="info" value="${requestScope.LIST}"/>
<c:set var="staff" value="${requestScope.LISTSTAFF}"/>
<c:set var="tenkhachhang" value="${requestScope.TENKH}"/>
<table class="table table-bordered table-hover" align="center">
    <thead>
        <tr>
            <th>Mã số ghi</th>
            <th>Tên khách hàng</th>
            <th>Tên nhân viên</th>
            <th>Chỉ số</th>
            <th>Ngày ghi số</th>                      
            <th>Ghi chú</th>
            <th>Sửa</th>
        </tr>
    </thead>               
    <tbody id="datatable">
        <c:forEach var="rows" items="${info}">
            <tr>                                                     
                <td id="maSoGhiTb">${rows.maSoGhi}</td>
        <input type="hidden" id="maKhachHangTb" value="${rows.maKhachHang}" />
        <td id="tenKHTb">${tenkhachhang}</td>
        <c:forEach var="staffs" items="${staff}">
            <c:if test="${staffs.maNhanVien == rows.maNhanVien}">
                <td id="tenNVTb">${staffs.tenNhanVien}</td>
            </c:if>
        </c:forEach>
        <input type="hidden" id="maNhanVienTb" value="${rows.maNhanVien}" />        
        <td id="chiSoTb">${rows.chiSo}</td>
        <td id="ngayGhiSoTb">${rows.ngayGhiSo}</td>
        <td id="ghiChuTb">${rows.ghiChu}</td>
        <td><button type="button" id="requestEdit" class="btn btn-warning" data-toggle="modal" data-target="#myModal">Sửa</button></td>
    </tr>
</c:forEach>

</tbody>
</table>
<script>
    $("button#requestEdit").click(function () {

        var $row = $(this).closest("tr");
        var maSG = $row.find("#maSoGhiTb").text();
        var tenKH = $row.find("#tenKHTb").text();
        var tenNV = $row.find("#tenNVTb").text();
        var chiSo = $row.find("#chiSoTb").text();
        var ngayGhiSo = $row.find("#ngayGhiSoTb").text();
        var ghiChu = $row.find("#ghiChuTb").text();
        var maKH = $row.find("#maKhachHangTb").val();
        var maNV = $row.find("#maNhanVienTb").val();
        var Indication = new editIndication(maSG, maKH, tenKH, maNV, tenNV, chiSo, ngayGhiSo, ghiChu);
        showInfoToModalEditIndication(Indication);
    });
</script>