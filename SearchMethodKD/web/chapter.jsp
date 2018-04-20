<%-- 
    Document   : chapter
    Created on : Mar 29, 2018, 3:18:53 PM
    Author     : DatPT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script language="javascript">
            $(document).ready(function () {
                $('html, body').animate({
                    scrollTop: $("#para").offset().top
                }, 1000);
            });
        </script>
    </head>
    <body>
        <h1>Hello World!</h1>
        <a href="#para">link</a>
        <c:set var="CHAP" value="${requestScope.Chapter}"/>
        <c:set var="MATCH" value="${requestScope.Chap}" />
        <c:set var="LISTKEY" value="${requestScope.ListKey}" />
        <c:set var="KEY" value="${requestScope.KEY}" />
        <p id="demo">${CHAP}</p>

    </body>
</html>
