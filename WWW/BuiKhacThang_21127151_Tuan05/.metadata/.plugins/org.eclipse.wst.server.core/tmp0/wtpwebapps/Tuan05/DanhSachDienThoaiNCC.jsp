<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Danh sách điện thoại theo nhà cung cấp</title>
<style type="text/css">
	.container{
		display: flex;
		flex-direction: row;
	}
	.menu{
		
	}
	.content{
		display:flex;
		flex-direction:column;
		margin-left: 400px;
		
	}
	th {
		padding: 20px;
		border-right: solid;
	}
	table{
		border: solid;	
	}
</style>

</head>
<body>
	<form action="/Tuan05/DanhSachDienThoaiNCCServlet" method="GET">
	<div class="container">
	
		<div class="menu">
		<ul>
			<h2>Nhà cung cấp</h2>
		<c:forEach var="NCC" items="${NhaCCList}">
			<li><a
				href="DanhSachDienThoaiNCCServlet?mancc=${NCC.mancc}">${NCC.tenNhaCungCap}</a></li>
		</c:forEach>
		</ul>
		</div>
		
		<div class="content">
		<h1>Danh sách điện thoại</h1>
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
				<c:forEach var= "dienThoai" items= "${dienThoaiList}">
					<tr>
						<td>${dienThoai.madt} </td>
						<td>${dienThoai.tenDienThoai} </td>
						<td>${dienThoai.namSanXuat} </td>
						<td>${dienThoai.cauHinh} </td>
					</tr>
				</c:forEach>
				
				</tbody>
			</table>
		</div>
		
		</div>
	</form>
</body>
</html>