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
	.dienThongTin{
		margin-top: 30px;
	}
</style>
</head>
<body>
<form action="/BuiKhacThang_OnTapGK/ThemNhanVienMoiServlet" method="post">
	<h1>Thêm nhân viên mới</h1>
	<div class="dienThongTin">
	<label>Mã nhân viên</label>
	<input type="text" name="maNhanVien" >
	<br>
	</div>
	<div class="dienThongTin">
	<label>Tên nhân viên</label>
	<input type="text" name="tenNhanVien">
	<br>
	</div>
	<div class="dienThongTin">
	<label>Tuổi nhân viên</label>
	<input type="text" name="tuoi">
	<br>
	</div>
	<div class="dienThongTin">
	<label>Số điện thoại </label>
	<input type="text" name="sdt">
	<br>
	</div>
	<div class="dienThongTin">
	<label>Địa chỉ</label>
	<input type="text" name="diaChi">
	<br>
	</div>
	<div class="dienThongTin">
	<label>Phòng ban</label>
	<select name="phongBan">
		<option>Chọn phòng ban</option>
		<c:forEach var= "phongBan" items= "${listPhongBan}">
			<option value="${phongBan.maPhongBan}" ${param.phongBan == phongBan.maPhongBan ? 'selected' : '' }>${phongBan.tenPhongBan}</option>
		</c:forEach>
	</select>
	
	</div>
	<div class="dienThongTin">
	<input type="submit" value="THÊM">
	</div>
	</form>
</body>
</html>