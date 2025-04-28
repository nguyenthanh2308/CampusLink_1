<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html><head><title>Tìm tốt nghiệp & việc làm</title></head><body>
<form action="search-graduate" method="post">
  Nhập CMND:
  <input type="text" name="cmnd" value="${cmnd}"/>
  <input type="submit" value="Tìm kiếm"/>
</form>

<c:if test="${not empty resultGraduate}">
  <table border="1">
    <tr>
      <th>SoCMND</th><th>HoTen</th><th>NganhTN</th><th>MaTruong</th>
      <th>NganhCV</th><th>TenCongTy</th><th>ThoiGianLamViec</th>
    </tr>
    <c:forEach var="row" items="${resultGraduate}">
      <tr>
        <td>${row.SoCMND}</td>
        <td>${row.HoTen}</td>
        <td>${row.NganhTN}</td>
        <td>${row.MaTruong}</td>
        <td>${row.NganhCV}</td>
        <td>${row.TenCongTy}</td>
        <td>${row.ThoiGianLamViec}</td>
      </tr>
    </c:forEach>
  </table>
</c:if>
</body></html>