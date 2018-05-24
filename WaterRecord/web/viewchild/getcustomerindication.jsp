<%-- 
    Document   : getcustomerindication
    Created on : May 18, 2018, 3:59:10 PM
    Author     : DatPT
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="customer" value="${requestScope.LISTCUSTOMER}"/>
<select class="form-control" id="mySelectCus">
    <option>Chọn khách hàng</option>
    <c:forEach var="rowarea" items="${customer}">
        <option value="${rowarea.maKhachHang}">${rowarea.tenKhachHang}</option>
    </c:forEach>
</select>
<script>
    var selectTorCus = $("#mySelectCus");
    $("#mySelectCus option[value=" + ${maKhachHang} + "]").attr('selected', true);
    selectTorCus.on("change", function () {
        sendIDCus(selectTorCus.val(), selectTorCus);
    });
</script>