<%-- 
    Document   : tram
    Created on : May 12, 2018, 10:39:19 PM
    Author     : DatPT
--%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="info" value="${requestScope.LIST}"/>
<c:set var="area" value="${requestScope.LISTAREA}"/>
<c:set var="maTram" value="${requestScope.MATRAM}" />
<c:set var="cost" value="${requestScope.LISTCOST}" />
<c:set var="areaName" value="${requestScope.AREANAME}" />
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Water Record</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="http://localhost:8080/WaterRecord/js/myjs.js"></script>
        <link rel="stylesheet" href="css/mystyle.css">

    </head>
    <body>
        <div class="container">
            <jsp:include page="block/header.jsp" flush="true" />
            <br>
            <div class="row">
                <div class="col-md-1">
                    <button type="button" id="resetTT" class="btn btn-info">Reset trạng thái</button>
                </div>
            </div>

            <br>
            <div class="row">
                <div class="col-md-5">
                    <label for="sel1">Chọn Trạm</label>
                    <select class="form-control" id="mySelect" >
                        <c:forEach var="rowarea" items="${area}">
                            <option value="${rowarea.maTram}">${rowarea.tenTram}</option>
                        </c:forEach>

                    </select>
                </div>
                <div class="col-md-5 col-md-offset-2">
                    <label for="sel1">Tìm kiếm</label>
                    <br>
                    <input type="text" id="search" class="form-control" name="keywork">
                </div>
            </div>

            <br>

            <table class="table table-bordered table-hover" align="center">
                <thead>
                    <tr>
                        <th>Mã khách hàng</th>
                        <th>Tên khác hàng</th>
                        <th>Tên khác</th>
                        <th>Địa chỉ</th>
                        <th>Số điện thoại</th>
                        <th>Mã số thuế</th>
                        <th>Mã đồng hồ</th>
                        <th>Bảng giá</th>
                        <th>Trạm</th>
                        <th>Tổng chỉ số</th>
                        <th>Ghi chú</th>
                        <th>Sửa</th>
                        <th>Xóa</th>
                    </tr>
                </thead>               
                <tbody id="datatable">
                    <c:forEach var="rows" items="${info}">
                        <tr>                                                     
                            <td id="maKHTb">${rows.maKhachHang}</td>
                            <td id="tenKHTb">${rows.tenKhachHang}</td>
                            <td id="tenKhacTb">${rows.tenKhac}</td>
                            <td id="diaChiTb">${rows.diaChi}</td>
                            <td id="dienThoaiTb">${rows.dienThoai}</td>
                            <td id="maSoThueTb">${rows.maSoThue}</td>
                            <td id="maSoDongHoTb">${rows.maSoDongHo}</td>
                            <c:forEach var="cost1" items="${cost}">
                                <c:if test="${cost1.maBangGia == rows.maBangGia}">
                                    <td>${cost1.tenBangGia}</td>
                            <input type="hidden" id="maBangGiaTb" value="${rows.maBangGia}"/>
                        </c:if>                             
                    </c:forEach>

                    <td>${areaName}</td>
                    <input type="hidden" id="maTramTb" value="${rows.maTram}"/>
                    <td id="tongChiSoTb">${rows.tongChiSo}</td>
                    <td id="ghiChuTb">${rows.ghiChu}</td>
                    <td><button type="button" id="requestEdit" class="btn btn-warning" data-toggle="modal" data-target="#myModal">Sửa</button></td>
                    <td><button type="button" id="deleteCustomer" class="btn">Xóa</button></td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
            <div class="row">
                <div class="col-md-1">
                    <button class="btn btn-success" id="addnewCustomer" data-toggle="modal" data-target="#myModal">Thêm khách hàng</button>

                </div>

            </div>

            <jsp:include page="block/footer.jsp" flush="true" />
            <!-- Modal -->
            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog">
                    <c:set var="maK" value="${ma}"/>
                    <!-- Modal content-->
                    <div class="modal-content">
                        <form action="CustomerServletProcess" method="GET">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">Thông tin khách hàng</h4>
                            </div>
                            <div class="modal-body">                                
                                <input type="hidden" class="form-control" id="maKhachHang" name="maKhachHang">                               
                                <div class="form-group">
                                    <label>Tên khách hàng</label>
                                    <input type="text" class="form-control" id="tenKhachHang" value="" name="tenKhachHang">
                                </div>
                                <div class="form-group">
                                    <label>Tên khác</label>
                                    <input type="text" class="form-control" id="tenKhac"  name="tenKhac">
                                </div>
                                <div class="form-group">
                                    <label>Địa chỉ</label>
                                    <input type="text" class="form-control" id="diaChi" name="diaChi">
                                </div>   
                                <div class="form-group">
                                    <label>Số điện thoại</label>
                                    <input type="number" class="form-control" id="soDienThoai" name="soDienThoai">
                                </div>
                                <div class="form-group">
                                    <label>Mã số thuế</label>
                                    <input type="text" class="form-control" id="maSoThue"  name="maSoThue">
                                </div>
                                <div class="form-group">
                                    <label>Mã đồng hồ</label>
                                    <input type="text" class="form-control" id="maDongHo"  name="maDongHo">
                                </div>
                                <div class="form-group">
                                    <label for="sel1">Chọn trạm</label>
                                    <select class="form-control" id="selectArea" name="maTram">
                                        <c:forEach items="${area}" var="area">
                                            <option value="${area.maTram}">${area.tenTram}</option>
                                        </c:forEach>
                                    </select>
                                </div> 
                                <div  class="form-group">
                                    <label for="sel1">Chọn bảng giá</label>
                                    <select  class="form-control" id="selectCost" name="maBangGia">
                                        <c:forEach var="cost" items="${cost}">
                                            <option value="${cost.maBangGia}">${cost.tenBangGia}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Tổng chỉ số</label>
                                    <input type="text" class="form-control" id="tongChiSo"  name="tongChiSo">
                                </div>
                                <div class="form-group">
                                    <label>Ghi chú</label>
                                    <input type="text" class="form-control" id="ghiChu" name="ghiChu">
                                </div>
                                <input type="hidden" name="command" id="action">
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-success">Xác nhận</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>



        <script>

            $("button#requestEdit").click(function () {
                var $row = $(this).closest("tr");
                var maKH = $row.find("#maKHTb").text();
                var tenKH = $row.find("#tenKHTb").text();
                var tenKhac = $row.find("#tenKhacTb").text();
                var diaChi = $row.find("#diaChiTb").text();
                var soDienThoai = $row.find("#dienThoaiTb").text();
                var maSoThue = $row.find("#maSoThueTb").text();
                var maDongHo = $row.find("#maSoDongHoTb").text();
                var maBangGia = $row.find("#maBangGiaTb").val();
                var maTram = $row.find("#maTramTb").val();
                var tongChiSo = $row.find("#tongChiSoTb").text();
                var ghiChu = $row.find("#ghiChuTb").text();
                var Cus = new editCustomer(maKH, tenKH, tenKhac, diaChi, soDienThoai, maSoThue, maDongHo, maBangGia, maTram, tongChiSo, ghiChu);

                showInfoToModalEdit(Cus);
            });

            $("button#resetTT").click(function () {
                resetStatusCustomer();
                alert("Trạng thái của khách hàng đã được cập nhật");
            });
            var selectTor = $("#mySelect");
            $("#mySelect option[value=" + ${maTram} + "]").attr('selected', true);
            selectTor.on("change", function () {
                sendRequest(selectTor.val(), selectTor);
            });

            $("button#addnewCustomer").click(function () {
                showModalAddnewCustomer(selectTor.val());
            });

            $("button#deleteCustomer").click(function () {
                var result = confirm("Bạn có muốn xóa dữ liệu này không?");
                if (result == true) {
                    var $row = $(this).closest("tr");
                    var maKH = $row.find("#maKHTb").text();
                    var maTram = $row.find("#maTramTb").val();
                    deleteCustomer(maKH, maTram);
                } else {
                }
            });
        </script>
    </body>
</html>
