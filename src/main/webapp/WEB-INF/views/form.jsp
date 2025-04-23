<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Đăng ký tốt nghiệp</title>
</head>
<body>
<form:form modelAttribute="graduateForm" action="save" method="post">
    <h2>Thông tin sinh viên</h2>
    Số CMND: <form:input path="sinhVien.soCMND"/> <form:errors path="sinhVien.soCMND"/><br/>
    Họ tên:   <form:input path="sinhVien.hoTen"/> <form:errors path="sinhVien.hoTen"/><br/>
    Email:    <form:input path="sinhVien.email"/> <form:errors path="sinhVien.email"/><br/>
    Số ĐT:    <form:input path="sinhVien.soDT"/> <form:errors path="sinhVien.soDT"/><br/>
    Địa chỉ:  <form:input path="sinhVien.diaChi"/> <form:errors path="sinhVien.diaChi"/><br/>

    <h2>Thông tin tốt nghiệp</h2>
    Trường:
    <form:select path="totNghiep.maTruong">
        <form:option value="" label="--Chọn Trường--"/>
        <form:options items="${allTruong}" itemValue="maTruong" itemLabel="tenTruong"/>
    </form:select>
    <form:errors path="totNghiep.maTruong"/><br/>

    Ngành:
    <form:select path="totNghiep.maNganh">
        <form:option value="" label="--Chọn Ngành--"/>
        <form:options items="${allNganh}" itemValue="maNganh" itemLabel="tenNganh"/>
    </form:select>
    <form:errors path="totNghiep.maNganh"/><br/>

    Ngày TN: <form:input path="totNghiep.ngayTN" type="date"/> <form:errors path="totNghiep.ngayTN"/><br/>
    Hệ TN:   <form:input path="totNghiep.heTN"/> <form:errors path="totNghiep.heTN"/><br/>
    Loại TN: <form:input path="totNghiep.loaiTN"/> <form:errors path="totNghiep.loaiTN"/><br/>

    <input type="submit" value="Lưu"/>
</form:form>
</body>
</html>
