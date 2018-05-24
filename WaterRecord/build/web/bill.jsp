<%-- 
    Document   : indication
    Created on : May 12, 2018, 10:39:19 PM
    Author     : DatPT
--%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="area" value="${requestScope.LISTAREA}"/>
<c:set var="month" value="${requestScope.MONTH}"/>
<c:set var="year" value="${requestScope.YEAR}"/>
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
                <div class="col-md-5">
                    <label for="sel1">Chọn Trạm</label>
                    <select class="form-control" id="mySelectArea" >
                        <option selected="selected">Chọn trạm</option>
                        <c:forEach var="rowarea" items="${area}">
                            <option value="${rowarea.maTram}">${rowarea.tenTram}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-3 col-md-offset-1">
                    <label for="sel1">Chọn tháng</label>
                    <select class="form-control" id="mySelectMonth">
                        <option id="selectedMonth" selected="selected" value="0">Chọn tháng</option>
                        <c:forEach var="months" items="${month}">
                            <option value="${months}">Tháng ${months}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-3">
                    <label for="sel1">Chọn năm</label>
                    <select class="form-control" id="mySelectYear">
                        <option id="selectedYear" selected="selected" value="0">Chọn năm</option>
                        <c:forEach var="years" items="${year}">
                            <option value="${years}">Năm ${years}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <br>   
            <div class="row">
                <div class="col-md-1">
                    <button class="btn btn-success" id="createbill" type="reset">Tạo hóa đơn</button>
                </div>
                <div class="col-md-1 col-md-offset-1">
                    <form action="BillServletWeb" method="GET">
                        <input type="hidden" name="command" value="printbill">
                        <input type="hidden" id="test1">
                        <button class="btn btn-warning" id="printbill" type="submit">In hóa đơn</button>
                    </form>
                </div>
            </div>


            <br>
            <br>           
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


                </tbody>
            </table>

            <jsp:include page="block/footer.jsp" flush="true" />
            <!-- Modal -->          
        </div>

        <script>
            var selectTorArea = $("#mySelectArea");

            selectTorArea.on("change", function () {

                sendRequestBill();
            });

            $("#printbill").click(function () {

                var selectTorArea1 = $("#mySelectArea");
                var selectTorMonth = $("#mySelectMonth");
                var selectTorYear = $("#mySelectYear");
                var area = selectTorArea1.val();
                var month = selectTorMonth.val();
                var year = selectTorYear.val();
                $("#test1").replaceWith("<input type=\"hidden\" name=\"tram\" value=" + area + ">"
                        + "<input type=\"hidden\" name=\"thang\" value=" + month + ">"
                        + "<input type=\"hidden\" name=\"nam\" value=" + year + ">"
                        );
            });
            $("#createbill").click(function () {              
                seandRequestCreateBill();
            });
        </script>
    </body>
</html>
