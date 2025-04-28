<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Trang chủ</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f1f1f1;
            text-align: center;
            padding-top: 100px;
        }
        h1 {
            color: #333;
        }
        .btn {
            display: inline-block;
            margin: 20px;
            padding: 15px 30px;
            font-size: 16px;
            background-color: #1976d2;
            color: white;
            border: none;
            border-radius: 8px;
            text-decoration: none;
        }
        .btn:hover {
            background-color: #0d47a1;
        }
    </style>
</head>
<body>
  <h1>Trang chủ hệ thống tốt nghiệp</h1>

  <!-- Đăng ký tốt nghiệp -->
  <a class="btn" href="${pageContext.request.contextPath}/graduate/form">
    Đăng ký tốt nghiệp
  </a>

  <!-- Tìm kiếm thông tin cơ bản -->
  <a href="${pageContext.request.contextPath}/graduate/search-basic" class="btn">
  Tìm kiếm sinh viên
</a>

  <!-- Tìm kiếm tốt nghiệp & việc làm -->
  <a href="${pageContext.request.contextPath}/graduate/search-graduate" class="btn">
  Tìm tốt nghiệp & việc làm
</a>
</body>
</html>
