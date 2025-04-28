<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html><head><title>Tìm sinh viên</title></head><body>
<form action="search-basic" method="post">
  Nhập CMND hoặc họ tên:
  <input type="text" name="keyword" value="${keyword}"/>
  <input type="submit" value="Tìm kiếm"/>
</form>

<c:if test="${not empty resultBasic}">
  <table border="1">
    <tr><th>SoCMND</th><th>HoTen</th><th>Email</th><th>SoDT</th><th>DiaChi</th></tr>
    <c:forEach var="sv" items="${resultBasic}">
      <tr>
        <td>${sv.soCMND}</td>
        <td>${sv.hoTen}</td>
        <td>${sv.email}</td>
        <td>${sv.soDT}</td>
        <td>${sv.diaChi}</td>
      </tr>
    </c:forEach>
  </table>
</c:if>
</body></html>