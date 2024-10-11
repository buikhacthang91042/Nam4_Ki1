<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bùi Khắc Tháng_Tuan05</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Layout</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: Arial, sans-serif;
}

.header {
	text-align: center;
	padding: 20px;
}

.header img {
	width: 100%;
	height: auto;
}

.menu {
	text-align: center;
	background-color: #f0f0f0;
	padding: 10px;
	border: 1px solid #000;
}

.menu a {
	margin: 0 15px;
	text-decoration: none;
	color: blue;
	font-weight: bold;
}

.content {
	height: 400px;
	border: 1px solid #000;
	margin-top: 10px;
	padding: 10px;
}

.footer {
	text-align: center;
	margin-top: 10px;
	padding: 10px;
	border: 1px solid #000;
}
</style>
</head>
<body>
	<form action="/Tuan05/TrangChuServlet" method="GET">
		<div class="header">
			<img src="image/logo.png" alt="Logo">
		</div>


		<div class="menu">
			<a href="DanhSachDienThoaiNCCServlet">Danh sách sản phẩm</a> | <a
				href="ThemMoiSanPhamServlet">Thêm mới sản phẩm</a> | <a
				href="QuanLyFormServlet">Chức năng quản lý</a>
		</div>


		<div class="content"></div>

		<div class="footer">Bùi Khắc Thắng – 21127151 – DHKTPM17</div>
	</form>
</body>
</html>