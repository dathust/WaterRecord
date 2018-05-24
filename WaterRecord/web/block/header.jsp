<%-- 
    Document   : header
    Created on : May 14, 2018, 3:18:56 PM
    Author     : DatPT
--%>

<%-- 
    Document   : test
    Created on : May 12, 2018, 10:09:40 PM
    Author     : DatPT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="tab" value="${requestScope.TAB}"/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Water Record</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="http://localhost:8080/WaterRecord/css/mystyle.css">
        <script src="http://localhost:8080/WaterRecord/js/myjs.js"></script>
    </head>
    <body>       
        <h2>Hệ thống quản lý</h2>
        <p>Hợp tác xã dịch vụ nước sạch sinh hoạt xã Thống Nhất</p>
        <ul class="nav nav-tabs">
            <li class="active"><a href="NewsServletWeb">Trang chủ</a></li>
            <li><a href="AreaServletWeb">Trạm</a></li>
            <li><a href="CustomerServletWeb">Khách hàng</a></li>
            <li><a href="#menu3">Nhân viên</a></li>
            <li><a href="IndicationServletWeb?command=first">Chỉ số đồng hồ</a></li>
            <li><a href="BillServletWeb?command=billservlet">Hóa đơn</a></li>
            <li><a href="#menu6">Báo cáo</a></li>
        </ul>   
        <input type="hidden" value="${tab}" name="tabnumber">
        <script>
            $(document).ready(function () {
                $(".nav-tabs a").click(function () {
                    $(this).tab('show');

                });
                var elements = document.getElementsByTagName("li");
            var tab = ${tab};
            document.onload = jumpTab(elements, tab);
            });  
            
            
        </script>
    </body>
</html>
