<%-- 
    Document   : tram
    Created on : May 12, 2018, 10:39:19 PM
    Author     : DatPT
--%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="info" value="${requestScope.LIST}"/>
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

            <br><br>
            <table class="table table-bordered table-hover">
                <thead>
                    <tr>
                        <th>Mã trạm</th>
                        <th>Tên trạm</th>
                        <th>Địa chỉ</th>
                        <th>Sửa</th>
                        <th>Xóa</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="rows" items="${info}">
                        <tr>
                            <td id="maTramTb">${rows.maTram}</td>
                            <td id="tenTramTb">${rows.tenTram}</td>
                            <td id="diaChiTb">${rows.diaChi}</td>
                            <td><button type="button" id="requestEdit" class="btn btn-warning" data-toggle="modal" data-target="#myModal">Sửa</button></td>
                            <td><button type="button" id="deleteArea" class="btn">Xóa</button></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <button class="btn btn-success" id="addnewArea" data-toggle="modal" data-target="#myModal">Thêm trạm mới</button>
            <jsp:include page="block/footer.jsp" flush="true" />
            <!-- Modal -->
            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog">
                    <c:set var="maK" value="${ma}"/>
                    <!-- Modal content-->
                    <div class="modal-content">
                        <form action="AreaServletProcess" method="GET">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">Thông tin trạm</h4>
                            </div>
                            <div class="modal-body">                                
                                <input type="hidden" class="form-control" id="maTram" name="maTram">                               
                                <div class="form-group">
                                    <label>Tên Trạm</label>
                                    <input type="text" class="form-control" id="tenTram" name="tenTram">
                                </div>
                                <div class="form-group">
                                    <label>Địa chỉ</label>
                                    <input type="text" class="form-control" id="diaChi" name="diaChi">
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
                var maTram = $row.find("#maTramTb").text();
                var tenTram = $row.find("#tenTramTb").text();
                var diaChi = $row.find("#diaChiTb").text();
                var Area = new editArea(maTram, tenTram, diaChi);
                showInfoToModalEditArea(Area);
            });

            $("button#addnewArea").click(function () {
                showModalAddnewArea();
            });
            
            $("button#deleteArea").click(function () {
                var result = confirm("Bạn có muốn xóa dữ liệu này không?");
                if (result == true) {
                    var $row = $(this).closest("tr");                  
                    var maTram = $row.find("#maTramTb").text();
                    deleteA(maTram);
                    
                } else {
                }
            });
        </script>
    </body>
</html>
