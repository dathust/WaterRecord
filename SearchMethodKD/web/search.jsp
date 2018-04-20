<%-- 
    Document   : search
    Created on : Apr 6, 2018, 1:38:38 PM
    Author     : DatPT
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    <c:set var="KEY" value="${requestScope.Key}"/>
    <h3>${KEY}</h3>
    <c:set var="CHAP" value="${requestScope.Chapters}"/>
    <c:forEach var="rows" items="${CHAP}">
        <a href="ChapterServlet?idStory=${rows.id_Chapter}&key=${KEY}"><h3>${rows.chapter_Name}</h3></a>
    </c:forEach>
</body>
</html>
