<%-- 
    Document   : test
    Created on : May 12, 2018, 10:09:40 PM
    Author     : DatPT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Water Record</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/mystyle.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>

        <div class="container">
            <jsp:include page="block/header.jsp" flush="true" />
            <div id="home" class="tab-pane fade in active">
                <h3>Trang chủ</h3>
                <p>Giới thiệu về HTX nước sinh hoạt</p>
            </div>
            <jsp:include page="block/footer.jsp" flush="true" />
        </div>
    </body>
</html>