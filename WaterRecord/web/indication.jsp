<%-- 
    Document   : tram
    Created on : May 12, 2018, 10:39:19 PM
    Author     : DatPT
--%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="info" value="${requestScope.LIST}"/>
<c:set var="area" value="${requestScope.LISTAREA}"/>
<c:set var="customer" value="${requestScope.LISTCUSTOMER}"/>
<c:set var="maTram" value="${requestScope.MATRAM}" />
<c:set var="maKhachHang" value="${requestScope.MAKH}" />
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
                <div class="col-md-5"><label for="sel1">Chọn Trạm</label>
                    <select class="form-control" id="mySelectArea" >
                        <option selected="selected">Chọn trạm</option>
                        <c:forEach var="rowarea" items="${area}">
                            <option value="${rowarea.maTram}">${rowarea.tenTram}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-5 col-md-offset-2"><label for="sel1">Chọn Khách Hàng</label>
                    <select class="form-control" id="mySelectCus">
                        <option>Chọn khách hàng</option>
                        <c:forEach var="rowarea" items="${customer}">
                            <option value="${rowarea.maKhachHang}">${rowarea.tenKhachHang}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <br>

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


                </tbody>
            </table>

            <jsp:include page="block/footer.jsp" flush="true" />
            <!-- Modal -->
            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog">
                    <!-- Modal content-->
                    <div class="modal-content">

                        <div class="modal-header">
                            <button type="button" class="close" id="closemodal" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Thông tin chỉ số đồng hồ</h4>
                        </div>
                        <div class="modal-body">                                
                            <input type="hidden" class="form-control" id="maSoGhi" name="maSoGhi">                               
                            <div class="form-group">
                                <label>Tên khách hàng</label>
                                <input type="hidden"  name="maKhachHang" id="maKhachHang">
                                <input type="text" class="form-control" id="tenKhachHang" value="" disabled="disabled" name="tenKhachHang">
                            </div>
                            <div class="form-group">
                                <label>Tên nhân viên</label>
                                <input type="hidden"  name="maNhanVien" id="maNhanVien">
                                <input type="text" class="form-control" id="tenNhanVien" disabled="disabled" name="tenNhanVien">
                            </div>
                            <div class="form-group">
                                <label>Chỉ số</label>
                                <input type="number" class="form-control" id="chiSo" name="chiSo">
                            </div>   
                            <div class="form-group">
                                <label>Ngày ghi số</label>
                                <input type="date" class="form-control" id="ngayGhi" name="ngayGhi">
                            </div>
                            <div class="form-group">
                                <label>Ghi chú</label>
                                <input type="text" class="form-control" id="ghiChu"  name="ghiChu">
                            </div>
                            <input type="hidden" name="command" id="action">
                        </div>
                        <div class="modal-footer">
                            <button type="submit" id="confirmEdit" class="btn btn-success">Xác nhận</button>
                            <button type="button" class="btn btn-default" id="closebutton" data-dismiss="modal">Đóng</button>
                        </div>

                    </div>

                </div>
            </div>
        </div>

        <script>
            var selectTorArea = $("#mySelectArea");

            selectTorArea.on("change", function () {
                sendIDArea(selectTorArea.val(), selectTorArea);
            });

            var selectButton = $("#confirmEdit");
            selectButton.on("click", function () {
                var maSoGhi = $("#maSoGhi").val();
                var maKhachHang = $("#maKhachHang").val();
                var maNhanVien = $("#maNhanVien").val();
                var chiSo = $("#chiSo").val();
                var ghiChu = $("#ghiChu").val();
                sendRequestEditIndication(maSoGhi, maKhachHang, maNhanVien, chiSo, ghiChu);
                alert("Dữ liệu đã được thay đổi");
            });
        </script>
    </body>
</html>
