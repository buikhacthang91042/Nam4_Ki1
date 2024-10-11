<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lí điện thoại</title>
<style type="text/css">
		.link{
		color: red;
	}
	.ChuyenTrang {
		margin-top: 20px;
	}
</style>
</head>
<body>
	<h2 style="color: blue">Quản lí điện thoại</h2>
	<table border="1">
		<tr>
			<th>Mã điện thoại</th>
			<th>Tên điện thoại</th>
			<th>Cấu hình</th>
			<th>Năm sản xuất</th>
			<th>Nhà cung cấp</th>
			<th>Hình ảnh </th>
			<th>Chức năng</th>
		</tr>
	<c:forEach var="dienThoai" items="${dienThoaiList}">
		<tr>
			<td>${dienThoai.madt}</td>
			<td>${dienThoai.tenDienThoai}</td>
			<td>${dienThoai.cauHinh}</td>
			<td>${dienThoai.namSanXuat}</td>
			<td>${dienThoai.nhaCungCap}</td>
			<td>${dienThoai.hinhAnh}</td>
			<td>
			<form action="QuanLyFormServlet" method="post">
				<input type="hidden" name="maDT" value="${dienThoai.madt}">
				<input type="submit" value="Xóa sản phẩm">
			</form>
			</td>
		</tr>
	</c:forEach>
	</table>
	<div class= "ChuyenTrang" >
	<h3>
	<a href="TrangChuServlet" class="link">Quay lại trang chủ</a>
	</h3>
	
	</div>
</body>
</html>