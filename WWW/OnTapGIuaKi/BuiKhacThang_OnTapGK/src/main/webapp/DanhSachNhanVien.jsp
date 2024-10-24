<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	.table {
		margin-top: 50px;
		margin-bottom: 50px;
		border-collapse: collapse;
		width: 100%;
	}
	.table th, .table td{
		border: 1px solid black;
	}

</style>
</head>
<body>
`	<form action="/BuiKhacThang_OnTapGK/QuanLyNhanVienServlet" method="get">
		<label for="timTheoMa">Tìm nhân viên theo mã: </label>
		<input type="text" id="timTheoMa" name="maPhongBan" placeholder="Nhập mã phòng ban cần tìm">
		<input type="submit" value="TÌM"> 
		<table class="table">
			<thead>
			<tr>
					<th>Mã nhân viên</th>
					<th>Tên nhân viên</th>
					<th>Tuổi</th>
					<th>Số điện thoại</th>
					<th>Địa chỉ</th>
					<th>Phòng ban</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="nhanvien" items="${danhSachNhanVien}">
				<tr>
					<td>${nhanvien.maNhanVien}</td>
					<td>${nhanvien.tenNhanVien }</td>
					<td>${nhanvien.tuoi }</td>
					<td>${nhanvien.sDT }</td>
					<td>${nhanvien.diaChi }</td>
					<td>${nhanvien.phongBan.tenPhongBan }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="ThemNhanVienMoiServlet">Thêm nhân viên mới</a>
	</form>
</body>
</html>