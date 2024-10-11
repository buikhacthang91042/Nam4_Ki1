<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Danh sách điện thoại theo nhà cung cấp</title>
<style type="text/css">
body {
	font-family: Arial, sans-serif;
}

.container {
	display: flex;
}

.menu {
	width: 20%;
	border-right: 1px solid #ddd;
	padding-right: 20px;
}

.menu ul {
	list-style-type: none;
	padding: 0;
}

.menu li {
	margin-bottom: 10px;
}

.menu li a {
	text-decoration: none;
	color: blue;
}

.menu li a:hover {
	text-decoration: underline;
}

.content {
	width: 80%;
	padding-left: 20px;
}

table {
	width: 100%;
	border-collapse: collapse;
}

table, th, td {
	border: 1px solid black;
}

th, td {
	padding: 10px;
	text-align: left;
}

.link {
	color: red;
}

.ChuyenTrang {
	margin-top: 20px;
}
</style>

</head>
<body>
	<form action="/Tuan05/DanhSachDienThoaiNCCServlet" method="GET">
		<div class="container">

			<div class="menu">
				<h3 >Danh sách nhà cung cấp</h3>
				<ul>
					<c:forEach var="nhaCC" items="${NhaCCList}">
						<li><a
							href="DanhSachDienThoaiNCCServlet?mancc=${nhaCC.mancc}">
								${nhaCC.tenNhaCungCap} </a></li>
					</c:forEach>

				</ul>
				<div class="ChuyenTrang">
					<h4>
						<a href="TrangChuServlet" class="link">Quay lại trang chủ</a>
					</h4>

				</div>
			</div>


			<div class="content">
				<h1 style="color: blue">Danh sách điện thoại</h1>
				<table>
					<thead>
						<tr>
							<th>Mã điện thoại</th>
							<th>Tên điện thoại</th>
							<th>Năm sản xuất</th>
							<th>Cấu hình</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="dienThoai" items="${dienThoaiList}">
							<tr>
								<td>${dienThoai.madt}</td>
								<td>${dienThoai.tenDienThoai}</td>
								<td>${dienThoai.namSanXuat}</td>
								<td>${dienThoai.cauHinh}</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
				<div class="ChuyenTrang">
					<a href="ThemMoiSanPhamServlet" class="link"> Thêm sản phẩm mới</a>
				</div>
			</div>

		</div>
	</form>
</body>
</html>