<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản Lý Nhân Viên</title>

    <style type="text/css">
        .table {
            margin-top: 50px;
            margin-bottom: 50px;
            border-collapse: collapse;
            width: 100%;
        }
        .table th, .table td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
    </style>
</head>
<body>
    <form action="/BuiKhacThang_OnTapGK/QuanLyNhanVienServlet" method="GET">
        <label for="timTheoMa">Tìm nhân viên theo mã: </label>
        <input type="text" id="timTheoMa" name="maPhongBan" placeholder="Nhập mã phòng ban cần tìm">
        <input type="submit" value="TÌM"> 
        
        <div items="${tongNhanVien}">
        	<h1>Tổng số nhân viên: ${tongNhanVien}</h1>
        </div>
    </form>

    <table class="table">
        <thead>
            <tr>
                <th>Mã nhân viên</th>
                <th>Tên nhân viên</th>
                <th>Tuổi</th>
                <th>Số điện thoại</th>
                <th>Địa chỉ</th>
                <th>Phòng ban</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="nhanvien" items="${danhSachNhanVien}">
                <tr>
                    <td>${nhanvien.maNhanVien}</td>
                    <td>${nhanvien.tenNhanVien}</td>
                    <td>${nhanvien.tuoi}</td>
                    <td>${nhanvien.sDT}</td>
                    <td>${nhanvien.diaChi}</td>
                    <td>${nhanvien.phongBan.tenPhongBan}</td>
                    <td>
                        
                        <form action="/BuiKhacThang_OnTapGK/QuanLyNhanVienServlet" method="POST" onsubmit="return CanhBao();">
                            <input type="hidden" name="maNhanVien" value="${nhanvien.maNhanVien}">
                            <input type="submit" value="XÓA">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="ThemNhanVienMoiServlet">Thêm nhân viên mới</a>

    <script>
        function CanhBao() {
            return confirm("Bạn có muốn xóa không?");
        }
    </script>
</body>
</html>
