<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm mới sản phẩm </title>
</head>
<body>
		<h1 style="color: blue">Thêm sản phẩm mới</h1>
		<form action="ThemMoiSanPhamServlet" method = "POST">
			<label>Mã điện thoại: </label> <br>
			<input type="text" id="madt" name="madt" value="${param.madt}"> <br>
			 <br>
			<label>Tên điện thoại: </label> <br>
			<input type="text" id="tenDienThoai" name="tenDienThoai" value="${param.tenDienThoai}"> <br> <br>
			
			<label>Năm sản xuất: </label> <br>
			<input type="text" id="namSanXuat" name="namSanXuat" value="${param.namSanXuat}"> <br> <br>
			
			<label>Cấu hình: </label> <br>
			<input type="text" id="cauHinh" name="cauHinh" value="${param.cauHinh}"> <br> <br>
			
			<label for="NhaCC">Nhà cung cấp:</label>
        <select id="NhaCC" name="NhaCC">
            <option value="">Chọn nhà cung cấp</option>
            <c:forEach var="NhaCC" items="${NhaCCList}">
                <option value="${NhaCC.mancc}" ${param.NhaCC == NhaCC.mancc ? 'selected' : ''}>
                    ${NhaCC.tenNhaCungCap}
                </option>
            </c:forEach>
        </select><br><br>
			
		<label>Hình ảnh: </label>
	
<input type="file" name="hinhAnh" accept="image/*"> <br>
		<br>
		<input type="submit" value="Thêm sản phẩm" style="color: red">
			 
		</form>
</body>
</html>